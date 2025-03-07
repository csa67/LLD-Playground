package auction_system.impl.status;

import auction_system.impl.Bid;
import auction_system.impl.Listing;

public class ScheduledState implements AuctionState{

    @Override
    public void startAuction(Listing listing) {
        listing.setStatus(new ActiveState());
        System.out.println("Auction started.");
    }

    @Override
    public void closeAuction(Listing auction) {
        System.out.println("Cannot close. Auction hasn't started yet.");
    }

    @Override
    public void cancelAuction(Listing auction) {
        auction.setStatus(new CancelledState());
        System.out.println("Auction canceled.");
    }

    @Override
    public void finishAuction(Listing auction) {
        System.out.println("Cannot finalize. Auction hasn't started yet.");
    }
}
