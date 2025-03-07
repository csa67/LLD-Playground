package auction_system.impl.status;

import auction_system.impl.Listing;

public class FinalizedState implements AuctionState {
    @Override
    public void startAuction(Listing listing) {
        System.out.println("Cannot start. Auction is finalized.");
    }

    @Override
    public void closeAuction(Listing auction) {
        System.out.println("Cannot close. Auction is finalized.");
    }

    @Override
    public void cancelAuction(Listing auction) {
        System.out.println("Cannot cancel. Auction is finalized.");
    }

    @Override
    public void finishAuction(Listing auction) {
        System.out.println("Auction is already finalized.");
    }
}
