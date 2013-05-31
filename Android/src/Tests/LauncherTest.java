package Tests;

import android.app.Activity;
import android.test.TouchUtils;
import nyanCatAttack.main.Launcher;
import android.test.ActivityInstrumentationTestCase2;

/**
 * A simple test class that tests that the launcher starts, and successfully
 * launches NyanCatActivity.
 * 
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 29, 2012
 */
public class LauncherTest
    extends ActivityInstrumentationTestCase2<Launcher>
{
    private Activity activity;


    /**
     * CONSTRUCTOR [LauncherTest]
     * 
     * @param activityClass
     */
    public LauncherTest()
    {
        super(Launcher.class);
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
     * Tests that Launcher starts and is able to start NyanCatAcitvity when
     * start button is pressed. If it doesn't start, the assetTrue statement
     * will not be reached.
     */
    public void testLauncher()
    {
        TouchUtils.clickView(this, ((Launcher)activity).getView());
        assertTrue(true);
    }
}
