package nyanCatAttack.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;

/**
 * A class used to represent gameobjects for the NyanCat game.
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 27, 2012
 */
public abstract class GameObject
    implements Scrollable
{
    // ~ Declarations ==========================================================

    private float    x;
    private float    y;
    private float    width;
    private float    height;

    private float    dx;

    private Bitmap image;
    private int    defColor;
    private RectF   hitBox;


    // ~ Initialization ========================================================
    /**
     * Creates a new GameOject.
     */
    public GameObject()
    {
        this(0, 0);
    }

    /**
     * Creates a new GameOject.
     * @param x the x value of the gameobject.
     * @param y the y value of the gameobject.
     * @param width the width of the gameobject.
     * @param height the height of the gameobject.
     * @param image the image representation fo the gameobject.
     */
    public GameObject(float x, float y, float width, float height, Bitmap image)
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);

        this.dx = 0;

        this.setImage(image);
        this.setDefColor(Color.RED);
        this.hitBox = new RectF(x, y, x + width, y + height);
    }

    /**
     * Creates a new GameOject.
     * @param x the x value of the gameobject.
     * @param y the y value of the gameobject.
     * @param image the image representation fo the gameobject.
     */
    public GameObject(int x, int y, Bitmap image)
    {
        this(x, y, 25, 25, image);
    }

    /**
     * Creates a new GameOject.
     * @param x the x value of the gameobject.
     * @param y the y value of the gameobject.
     */
    public GameObject(int x, int y)
    {
        this(x, y, null);
    }


    // ~ Public Access =========================================================

    // - Scroll -------------------------
    public void scroll()
    {
        this.x -= this.dx;
        this.resetHitBox();
    }


    // - TO STRING ----------------------
    /**
     * TO STRING Default - Coords.
     */
    public String toString()
    {
        return "[" + this.x + ", " + this.y + "]";
    }

    /**
     * Returns the name of the gameobject.
     * @return a string representation of the objects name.
     */
    public abstract String name();


    // - Equals ------------------------
    /**
     * A method that determines if 2 gameobjects are equals.
     * @param other the Gameobject to be compared to the original.
     * @return true if equal, false otherwise.
     */
    public boolean equals(GameObject other)
    {
        return (this.x == other.getX() && this.y == other.getY());
    }


    // - Getters / Setters -------------------
    /**
     * resets Rect
     */
    public void resetHitBox()
    {
        this.hitBox = new RectF(x, y, x + width, y + height);
    }
    /**
     * Getter - x
     * @return x - [int]
     */
    public float getX()
    {
        return x;
    }
    /**
     * Setter - x
     * @param x
     */
    public void setX(float x)
    {
        this.x = x;
    }
    /**
     * Getter - y
     * @return y - [int]
     */
    public float getY()
    {
        return y;
    }
    /**
     * Setter - y
     * @param y
     */
    public void setY(float y)
    {
        this.y = y;
    }
    /**
     * Getter - Width()
     * @return width - [int]
     */
    public float getWidth()
    {
        return width;
    }
    /**
     * Setter - width
     * @param width
     */
    public void setWidth(float width)
    {
        this.width = width;
    }
    /**
     * Getter - Height
     * @return height - [int]
     */
    public float getHeight()
    {
        return height;
    }
    /**
     * Setter - Height
     * @param height
     */
    public void setHeight(float height)
    {
        this.height = height;
    }
    /**
     * Getter - Image
     * @return image - [Bitmap]
     */
    public Bitmap getImage()
    {
        return image;
    }
    /**
     * Setter - Image
     * @param image
     */
    public void setImage(Bitmap image)
    {
        this.image = image;
    }
    /**
     * Getter - DefColor
     * @return defColor - [int]
     */
    public int getDefColor()
    {
        return defColor;
    }
    /**
     * Setter - DefColor
     * @param defColor
     */
    public void setDefColor(int defColor)
    {
        this.defColor = defColor;
    }
    /**
     * Getter - Hitbox
     * @return hitBox - [Rect]
     */
    public RectF getHitBox()
    {
        return hitBox;
    }
    /**
     * Setter - Hitbox
     * @param hitBox
     */
    public void setHitBox(RectF hitBox)
    {
        this.hitBox = hitBox;
    }
    /**
     * Setter - Rate
     * @param rate
     */
    public void setRate(float rate)
    {
        this.dx = rate;
    }
}
