package turing;

public class Tape {

    private Cell currentCell = new Cell();

    /**
     * get current cell
     *
     * @return currentCell
     */
    public Cell getCurrentCell() {

        return currentCell;
    }

    /**
     * get char from the current cell.
     *
     * @return currentCell.content
     */
    public char getContent() {

        return currentCell.getContent();
    }

    /**
     * changes the char in the current cell
     * to the specified value.
     *
     * @param ch
     */
    public void setContent(char ch) {
        currentCell.setContent(ch);
    }

    /**
     * moves the current cell one position
     * to the left along the tape
     */
    public void moveLeft() {
        // current cell is the leftmost cell
        if (currentCell.getPrev() == null) {
            //create a cell
            Cell cell = new Cell();
            cell.setNext(currentCell);
            currentCell.setPrev(cell);
            currentCell = cell;
            currentCell.setContent(' ');
        }
    }

    /**
     * moves the current cell one position
     * to the right along the tape
     */
    public void moveRight() {

        // current cell is the rightmost cell
        if (currentCell.getNext() == null) {
            //create a cell
            Cell nextCell = new Cell();
            currentCell.setNext(nextCell);
            nextCell.setPrev(currentCell);
            currentCell = nextCell;
            currentCell.setContent(' ');

        }
    }

    /**
     * get the chars from all the cells on the tape,
     * read from left to right,
     *
     * @return tapeString
     */
    public String getTapeContents() {
        String tapeString = "";
        String preString = "";
        String nextString = "";

        if (currentCell != null) {
            StringBuilder str = new StringBuilder();

            Cell nextCell = currentCell.getNext();
            Cell preCell = currentCell.getPrev();

            // read right
            while (nextCell != null) {

                char nextChar = nextCell.getContent();
                str.append(nextChar);

                nextCell = nextCell.getNext();
            }

            nextString = str.toString();

            //clear the stringbuilder
            str.setLength(0);

            //read left
            while (preCell != null) {

                str.append(preCell.getContent());

                preCell = preCell.getPrev();
            }
            preString = str.reverse().toString();
        }
        // current char could be the middle
        char currentChar = currentCell.getContent();

        tapeString = preString + " " + nextString;
        System.out.println(currentChar);

        return tapeString;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
}





