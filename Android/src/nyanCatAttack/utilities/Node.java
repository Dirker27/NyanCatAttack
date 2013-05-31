/**
 * Node.java [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
package nyanCatAttack.utilities;

/**
 * Node [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 * @param <Type> The type of data represented by a node.
 */
public final class Node<Type>
{
	//~ Declarations ===================================================
	private Type data;
	private Node<Type> next;

	//~ Initialization =================================================
	/**
	 * CONSTRUCTOR [Node]
	 * @param data The type of data represented by the node.
	 */
	public Node(Type data)
	{
		this.setData(data);
		this.setNext(null);
	}


	//~ Public Access ==================================================

	//- Data -------------------
	/**
	 * Getter - Data
	 * @return data - [Type]
	 */
	public Type getData()
	{
		return data;
	}

	/**
	 * Setter - Data
	 * @param data
	 */
	public void setData(Type data)
	{
		this.data = data;
	}


	//- Next -----------------------
	/**
	 * Getter - next
	 * @return next - [Node<Type>]
	 */
	public Node<Type> getNext()
	{
		return next;
	}

	/**
	 * Setter - Next
	 * @param next
	 */
	public void setNext(Node<Type> next)
	{
		this.next = next;
	}

}
