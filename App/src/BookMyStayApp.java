/**
 * UseCase5BookingRequestQueue
 *
 * This class demonstrates how booking requests are collected and stored
 * using a Queue to ensure First-Come-First-Served (FIFO) processing.
 *
 * No inventory updates or room allocation happens at this stage.
 * It only handles request intake and ordering.
 *
 * @author YourName
 * @version 5.0
 */

import java.util.*;

// Reservation class representing a booking request
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Requested Room: " + roomType);
    }
}

// Booking Request Queue Manager
class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request to queue
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for " + reservation.getGuestName());
    }

    // Display all queued requests (without processing)
    public void displayQueue() {
        System.out.println("\n---- Booking Request Queue ----\n");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App!");
        System.out.println("Hotel Booking System v5.0\n");

        // Initialize queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate incoming booking requests
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Diana", "Single Room"));

        // Display queue (FIFO order preserved)
        bookingQueue.displayQueue();

        System.out.println("\nAll requests are queued for processing (FIFO).");
        System.out.println("Application terminated successfully.");
    }
}