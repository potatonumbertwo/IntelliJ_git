package turing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeUnitTest {
    @Test
    public void testMoveLeft() {
        Tape tape = new Tape();
        Cell cell = new Cell('b');
        tape.setCurrentCell(cell);

        tape.moveLeft();

        Cell newCurrentCell = tape.getCurrentCell();

        assertEquals(' ', newCurrentCell.getContent());
        assertEquals(newCurrentCell, cell.getPrev());

        tape.moveLeft();
        tape.moveLeft();
        tape.moveLeft();
        tape.moveLeft();
        tape.moveLeft();

        String t = tape.getTapeContents();
        assertEquals(6, t.length());
    }

    @Test
    public void testMoveRight() {
        Tape tape = new Tape();
        Cell cell = new Cell('b');

        tape.setCurrentCell(cell);

        tape.moveRight();

        Cell newCurrentCell = tape.getCurrentCell();

        assertEquals(' ', newCurrentCell.getContent());
        assertEquals(cell, newCurrentCell.getPrev());

    }

    @Test
    public void getTapeContents() {
        Tape tape = new Tape();
        String words = "Hello World";
        for (int i = 0; i < words.length(); i++) {
            tape.setContent(words.charAt(i));
            tape.moveRight();
        }
        String tapeContent = tape.getTapeContents();

        assertEquals(words, tapeContent);
    }
}
