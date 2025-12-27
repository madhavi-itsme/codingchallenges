package snakeandladder.entity;


import java.util.Random;

public class Dice {
    // Create a single Random instance
    private final int sides;
    private final Random random = new Random();

    public Dice(int sides) {
        this.sides = sides;
    }

    public int rollDice() {
        return random.nextInt(sides) + 1;
    }
}