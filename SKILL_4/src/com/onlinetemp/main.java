package com.onlinetemp;

import java.util.Scanner;



import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        auction auction = new auction("Vintage Painting");

        
        bidder bidder1 = new bidder("sunny");
        bidder bidder2 = new bidder("var");

        
        auction.subscribe(bidder1);
        auction.subscribe(bidder2);

        
        System.out.println("Choose auction type (1 for Standard Auction, 2 for Reserve Auction):");
        int auctionType = scanner.nextInt();

        abstractp auctionProcess;
        if (auctionType == 1) {
            auctionProcess = new standardauction();
        } else {
            System.out.println("Enter reserve price:");
            double reservePrice = scanner.nextDouble();
            auctionProcess = new reverse(reservePrice);
        }

       
        auction.itemAvailable();

       
        auctionProcess.conductAuction();

        
        auction.endBidding();

        scanner.close();
    }
}
