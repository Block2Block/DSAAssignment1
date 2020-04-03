package dsa_assignment1;

public class MLNode<E> implements MLNodeInterface<E>
{
	private E                  item;
	private MLNodeInterface<E> next1;
	private MLNodeInterface<E> prev1;
	private MLNodeInterface<E> next2;
	private MLNodeInterface<E> prev2;

	MLNode(E element)
	{
		this.item = element;
		this.next1 = this.prev1 = this.next2 = this.prev2 = this;
	}

	/**
	 * For marking purposes
	 *
	 * @return Your student id
	 */
	public String getStudentID()
	{
		/* WRITE THIS CODE */

		// Change this return value to return your University Student Id number, e.g.
		// return "1234567";
		return "2025695";
	}

	/**
	 * For marking purposes
	 *
	 * @return Your name
	 */
	public String getStudentName()
	{

		// Change this return value to return your name, e.g.
		// return "John Smith";
		return "Ethan Lee Paterson-Barker";
	}

	public MLNodeInterface<E> remove1()
	{
		this.getPrev1().setNext1(this.getNext1());
		this.getNext1().setPrev1(this.getPrev1());

		this.setNext1(this);
		this.setPrev1(this);

		return this;
	}

	public MLNodeInterface<E> remove2()
	{
		this.getPrev2().setNext2(this.getNext2());
		this.getNext2().setPrev2(this.getPrev2());

		this.setNext2(this);
		this.setPrev2(this);

		return this;
	}

	public MLNodeInterface<E> addAfter1(MLNodeInterface<E> target)
	{
		remove1();

		//Sets the next value as what would have been in this nodes place.
		this.setNext1(target.getNext1());

		//Sets the next node of target (so what would be after this node)'s prev node to this one.
		target.getNext1().setPrev1(this);

		//Sets targets next node to this.
		target.setNext1(this);

		//Sets the previous node to target.
		this.setPrev1(target);
		return this;
	}

	public MLNodeInterface<E> addAfter2(MLNodeInterface<E> target)
	{
		remove2();

		//Sets the next value as what would have been in this nodes place.
		this.setNext2(target.getNext2());

		//Sets the next node of target (so what would be after this node)'s prev node to this one.
		target.getNext2().setPrev2(this);

		//Sets targets next node to this.
		target.setNext2(this);

		//Sets the previous node to target.
		this.setPrev2(target);
		return this;
	}

	public MLNodeInterface<E> addBefore1(MLNodeInterface<E> target)
	{

		remove1();

		//Sets the next value as what would have been in this nodes place.
		this.setNext1(target);

		//Sets the previous node to target.
		this.setPrev1(target.getPrev1());

		//Sets the previous node of target (so what would be before this node)'s next node to this one.
		target.getPrev1().setNext1(this);

		//Sets targets prev node to this.
		target.setPrev1(this);
		return this;
	}

	public MLNodeInterface<E> addBefore2(MLNodeInterface<E> target)
	{
		remove2();

		//Sets the next value as what would have been in this nodes place.
		this.setNext2(target);

		//Sets the previous node of target (so what would be before this node)'s next node to this one.
		target.getPrev2().setNext2(this);

		//Sets the previous node to target.
		this.setPrev2(target.getPrev2());

		//Sets targets prev node to this.
		target.setPrev2(this);
		return this;
	}

	public E getElement()
	{
		return item;
	}

	public MLNodeInterface<E> getNext1()
	{
		return next1;
	}

	public void setNext1(MLNodeInterface<E> next1)
	{
		this.next1 = next1;
	}

	public MLNodeInterface<E> getPrev1()
	{
		return prev1;
	}

	public void setPrev1(MLNodeInterface<E> prev1)
	{
		this.prev1 = prev1;
	}

	public MLNodeInterface<E> getNext2()
	{
		return next2;
	}

	public void setNext2(MLNodeInterface<E> next2)
	{
		this.next2 = next2;
	}

	public MLNodeInterface<E> getPrev2()
	{
		return prev2;
	}

	public void setPrev2(MLNodeInterface<E> prev2)
	{
		this.prev2 = prev2;
	}
}
