package com.onlinetemp;


public class bidder implements auctionevent {
    private String name;

    public bidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " received notification: " + event);
    }

    public String getName() {
        return name;
    }
}

