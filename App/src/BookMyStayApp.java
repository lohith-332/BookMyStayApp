/**
 * UseCase3InventorySetup
 *
 * This class demonstrates centralized room inventory management using HashMap.
 * It replaces scattered availability variables with a single data structure,
 * ensuring consistency and scalability.
 *
 * @author YourName
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

// Inventory class to manage room availability
class RoomInventory {

    // HashMap to store room type and availability
    private Map<String, Integer> inventory;

    // Constructor initializes inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initial room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability (increase/decrease)
    public void updateAvailability(String roomType, int countChange) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + countChange);
    }

    // Method to display full inventory
    public void displayInventory() {
        System.out.println("---- Current Room Inventory ----");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

// Main Application Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App!");
        System.out.println("Hotel Booking System v3.1\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Simulate updates
        System.out.println("\nUpdating Inventory...\n");

        inventory.updateAvailability("Single Room", -1); // booking
        inventory.updateAvailability("Suite Room", +1);  // cancellation

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication terminated successfully.");
    }
}