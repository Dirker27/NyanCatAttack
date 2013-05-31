/**
 * Stack.java [NyanCatAttack]
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 26, 2012
 */
package nyanCatAttack.utilities;

/**
 * Stack [NyanCatAttack]
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 26, 2012
 * @param <Type>
 *            The of objects store in the stack.
 */
public class Stack<Type>
    extends Linked<Type>
{
    /**
     * The push method for the stack.
     * LIFO
     * Creates new head, puts old head as new's next
     */
    @Override
    public final void push(Type t)
    {
        Node<Type> temp = new Node<Type>(t);
        temp.setNext(this.getHead());
        this.setHead(temp);
    }
}
