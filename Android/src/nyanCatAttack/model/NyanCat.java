/**
 * NyanCat.java [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
package nyanCatAttack.model;

import nyanCatAttack.utilities.Linked;
import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * A class used to model the main character of the game, Nyan Cat.
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
public final class NyanCat
	extends GameObject
{
	//~ Declarations ==========================================================
	//- Objects -----------------------
	private float 				dy;
	private final static float 	GRAVITY	 = 3;
	private final static float	UPS		 = 20;
	private Platform 			floor;

	//- Data --------------------------
	private final static int 	DEFHEIGHT = 44;
	private final static int 	DEFWIDTH = 72;

	//~ Initialization ========================================================
	/**
	 * Creates a new NyanCat object.
	 * @param image the image used to represent Nyan Cat.
	 */
	public NyanCat(Bitmap image)
	{
		super(50, 50, DEFWIDTH, DEFHEIGHT, image);
		super.setDefColor(Color.MAGENTA);

		this.dy = 0;
		this.floor = null;
	}

	//~ Private Operations ====================================================
	/**
	 * Determines if gravity should be affecting nyan cat.
	 * @param jump true if nyan cat has jumped, false otherwise.
	 */
	private void fall(boolean jump)
	{
		// if airborne
		if (floor == null)
		{
			if (jump)
			{
				this.dy += GRAVITY / 3;
			}
			this.dy -= GRAVITY;
		}
		// otherwise
		else
		{
			this.dy = 0;

			if (jump)
			{
				this.dy = UPS;
			}
		}
		
		this.setY(this.getY() - Math.round(this.dy));
		this.resetHitBox();
	}
	/**
	 * searches for platform objects NyanCat is "standing" on
	 * 		Determines if falling
	 * @param objs - platform array to search through
	 */
	private void floorSearch(Linked<GameObject> objs)
	{
		float back = this.getX();
		float front = this.getX() + this.getWidth();
		float alt = this.getY() + this.getHeight();

		this.floor = new Platform(0, 0, 0, 0, null);

		for (GameObject g : objs)
		{
			if (g instanceof Platform)
			{
				if (g.getX() < front && g.getX() + g.getWidth() > back)
				{
					if (alt - g.getY() > -10 && this.getY() - g.getY() < -10
							&& g.getX() > this.floor.getX())
					{
						this.floor = (Platform) g;
					}
				}
			}
		}

		if (this.floor.getX() + this.floor.getWidth() < back)
		{
			this.floor = null;
		}

		if (this.floor != null)
		{
			this.setY(this.floor.getY() - this.getHeight());
		}
	}

	/**
	 * Moves NyanCat to dash specifications
	 * @param dash - input 
	 */
	private void dash(Boolean dash)
	{
		if (dash)
		{
			this.setRate(-5);
		}
		else
		{
			if (this.getX() > 50)
			{
				this.setRate(2);
			}
			else
			{
				this.setRate(0);
			}
		}

	}

	//~ Public Access =========================================================
	/**
	 * Updated the NyanCat object during the game.
	 * @param arr the task being performed by nyan cat.
	 * @param objs the objects nyan cat is interacting with on the map.
	 */
	public void update(Boolean arr[], Linked<GameObject> objs)
	{
		this.floorSearch(objs);
		this.fall(arr[0]);
		this.dash(arr[1]);
	}


	/**
	 * Returns the name of nyan cat.
	 * @return the name of nyan cat <NyanCat>.
	 */
	public String name()
	{
		return "<NyanCat>";
	}

}
