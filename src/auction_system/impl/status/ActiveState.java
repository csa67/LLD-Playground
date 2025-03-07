package auction_system.impl.status;

import auction_system.impl.Bid;
import auction_system.impl.Listing;

public class ActiveState implements AuctionState{
    @Override
    public void startAuction(Listing listing) {
        System.out.println("Auction is already active");
    }

    @Override
    public void closeAuction(Listing auction) {
        auction.setStatus(new ClosedState());
        System.out.println("Auction for " +auction.getTitle()+" closed.");
    }

    @Override
    public void cancelAuction(Listing auction) {
        auction.setStatus(new CancelledState());
        System.out.println("Auction for" +auction.getTitle()+" canceled.");
    }

    @Override
    public void finishAuction(Listing auction) {
        System.out.println("Cannot finalize. Auction hasn't started yet.");
    }
}