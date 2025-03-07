package auction_system.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionSystem {
    private static AuctionSystem instance;
    private final ConcurrentHashMap<String, Listing> auctions;
    private final ConcurrentHashMap<String,User> users;

    private AuctionSystem() {
        auctions = new ConcurrentHashMap<>();
        users = new ConcurrentHashMap<>();
    }

    public static synchronized AuctionSystem getInstance() {
        if (instance == null) {
            instance = new AuctionSystem();
        }
        return instance;
    }

    public void registerUser(User user) {
        if(users.putIfAbsent(user.getId(),user) == null){
            System.out.println("User registered: " + user.getName());
        } else {
            System.out.println("User already exists: " + user.getName());
        }
    }

    public void addAuction(Listing listing) {
        if (auctions.putIfAbsent(listing.getId(), listing) == null) {
            System.out.println("Auction added: " + listing.getTitle());
        } else {
            System.out.println("Auction already exists: " + listing.getTitle());
        }
    }

    // Get a registered user by ID
    public User getUserById(String userId) {
        return users.get(userId);
    }

    // Get an auction listing by ID
    public Listing getListingById(String listingId) {
        return auctions.get(listingId);
    }

    // Get all registered users
    public Map<String, User> getRegisteredUsers() {
        return users;
    }

    // Get all auction listings
    public Map<String, Listing> getAuctions() {
        return auctions;
    }

}
