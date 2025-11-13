package hotel;

public class Booking {
    public static void confirm(Location loc, Hotel hotel, int rooms, double totalPrice) {
        System.out.println("\n----- BOOKING CONFIRMED -----");
        System.out.println("Location: " + loc.getName());
        System.out.println("Hotel: " + hotel.getName());
        System.out.println("Rooms Booked: " + rooms);
        System.out.println("Total Price: ₹" + totalPrice);
        System.out.println("-----------------------------\n");
    }
}