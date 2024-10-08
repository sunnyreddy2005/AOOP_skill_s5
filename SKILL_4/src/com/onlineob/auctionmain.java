package com.onlineob;

import java.util.Scanner;

public class auctionmain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        auction auction = new auction("Vintage Painting");

        
        bidder bidder1 = new bidder("sunny");
        bidder bidder2 = new bidder("bunny");
        bidder bidder3 = new bidder("var");

       
        while (true) {
            System.out.println("\nEnter 1 to subscribe, 2 to unsubscribe, 3 to start auction, or 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.println("Enter bidder name (Alice, Bob, Charlie):");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("Alice")) {
                    auction.subscribe(bidder1);
                } else if (name.equalsIgnoreCase("Bob")) {
                    auction.subscribe(bidder2);
                } else if (name.equalsIgnoreCase("Charlie")) {
                    auction.subscribe(bidder3);
                } else {
                    System.out.println("Invalid bidder name.");
                }
            } else if (choice == 2) {
                System.out.println("Enter bidder name (Alice, Bob, Charlie):");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("Alice")) {
                    auction.unsubscribe(bidder1);
                } else if (name.equalsIgnoreCase("Bob")) {
                    auction.unsubscribe(bidder2);
                } else if (name.equalsIgnoreCase("Charlie")) {
                    auction.unsubscribe(bidder3);
                } else {
                    System.out.println("Invalid bidder name.");
                }
            } else if (choice == 3) {
                
                auction.itemAvailable();
                auction.startBidding();
                auction.endBidding();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
