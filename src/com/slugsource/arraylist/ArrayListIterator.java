/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Nathan Fearnley
 */
public class ArrayListIterator<T> implements Iterator<T>
{
    private int index = -1;
    private T[] items;
    private int numItems;

    public ArrayListIterator(int numItems, T[] items)
    {
        this.items = items;
        this.numItems = numItems;
    }
    
    @Override
    public boolean hasNext()
    {
        return index + 1 < numItems;
    }

    @Override
    public T next()
    {
        if (!hasNext())
            throw new NoSuchElementException();
        index++;
        return items[index];
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Array list iterator does not support remove.");
    }
    
    
}
