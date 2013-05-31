/**
 * Platform.java [NyanCatAttack]
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
 * Platform [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
public final class Platform
	extends GameObject
{
	//~ Declarations ==========================================================

	//- Data -----------------------
	private final static int DEFWIDTH = 25;
	private final static int DEFHEIGHT = 25;

	//~ Initialization ========================================================
	/**
	 * CONSTRUCTOR [Platform]
	 * @param x the x value of the platform.
	 * @param y the y value of the platform.
	 * @param width the width of the platform.
	 * @param height the height of the platform.
	 * @param image the image used to represent the platforms.
	 *
	 */
	public Platform(int x, int y, int width, int height, Bitmap image)
	{
		super(x, y, width, height, image);
		super.setDefColor(Color.LTGRAY);
		super.setRate(10);
	}

	/**
	 * CONSTRUCTOR [Platform]
	 * @param x the x value of the platform.
	 * @param y the y value of the platform.
	 * @param image the image used to represent the platform.
	 *
	 */
	public Platform(int x, int y, Bitmap image)
	{
		this(x, y, DEFWIDTH, DEFHEIGHT, image);
	}

	//~ Public Access =========================================================

	//- TO STRING ----------------------
	/**
	 * TO STRING
	 *
	 * @return [String] Object name.
	 */
	public String name()
	{
		return "<Platform>";
	}
}
