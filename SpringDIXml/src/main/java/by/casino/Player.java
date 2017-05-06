package by.casino;

/**
 * Created by AMakas on 21.02.2017.
 */
public class Player {
    private int wins;
    public int getWins() {
        return wins;
    }
    private String name;

    private int currentSumma = 0;
    public int getCurrentSumma() {
        return currentSumma;
    }
    public void setCurrentSumma(int currentSumma) {
        this.currentSumma = currentSumma;
    }

    public void incriseWins() {
        ++wins;
    }

    public Player(int wins, String name) {
        this.wins = wins;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "wins=" + wins +
                ", name='" + name + '\'' +
                '}';
    }
}
