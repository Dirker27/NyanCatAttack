package nyanCatAttack.gui;

import java.util.Observable;
import java.util.Observer;

import nyanCatAttack.model.GameObject;
import nyanCatAttack.model.Level;
import android.content.Context;
import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * The view for NyanCatAttack.
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 27, 2012
 */
public final class NyanCatView
	extends View
{
	//~ Declarations ==========================================================

	//- Objects ---------------------
	private Level 			model;

	//- Data ------------------------
	//private float 			time;
	//private Boolean			click;
	private Boolean 		jump;
	private Boolean			dash;

	//~ Initialization ========================================================
	/**
	 * Creates a new NyanCatView objects.
	 *
	 * @param context the context of the View.
	 * @param attrs the set of attributes for the View.
	 */
	public NyanCatView(Context context, AttributeSet attrs)
	{
		//- View Properties -------
		super(context, attrs);
		this.setClickable(true);
		this.setKeepScreenOn(true);

		//- Objects -------
		this.model = null;

		//- Data ----------
		//this.time = 0;
		//this.click = false;
		this.jump = false;
		this.dash = false;
	}

	//~ Public Access =========================================================
	/**
	 * Sets the model to a new level.
	 * @param level the new level.
	 */
	public void setModel(Level level)
	{
		this.model = level;
		this.model.addObserver(new Overseer());
	}
	
	/**
	 * Relays input (sent to Model)
	 * @return [Boolean[]] Input values
	 */
	public Boolean[] relayInput()
	{
		//this.time += 0.04;

		Boolean[] arr = new Boolean[2];
		arr[0] = this.jump;
		arr[1] = this.dash;

		return arr;
	}


	//~ Processing ============================================================

	// - On Touch ----------------------------------------------------
    /**
     * Analyzes Screen input and relays data as necessary
     * 
     * Sets Jump/Dash Input
     *
     * @param e - Motion Event        
     * @return - boolean true if action is valid
     */
    public boolean onTouchEvent(MotionEvent e)
    {
        boolean b = false;

        if (e.getAction() == MotionEvent.ACTION_DOWN)
        {
            b = true;
            //this.click = true;

            //- Input Commands [Early Stage]
            if (e.getX() < this.getWidth() / 2)
            {
            	this.jump = true;
            }
            else if (e.getX() > this.getWidth() / 2)
            {
            	this.dash = true;
            }
        }

        if (e.getAction() == MotionEvent.ACTION_MOVE)
        {
            b = true;
        }

        if (e.getAction() == MotionEvent.ACTION_UP)
        {
            b = true;
            
            //this.click = false;
            this.dash = false;
            this.jump = false;
        }

        return b;
    }

	// - ON DRAW -----------------------------------------------------
    /**
     * Draws the display screen
     * 
     * 		HEAVILY COMMENTED OUT - Debug Outputs (positions, data, input)
     *
     * @param canvas - drawable area
     */
    public void onDraw(Canvas canvas)
    {
        //Paint p = new Paint();

        // Values for Debug Output
        /*int screen = 0;
        int total = 0;
        boolean alive = false;*/

        //- Object Rendering ----------------------------
        if (this.model != null)
        {
            for (GameObject g : this.model.getOnScreen())
            {
            	this.drawObj(canvas, g);
                //screen++;
            }
            //total = this.model.getALL().size();
            //alive = this.model.getAlive();
        }

        //- View Data (Debug Out) ---------------------------------
        /*p.setColor(Color.WHITE);
        canvas.drawText("" + this.time, this.getWidth() / 2, 10, p);
        canvas.drawText("Screen: " + screen, 10, 30, p);
        canvas.drawText("Total:  " + total, 10, 10, p);
        canvas.drawText("" + this.getWidth(),
        		this.getWidth() - 20 , 10, p);
        canvas.drawText("" + this.getHeight(),
        		this.getWidth() - 20 , this.getHeight() - 10, p);*/
        
        /*if (alive)
        {
        	p.setAlpha(100);
        	canvas.drawText("[alive]", this.getWidth() / 2,
        			this.getHeight() / 2, p);
        }
        else
        {
        	canvas.drawText("[DEAD]", this.getWidth() / 2,
        			this.getHeight() / 2, p);
        }*/

        //- Input circle -----------------------------
        /*p.setColor(Color.WHITE);
        if (this.jump)
        {
        	p.setColor(Color.MAGENTA);
        }
        p.setAlpha(172);
        canvas.drawCircle(20, getHeight() -20, 20, p);
        p.setColor(Color.GREEN);
        if (this.dash)
        {
        	p.setColor(Color.YELLOW);
        }
        p.setAlpha(172);
        canvas.drawCircle(20, getHeight() -20, 15, p);
        p.setColor(Color.BLUE);
        if (this.click)
        {
        	p.setColor(Color.RED);
        }
        p.setAlpha(172);
        canvas.drawCircle(20, getHeight() -20, 8, p);*/
    }

    /**
     * Dedicated draw method for GameObjects
     *
     * @param canvas - Drawable Canvas
     * @param g - object to draw
     */
    private void drawObj(Canvas canvas, GameObject g)
	{
		if (g.getImage() != null)
		{
			canvas.drawBitmap(g.getImage(), null, g.getHitBox(), null);
		}
		else
		{
			Paint p = new Paint();
			p.setColor(g.getDefColor());
			p.setAlpha(172);

			canvas.drawRect((float) g.getX(),
					(float) g.getY(),
					(float) g.getX() + g.getWidth(),
					(float) g.getY() + g.getHeight(),
					p);
		}
		//- Object Data ------------------------------------------
		/*Paint d = new Paint();
		d.setColor(Color.WHITE);
		d.setAlpha(100);
		canvas.drawText(g.toString(), g.getX(), g.getY() + 10, d);
		canvas.drawText(g.name(), g.getX(),
				g.getY() + g.getHeight(), d);*/
	}


	//~ Observation  ==========================================================

	/**
	 * Overseer [NyanCatAttack]
	 *
	 *
	 * @author Dirk Hotensius 	[dirker27]
	 * @author Erich Alderfer 	[er1chald]
	 * @author Jonathan Lester	[jonal90]
	 * @version Apr 26, 2012
	 */
	private class Overseer
		implements Observer
	{
		/**
		 * Invalidates View, Sets To Re-Draw
		 */
		public void update(Observable observable, Object data)
		{
			postInvalidate();
		}
	}

}
