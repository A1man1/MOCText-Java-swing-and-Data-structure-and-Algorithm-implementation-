package textgen;

import java.awt.List;
import java.util.AbstractList;

/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size=0;
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
	}
	public LLNode<E> Getprev()
	{
		LLNode<E> tmp =head.next;
		return  tmp.getPrev();
	}

 
	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	@Override
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null)
		{
			throw new NullPointerException();
		}
		   LLNode<E> tmp=tail;
		   tmp=tmp.prev;
			LLNode<E> newNode =new LLNode<E>(element);
			newNode.next=tmp.next;
			newNode.prev=tmp;
			newNode.next.prev=newNode;
			tmp.next=newNode;
			
		size++;
		return true;
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	@Override
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(size<index)throw new ArrayIndexOutOfBoundsException();
		LLNode<E> current=head;
		for(int i=0;i<=index;i++)
		{
			current=current.getNext();
		}
		if(current.data==null)throw new ArrayIndexOutOfBoundsException();
		return current.getdata();
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	@Override
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element==null) throw new NullPointerException();
		if(index>size)throw new ArrayIndexOutOfBoundsException();
		if(index==0)
		{
		  	LLNode<E> tmp=head;
			LLNode<E>  n=new LLNode<E>(element);
			n.next=tmp.next;
			n.prev=tmp;
			n.next.prev=n;
			tmp.next=n;
		}
		else
		{
			LLNode<E> tmp =head;
			LLNode<E> newNode;
			for(int i=1;i<=index;i++)
			{
				tmp=tmp.next;
			}
			 newNode=new LLNode<E>(element);
			newNode.next=tmp.next;
			newNode.prev=tmp;
			newNode.next.prev=newNode;
			tmp.next=newNode;
		}
		size++;
		return;		 
	}


	/** Return the size of the list */
	@Override
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	@Override
	public E remove(int index) 
	{
		// TODO: Implement this method
		E data=null;
		int pos=0;
		if(index>size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
			LLNode<E> tmp=head;
			for(pos=0;pos<=index;pos++)
			{
				tmp=tmp.getNext();
			}
			//removeMatch(tmp);
			LLNode<E> predecessor =tmp.getPrev();
			LLNode<E> successor =tmp.getNext();
			predecessor.setNext(successor);
			successor.setPrev(predecessor);
			size--;
			data= tmp.getdata();
		
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	@Override
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index>size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		LLNode<E> current=head;
		int pos;
		for(pos=0;pos<=index;pos++)
		{
			current=current.next;
		}
		return current.setData(element);
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
  
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	public E getdata()
	{
	  return this.data=data;
	}
	
	public E setData(E data)
	{
	    return this.data=data;	
	}
	
	public LLNode<E> getPrev()
	{
	  return this.prev=prev;
	}
	public LLNode<E> getNext()
	{
		return this.next=next;
	}
	public void setPrev(LLNode<E> wher)
	{
		 this.prev=wher;
	}
	public void setNext(LLNode<E> wher)
	{
		 this.next=wher;
	}
}
