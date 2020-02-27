package turing;

/**
 * Represents one cell on a Turing Machine tape.
 */
public class Cell {

    private char content;  // The character in this cell.
    private Cell next;     // Pointer to the cell to the right of this one.
    private Cell prev;     // Pointer to the cell to the left of this one.

    public Cell(char content) {
        this.content = content;
    }

    public Cell() {

    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell next) {
        this.next = next;
    }

    public Cell getPrev() {
        return prev;
    }

    public void setPrev(Cell prev) {
        this.prev = prev;
    }
}


