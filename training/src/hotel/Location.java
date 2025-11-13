package hotel;

import java.util.*;

public class Location {
	 private String name;
	    private List<Hotel> hotels;

	    public Location(String name) {
	        this.name = name;
	        this.hotels = new ArrayList<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public void addHotel(Hotel hotel) {
	        hotels.add(hotel);
	    }

	    public List<Hotel> getHotels() {
	        return hotels;
	    }

	    public void showHotels() {
	        for (int i = 0; i < hotels.size(); i++) {
	            System.out.print((i + 1) + ". ");
	            hotels.get(i).showDetails();
	        }
	    }
}
