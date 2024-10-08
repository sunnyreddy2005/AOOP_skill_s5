package com.onlinetemp;

public class reverse extends abstractp {
    private double reservePrice;

    public reverse(double reservePrice) {
        this.reservePrice = reservePrice;
    }

    @Override
    protected boolean hasReservePrice() {
        return true;
    }

    @Override
    protected void setReservePrice() {
        System.out.println("Setting the reserve price: $" + reservePrice);
    }

    @Override
    protected void acceptBids() {
        System.out.println("Accepting bids for the reserve auction.");
    }

    @Override
    protected void announceWinner() {
        System.out.println("Announcing the winner of the reserve auction.");
    }
}
