package nyanCatAttack.gui;

import nyanCatAttack.model.Level;
import nyanCatAttack.main.R;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;

/**
 * An activity for the Nyan Cat game.
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 27, 2012
 */
public class NyanCatActivity
	extends Activity
{
	//~ Instance Declarations =================================================

	//- Resource Components ------------
	private AssetManager 	assetMgr;

	//- MVC Components -----------------
	private Level 			model;
	private NyanCatView 	view;

	//- Threading Components -----------
	private Thread 			background;
	private Handler 		crypt;
	private Runnable		kick;
	private Boolean			active;
	
	//~ Activity Actions ======================================================
	/**
	 * Activity - [onCreate]
	 * 
	 * Initialization of Relevant Objects, Sets Thread
	 * 
	 * @param savedInstanceState - the state of the saved Instances
	 */
	public void onCreate(Bundle savedInstanceState)
    {
		// Find Bearings
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.game);
        this.assetMgr = this.getAssets();
        
        // Acquires TRUE screen size (Bypasses size default
        //		initialization to 0 in view)
        Display display = getWindowManager().getDefaultDisplay();
        int temph = Math.round((float).84375 * display.getHeight());
        int tempw = display.getWidth();

        // Link MVC
        this.view = (NyanCatView) findViewById(R.id.nyanView);
        this.view.postInvalidate();
		this.model = new Level(tempw,
				temph, this.assetMgr);
        this.view.setModel(this.model);

        // Set Timer
        this.active = true;
        this.background = null;
        this.crypt = new Handler();
        this.kick = new Runnable()
        	{
        		//- Update Tasks ---------------
				public void run()
				{
					// While Nyan Cat is Alive
					while (active)
					{
						try
						{
							// Sets Thread cycle
							Thread.sleep(30);
							model.update(view.relayInput());
							crypt.sendEmptyMessage(0);
							endGame();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					// When Nyan Cat Dies ------
					for (int c = 0; c < 20; c ++)
					{
						// Bypass input
						Boolean[] temp = new Boolean[2];
						temp[0] = false;
						temp[1] = false;
						
						// Slows display when dead (2 secs)
						try
						{
							Thread.sleep(100);
							model.update(temp);
							crypt.sendEmptyMessage(0);
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					// END ACTIVITY (End of Game)
					finish();
				}
        	};
    }

	/**
	 * [Execute]
	 * 
	 * Starts Threading
	 */
	public void onStart()
	{
		super.onStart();
		
		// Start Update Thread ----------------
		this.background = new Thread(this.kick);
		this.background.start();
	}
	
	/**
	 * onPause
	 */
	public void onPause()
	{
		super.onPause();
	}

	/**
	 * onResume
	 */
	public void onResume()
	{
		super.onResume();
	}

	//~ Private Processing ====================================================

	/**
	 * Ends Game/Activity if NyanCat dies
	 */
	private void endGame()
	{
		this.active = this.model.getAlive();
	}

	// ~ Public Access ========================================================

    // ~ Getters (Testing) -------------------------------------------
    /**
     * Releases Model for tests
     *
     * @return model [World]
     */
    public Level getModel()
    {
        return this.model;
    }


    /**
     * Releases View for tests
     *
     * @return view [NyanCatView]
     */
    public NyanCatView getView()
    {
        return this.view;
    }
}
