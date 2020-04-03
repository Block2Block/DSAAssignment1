package dsa_assignment1;

import org.apache.log4j.Logger;

public class OrderedMruList<E extends Comparable<E>> implements OrderedMruListInterface<E>
{
	/**
	 * The head field is an <code>MLNode</code> object, where the
	 * <code>next1</code> and <code>prev1</code> pointers are for the circular Ordered list,
	 * and the <code>next2</code> and <code>prev2</code> are for the circular MRU list.
	 * It always contains the value <code>Null</code>.
	 * These lists are considered empty if there is no
	 * <b>other</b> <code>MLNode</code> object on the lists other
	 * than the <code>head</code> node itself
	 */
	MLNodeInterface<E> head   = new MLNode<E>(null);
	Logger             logger = Logger.getLogger(this.getClass());

	public OrderedMruList()
	{
	}

	public boolean isEmptyOrdered()
	{
		//This expression is OK, because i want to check that the objects are literally the same object,
		// and not just the .equals() function as this will return true even if they are not the same object.
		return head.getNext1() == head;
	}

	public boolean isEmptyMru()
	{
		//This expression is OK, because i want to check that the objects are literally the same object,
		// and not just the .equals() function as this will return true even if they are not the same object.
		return head.getNext2() == head;
	}

	public OrderedMruListInterface<E> touch(MLNodeInterface<E> target)
	{
		target.remove2();
		target.addAfter2(head);
		return null;
	}

	public MLNodeInterface<E> getFirstMru()
	{
		return ((isEmptyMru()) ? null : head.getNext2());
	}

	public MLNodeInterface<E> getFirstOrdered()
	{
		return ((isEmptyOrdered()) ? null : head.getNext1());
	}

	public MLNodeInterface<E> getNextOrdered(MLNodeInterface<E> current)
	{
		return current.getNext1();
	}

	public MLNodeInterface<E> getNextMru(MLNodeInterface<E> current)
	{
		return current.getNext2();
	}

	public OrderedMruListInterface<E> remove(MLNodeInterface<E> target)
	{
		target.remove1();
		target.remove2();
		return this;
	}

	public OrderedMruListInterface<E> add(E element)
	{
		logger.debug("Adding element " + element);
		MLNode<E> node = new MLNode<>(element);
		node.addBefore2(head.getNext2());
		if (isEmptyOrdered())
		{
			logger.debug("Adding node " + element + " after the HEAD node.");
			node.addAfter1(head);
		}
		else
		{
			MLNodeInterface<E> comparison = head.getNext1();
			while (comparison != head)
			{
				if (comparison.getNext1() == head)
				{
					if (element.compareTo(comparison.getElement()) > 0)
					{
						logger.debug("Adding node " + element + " after " + comparison.getElement());
						node.addAfter1(comparison);
						return this;
					}
					else
					{
						break;
					}
				}
				else
				{
					logger.debug("Comparison element: " + comparison.getElement());
					logger.debug("Value of comparison: " + element.compareTo(comparison.getElement()) + ">" + element
							.compareTo(comparison.getNext1().getElement()));
					if (element.compareTo(comparison.getElement()) > 0)
					{
						comparison = comparison.getNext1();
					}
					else
					{
						break;
					}
				}
			}
			logger.debug("Adding node " + element + " before " + comparison.getElement());
			node.addBefore1(comparison);
		}
		return this;
	}
}
