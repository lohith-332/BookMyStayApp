/**
 * UseCase7AddOnServiceSelection
 *
 * This class demonstrates how add-on services can be attached to an
 * existing reservation without modifying core booking or inventory logic.
 *
 * It uses a Map<String, List<Service>> to maintain a one-to-many
 * relationship between reservation IDs and selected services.
 *
 * @author YourName
 * @version 7.0
 */

import java.util.*;

// Service class representing an add-on
class Service {
    private String serviceName;
    private double cost;

    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}

// Add-On Service Manager
class AddOnServiceManager {

    // Map: Reservation ID -> List of Services
    private Map<String, List<Service>> serviceMap = new HashMap<>();

    // Add service to a reservation
    public void addService(String reservationId, Service service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added service: " + service.getServiceName() +
                " to Reservation ID: " + reservationId);
    }

    // Calculate total cost of services for a reservation
    public double calculateTotalCost(String reservationId) {
        double total = 0;

        List<Service> services = serviceMap.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.getCost();
            }
        }

        return total;
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {
        System.out.println("\nServices for Reservation ID: " + reservationId);

        List<Service> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services selected.");
            return;
        }

        for (Service s : services) {
            System.out.println("- " + s.getServiceName() + " : ₹" + s.getCost());
        }

        System.out.println("Total Add-On Cost: ₹" + calculateTotalCost(reservationId));
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App!");
        System.out.println("Hotel Booking System v7.0\n");

        // Simulated reservation IDs (from previous use case)
        String reservation1 = "SI101";
        String reservation2 = "SU202";

        // Initialize service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        Service breakfast = new Service("Breakfast", 200);
        Service wifi = new Service("WiFi", 100);
        Service airportPickup = new Service("Airport Pickup", 500);

        // Guest selects services
        manager.addService(reservation1, breakfast);
        manager.addService(reservation1, wifi);

        manager.addService(reservation2, airportPickup);
        manager.addService(reservation2, breakfast);

        // Display services and cost
        manager.displayServices(reservation1);
        manager.displayServices(reservation2);

        System.out.println("\nAdd-on services processed successfully.");
    }
}