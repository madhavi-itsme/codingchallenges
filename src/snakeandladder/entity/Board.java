package snakeandladder.entity;

import snakeandladder.entity.Cell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Board {

    private final int size;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int pos) {
        if (pos > size) return pos;

        if (snakes.containsKey(pos)) {
            System.out.println("Oops! Bitten by a snake at " + pos);
            return snakes.get(pos);
        }

        if (ladders.containsKey(pos)) {
            System.out.println("Yay! Climbed a ladder at " + pos);
            return ladders.get(pos);
        }

        return pos;
    }
}
