
public class LinkedListStack implements Stack {
	private Node header;
	private int size;
	
	public LinkedListStack(){
		header = new Node(null);
	}
	
	public void push(Integer data){
		Node n = new Node(data);
		if(size == 0){
			header.next = n;
			size++;
		}
		else{
			Node temp = header.next;
			header.next = n;
			n.next = temp;
			size++;
		}
	}

	
	public int getSize(){
		return size;
	}
	
	public String toString(){
		Node n = header.next;
		String temp = "";
		while(n != null){
			temp = temp + n.data + " ";
			n = n.next;
		}
		return temp;
	}

	@Override
	public Integer pop() {
		if(size != 0){
			int temp = header.next.data;
			header.next = header.next.next;
			size--;
			return temp;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public Integer peek() {
		if(size != 0)
			return header.next.data;
		return null;
	}
	
	
}
