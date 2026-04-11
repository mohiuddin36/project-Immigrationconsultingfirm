package com.example.javafxproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingStorage {

    // ✅ Shared booking list (Client + Receptionist)
    public static ObservableList<Booking> bookings =
            FXCollections.observableArrayList();

    // ✅ Add booking
    public static void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        }
    }

    // ✅ Remove booking
    public static void removeBooking(Booking booking) {
        if (booking != null) {
            bookings.remove(booking);
        }
    }

    // ✅ Update status (MAIN FEATURE 🔥)
    public static void updateStatus(Booking booking, String status) {
        if (booking != null && status != null) {
            booking.setStatus(status);
        }
    }

    // ✅ Get all bookings (optional helper)
    public static ObservableList<Booking> getAllBookings() {
        return bookings;
    }
}