package hotel;
import java.util.*;
public class Hotel {
	 private String name;
	    private double pricePerRoom;
	    private int availableRooms;

	    public Hotel(String name, double pricePerRoom, int availableRooms) {
	        this.name = name;
	        this.pricePerRoom = pricePerRoom;
	        this.availableRooms = availableRooms;
	    }

	    public String getName() { return name; }
	    public double getPricePerRoom() { return pricePerRoom; }
	    public int getAvailableRooms() { return availableRooms; }

	    public void showDetails() {
	        System.out.println("Hotel: " + name + " | Price: ₹" + pricePerRoom + " | Rooms left: " + availableRooms);
	    }

	    public double bookRooms(int rooms) {
	        if (rooms <= 0) {
	            System.out.println("Invalid number of rooms.");
	            return 0;
	        }
	        if (rooms > availableRooms) {
	            System.out.println("Not enough rooms available!");
	            return 0;
	        }
	        availableRooms -= rooms;
	        return rooms * pricePerRoom;
	    }
}
