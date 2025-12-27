package snakeandladder_old.entity;

import snakeandladder.entity.Dice;

import java.util.*;


public class Game {
    Board board;
    Dice dice;
    private Map<Integer, Player> res;
    private int winnerCount;
    Queue<Player> playerQueue;

    public void setDice(Dice dice){
        this.dice=dice;
    }

    public Game(List<Player> playerList, Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        this.res = new HashMap<>();
        this.playerQueue = new ArrayDeque<>(playerList);
    }

    private boolean checkReachToEnd(Player player) {
        return player.getPosition() == 100;
    }

    private void updateGameStatus(Player player) {
        if (checkReachToEnd(player)) {
            res.put(++winnerCount, player);
            if (playerQueue.size() == 1) {
                res.put(++winnerCount, playerQueue.poll());
            }
        } else playerQueue.add(player);
    }

    private void declareResult(Map<Integer, Player> res) {
        res.forEach((k, v) -> System.out.println(v + " ranks " + k));
    }

}
