package com.slugsource.arraylist;

import com.slugsource.listinterface.ListInterface;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nathan Fearnley
 */
public class ArrayListTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public ArrayListTest()
    {
    }

    @Before
    public void setUpStreams() {
        outContent.reset();
        errContent.reset();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    
    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd_Object()
    {
        ArrayList instance = new ArrayList(10);
        Object newEntry = "a";
        
        boolean result = instance.add(newEntry);
        assertTrue(result);
        
        Object getEntry = instance.getEntry(1);
        assertEquals(newEntry, getEntry);
    }
    
    /**
     * Test of add method, of class ArrayList.
     * Test that ArrayList returns false when full
     */
    @Test
    public void testAdd_Object_Full()
    {
        ArrayList instance = new ArrayList(1);
        Object entryOne = "a";
        Object entryTwo = "b";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertFalse(resultTwo);
        
        Object getEntry = instance.getEntry(1);
        assertEquals(entryOne, getEntry);
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd_int_Object()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultThree = instance.add(entryThree);
        assertTrue(resultThree);
        
        boolean resultTwo = instance.add(2, entryTwo);
        assertTrue(resultTwo);
        
        Object getEntryOne = instance.getEntry(1);
        assertEquals(entryOne, getEntryOne);
        
        Object getEntryTwo = instance.getEntry(2);
        assertEquals(entryTwo, getEntryTwo);
        
        Object getEntryThree = instance.getEntry(3);
        assertEquals(entryThree, getEntryThree);
    }

    /**
     * Test of clear method, of class ArrayList.
     */
    @Test
    public void testClear()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertTrue(resultTwo);
        
        instance.clear();
        
        Object getEntryOne = instance.getEntry(0);
        assertNull(getEntryOne);
        
        Object getEntryTwo = instance.getEntry(0);
        assertNull(getEntryTwo);
    }

    /**
     * Test of contains method, of class ArrayList.
     */
    @Test
    public void testContains()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertTrue(resultTwo);
        
        boolean resultThree = instance.add(entryThree);
        assertTrue(resultThree);
        
        boolean containsOne = instance.contains(entryOne);
        assertTrue(containsOne);
        
        boolean containsTwo = instance.contains(entryTwo);
        assertTrue(containsTwo);
        
        boolean containsThree = instance.contains(entryThree);
        assertTrue(containsThree);
    }

        /**
     * Test of contains method, of class ArrayList.
     * Tests that contains returns falls when entries are not found
     */
    @Test
    public void testContains_NotFound()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean containsOne = instance.contains(entryOne);
        assertFalse(containsOne);
        
        boolean containsTwo = instance.contains(entryTwo);
        assertFalse(containsTwo);
        
        boolean containsThree = instance.contains(entryThree);
        assertFalse(containsThree);
    }
    
    /**
     * Test of display method, of class ArrayList.
     */
    @Test
    public void testDisplay()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        System.out.println(entryOne);
        System.out.println(entryTwo);
        System.out.println(entryThree);
        String expected = outContent.toString();
        outContent.reset();
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertTrue(resultTwo);
        
        boolean resultThree = instance.add(entryThree);
        assertTrue(resultThree);
        
        instance.display();
        String result = outContent.toString();
        assertEquals(expected, result);
    }

    /**
     * Test of equals method, of class ArrayList.
     */
    @Test
    public void testEquals()
    {
        ArrayList instanceOne = new ArrayList(10);
        ArrayList instanceTwo = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOneOne = instanceOne.add(entryOne);
        assertTrue(resultOneOne);
        
        boolean resultOneTwo = instanceOne.add(entryTwo);
        assertTrue(resultOneTwo);
        
        boolean resultOneThree = instanceOne.add(entryThree);
        assertTrue(resultOneThree);
        
        boolean resultTwoOne = instanceTwo.add(entryOne);
        assertTrue(resultTwoOne);
        
        boolean resultTwoThree = instanceTwo.add(entryThree);
        assertTrue(resultTwoThree);
        
        boolean resultTwoTwo = instanceTwo.add(2, entryTwo);
        assertTrue(resultTwoTwo);
        
        assertTrue(instanceOne.equals(instanceTwo));
        assertTrue(instanceTwo.equals(instanceOne));
    }
    
    /**
     * Test of equals method, of class ArrayList.
     */
    @Test
    public void testEquals_DifferentValues()
    {
        ArrayList instanceOne = new ArrayList(10);
        ArrayList instanceTwo = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOneOne = instanceOne.add(entryOne);
        assertTrue(resultOneOne);
        
        boolean resultOneTwo = instanceOne.add(entryTwo);
        assertTrue(resultOneTwo);
        
        boolean resultOneThree = instanceOne.add(entryThree);
        assertTrue(resultOneThree);
        
        boolean resultTwoOne = instanceTwo.add(entryOne);
        assertTrue(resultTwoOne);
        
        boolean resultTwoThree = instanceTwo.add(entryTwo);
        assertTrue(resultTwoThree);
        
        boolean resultTwoTwo = instanceTwo.add(1, entryThree);
        assertTrue(resultTwoTwo);
        
        assertFalse(instanceOne.equals(instanceTwo));
        assertFalse(instanceTwo.equals(instanceOne));
    }
    
    /**
     * Test of equals method, of class ArrayList.
     */
    @Test
    public void testEquals_DifferentLengths()
    {
        ArrayList instanceOne = new ArrayList(10);
        ArrayList instanceTwo = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOneOne = instanceOne.add(entryOne);
        assertTrue(resultOneOne);
        
        boolean resultOneTwo = instanceOne.add(entryTwo);
        assertTrue(resultOneTwo);
        
        boolean resultTwoOne = instanceTwo.add(entryOne);
        assertTrue(resultTwoOne);
        
        boolean resultTwoThree = instanceTwo.add(entryThree);
        assertTrue(resultTwoThree);
        
        boolean resultTwoTwo = instanceTwo.add(1, entryTwo);
        assertTrue(resultTwoTwo);
        
        assertFalse(instanceOne.equals(instanceTwo));
        assertFalse(instanceTwo.equals(instanceOne));
    }

    /**
     * Test of getEntry method, of class ArrayList.
     */
    @Test
    public void testGetEntry()
    {
        ArrayList instance = new ArrayList(10);
        Object newEntry = "a";
        
        boolean result = instance.add(newEntry);
        assertTrue(result);
        
        Object getEntry = instance.getEntry(1);
        assertEquals(newEntry, getEntry);
    }

    /**
     * Test of getEntry method, of class ArrayList.
     */
    @Test
    public void testGetEntry_Empty()
    {
        ArrayList instance = new ArrayList(10);
        
        Object getEntry = instance.getEntry(1);
        assertNull(getEntry);
    }
    
    /**
     * Test of getEntry method, of class ArrayList.
     */
    @Test
    public void testGetEntry_OutOfBounds()
    {
        ArrayList instance = new ArrayList(10);
        Object newEntry = "a";
        
        boolean result = instance.add(newEntry);
        assertTrue(result);
        
        Object getEntry = instance.getEntry(2);
        assertNull(getEntry);
    }
    
    /**
     * Test of getLength method, of class ArrayList.
     */
    @Test
    public void testGetLength()
    {
        ArrayList instance = new ArrayList(10);
        Object newEntry = "a";
        
        boolean result = instance.add(newEntry);
        assertTrue(result);
        
        int expected = 1;
        int getLength = instance.getLength();
        assertEquals(expected, getLength);
    }

    /**
     * Test of isEmpty method, of class ArrayList.
     */
    @Test
    public void testIsEmpty()
    {
        ArrayList instance = new ArrayList(10);
        Object newEntry = "a";
        
        boolean isEmptyTrue = instance.isEmpty();
        assertTrue(isEmptyTrue);
        
        boolean result = instance.add(newEntry);
        assertTrue(result);
        
        boolean isEmptyFalse = instance.isEmpty();
        assertFalse(isEmptyFalse);
    }

    /**
     * Test of isFull method, of class ArrayList.
     */
    @Test
    public void testIsFull()
    {
        ArrayList instance = new ArrayList(1);
        Object newEntry = "a";
        
        boolean isFullFalse = instance.isFull();
        assertFalse(isFullFalse);
        
        boolean result = instance.add(newEntry);
        assertTrue(result);
        
        boolean isFullTrue = instance.isFull();
        assertTrue(isFullTrue);
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertTrue(resultTwo);
        
        boolean resultThree = instance.add(entryThree);
        assertTrue(resultThree);
        
        Object removeTwo = instance.remove(2);
        assertEquals(entryTwo, removeTwo);
        
        Object getEntryOne = instance.getEntry(1);
        assertEquals(entryOne, getEntryOne);
        
        Object getEntryThree = instance.getEntry(2);
        assertEquals(entryThree, getEntryThree);
        
        Object getEntryNull = instance.getEntry(3);
        assertNull(getEntryNull);
    }

    /**
     * Test of replace method, of class ArrayList.
     */
    @Test
    public void testReplace()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        Object entryFour = "d";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertTrue(resultTwo);
        
        boolean resultThree = instance.add(entryThree);
        assertTrue(resultThree);
        
        boolean replace = instance.replace(2, entryFour);
        assertTrue(replace);
        
        Object getEntryOne = instance.getEntry(1);
        assertEquals(entryOne, getEntryOne);
        
        Object getEntryFour = instance.getEntry(2);
        assertEquals(entryFour, getEntryFour);
        
        Object getEntryThree = instance.getEntry(3);
        assertEquals(entryThree, getEntryThree);
    }

    /**
     * Test of swap method, of class ArrayList.
     */
    @Test
    public void testSwap()
    {
        ArrayList instance = new ArrayList(10);
        Object entryOne = "a";
        Object entryTwo = "b";
        Object entryThree = "c";
        
        boolean resultOne = instance.add(entryOne);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entryTwo);
        assertTrue(resultTwo);
        
        boolean resultThree = instance.add(entryThree);
        assertTrue(resultThree);
        
        instance.swap(2, 3);
        
        Object getEntryOne = instance.getEntry(1);
        assertEquals(entryOne, getEntryOne);
        
        Object getEntryThree = instance.getEntry(2);
        assertEquals(entryThree, getEntryThree);
        
        Object getEntryTwo = instance.getEntry(3);
        assertEquals(entryTwo, getEntryTwo);
    }

    /**
     * Test of iterator method, of class ArrayList.
     */
    @Test
    public void testIterator()
    {
        ArrayList instance = new ArrayList(10);
        Object[] entries = {"a", "b", "c"};
        
        boolean resultOne = instance.add(entries[0]);
        assertTrue(resultOne);
        
        boolean resultTwo = instance.add(entries[1]);
        assertTrue(resultTwo);
        
        boolean resultThree = instance.add(entries[2]);
        assertTrue(resultThree);
        
        int x = 0;
        for (Object object : instance)
        {
            assertEquals(entries[x], object);
            x++;
        }
    }
}
