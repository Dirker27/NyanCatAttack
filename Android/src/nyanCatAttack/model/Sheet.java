/**
 * Sheet.java [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
package nyanCatAttack.model;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Sheet [NyanCatAttack]
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
public final class Sheet
	extends GameObject
{
	//~ Declarations ==========================================================
	private final static int DEFWIDTH = 720;
	private final static int DEFHEIGHT = 225;

	//~ Initialization ========================================================
	/**
	 * CONSTRUCTOR [Sheet]
	 * @param x the x value for the sheets.
	 * @param y the y value for the sheets.
	 * @param image the image representation of the sheets.
	 *
	 */
	public Sheet(int x, int y, Bitmap image)
	{
		this(x, y, DEFWIDTH, DEFHEIGHT, image);
	}

	/**
	 * CONSTRUCTOR [Sheet]
	 * @param x the x value for the sheets.
     * @param y the y value for the sheets.
	 * @param width the width of the sheets.
	 * @param height the height of the sheets.
     * @param image the image representation of the sheets.
	 */
	public Sheet(int x, int y, int width, int height, Bitmap image)
	{
		super(x, y, width, height, image);
		super.setDefColor(Color.CYAN);
		super.setRate(7);
	}

	//~ Public Access =========================================================

	/**
	 * Overrides GameObject.scroll()
	 * 
	 * Sets sheet to "new" location for continuous display
	 */
	public void scroll()
	{
		// Moves Sheet
		super.scroll();
		
		// Shifts to new location (if necessary)
		float t = this.getX() + this.getWidth();
		if (t < 0)
		{
			this.setX(this.getWidth() + t);
			this.resetHitBox();
		}
	}

	//- TO STRING ----------------------
	/**
	 * TO STRING
	 *
	 * @return [String] Object name.
	 */
	public String name()
	{
		return "<Sheet>";
	}

}
