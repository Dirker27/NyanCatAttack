package Tests;

import android.app.Activity;
import nyanCatAttack.gui.NyanCatActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * NyanCatActivityTest [NyanCatAttack]
 * 
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 29, 2012
 */
public class NyanCatActivityTest
    extends ActivityInstrumentationTestCase2<NyanCatActivity>
{
    @SuppressWarnings("unused")
	private Activity activity; // Game won't start without creating an activity
// object


    /**
     * CONSTRUCTOR [NyanCatActivityTest]
     */
    public NyanCatActivityTest()
    {
        super(NyanCatActivity.class);
    }


    public void setUp()
    {
        activity = this.getActivity();
    }


    // ~ Declarations ==========================================================

    // ~ Initialization ========================================================

    // ~ Private Operations ====================================================

    // ~ Public Access =========================================================
    /**
     * Tests that the game runs. If it didn't, it the assetTrue statement will
     * not be reached.
     */
    public void testGame()
    {
        assertTrue(true);
    }
}
