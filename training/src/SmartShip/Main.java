package SmartShip;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            DeliveryManager manager = new DeliveryManager();

            System.out.print("Enter number of delivery agents: ");
            int numAgents = sc.nextInt();
            sc.nextLine(); 
            for (int i = 0; i < numAgents; i++) {
                System.out.println("\nEnter details for Agent #" + (i + 1));
                System.out.print("Agent ID: ");
                String id = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("City: ");
                String city = sc.nextLine();

                System.out.print("Max Load Capacity: ");
                int maxLoad = sc.nextInt();
                sc.nextLine(); 

                manager.addAgent(new DeliveryAgent(id, name, city, maxLoad));
            }

            System.out.print("\nEnter number of packages: ");
            int numPackages = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < numPackages; i++) {
                System.out.println("\nEnter details for Package " + (i + 1));
                System.out.print("Package ID: ");
                String id = sc.nextLine();

                System.out.print("Destination City: ");
                String city = sc.nextLine();

                System.out.print("Priority (1–5): ");
                int priority = sc.nextInt();
                sc.nextLine(); // consume newline

                manager.addPackage(new Package(id, city, priority));
            }

            System.out.println("Assigning packages to agents...");
            manager.assignPackages();
            manager.showAllAgents();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
