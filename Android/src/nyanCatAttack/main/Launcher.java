package nyanCatAttack.main;

import nyanCatAttack.gui.NyanCatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Launcher for NyanCatAttack
 * 
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 27, 2012
 */
public class Launcher
    extends Activity
{
    // ~ Declarations ==========================================================
    private Button start;


    // private Intent myIntent;

    // ~ Initialization ========================================================

    // - onCreate ----------------------------------------------------
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.start = (Button)findViewById(R.id.launch);
        this.start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                Intent myIntent =
                    new Intent(view.getContext(), NyanCatActivity.class);
                // May need startActivity instead. This should work though
                startActivity(myIntent);
            }

        });
    }


    /**
     * Returns the button for testing purposes.
     * 
     * @return the button object
     */
    public Button getView()
    {
        return start;
    }


    /*
     * public Intent getIntent() { return null; // return myIntent; }
     */

    public void onStart()
    {
        super.onStart();
    }
}
