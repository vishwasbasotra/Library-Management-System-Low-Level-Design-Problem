package com.library;
import com.library.model.*;
import com.library.service.*;
import com.library.factory.PatronFactory;

public class LibrarySystem {
    public static void main(String[] args) {
        // 1. Initialize System
        ReservationService reservations = new ReservationService();
        LendingService lending = new LendingService(reservations);
        RecommendationService recs = new RecommendationService();
        BranchService branchService = new BranchService(); // Added

        // 2. Setup Data
        Branch mainBranch = new Branch("B1", "Downtown Library");
        Branch northBranch = new Branch("B2", "North Side Branch");

        // Added "Tech" genre to ensure recommendations work
        Book book1 = new Book("978-1", "Effective Java", "Joshua Bloch", "Tech");
        mainBranch.addBook(book1);

        Patron alice = PatronFactory.create("STUDENT", "S1", "Alice");
        Patron bob = PatronFactory.create("FACULTY", "F1", "Bob");

        // 3. Simulation
        System.out.println("--- Scenario: Lending & Reservation ---");
        lending.checkout(book1, alice);
        reservations.reserve(book1, bob);

        System.out.println("Alice returning book...");
        lending.returnBook(book1);

        System.out.println("\n--- Scenario: Recommendations ---");
        // This will now show Effective Java if it's AVAILABLE and matches Alice's genre history
        recs.recommend(alice, mainBranch.getInventory()).forEach(System.out::println);

        System.out.println("\n--- Scenario: Branch Transfer ---");
        branchService.transferBook(book1, mainBranch, northBranch);
    }
}