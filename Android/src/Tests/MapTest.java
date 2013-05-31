package Tests;

import junit.framework.TestCase;
import nyanCatAttack.model.Map;

/**
 * MapTest [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 28, 2012
 */
public class MapTest
    extends TestCase
{
    private Map map;

    /**
     * Sets up a new map for testing.
     */
    public void setUp()
    {
        map = new Map(5, 5, null);
    }

    /**
     * Tests the getObjects method for map.
     */
    public void testGetObjects()
    {
        assertNotNull( map.getObjects() );
    }

    /**
     * Tests the getTerrain method for map.
     */
    public void testGetTerrain()
    {
        assertNotNull( map.getTerrain() );
    }

    /**
     * Tests the getBackground method for map.
     */
    public void testGetBackground()
    {
        assertNotNull( map.getBackground() );
    }

}
