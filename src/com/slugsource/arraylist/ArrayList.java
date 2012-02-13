/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.arraylist;

import com.slugsource.listinterface.ListInterface;
import java.util.Iterator;

/**
 *
 * @author Nathan Fearnley
 */
public class ArrayList<T> implements ListInterface<T>, Iterable<T>
{

    int numItems = 0;
    int maxSize;
    T[] items;

    public ArrayList(int maxSize)
    {
        this.maxSize = maxSize;
        items = new T[maxSize];
    }
    
    @Override
    public boolean add(T newEntry)
    {
        if (newEntry == null)
            return false;
        if (isFull())
            return false;
        
        items[numItems] = newEntry;
        numItems++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry)
    {
        newPosition--;
        if (newEntry == null)
            return false;
        if (isFull())
            return false;
        if (newPosition < 0)
            return false;
        if (newPosition > numItems)
            return false;
        
        shiftUp(newPosition, numItems - 1);
        items[newPosition] = newEntry;
        numItems++;
        return true;
    }

    @Override
    public void clear()
    {
        items = new T[maxSize];
    }

    @Override
    public boolean contains(T anEntry)
    {
        if (anEntry == null)
            return false;
        
        boolean result = false;
        
        for (T elem : this)
        {
            if (anEntry.equals(elem))
            {
                result = true;
                break;
            }
        }
        
        return result;
    }

    @Override
    public void display()
    {
        for (T elem : this)
        {
            System.out.println(elem);
        }
    }

    @Override
    public boolean equals(ListInterface<T> otherList)
    {
        if (this.getLength() != otherList.getLength())
            return false;
        
        boolean result = true;
        
        for (int x = 0; x < this.getLength(); x++)
        {
            if (!this.getEntry(x).equals(otherList.getEntry(x)))
            {
                result = false;
                break;
            }
        }
        
        return result;
    }

    @Override
    public T getEntry(int givenPosition)
    {
        givenPosition--;
        if (givenPosition < 0)
            return null;
        if (givenPosition > numItems - 1)
            return null;
     
        return items[givenPosition];
    }

    @Override
    public int getLength()
    {
        return numItems;
    }

    @Override
    public boolean isEmpty()
    {
        return numItems == 0;
    }

    @Override
    public boolean isFull()
    {
        return numItems == maxSize;
    }

    @Override
    public T remove(int givenPosition)
    {
        givenPosition--;
        if (givenPosition < 0)
            return null;
        if (givenPosition > numItems - 1)
            return null;
        
        T temp = items[givenPosition];
        shiftDown(givenPosition + 1, numItems - 1);
        items[numItems - 1] = null;
        numItems--;
        return temp;
    }
    
    // Shift every element between start to end, one index down
    private void shiftDown(int start, int end)
    {
        for(int x = start; x <= end; x++)
        {
            items[x - 1] = items[x];
        }
    }
    
    // Shift every element between start to end, one index up
    private void shiftUp(int start, int end)
    {
        for(int x = end; x >= start; x--)
        {
            items[x + 1] = items[x];
        }
    }

    @Override
    public boolean replace(int givenPosition, T newEntry)
    {
        givenPosition--;
        if (newEntry == null)
            return false;
        if (givenPosition < 0)
            return false;
        if (givenPosition > numItems - 1)
            return false;
        
        items[givenPosition] = newEntry;
        return true;
    }

    @Override
    public void swap(int positionOne, int positionTwo)
    {
        positionOne--;
        positionTwo--;
        if (positionOne < 0)
            return;
        if (positionOne > numItems - 1)
            return;
        if (positionTwo < 0)
            return;
        if (positionTwo > numItems - 1)
            return;
        
        T temp = items[positionOne];
        items[positionOne] = items[positionTwo];
        items[positionTwo] = temp;
    }
    
    @Override
    public Iterator<T> iterator()
    {
        return new ArrayListIterator<T>(numItems, items);
    }
    
}
