package snakeandladder.entity;

import snakeandladder.entity.Board;
import snakeandladder.entity.Dice;
import snakeandladder.entity.Player;

import java.util.*;


public class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;
    private boolean isGameOver;

    public Game(int boardSize, List<Player> playersList, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.board = new Board(boardSize, snakes, ladders);
        this.players = new LinkedList<>(playersList);
        this.dice = new Dice(6); // 6-sided dice
        this.isGameOver = false;
    }

    public void start(){
         while(!isGameOver){
             Player currentPlayer = players.poll();
             System.out.println(currentPlayer.getPlayerName() + "'s turn");
             int diceCount= dice.rollDice();

             int currPosition=currentPlayer.getPosition();
             int newPosition=currPosition+diceCount;
             currentPlayer.setPosition(newPosition);

             if (newPosition == board.getSize()) {
                 System.out.println(currentPlayer.getPlayerName() + " wins!");
                 isGameOver = true;
             } else {
                 players.offer(currentPlayer); // add back to queue
             }

             try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
         }
    }
}
