package hotel;
import java.util.*;
public class Main {

    private static List<Location> locations = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		 Location hyd = new Location("Hyderabad");
	        hyd.addHotel(new Hotel("Hyd Resort", 2500, 5));
	        hyd.addHotel(new Hotel("Hyd Hotel", 3500, 3));

	        Location delhi = new Location("Delhi");
	        delhi.addHotel(new Hotel("Del Resort", 2000, 4));
	        delhi.addHotel(new Hotel("Del Hotel", 2800, 6));

	        Location mumbai = new Location("Mumbai");
	        mumbai.addHotel(new Hotel("Mum Resort", 4000, 5));
	        mumbai.addHotel(new Hotel("Mum Hotel", 4500, 2));

	        locations.add(hyd);
	        locations.add(delhi);
	        locations.add(mumbai);
	        boolean running = true;
	        while (running) {
	            System.out.println("1. Hyderabad");
	            System.out.println("2. Delhi");
	            System.out.println("3. Mumbai");
	            System.out.println("0. Exit");
	            System.out.print("Select a location: ");
	            int locChoice = sc.nextInt();

	            Location selectedLoc = null;
	            switch (locChoice) {
	                case 1 -> selectedLoc = hyd;
	                case 2 -> selectedLoc = delhi;
	                case 3 -> selectedLoc = mumbai;
	                case 0 -> {
	                    System.out.println("Exiting... Thank you!");
	                    running = false;
	                    continue;
	                }
	                default -> {
	                    System.out.println("Invalid choice!");
	                    continue;
	                }
	            }

	            // Show hotels for that location
	            System.out.println("\nHotels in " + selectedLoc.getName() + ":");
	            selectedLoc.showHotels();
	            System.out.print("Select a hotel: ");
	            int hotelChoice = sc.nextInt();

	            if (hotelChoice < 1 || hotelChoice > selectedLoc.getHotels().size()) {
	                System.out.println("Invalid hotel selection!");
	                continue;
	            }

	            Hotel selectedHotel = selectedLoc.getHotels().get(hotelChoice - 1);

	            System.out.print("Enter number of rooms to book: ");
	            int rooms = sc.nextInt();

	            double total = selectedHotel.bookRooms(rooms);
	            if (total > 0) {
	                Booking.confirm(selectedLoc, selectedHotel, rooms, total);
	            }

	            System.out.print("Do you want to book again? (y/n): ");
	            running = sc.next().equalsIgnoreCase("y");
	        }
	}

}
