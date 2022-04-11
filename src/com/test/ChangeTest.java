package com.test;

import com.main.Change;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeTest {

    @Test
    public void computeChangePiecesTest(){
        Change change = new Change();
        int[] pieces = new int[]{10,5,2};
        int changeValue = 11;
        assertEquals(0, (int)change.computeChangePieces(pieces, changeValue).get(0));
    }

    @Test
    public void computeChangePiecesNoRelevantPiecesTest(){
        Change change = new Change();
        int[] pieces = new int[]{10,5,2};
        int changeValue = 1;
        assertEquals(-1, (int)change.computeChangePieces(pieces, changeValue).get(0));
    }
}
