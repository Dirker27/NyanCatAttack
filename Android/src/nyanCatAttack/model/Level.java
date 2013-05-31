package nyanCatAttack.model;

import java.util.Observable;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import nyanCatAttack.utilities.Linked;
import nyanCatAttack.utilities.Queue;

/**
 * A class used to represent a level of Nyan Cat Attack.
 * 
 * Processes Map, Runs Game
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 27, 2012
 */
public final class Level
	extends Observable
{
	//~ Declarations ==========================================================

	//- Objects ------------------------
	private Queue<GameObject> 	onScreen;
	private Queue<GameObject>	objects;
	private Map					field;

	private NyanCat				cat;
	private boolean 			alive;

	//- Data ---------------------------
	private int 				width;
	private int 				height;
	private AssetManager		assets;

	/**
	 * Create a new Level Object.
	 *
	 * @param screenWidth the width of the screen.
	 * @param screenHeight the height of the screen.
	 * @param manager the assetManager of level assets.
	 */
	public Level(int screenWidth, int screenHeight, AssetManager manager)
	{
		// Set Data
		this.width = screenWidth;
		this.height = screenHeight;
		this.assets = manager;
		this.alive = true;

		// Fetches objects from Map
		this.field = new Map(this.width, this.height, manager);
		this.objects = this.field.getObjects();
		this.initNyan();
		this.objects.push(this.cat);

		// Sets OnScreenQueue (Bckgd first)
		this.onScreen = new Queue<GameObject>();
		for (GameObject g : this.field.getBackground())
		{
			this.onScreen.push(g);
		}
		this.manageOnScreen();

	}

	/**
	 * Updates the level according to the most recent input.
	 * @param arr the input type.
	 */
	public void update(Boolean[] arr)
	{
		//- Moves Objects ---
		if (arr[1])
		{
			this.scroll();
		}
		this.scroll();
		this.manageOnScreen();

		//- Moves Nyan Cat -----------------
		this.cat.update(arr, this.onScreen);
		if (this.cat.getY() > this.height)
		{
			this.alive = false;
		}

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Initializes Nyan Cat
	 */
	private void initNyan()
	{
		// Load Image
		Bitmap image;
		try
		{
			image = BitmapFactory
					.decodeStream(assets.open("img/nyanCat0.png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			image = null;
		}

		// Default Display Testing
		//image = null;

		this.cat = new NyanCat(image);
	}

	/**
	 * Manages onScreen Queue, ensures only items on Screen are sent to
	 *  View for display
	 */
	private void manageOnScreen()
	{
		for (GameObject obj : this.objects)
		{
			// Check if need to be pushed
			if (! this.onScreen.contains(obj)
					&& obj.getX() < this.width)
			{
				this.onScreen.push(obj);
			}
			// Removes object of off Screen
			else if(obj.getX() + obj.getWidth() < 0)
			{
				this.onScreen.delete(obj);
				this.objects.delete(obj);
			}
		}
	}

	/**
	 * Scrolls all objects
	 */
	private void scroll()
	{
		for (GameObject obj : this.objects)
		{
			obj.scroll();
		}
	}

	/**
	 * Determines if Nyan cat is still alive.
	 * @return true if still alive, false otherwise.
	 */
	public boolean getAlive()
	{
		return this.alive;
	}

	/**
	 * Returns all GameObjects.
	 * @return all GameObjects.
	 */
	public Linked<GameObject> getALL()
	{
		return this.objects;
	}

	/**
	 * Retusn the GameObjects currently on screen.
	 * @return the gameobjects currently on screen.
	 */
	public Linked<GameObject> getOnScreen()
	{
		return this.onScreen;
	}
}
