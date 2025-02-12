package stackoverflow.solution;

public class Vote {
    private User user;
    private int totalVotes;

    Vote(User user, int totalVotes) {
        this.user = user;
        this.totalVotes = totalVotes;
    }

    public User getUser() {
        return user;
    }

    public int getTotalVotes() {
        return totalVotes;
    }
}
