package auction_system.impl;

public class AuctionDemo {
    public static void main(String[] args) {
        AuctionSystem auctionSystem = AuctionSystem.getInstance();

        // Create users
        User user1 = new User("U1", "Alice", "alice@example.com", "password123");
        User user2 = new User("U2", "Bob", "bob@example.com", "securepass");
        auctionSystem.registerUser(user1);
        auctionSystem.registerUser(user2);

        // Create auction listing
        Listing listing = new Listing("L1", "Vintage Clock", "Antique 1900s clock", 100.0, user1);
        auctionSystem.addAuction(listing);

        // Start Auction
        listing.startAuction();

        // Place bids
        Bid bid1 = new Bid("1", 120.0, user2);
        listing.addBid(bid1); // Accepted

        Bid bid2 = new Bid("2", 110.0, user1);
        listing.addBid(bid2); // Rejected (lower than currentHighestBid)

        Bid bid3 = new Bid("3", 130.0, user1);
        listing.addBid(bid3); // Accepted

        System.out.println("Latest bidder: " + listing.getLatestBidder().getName());
        System.out.println("Current highest bid: " + listing.getCurrentHighestBid());

        // Close Auction
        listing.closeAuction();

        // Display all registered users
        System.out.println("Registered Users:");
        auctionSystem.getRegisteredUsers().forEach((id, user) ->
                System.out.println("- " + user.getName()));

        // Display all auctions
        System.out.println("All Auctions:");
        auctionSystem.getAuctions().forEach((id, list) ->
                System.out.println("- " + list.getTitle() + " [Status: " + list.getStatus() + "]"));
    }
}
