package auction_system.impl;

import auction_system.impl.status.AuctionState;
import auction_system.impl.status.ScheduledState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Listing {
    private final String id;
    private final String title;
    private final String description;
    private final double minimumPrice;
    private double currentHighestBid;
    private AuctionState status;
    private final User lister;
    private User latestBidder;
    private final Map<User, List<Bid>> bids;

    public Listing(String id, String title, String description, double minimumPrice, User lister) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minimumPrice = minimumPrice;
        this.status = new ScheduledState();
        this.lister = lister;
        this.bids = new ConcurrentHashMap<>();
        this.currentHighestBid = minimumPrice;
        this.latestBidder = null;
    }

    public void setStatus(AuctionState status) {
        this.status = status;
    }

    public void startAuction() {
        status.startAuction(this);
    }

    public void closeAuction() {
        status.closeAuction(this);
    }

    public void cancelAuction() {
        status.cancelAuction(this);
    }

    public void finishAuction() {
        status.finishAuction(this);
    }

    public void addBid(Bid bid) {
        User bidder = bid.getBidder();
        double bidAmount = bid.getAmount();

        if(bidAmount > currentHighestBid){
            bids.computeIfAbsent(bidder, k -> new ArrayList<>()).add(bid);
            currentHighestBid = bidAmount;
            latestBidder = bidder;
            System.out.println("New highest bid of " + bidAmount + " placed by " + bidder.getName());
        }else {
            System.out.println("Bid rejected! New bid must be higher than current bid: " + currentHighestBid);
        }
    }

    // Getters
    public User getLatestBidder() {
        return latestBidder;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Map<User, List<Bid>> getBids() {
        return bids;
    }

    public double getCurrentHighestBid() {
        return currentHighestBid;
    }

    public AuctionState getStatus() {
        return status;
    }
}