package Tests;

import android.graphics.RectF;
import android.graphics.Bitmap;
import junit.framework.TestCase;
import nyanCatAttack.model.*;

// -------------------------------------------------------------------------
/**
 * Contains test cases for Platform class.
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 18, 2012
 */
public class GameObjectTest
    extends TestCase
{
    private Platform platform;
    private Platform platform2;
    private NyanCat  nyan;
    private Bitmap  image;
    private Sheet   sheet;
    private Sheet   sheet2;
    private testObj	obj;


    // ----------------------------------------------------------
    /**
     * Create a new GameObjectTest object.
     */
    public GameObjectTest()
    {
        // Nothing.
    }


    // ----------------------------------------------------------
    /**
     * Sets up the test cases. Puts everything in the top left corner, with a
     * height and width of 10.
     */
    public void setUp()
    {
        image = null;
        sheet = new Sheet(5, 5, 10, 10, image);
        sheet2 = new Sheet(5, 5, image);
        platform = new Platform(5, 5, 10, 10, image);
        platform2 = new Platform(5, 5, image);
        nyan = new NyanCat( image );
        obj = new testObj();
    }


    // ----------------------------------------------------------
    /**
     * Tests that all objects have the the appropriate location and dimensions.
     */
    public void testLocation()
    {
        assertEquals(platform.getHitBox().left, 5, .01);
        assertEquals(platform.getHitBox().right, 15, .01);
        assertEquals(platform.getHitBox().top, 5, .01);
        assertEquals(platform.getHitBox().bottom, 15, .01);
        assertEquals(platform.getX(), 5, .01);
        assertEquals(platform.getY(), 5, .01);
        assertEquals(platform.getHeight(), 10, .01);
        assertEquals(platform.getWidth(), 10, .01);

        assertEquals(platform2.getHitBox().left, 5, .01);
        assertEquals(platform2.getHitBox().right, 30, .01);
        assertEquals(platform2.getHitBox().top, 5, .01);
        assertEquals(platform2.getHitBox().bottom, 30, .01);
        assertEquals(platform2.getX(), 5, .01);
        assertEquals(platform2.getY(), 5, .01);
        assertEquals(platform2.getHeight(), 25, .01);
        assertEquals(platform2.getWidth(), 25, .01);

        assertEquals(nyan.getHitBox().left, 50, .01);
        assertEquals(nyan.getHitBox().right, 122, .01);
        assertEquals(nyan.getHitBox().top, 50, .01);
        assertEquals(nyan.getHitBox().bottom, 94, .01);
        assertEquals(nyan.getX(), 50, .01);
        assertEquals(nyan.getY(), 50, .01);
        assertEquals(nyan.getHeight(), 44, .01);
        assertEquals(nyan.getWidth(), 72, .01);

        assertEquals(sheet.getHitBox().left, 5, .01);
        assertEquals(sheet.getHitBox().right, 15, .01);
        assertEquals(sheet.getHitBox().top, 5, .01);
        assertEquals(sheet.getHitBox().bottom, 15, .01);
        assertEquals(sheet.getX(), 5, .01);
        assertEquals(sheet.getY(), 5, .01);
        assertEquals(sheet.getHeight(), 10, .01);
        assertEquals(sheet.getWidth(), 10, .01);

        assertEquals(sheet2.getHitBox().left, 5, .01);
        assertEquals(sheet2.getHitBox().right, 725, .01);
        assertEquals(sheet2.getHitBox().top, 5, .01);
        assertEquals(sheet2.getHitBox().bottom, 230, .01);
        assertEquals(sheet2.getX(), 5, .01);
        assertEquals(sheet2.getY(), 5, .01);
        assertEquals(sheet2.getHeight(), 225, .01);
        assertEquals(sheet2.getWidth(), 720, .01);
        
        assertEquals(obj.getHitBox().left, 0, .01);
        assertEquals(obj.getHitBox().right, 25, .01);
        assertEquals(obj.getHitBox().top, 0, .01);
        assertEquals(obj.getHitBox().bottom, 25, .01);
        assertEquals(obj.getX(), 0, .01);
        assertEquals(obj.getY(), 0, .01);
        assertEquals(obj.getHeight(), 25, .01);
        assertEquals(obj.getWidth(), 25, .01);
    }

    /**
     * Tests the name method for Platforms.
     */
    public void testName()
    {
        assertEquals( "<Platform>", platform.name() );

        assertEquals( "<NyanCat>", nyan.name());

        assertEquals( "<Sheet>", sheet.name());
        
        assertEquals( "", obj.name());

    }

    /**
     * Tests the scroll method.
     */
    public void testScroll()
    {
        platform.setRate(2);
        platform.scroll();
        assertEquals( 3, platform.getX(), .01 );

        nyan.setRate(2);
        nyan.scroll();
        assertEquals( 48, nyan.getX(), .01 );

        sheet.setRate(2);
        sheet.scroll();
        assertEquals( 3, sheet.getX(), .01 );
    }

    /**
     * Tests that an objects hitbox is set and removed properly.
     */
    public void testHitBox()
    {
        RectF newHitbox = new RectF(1,2,3,4);

        platform.setHitBox(newHitbox);
        assertEquals( newHitbox, platform.getHitBox() );
        platform.resetHitBox();
        assertEquals(platform.getHitBox().left, 5, .01);
        assertEquals(platform.getHitBox().right, 15, .01);
        assertEquals(platform.getHitBox().top, 5, .01);
        assertEquals(platform.getHitBox().bottom, 15, .01);

        nyan.setHitBox(newHitbox);
        assertEquals( newHitbox, nyan.getHitBox() );
        nyan.resetHitBox();
        assertEquals(nyan.getHitBox().left, 50, .01);
        assertEquals(nyan.getHitBox().right, 122, .01);
        assertEquals(nyan.getHitBox().top, 50, .01);
        assertEquals(nyan.getHitBox().bottom, 94, .01);

        sheet.setHitBox(newHitbox);
        assertEquals( newHitbox, sheet.getHitBox() );
        sheet.resetHitBox();
        assertEquals(sheet.getHitBox().left, 5, .01);
        assertEquals(sheet.getHitBox().right, 15, .01);
        assertEquals(sheet.getHitBox().top, 5, .01);
        assertEquals(sheet.getHitBox().bottom, 15, .01);
    }

    /**
     * Tests that the defColor is set and returned properly.
     */
    public void testDefColor()
    {
        platform.setDefColor(1);
        assertEquals( 1, platform.getDefColor() );

        nyan.setDefColor(1);
        assertEquals( 1, nyan.getDefColor() );

        sheet.setDefColor(1);
        assertEquals( 1, sheet.getDefColor() );
    }

    /**
     * Testst that the image has been set and returned properly.
     */
    public void testImage()
    {
        platform2.setImage(null);
        assertNull( platform2.getImage());

        nyan.setImage(null);
        assertNull( nyan.getImage());

        sheet.setImage(null);
        assertNull( sheet.getImage());
    }

    /**
     * Tests the equals method.
     */
    public void testEquals()
    {
        Platform temp = platform;
        assertTrue( platform.equals(temp));
        assertFalse( platform.equals(nyan));

        NyanCat temp2 = nyan;
        assertTrue( nyan.equals(temp2));
        assertFalse( nyan.equals(platform));

        Sheet temp3 = sheet;
        assertTrue( sheet.equals(temp3));
        assertFalse( sheet.equals(nyan));
    }

    /**
     * Tests the toString method.
     */
    public void testToString()
    {
        assertEquals( "[5.0, 5.0]", platform.toString());

        assertEquals( "[50.0, 50.0]", nyan.toString());

        assertEquals( "[5.0, 5.0]", sheet.toString());
    }

    /**
     * Tests that width is set properly.
     */
    public void testSetWidth()
    {
        platform.setWidth( 100 );
        assertEquals(100, platform.getWidth(), .01);

        nyan.setWidth( 100 );
        assertEquals(100, nyan.getWidth(), .01);

        sheet.setWidth( 100 );
        assertEquals(100, sheet.getWidth(), .01);
    }

    /**
     * Tests that height is set properly.
     */
    public void testSetHeight()
    {
        platform.setHeight( 100 );
        assertEquals(100, platform.getHeight(), .01);

        nyan.setHeight( 100 );
        assertEquals(100, nyan.getHeight(), .01);

        sheet.setHeight( 100 );
        assertEquals(100, sheet.getHeight(), .01);
    }

    /**
     * Tests that X coordinate is set properly.
     */
    public void testSetX()
    {
        platform.setX( 100 );
        assertEquals(100, platform.getX(), .01);

        nyan.setX( 100 );
        assertEquals(100, nyan.getX(), .01);

        sheet.setX( 100 );
        assertEquals(100, sheet.getX(), .01);
    }

    /**
     * Tests that Y coordinate is set properly.
     */
    public void testSetY()
    {
        platform.setY( 100 );
        assertEquals(100, platform.getY(), .01);

        nyan.setY( 100 );
        assertEquals(100, nyan.getY(), .01);

        sheet.setY( 100 );
        assertEquals(100, sheet.getY(), .01);
    }
    
    
    /**
     * Proudly Cheating the system since 2012
     * testObj [NyanCatAttack]
     *  
     *
     * @author Dirk Hotensius 	[dirker27]
     * @author Erich Alderfer 	[er1chald]
     * @author Jonathan Lester	[jonal90]
     * @version Apr 29, 2012
     */
    private class testObj 
    	extends GameObject
    {
		/** 
		 * Name
		 * @return empty String
		 */
		@Override
		public String name()
		{
			return "";
		}  	
    }
}
