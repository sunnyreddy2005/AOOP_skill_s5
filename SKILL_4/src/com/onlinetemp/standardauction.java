package com.onlinetemp;

public class standardauction extends abstractp {
    @Override
    protected void acceptBids() {
        System.out.println("Accepting bids for the standard auction.");
    }

    @Override
    protected void announceWinner() {
        System.out.println("Announcing the winner of the standard auction.");
    }
}

