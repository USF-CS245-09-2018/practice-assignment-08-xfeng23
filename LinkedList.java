
public class LinkedList implements List {

	public Node head;
	public int size;

	public LinkedList() {
		size = 0;
		head = null;
	}

	@Override
	public void add(Object obj) throws Exception {
		Node newNode = new Node(obj);
		newNode.next = head;
		head = newNode;
		size++;

	}

	public Node getNode(int pos) {
		if(pos<0||pos>size){
		      throw new IndexOutOfBoundsException("Index is not in the list");
		    }
		      
		   	Node current = head;
				for(int i=0; i<pos; i++){
		      current=current.next;
		    }
		    return current;

	}
	
	@Override
	public void add(int pos, Object obj) throws Exception {
		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException("Index is out of the limits of the list");
		}
		if (pos == 0) {
			Node newNode = new Node(obj);
			newNode.next = head;
			head = newNode;
			size++;
		} else {

			Node previous = getNode(pos - 1);
			Node newNode = new Node(obj);
			newNode.next = previous.next;
			previous.next = newNode;
			size++;
		}

	}

	@Override
	public Object get(int pos)throws Exception {
	    Node node = getNode(pos);
	    return node.getValue();
	  }
	
	

	@Override
	public Object remove(int pos) throws Exception {
		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException("Index is out of the limits of the list");
		}
		if (pos == 0) {
			Node current = head;
			head = head.next;
			size--;
			return current.getValue();
		} else {

			Node previous = getNode(pos - 1);
			Node current = getNode(pos);
			Node temp = current;
			current = current.next;
			previous.next = current;
			size--;
			return temp.getValue();
		}
	}

	@Override
	public int size() {
		return size;
	}

}
