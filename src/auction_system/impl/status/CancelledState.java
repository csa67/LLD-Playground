package auction_system.impl.status;

import auction_system.impl.Bid;
import auction_system.impl.Listing;

public class CancelledState implements AuctionState{
    @Override
    public void startAuction(Listing listing) {
        System.out.println("Cannot start. Auction was canceled.");
    }

    @Override
    public void closeAuction(Listing auction) {
        System.out.println("Cannot close. Auction was canceled.");
    }

    @Override
    public void cancelAuction(Listing auction) {
        System.out.println("Auction is already canceled.");
    }

    @Override
    public void finishAuction(Listing auction) {
        System.out.println("Cannot finalize. Auction was canceled.");
    }
}
