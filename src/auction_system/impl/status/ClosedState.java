package auction_system.impl.status;

import auction_system.impl.Listing;

public class ClosedState implements AuctionState{

    @Override
    public void startAuction(Listing listing) {
        System.out.println("Cannot start. Auction is already closed.");
    }

    @Override
    public void closeAuction(Listing auction) {
        System.out.println("Auction is closed.");
    }

    @Override
    public void cancelAuction(Listing auction) {
        System.out.println("Cannot cancel. Auction is already closed.");
    }

    @Override
    public void finishAuction(Listing auction) {
        auction.setStatus(new FinalizedState());
        System.out.println("Auction finalized. "+auction.getLatestBidder()+" is winner");
    }
}
