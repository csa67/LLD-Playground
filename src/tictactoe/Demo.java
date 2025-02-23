package tictactoe;

public class Demo {
    public static void main(String[] args) {
        Player p1 = new Player("Alice",'X');
        Player p2 = new Player("Bob",'O');

        Game game = new Game(p1,p2,3);

        game.play();
    }
}
