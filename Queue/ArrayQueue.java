
public class ArrayQueue implements Queue {
	private int header = -1;
	private int tail = -1;
	private int size;
	private int[] array;
	
	public ArrayQueue(int size){
		array = new int[size];
	}
	
	public ArrayQueue(){
		array = new int[10];
	}
	
	@Override
	public void enqueue(int data) {
		if(isFull())
			resize();
		if(isEmpty()){
			header = 0;
			tail = 0;
			array[0] = data;
			size++;
		}
		else{
			tail = (tail + 1) % array.length;
			array[tail] = data;
			size++;
		}
	}
	
	public int getSize(){
		return size;
	}

	@Override
	public Integer dequeue() {
		if(isEmpty())
			return null;
		else if(header == tail){
			int temp = array[header];
			header = -1;
			tail = - 1;
			size = 0;
			return temp;
			
		}
		else{
			int temp = array[header];
			header = (header + 1) % array.length;
			size--;
			return temp;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	

	@Override
	public Integer peek() {
		if(isEmpty())
			return null;
		return array[header];
	}
	
    private void resize() {
    	int [] temp = new int[2 * array.length];
        for (int i = 0; i < size; i++) {
            temp[i] = array[(header + i) % array.length];
        }
        array = temp;
        header = 0;
        tail  = size - 1;
    }

	@Override
	public boolean isFull() {
		return size == array.length;
	}
	
	public String toString(){
		String temp = "";
	    for (int i = 0; i < size; i++) {
	    	temp = temp + array[(header + i) % array.length] + " ";
	    }
	    return temp;
		
	}

}
