/***************************************************************
 * Below is the Queue code from the textbook, but modified to be
 * a queue of Price objects rather than a generic queue.
 ****************************************************************/

package hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class PriceQueue implements Iterable<Price> {
    private Node first;    
    private Node last;    
    private int n;       
    private TreeMap<Price, Node> tmap; 

    // helper linked list class
    private static class Node {
        private Price price;
        private Node next;
    }

    /**
     * Initializes empty queue.
     * Start the Tree map
     */
    public PriceQueue() {
        tmap = new TreeMap<Price, Node>(); 
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of Prices in this queue.
     *
     * @return the number of Prices in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the Price least recently added to this queue.
     *
     * @return the Price least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Price peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.price;
    }

    /**
     * Adds a Price to the front of the queue if it is not already present
     * in the queue.
     * 
     * @param price the Price to be added
     * @return {@code true} if the Price was added and {@code false} if it was
     *         not added (it was already present in the queue).
     */
    public boolean enqueue(Price price) {

        // Case - Already Present: return false 
        if (tmap.containsKey(price)) return false;
        
        // Case - Not Present: Add to TreeMap & Add to Queue 
        Node oldlast = last;
        tmap.put(price,oldlast);

        last = new Node(); 
        last.price = price; 
        last.next = null;
        
        // Empty Queue: Add as First or Add to End
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
        return true;
    }


    /**
     * Removes and returns the Price in this queue that was least recently added.
     *
     * @return the Price on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Price dequeue() {
        // Case - Empty Queue: Cannot Dequeue! 
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        
        // Case - Remove first item

        Price price = first.price;
        tmap.remove(price); // Tree removal - 
        // No rearrange because first; I'm assuming java removes node, 
        // making it null, meaning that reference to this node will be null
        // for which is wanted.
        
        first = first.next; // Queue removal
        n--;

        if (isEmpty()) last = null;   // to avoid loitering
        return price;
    }
    
    
    /**
     * Deletes a Price from the queue if it was present.
     * 
     * @param price the Price to be deleted.
     * @return {@code true} if the Price was deleted and {@code false} otherwise
     */
    public boolean delete(Price price) {
        // Case - Empty: Delete Nothing 
    	if (first == null) return false;
    	
        // Case - First Item: Dequeue item
    	if (first.price.equals(price)) {
            dequeue();
    		return true;
    	}
        
        // Case - Middle item: 
        // Get Previous Node, remove it from queue, rearrange values in tree
        Node previousNode = tmap.get(price);
        Price higherKey = tmap.higherKey(price);

        if (previousNode == null) return false;

        // Edge Case - Last item:
        // remove without accessing and reassign last node
        if (higherKey == null) 
        {
        	previousNode.next = previousNode.next.next; 
        	last = previousNode;
        	tmap.remove(price);
        	n--;
        	return true;
        }

        previousNode.next = previousNode.next.next; // remove it from queue
        tmap.put(higherKey, previousNode); // make higher key point to this
        // node since middle is to be deleted in tree; I'm assuming everything
        // in the tree is will hold the same order as the queue.
        tmap.remove(price); // actually delete it
    	n--;
    	return true;
    }


    /**
     * Returns an iterator that iterates over the Prices in this queue in FIFO order.
     *
     * @return an iterator that iterates over the Prices in this queue in FIFO order
     */
    public Iterator<Price> iterator()  {
        return new PriceListIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class PriceListIterator implements Iterator<Price> {
        private Node current;

        public PriceListIterator(Node first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Price next() {
            if (!hasNext()) throw new NoSuchElementException();
            Price price = current.price;
            current = current.next; 
            return price;
        }
    }
}

/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
