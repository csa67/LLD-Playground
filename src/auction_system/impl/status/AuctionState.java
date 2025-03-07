package auction_system.impl.status;

import auction_system.impl.Listing;

public interface AuctionState {
    void startAuction(Listing listing);
    void closeAuction(Listing auction);
    void cancelAuction(Listing auction);
    void finishAuction(Listing auction);
}
