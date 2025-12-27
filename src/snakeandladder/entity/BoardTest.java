package snakeandladder.entity;

import java.util.Map;

public class BoardTest {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = Map.of(14, 7, 31, 19);
        Map<Integer, Integer> ladders = Map.of(3, 22, 8, 26);

        Board board = new Board(100, snakes, ladders);

        System.out.println("Final Position (3): " + board.getNextPosition(3));  // should go to 22
        System.out.println("Final Position (14): " + board.getNextPosition(14)); // should go to 7
        System.out.println("Final Position (10): " + board.getNextPosition(10)); // stays at 10
    }
}
