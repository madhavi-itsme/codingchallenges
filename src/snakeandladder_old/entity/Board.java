package snakeandladder_old.entity;

import java.util.List;
import java.util.Optional;

public class Board {
    List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }


//    public void moveToNextPosition(int currentPosition, int score){
//        // based on score move the currPos to currPos+score.
//        // After currPos+score if it is ladder or snake according to that curr pos will change.
//        if (currentPosition < 0)
//            throw new IllegalArgumentException("Position should be greater than zero");
//        Optional<Cell> nextCellByPosition = getNextCellByPosition(currentPosition + score);
////        return nextCellByPosition.map(Cell::nextPosition).orElse(currentPosition);
//    }
//
//    private Optional<Cell> getNextCellByPosition(int position) {
//        return cells.stream().filter(cell -> cell.getPosition() == position)
//                .findFirst();
//    }
}
