package stackoverflow.solution;

public interface Votable {
    void vote(User user, int value);
    int getValueCount();
}
