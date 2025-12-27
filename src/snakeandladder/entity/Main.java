package snakeandladder.entity;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = Map.of(
                14, 7,
                31, 19,
                78, 39
        );

        Map<Integer, Integer> ladders = Map.of(
                3, 22,
                8, 26,
                20, 29
        );

        List<Player> players = List.of(
                new Player(0,"Alice"),
                new Player(0,"Bob"),
                new Player(10,"Alice"),
                new Player(100,"Bob")
        );

        Game game = new Game(100, players, snakes, ladders);
        game.start();
    }
}
