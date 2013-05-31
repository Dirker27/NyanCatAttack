package Tests;

import nyanCatAttack.utilities.Node;
import nyanCatAttack.utilities.Stack;
import nyanCatAttack.utilities.Queue;
import junit.framework.TestCase;

/**
 *  Tests the utilities used in our project.
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 11, 2012
 */
public class LinkedTests
extends TestCase
{
    private Queue<String> q;
    private Stack<String> s;

    /**
     * Create a new LinkedTests object.
     */
    public LinkedTests()
    {
        super();
    }

    /**
     * Sets up the utilities for testing.
     */
    public void setUp()
    {
        q = new Queue<String>();
        s = new Stack<String>();
    }

    /**
     * Tests the stack.
     */
    public void testStack()
    {
        // STRING ---------------------------------
        // initialization    	
        assertTrue(s.isEmpty());
        assertNull(s.getHead());

        // LIFO push/pop
        s.push("First");
        s.push("Second");
        s.push("Last");
        s.push("MORE!");
        assertEquals( 4, s.size());
        assertTrue( s.contains("MORE!"));
        assertTrue( s.contains("First"));
        s.pop();
        assertEquals(3, s.size());
        assertFalse(s.contains( "MORE!"));
        assertEquals( "Last", s.top() );
        s.delete("Last");
        assertEquals(2, s.size());
        s.delete("First");
        assertEquals(1, s.size());

        s = new Stack<String>();
        assertNull( s.top() );
    }

    /**
     * Tests the queue.
     */
    public void testQueue()
    {
        // STRING ---------------------------------
        // initialization
        assertTrue(q.isEmpty());
        assertNull(q.getHead());

        // LIFO push/pop
        q.push("MORE!");
        q.push("First");
        q.push("Second");
        q.push("Last");
        assertEquals( 4, q.size());
        assertTrue( q.contains("MORE!"));
        q.pop();
        assertEquals(3, q.size());
        assertFalse(q.contains( "MORE!"));
        assertEquals( "First", q.top() );
    }

    /**
     * Tests pop when an exception is thrown.
     */
    public void testPopInvalid()
    {
        q = new Queue<String>();

        Exception occurred = null;

        try
        {
            q.pop();
        }
        catch ( Exception exception)
        {
            occurred = exception;
        }

        assertNotNull( occurred);
        assertTrue( occurred instanceof NullPointerException);
    }

    /**
     * Tests the empty node constructor.
     */
    public void testNode()
    {
        Node<String> node = new Node<String>(null);
        Node<String> node2 = new Node<String>("data2");
        assertNull( node.getData() );
        assertNull( node.getNext() );
        node.setData("data");
        node.setNext(node2);
        assertEquals( "data", node.getData().toString());
        assertEquals( node2, node.getNext());
    }

    /**
     * Tests the delete method when an exception is thrown.
     */
    public void testDeleteException()
    {
        s = new Stack<String>();

        Exception occurred = null;

        try
        {
            s.delete("data");
        }
        catch ( Exception exception)
        {
            occurred = exception;
        }

        assertNotNull( occurred);
        assertTrue( occurred instanceof IllegalStateException);
    }


}
