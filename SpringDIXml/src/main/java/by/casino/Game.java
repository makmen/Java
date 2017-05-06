package by.casino;

import java.util.List;

/**
 * Created by AMakas on 21.02.2017.
 */
public class Game {
    private List<Bone> listBones;
    private Player[] players;
    private boolean finish = false;
    private int currentPlayer = 0;
    private int limitGames = 5;
    private Player winner;


    public Game(List<Bone> listBones, Player[] players) {
        this.listBones = listBones;
        this.players = players;
    }

    public void start() {

        while(!finish) {
            System.out.println("Кидает " + players[currentPlayer].toString());
            System.out.println(throwBones());
            if (changePlayer()) {
                finish = stopGame();
            }
        }
        System.out.println("Winner: " + winner.toString() );

    }

    public boolean stopGame() {
        boolean stop = false;
        for (int i = 0, count = players.length; i < count; i++) {
            if (players[i].getWins() >= limitGames ) {
                winner = players[i];
                stop = true;
                break;
            }
        }

        return stop;
    }


    public boolean changePlayer() {
        boolean endRound = false;
        if (++currentPlayer == players.length) {
            defineWinnerRound();
            endRound = true;
            currentPlayer = 0;
        }

        return endRound;
    }

    private void defineWinnerRound() {
        boolean isDraw = false;
        int pos = 0;
        int max = players[0].getCurrentSumma();
        for (int i = 1, count = players.length; i < count; i++) {
            if (players[i].getCurrentSumma() > max) {
                pos = i;
                max = players[i].getCurrentSumma();
            } else if (players[i].getCurrentSumma() == max) {
                System.out.println("Draw Game");
                isDraw = true;
            }
        }
        if (!isDraw) {
            players[pos].incriseWins();
        }
    }



    public void showList() {
        for (Player item : players) {
            System.out.println(item);
        }
    }

    public String throwBones() {
        StringBuilder str = new StringBuilder();
        int summa = 0;
        int number;
        for (Bone item : listBones) {
            number = item.getNumber();
            str.append(number + " ");
            summa += number;
        }
        str.append("Summa: " + summa);
        players[currentPlayer].setCurrentSumma(summa);

        return str.toString();
    }
}
