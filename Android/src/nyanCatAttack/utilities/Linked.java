/**
 * Linked.java [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 */
package nyanCatAttack.utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked [NyanCatAttack]
 *
 *
 * @author Dirk Hotensius 	[dirker27]
 * @author Erich Alderfer 	[er1chald]
 * @author Jonathan Lester	[jonal90]
 * @version Apr 26, 2012
 * @param <Type> The type of data stored in the linked data structures.
 */
public abstract class Linked<Type>
	implements Iterable <Type>
{
	//~ Declarations ==========================================================
	private Node<Type> head;

	//~ Initialization ========================================================
	/**
	 * CONSTRUCTOR [Linked]
	 *
	 */
	protected Linked()
	{
		this.setHead(null);
	}

	//~ Private Operations ====================================================
	/**
	 * linkedIterator [NyanCatAttack]
	 *
	 * @author Dirk Hotensius 	[dirker27]
	 * @author Erich Alderfer 	[er1chald]
	 * @author Jonathan Lester	[jonal90]
	 * @version Apr 26, 2012
	 */
	private class linkedIterator<E>
		implements Iterator<E>
	{
		private Node<E> current;
		private Node<E> prev;
		private boolean primed;

		/**
		 * CONSTRUCTOR [linkedIterator]
		 *
		 */
		@SuppressWarnings("unchecked")
		public linkedIterator()
		{
			this.prev = new Node<E>(null);
			this.prev.setNext((Node<E>) getHead());
			this.current = this.prev;
			this.primed = false;
		}

		/** 
		 * Iteration - hasNext
		 * 
		 * @return [Boolean] if there is a next value
		 */
		public boolean hasNext()
		{
			return (this.current.getNext() != null);
		}

		/**
		 * Iteration - next
		 * 
		 * @return value of next item in iteration
		 */
		public E next()
		{
			if (hasNext())
			{
				this.prev = current;
				this.current = this.current.getNext();
				this.primed = true;

				return this.current.getData();
			}

			throw new NoSuchElementException();
		}

		/**
		 * Iterator - remove
		 */
		@SuppressWarnings("unchecked")
		public void remove()
		{
			if (this.primed)
			{
				if (this.current == getHead())
				{
					pop();
					this.prev = new Node<E>(null);
					this.prev.setNext((Node<E>) getHead());
				}
				else
				{
					Node<E> temp = this.current;
					this.current.setNext(temp.getNext());
					temp.setNext(null);
				}
				this.current = this.prev;
				this.primed = false;
			}
			else
			{
				throw new IllegalStateException();
			}
		}
	}


	//~ Public Access =========================================================

	//- Push ----------------------------
	/**
	 * Allows new items to be added to the data structure.
	 * @param t the type of data to be added to the structure.
	 */
	public abstract void push(Type t);

	//- Pop -----------------------------
	/**
	 * Removes the top/front item from the data structure.
	 */
	public final void pop()
	{
		if( size() > 0 )
		{
			Node<Type> temp = this.head;
			this.head = this.head.getNext();
			temp.setNext(null);
		}
		else
		{
			throw new NullPointerException();
		}
	}

	//- Top -----------------------------
	/**
	 * Top Accessor
	 * @return Top data
	 */
	public final Type top()
	{
		if (this.head == null)
		{
			return null;
		}
		else
		{
			return this.head.getData();
		}
	}

	//- Delete -----------------------------
	/**
	 * removes specific element from chain (first Instance)
	 * 
	 * @param t - element to be removed
	 */
	public final void delete(Type t)
	{
		if (! this.isEmpty())
		{
			Node<Type> temp = this.head;
			if (this.head.getData().equals(t))
			{
				this.pop();
				temp.setNext(null);
			}
			else
			{
				Node<Type> prev = this.head;
				while (temp != null)
				{
					if (temp.getData().equals(t))
					{
						prev.setNext(temp.getNext());
						temp.setNext(null);
						break;
					}
					prev = temp;
					temp = temp.getNext();
				}
			}
		}
		else
		{
		    throw new IllegalStateException();
		}
	}

	//- Is Empty ----------------------------------
	/**
	 * Determines if a data structure is empty.
	 * 
	 * @return [Boolean] true if empty, false otherwise.
	 */
	public final boolean isEmpty()
	{
		return (this.head == null);
	}

	//- Contains ----------------------------
	/**
	 * Determines if the data structure contains an object.
	 * @param r the object being searched for.
	 * @return true if object is found, false otherwise.
	 */
	public final boolean contains(Type r)
	{
		Boolean b = false;
		Node<Type> temp = this.head;

		while (temp != null)
		{
			if (temp.getData().equals(r))
			{
				b = true;
				break;
			}
			temp = temp.getNext();
		}

		return b;
	}

	//- Size ---------------------------
	/**
	 * Returns the size of the data structure.
	 * @return the size, number of elements in the data structure.
	 */
	public final int size()
	{
		Node<Type> temp = this.head;
		int c = 0;
		while (temp != null)
		{
			temp = temp.getNext();
			c ++;
		}

		return c;
	}

	//- Iterator -----------------------
	/**
	 * The iterator method for the linked data structures.
	 * @return the iterator the the data structures.
	 */
	public final Iterator<Type> iterator()
	{
		return new linkedIterator<Type>();
	}

	//- Head ---------------------
	/**
	 * Returns the top, head, node of a data structure.
	 * @return the head of the data structure.
	 */
	public final Node<Type> getHead()
	{
		return head;
	}

	/**
	 * @param head
	 */
	public final void setHead(Node<Type> head)
	{
		this.head = head;
	}

}
