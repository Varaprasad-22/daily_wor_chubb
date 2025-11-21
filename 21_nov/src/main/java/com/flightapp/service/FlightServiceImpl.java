package com.flightapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dto.Flight;
import com.flightapp.model.Airline;
import com.flightapp.model.FlightEntity;
import com.flightapp.dto.Search;
import com.flightapp.dto.SearchResult;
import com.flightapp.exceptions.ResourceNotFoundException;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private AirlineRepository airlineRepository;

	@Override
	public Mono<Integer> addFlight(Flight flightRequest) {
		
		return airlineRepository.findByAirlineName(flightRequest.getAirlineName()).switchIfEmpty(Mono.<Airline>error(
				new ResourceNotFoundException("Flight save failed: Airline '" + flightRequest.getAirlineName() + "' not found.")))
				.flatMap(airline->flightRepository.findByFlightNumber(flightRequest.getFlightNumber()).
						flatMap(existing->Mono.<Integer>error(
								new ResourceNotFoundException("Flight with number " + flightRequest.getFlightNumber() + " does  exist.")))
						.switchIfEmpty(Mono.<Integer>defer(()->{
							FlightEntity flightEntity = new FlightEntity();
							flightEntity.setAirlineId(airline.getAirlineId());
							flightEntity.setFlightNumber(flightRequest.getFlightNumber());
							flightEntity.setFromLocation(flightRequest.getFromPlace());
							flightEntity.setToLocation(flightRequest.getToPlace());
							flightEntity.setPrice(flightRequest.getPrice());
							flightEntity.setArrivalTime(flightRequest.getArrivalTime());
							flightEntity.setDepatureTime(flightRequest.getDepatureTime());
							flightEntity.setTotalSeats(flightRequest.getTotalSeats());
							flightEntity.setAvaliSeats(flightRequest.getTotalSeats());
							return flightRepository.save(flightEntity).map(FlightEntity::getFlightId);
							
						})));
	}

	@Override
	public Mono<SearchResult> search(Search searchRequest) {
		// TODO Auto-generated method stub

		LocalDateTime startOfDay = searchRequest.getDepartureDate().atStartOfDay();
		LocalDateTime endOfDay = searchRequest.getDepartureDate().atTime(LocalTime.MAX);

		Mono<List<FlightEntity>> outboundEntities = flightRepository.findByFromLocationAndToLocationAndDepatureTimeBetween(
				searchRequest.getFromPlace(), searchRequest.getToPlace(), startOfDay, endOfDay).collectList();
		
		
		
		 Mono<List<Flight>> outBoundDto=
				 outboundEntities
	                .flatMapMany(list -> Flux.fromIterable(list))   
	                .flatMap(this::mapEntitiesToDTOs)
	                .collectList();
		if (!"round-trip".equalsIgnoreCase(searchRequest.getTripType()) && searchRequest.getReturnDate() != null) {
			return outBoundDto.map(dtoList -> {
			    SearchResult result = new SearchResult();
			    result.setOutboundFlights(dtoList); 
			    return result;
			});
		
		}
		LocalDateTime returnStart = searchRequest.getReturnDate().atStartOfDay();
		LocalDateTime returnEnd = searchRequest.getReturnDate().atTime(LocalTime.MAX);

		Mono<List<FlightEntity>> inboundEntities = flightRepository.findByFromLocationAndToLocationAndDepatureTimeBetween(
				searchRequest.getToPlace(), searchRequest.getFromPlace(), returnStart, returnEnd)
                .collectList()
                .flatMap(list -> list.isEmpty()
                        ? Mono.error(new ResourceNotFoundException("No return flights found"))
                        : Mono.just(list));
		Mono<List<Flight>> inboundDto =
				inboundEntities
		                    .flatMapMany(list -> Flux.fromIterable(list))
		                    .flatMap(this::mapEntitiesToDTOs)
		                    .collectList();
		 
		return outBoundDto.zipWith(inboundDto,(out,in)->{
			SearchResult result=new SearchResult();
			result.setInboundFlights(in);
			result.setOutboundFlights(out);
			return result;
		});
	}

	private Mono<Flight> mapEntitiesToDTOs(FlightEntity flightEntities) {
		return  airlineRepository.findByAirlineId(flightEntities.getAirlineId())
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Airline not found for ID: " + flightEntities.getAirlineId())))
				.map(airline ->{ Flight flightRequestDto=new Flight();
			flightRequestDto.setAirlineName(airline.getAirlineName());
			flightRequestDto.setFlightNumber(flightEntities.getFlightNumber());
			flightRequestDto.setFromPlace(flightEntities.getFromLocation());
			flightRequestDto.setToPlace(flightEntities.getToLocation());
			flightRequestDto.setPrice(flightEntities.getPrice());
			flightRequestDto.setTotalSeats(flightEntities.getTotalSeats());
			flightRequestDto.setDepatureTime(flightEntities.getDepatureTime());
			flightRequestDto.setArrivalTime(flightEntities.getArrivalTime());

			// TODO: Add your logic to find airlineName from entity.getAirlineId()

			return flightRequestDto;
		});
	}

}
