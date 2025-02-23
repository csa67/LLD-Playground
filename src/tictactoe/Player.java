package tictactoe;

public class Player {
    private final String name;
    private final char marker;

    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }
}
