package com.onlinetemp;



import java.util.ArrayList;
import java.util.List;

public class auction {
    private List<auctionevent> bidders;
    private String auctionItem;

    public auction(String auctionItem) {
        this.auctionItem = auctionItem;
        this.bidders = new ArrayList<>();
    }

    
    public void subscribe(auctionevent bidder) {
        bidders.add(bidder);
        System.out.println("Bidder subscribed.");
    }

    
    public void unsubscribe(auctionevent bidder) {
        bidders.remove(bidder);
        System.out.println("Bidder unsubscribed.");
    }

    
    public void notifyBidders(String event) {
        for (auctionevent bidder : bidders) {
            ((auctionevent) bidder).update(event);
        }
    }

    
    public void itemAvailable() {
        System.out.println("Item is available for bidding: " + auctionItem);
        notifyBidders("Item Available: " + auctionItem);
    }

    public void startBidding() {
        System.out.println("Bidding has started.");
        notifyBidders("Bidding Started");
    }

    public void endBidding() {
        System.out.println("Bidding has ended.");
        notifyBidders("Bidding Ended");
    }
}
