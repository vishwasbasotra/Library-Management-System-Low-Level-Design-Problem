package com.library;

import com.library.model.*;
import com.library.service.*;
import com.library.factory.PatronFactory;
import com.library.search.*;
import com.library.exception.BookNotFoundException;
import java.util.List;

public class LibrarySystem {
    public static void main(String[] args) {
        // 1. Initialize Services
        InventoryService inventory = new InventoryService();
        ReservationService reservations = new ReservationService();
        LendingService lending = new LendingService(reservations);
        RecommendationService recommendations = new RecommendationService();
        BranchService branchService = new BranchService();

        // 2. Setup Branches
        Branch centralBranch = new Branch("BR-01", "Central Downtown");
        Branch techBranch = new Branch("BR-02", "Silicon Valley Tech Hub");

        // 3. Populate Inventory with various Genres
        Book b1 = new Book("101", "Effective Java", "Joshua Bloch", "Tech");
        Book b2 = new Book("102", "Clean Code", "Robert Martin", "Tech");
        Book b3 = new Book("103", "The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        Book b4 = new Book("104", "Dune", "Frank Herbert", "Sci-Fi");
        Book b5 = new Book("105", "Foundation", "Isaac Asimov", "Sci-Fi");

        inventory.addBook(b1); inventory.addBook(b2); inventory.addBook(b3);
        inventory.addBook(b4); inventory.addBook(b5);

        centralBranch.addBook(b1); centralBranch.addBook(b3);
        techBranch.addBook(b2); techBranch.addBook(b4); techBranch.addBook(b5);

        // 4. Create Patrons via Factory
        Patron alice = PatronFactory.create("STUDENT", "S1", "Alice");
        Patron bob = PatronFactory.create("FACULTY", "F1", "Dr. Bob");
        Patron charlie = PatronFactory.create("STUDENT", "S2", "Charlie");

        System.out.println("=== 1. STRATEGY PATTERN: Multi-Criteria Search ===");
        SearchStrategy titleSearch = new TitleSearch();
        System.out.println("Searching for 'Dune': " + titleSearch.search(inventory.getAll(), "Dune"));

        SearchStrategy authorSearch = new AuthorSearch();
        System.out.println("Searching by Author 'Joshua Bloch': " + authorSearch.search(inventory.getAll(), "Joshua Bloch"));

        System.out.println("\n=== 2. OBSERVER PATTERN: Reservation System ===");
        // Alice borrows Dune
        lending.checkout(b4, alice);
        System.out.println("Status of Dune: " + b4.getStatus());

        // Bob and Charlie both want Dune (Queueing up)
        System.out.println("Bob and Charlie are reserving 'Dune'...");
        reservations.reserve(b4, bob);
        reservations.reserve(b4, charlie);

        // Alice returns it -> Bob should be notified
        System.out.println("Alice returns 'Dune'...");
        lending.returnBook(b4);

        System.out.println("\n=== 3. BRANCH MANAGEMENT: Book Transfer ===");
        // Transfer "Effective Java" from Central to Tech Hub
        branchService.transferBook(b1, centralBranch, techBranch);

        System.out.println("\n=== 4. RECOMMENDATION ENGINE: History-Based ===");
        // Alice has borrowed a Sci-Fi book (Dune). Let's see what we suggest.
        System.out.println("Recommendations for Alice (Based on Sci-Fi history):");
        List<Book> aliceRecs = recommendations.recommend(alice, inventory.getAll());
        aliceRecs.forEach(book -> System.out.println(" -> Suggested: " + book.getTitle()));

    }
}