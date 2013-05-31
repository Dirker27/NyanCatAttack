package Tests;

import nyanCatAttack.utilities.Node;
import nyanCatAttack.utilities.Stack;
import nyanCatAttack.utilities.Queue;
import java.util.NoSuchElementException;
import java.util.Iterator;
import junit.framework.TestCase;

/**
 * Tests the Iterable utilities.
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 11, 2012
 */
public class IterationTests
    extends TestCase
{
    private Stack<String>         deck;
    private Queue<String>         line;
    private Stack<String>         stack;
    private Queue<String>         queue;
    private Iterator<String>      q;
    private Iterator<String>      d;
    private Iterator<String>      l;
    private Iterator<String>      s;


    /**
     * Sets up the utilities for testing.
     */
    public void setUp()
    {
        line = new Queue<String>();
        deck = new Stack<String>();
        queue = new Queue<String>();
        stack = new Stack<String>();

        deck.push("First");
        line.push("First");
        deck.push("Second");
        line.push("Second");
        deck.push("Third");
        line.push("Third");
        deck.push("Fourth");
        line.push("Fourth");
        deck.push("Last");
        line.push("Last");

        d = deck.iterator();
        l = line.iterator();
    }


    /**
     * Tests the iterator.
     */
    public void testIterate()
    {
        assertTrue(d.hasNext());
        assertTrue(l.hasNext());

        assertEquals("First", l.next());
        assertEquals("Last", d.next());

        l.remove();
        d.remove();

        assertEquals("Fourth", deck.getHead().getData());
        assertEquals("Second", line.getHead().getData());
        assertEquals("Fourth", d.next());
        assertEquals("Second", l.next());

        while (l.hasNext())
        {
            l.next();
        }
        l.remove();
        assertTrue(l.hasNext());
        assertEquals("Second", line.getHead().getData());

        while (d.hasNext())
        {
            d.next();
        }
        d.remove();
        assertTrue(d.hasNext());
        assertEquals("Fourth", deck.getHead().getData());
    }

    /**
     * Tests for each.
     */
    public void testForEach()
    {
        String str = "";
        for (String s : deck)
        {
            str += s + ", ";
        }
        assertEquals("Last, Fourth, Third, Second, First, ", str);

        str = "";
        for (String s : line)
        {
            str += s + ", ";
        }
        assertEquals("First, Second, Third, Fourth, Last, ", str);
    }

    /**
     * Tests remove in IterableQueue when an exception is thrown.
     */
    public void testIterableQueueRemoveException()
    {
        Exception occurred = null;

        queue.push(null);
        q = queue.iterator();

        try
        {
            q.remove();
        }
        catch ( Exception exception)
        {
            occurred = exception;
        }

        assertNotNull( occurred);
        assertTrue( occurred instanceof IllegalStateException);
    }

    /**
     * Tests remove in IterableStack when an exception is thrown.
     */
    public void testIterableStackRemoveException()
    {
        Exception occurred = null;

        stack.push(null);
        s = stack.iterator();

        try
        {
            s.remove();
        }
        catch ( Exception exception)
        {
            occurred = exception;
        }

        assertNotNull( occurred);
        assertTrue( occurred instanceof IllegalStateException);
    }

    /**
     * Tests next for the IterableStack
     */
    public void testIterableStackNext()
    {
        Exception occurred = null;

        s = stack.iterator();
        assertFalse( s.hasNext() );

        try
        {
            s.next();
        }
        catch ( Exception exception)
        {
            occurred = exception;
        }

        assertNotNull( occurred);
        assertTrue( occurred instanceof NoSuchElementException);
    }

    /**
     * Tests remove method in IterableStack when current node is null.
     */
    public void testStackRemoveCurrentNull()
    {
        stack.push("data");
        stack.push(null);
        stack.push(null);

        s = stack.iterator();
        assertTrue( s.hasNext() );
        Node<String> temp = new Node<String>(s.next() );
        s.remove();
        assertNull( temp.getNext() );
        assertEquals( 2, stack.size());
    }
}
