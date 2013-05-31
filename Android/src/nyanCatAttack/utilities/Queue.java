/**
 * Queue.java [NyanCatAttack]
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 26, 2012
 */
package nyanCatAttack.utilities;

/**
 * Queue [NyanCatAttack]
 *
 * @author Dirk Hotensius [dirker27]
 * @author Erich Alderfer [er1chald]
 * @author Jonathan Lester [jonal90]
 * @version Apr 26, 2012
 * @param <Type>
 *            The type of objects stored in the queue.
 */
public class Queue<Type>
    extends Linked<Type>
{
    /**
     * The push method for the queue.
     * [FIFO]
     * Steps through  chain, finds end of chain, inserts new node at end.
     */
    @Override
    public final void push(Type t)
    {
        Node<Type> temp = new Node<Type>(t);
        temp.setNext(null);

        if (this.isEmpty())
        {
            this.setHead(temp);
        }
        else
        {
            Node<Type> step = this.getHead();

            while (step.getNext() != null)
            {
                step = step.getNext();
            }
            step.setNext(temp);
        }
    }
}
