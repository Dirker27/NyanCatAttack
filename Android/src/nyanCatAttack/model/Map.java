package nyanCatAttack.model;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import nyanCatAttack.utilities.Queue;
import nyanCatAttack.utilities.Stack;

/**
 * A class used to represent the maps for Nyan Cat Attack.
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 27, 2012
 */
public class Map
{
	//~ Declarations ==========================================================

	//- Objects -----------------
	private Stack<Platform>		terrain;
	private Stack<Sheet>		background;

	//- Data --------------------
	private int 				width;
	private int					height;

	//~ Initialization ========================================================
	/**
	 * Creates a new Map object.
	 *
	 * @param screenWidth the width of the screen.
	 * @param screenHeight the height of the screen.
	 * @param assets the assets used by the map.
	 */
	public Map(int screenWidth, int screenHeight, AssetManager assets)
	{
		this.terrain = new Stack<Platform>();
		this.background = new Stack<Sheet>();

		this.width = screenWidth;
		this.height = screenHeight;

		this.genPlatforms(assets);
		this.genBackground(assets);
	}

	/**
	 * Hard-Sets Platforms for Map
	 * 
	 * @param assets - Images for Platform Initialization
	 */
	private void genPlatforms(AssetManager assets)
	{
		// loads platform image
		Bitmap image;
		try
		{
			image =
				BitmapFactory.decodeStream(assets.open("img/SolarPanel.png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			image = null;
		}

		// Default Display Testing
		//image = null;

		//- Set Platforms (level) ------------------------------------------
		for (int c = 5; c < 25; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 100, image));
		}
		for (int c = 30; c < 50; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 25, image));
		}
		for (int c = 50; c < 65; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 75, image));
		}
		for (int c = 30; c < 65; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 200, image));
		}
		for (int c = 75; c < 95; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 150, image));
		}
		for (int c = 75; c < 95; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 50, image));
		}
		for (int c = 105; c < 130; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 100, image));
		}
		for (int c = 105; c < 115; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 25, image));
		}
		for (int c = 125; c < 128; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 175, image));
		}
		for (int c = 130; c < 150; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 200, image));
		}
		for (int c = 140; c < 175; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 75, image));
		}
		for (int c = 135; c < 140; c ++)
		{
			this.terrain.push(new Platform(c * 25, this.height - 25, image));
		}

		//- N ------------------------------------------------------------
		this.terrain.push(new Platform(175 * 25, this.height - 50, image));
		this.terrain.push(new Platform(175 * 25, this.height - 75, image));
		this.terrain.push(new Platform(175 * 25, this.height - 100, image));
		this.terrain.push(new Platform(175 * 25, this.height - 125, image));
		this.terrain.push(new Platform(175 * 25, this.height - 150, image));
		this.terrain.push(new Platform(176 * 25, this.height - 50, image));
		this.terrain.push(new Platform(176 * 25, this.height - 75, image));
		this.terrain.push(new Platform(176 * 25, this.height - 100, image));
		this.terrain.push(new Platform(176 * 25, this.height - 125, image));
		this.terrain.push(new Platform(176 * 25, this.height - 150, image));

		this.terrain.push(new Platform(179 * 25, this.height - 50, image));
		this.terrain.push(new Platform(179 * 25, this.height - 75, image));
		this.terrain.push(new Platform(179 * 25, this.height - 100, image));
		this.terrain.push(new Platform(179 * 25, this.height - 125, image));
		this.terrain.push(new Platform(179 * 25, this.height - 150, image));
		this.terrain.push(new Platform(180 * 25, this.height - 50, image));
		this.terrain.push(new Platform(180 * 25, this.height - 75, image));
		this.terrain.push(new Platform(180 * 25, this.height - 100, image));
		this.terrain.push(new Platform(180 * 25, this.height - 125, image));
		this.terrain.push(new Platform(180 * 25, this.height - 150, image));

		this.terrain.push(new Platform(177 * 25, this.height - 125, image));
		this.terrain.push(new Platform(177 * 25, this.height - 100, image));
		this.terrain.push(new Platform(178 * 25, this.height - 100, image));
		this.terrain.push(new Platform(178 * 25, this.height - 75, image));

		//- Y -------------------------------------------------------------
		this.terrain.push(new Platform(182 * 25, this.height - 150, image));
		this.terrain.push(new Platform(182 * 25, this.height - 125, image));
		this.terrain.push(new Platform(183 * 25, this.height - 125, image));
		this.terrain.push(new Platform(183 * 25, this.height - 100, image));
		this.terrain.push(new Platform(184 * 25, this.height - 100, image));
		this.terrain.push(new Platform(184 * 25, this.height - 75, image));
		this.terrain.push(new Platform(184 * 25, this.height - 50, image));
		this.terrain.push(new Platform(185 * 25, this.height - 50, image));
		this.terrain.push(new Platform(185 * 25, this.height - 75, image));
		this.terrain.push(new Platform(185 * 25, this.height - 100, image));
		this.terrain.push(new Platform(187 * 25, this.height - 150, image));
		this.terrain.push(new Platform(187 * 25, this.height - 125, image));
		this.terrain.push(new Platform(186 * 25, this.height - 125, image));
		this.terrain.push(new Platform(186 * 25, this.height - 100, image));


		//- A -------------------------------------------------------------
		this.terrain.push(new Platform(188 * 25, this.height - 50, image));
		this.terrain.push(new Platform(188 * 25, this.height - 75, image));
		this.terrain.push(new Platform(189 * 25, this.height - 50, image));
		this.terrain.push(new Platform(189 * 25, this.height - 75, image));
		this.terrain.push(new Platform(191 * 25, this.height - 50, image));
		this.terrain.push(new Platform(191 * 25, this.height - 75, image));
		this.terrain.push(new Platform(192 * 25, this.height - 50, image));
		this.terrain.push(new Platform(192 * 25, this.height - 75, image));

		this.terrain.push(new Platform(189 * 25, this.height - 100, image));
		this.terrain.push(new Platform(189 * 25, this.height - 125, image));
		this.terrain.push(new Platform(189 * 25, this.height - 150, image));
		this.terrain.push(new Platform(191 * 25, this.height - 150, image));
		this.terrain.push(new Platform(191 * 25, this.height - 125, image));
		this.terrain.push(new Platform(191 * 25, this.height - 100, image));
		this.terrain.push(new Platform(190 * 25, this.height - 100, image));
		this.terrain.push(new Platform(190 * 25, this.height - 150, image));

		//- N ------------------------------------------------------------
		this.terrain.push(new Platform(194 * 25, this.height - 50, image));
		this.terrain.push(new Platform(194 * 25, this.height - 75, image));
		this.terrain.push(new Platform(194 * 25, this.height - 100, image));
		this.terrain.push(new Platform(194 * 25, this.height - 125, image));
		this.terrain.push(new Platform(194 * 25, this.height - 150, image));
		this.terrain.push(new Platform(195 * 25, this.height - 50, image));
		this.terrain.push(new Platform(195 * 25, this.height - 75, image));
		this.terrain.push(new Platform(195 * 25, this.height - 100, image));
		this.terrain.push(new Platform(195 * 25, this.height - 125, image));
		this.terrain.push(new Platform(195 * 25, this.height - 150, image));

		this.terrain.push(new Platform(198 * 25, this.height - 50, image));
		this.terrain.push(new Platform(198 * 25, this.height - 75, image));
		this.terrain.push(new Platform(198 * 25, this.height - 100, image));
		this.terrain.push(new Platform(198 * 25, this.height - 125, image));
		this.terrain.push(new Platform(198 * 25, this.height - 150, image));
		this.terrain.push(new Platform(199 * 25, this.height - 50, image));
		this.terrain.push(new Platform(199 * 25, this.height - 75, image));
		this.terrain.push(new Platform(199 * 25, this.height - 100, image));
		this.terrain.push(new Platform(199 * 25, this.height - 125, image));
		this.terrain.push(new Platform(199 * 25, this.height - 150, image));

		this.terrain.push(new Platform(196 * 25, this.height - 125, image));
		this.terrain.push(new Platform(196 * 25, this.height - 100, image));
		this.terrain.push(new Platform(197 * 25, this.height - 100, image));
		this.terrain.push(new Platform(197 * 25, this.height - 75, image));
	}

	/**
	 * Hard-Sets Background for Map
	 * 
	 * @param assets - Images for Platform Initialization
	 */
	private void genBackground(AssetManager assets)
	{
		// Loads Image ------------------------------------------------------
		Bitmap image;
		int w = this.width;
		try
		{
			image = BitmapFactory.decodeStream(assets.open("img/Bckgd0.png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			image = null;
		}
		// Default Display Testing
		//image = null;

		// Scales ---------------------------------------
		if (image != null)
		{
			double scale = this.height / image.getHeight();
			w = (int) scale * image.getWidth();
		}

		// Sets Sheets -----------------------------
		for (int c = 0; c < 2; c++)
		{
			this.background.push(new Sheet(c * w, 0,
					w, this.height, image));
		}
	}

	//~ Public Access =========================================================
	/**
	 * Returns all the gameObjects associated with Map.
	 * @return the gameobjects.
	 */
	public Queue<GameObject> getObjects()
	{
		Queue<GameObject> temp = new Queue<GameObject>();

		// Push Bckgd First, First to Draw
		for (Sheet s : this.background)
		{
			temp.push(s);
		}

		// Super-impose on previous pushes
		for (Platform p : this.terrain)
		{
			temp.push(p);
		}

		return temp;
	}

	/**
	 * Returns the platforms used in the game.
	 * @return the platforms used in the game.s
	 */
	public Stack<GameObject> getTerrain()
	{
		Stack<GameObject> temp = new Stack<GameObject>();
		for (Platform p : this.terrain)
		{
			temp.push(p);
		}
		return temp;
	}

	/**
	 * Returns the background objects ued in the game.
	 * @return the backbround objects.
	 */
	public Stack<GameObject> getBackground()
	{
		Stack<GameObject> temp = new Stack<GameObject>();
		for (Sheet s : this.background)
		{
			temp.push(s);
		}
		return temp;
	}

}
