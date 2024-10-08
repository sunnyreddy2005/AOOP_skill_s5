package com.onlinetemp;

public abstract class abstractp {
   
    public final void conductAuction() {
        itemAvailable();
        startBidding();
        if (hasReservePrice()) {
            setReservePrice();
        }
        acceptBids();
        announceWinner();
        endBidding();
    }

    
    protected abstract void acceptBids();
    protected abstract void announceWinner();

    
    protected boolean hasReservePrice() {
        return false;
    }

    protected void setReservePrice() {
       
    }

    
    private void itemAvailable() {
        System.out.println("Item is now available for bidding.");
    }

    private void startBidding() {
        System.out.println("Bidding has started.");
    }

    private void endBidding() {
        System.out.println("Bidding has ended.");
    }
}
