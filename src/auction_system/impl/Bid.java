package auction_system.impl;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

public class Bid {
    private final String id;
    private final double amount;
    private final User bidder;
    private final Timestamp timestamp;

    public Bid(String id, double amount, User bidder) {
        this.id = id;
        this.amount = amount;
        this.bidder = bidder;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double getAmount() {
        return amount;
    }

    public User getBidder() {
        return bidder;
    }
}
