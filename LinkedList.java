/**
 * Represents a list of Nodes. 
 */
public class LinkedList {
	
	private Node first; // pointer to the first element of this list
	private Node last;  // pointer to the last element of this list
	private int size;   // number of elements in this list
	
	/**
	 * Constructs a new list.
	 */ 
	public LinkedList () {
		first = null;
		last = first;
		size = 0;
	}
	
	/**
	 * Gets the first node of the list
	 * @return The first node of the list.
	 */		
	public Node getFirst() {
		return this.first;
	}

	/**
	 * Gets the last node of the list
	 * @return The last node of the list.
	 */		
	public Node getLast() {
		return this.last;
	}
	
	/**
	 * Gets the current size of the list
	 * @return The size of the list.
	 */		
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Gets the node located at the given index in this list. 
	 * 
	 * @param index
	 *        the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 * @return the node at the given index
	 */		
	public Node getNode(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException(
					"index must be between 0 and size");
		}
		Node c = first;
		int i = 0;
		while (i < index) {
			c = c.next;
			i++;
		}
		return c;
	}
	
	/**
	 * Creates a new Node object that points to the given memory block, 
	 * and inserts the node at the given index in this list.
	 * <p>
	 * If the given index is 0, the new node becomes the first node in this list.
	 * <p>
	 * If the given index equals the list's size, the new node becomes the last 
	 * node in this list.
     * <p>
	 * The method implementation is optimized, as follows: if the given 
	 * index is either 0 or the list's size, the addition time is O(1). 
	 * 
	 * @param block
	 *        the memory block to be inserted into the list
	 * @param index
	 *        the index before which the memory block should be inserted
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 */
	public void add(int index, MemoryBlock block) {
		if (index< 0 || index> size) {
			throw new IllegalArgumentException("index must be between 0 and size");
		}
		Node newNode = new Node(block);
		if (index == 0) {
			addFirst(block);
			return;
		}
		else if (index==size) {
			addLast(block);
			return;
		}
		else {
			Node c = first;
			Node p = null;
			for(int i= 0; i < index; i++){
				p = c;
				c = c.next;
			}
			p.next = newNode;
			newNode.next = c;
			this.size++;
		}
		
	}

	/**
	 * Creates a new node that points to the given memory block, and adds it
	 * to the end of this list (the node will become the list's last element).
	 * 
	 * @param block
	 *        the given memory block
	 */
	public void addLast(MemoryBlock block) {
		Node node = new Node(block);
		if(first== null){
			first= node;
			last= node;
		} 
		else{
			last.next= node;
			last= node;
		}
		this.size++;
	}
	
	/**
	 * Creates a new node that points to the given memory block, and adds it 
	 * to the beginning of this list (the node will become the list's first element).
	 * 
	 * @param block
	 *        the given memory block
	 */
	public void addFirst(MemoryBlock block) {
		Node newNode = new Node(block);
		if (size== 0) {
			last= newNode;
			first= newNode;
			size++;
		}
		else
		{
		newNode.next= first;
		first= newNode;
		size++; 
		}
	}

	/**
	 * Gets the memory block located at the given index in this list.
	 * 
	 * @param index
	 *        the index of the retrieved memory block
	 * @return the memory block at the given index
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than or equal to size
	 */
	public MemoryBlock getBlock(int index) {
		if (index < 0 || index > size || size == 0) {
			throw new IllegalArgumentException("index must be between 0 and size");
	}
	Node node = getNode(index);
	return node.block;
	}	

	/**
	 * Gets the index of the node pointing to the given memory block.
	 * 
	 * @param block
	 *        the given memory block
	 * @return the index of the block, or -1 if the block is not in this list
	 */
	public int indexOf(MemoryBlock block) {
		Node c= first;
		int i= 0;
		while (c!= null) {
			if (c.block.equals(block)) {
				return i;
			}
			c= c.next;
			i++;
		}
		return -1;
	}

	/**
	 * Removes the given node from this list.	
	 * 
	 * @param node
	 *        the node that will be removed from this list
	 */
	public void remove(Node node) {
		if (node == null) {
			throw new IllegalArgumentException(" NullPointerException!");
		}
		if (size== 0) {
			return;
		} else if (size== 1) {
			if (this.first.equals(node)) {
				this.first = null;
				this.last = first;
				size--;
				return;
			} else {
				return;
			}
		} else if (first.equals(node)) {
			first = first.next;
			size--;
			return;
		}
		Node prev = this.first;
		Node current = prev.next;
		while (current != null) {
			if (current.equals(node)) {
				prev.next = current.next;
				size--;
				if (prev.next== null) {
					last= prev;
				}
				return;
			}
			prev= current;
			current = current.next;
		}
	}

	/**
	 * Removes from this list the node which is located at the given index.
	 * 
	 * @param index the location of the node that has to be removed.
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than or equal to size
	 */
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("index must be between 0 and size");
		}
		int cp = index;
		if (cp== 0) {
			first = first.next;
			size--;
			if (size==0) {
				last= first;
			}
			return;
		}
		Node c = first;
		while (cp > 1) {
			c=c.next;
			cp--;
		}
		if (index == size-1) {
			last= c;
		}
		c.next= c.next.next;
		size--;
	}

	

	/**
	 * Removes from this list the node pointing to the given memory block.
	 * 
	 * @param block the memory block that should be removed from the list
	 * @throws IllegalArgumentException
	 *         if the given memory block is not in this list
	 */
	public void remove(MemoryBlock block) {
		if (block== null) {
			throw new IllegalArgumentException("index must be between 0 and size");
		}
		if (size== 0) {
			return;
		} else if (size == 1) {
			if (this.first.block.equals(block)) {
				this.first = null;
				this.last = first;
				size--;
				return;
			} 
			else {
				throw new IllegalArgumentException("index must be between 0 and size");
			 } 
		} else 
		if(first.block.equals(block)) {
			first= first.next;
			size-- ;
			return;
		}
		Node prev = this.first;
		Node c = prev.next;
		while (c!=null) {
			if (c.block.equals(block)) {
				prev.next = c.next;
				size--;
				if (prev.next == null) {
					last= prev;
				}
				return;
			}
			prev=c;
			c=c.next;
		}
		throw new IllegalArgumentException("index must be between 0 and size");
	}	



	/**
	 * Returns an iterator over this list, starting with the first element.
	 */
	public ListIterator iterator(){
		return new ListIterator(first);
	}
	
	/**
	 * A textual representation of this list, for debugging.
	 */
	public String toString() {
		String str = "(";
		Node c = this.first;
		while (c != null) {
			str += c + ", ";
			c = c.next;
		}
		return str;
	}
	}
