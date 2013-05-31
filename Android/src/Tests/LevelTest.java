package Tests;

import junit.framework.TestCase;
import nyanCatAttack.model.Level;

/**
 * LevelTest [NyanCatAttack]
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 27, 2012
 */
public class LevelTest
    extends TestCase
{
    private Level       level;
    private Level       level2;

    /**
     * Sets up the fields for testing.
     */
    public void setUp()
    {
        level = new Level(5, 5, null );
        level2 = new Level(500, 500, null );
    }

    /**
     * Tests the getAll objects.
     */
    public void testGetAll()
    {
        assertNotNull( level.getALL() );
    }

    /**
     * Tests the getOnScreen method.
     */
    public void testGetOnScreen()
    {
        assertNotNull( level.getOnScreen() );
    }

    /**
     * Tests the update method for a false argument.
     */
    public void testUpdateFalse()
    {
        Boolean[] arr = new Boolean[2];
        arr[0] = false;
        arr[1] = false;

        level2.update(arr);
        assertTrue( level2.getAlive());
    }

    /**
     * Tests the update method for a true argument.
     */
    public void testUpdateTrue()
    {
        Boolean[] arr = new Boolean[2];
        arr[0] = true;
        arr[1] = true;

        level.update(arr);
        assertFalse( level.getAlive() );
    }

    /**
     * Tests the update method for a false argument.
     */
    public void testUpdateFalseTrue()
    {
        Boolean[] arr = new Boolean[2];
        arr[0] = false;
        arr[1] = true;

        level2.update(arr);
        assertTrue( level2.getAlive());
    }

    /**
     * Tests the update method for a true argument.
     */
    public void testUpdateTrueFalse()
    {
        Boolean[] arr = new Boolean[2];
        arr[0] = true;
        arr[1] = false;

        level2.update(arr);
        assertTrue( level2.getAlive() );
    }
}
