
public class ArrayStack implements Stack{
	
	private int[] array;
	private int size;
    private int top = -1;
	
	public ArrayStack(int size){
		array = new int[size];
	}
    
    public ArrayStack(){
        array = new int[10];
    }
	
	@Override
	public void push(int data) {
		if(top == array.length)
			resize();
		top = top + 1;
		array[top] = data;
        size++;
	}

	@Override
	public Integer pop() {
		if(isEmpty())
			return null;
		int temp = array[top];
        top = top - 1;
        size--;
		return temp;
		
	}

	@Override
	public int getSize() {
		return size;
	}
	
	public void resize(){
		int[] temp = new int[array.length * 2];
		for(int i = 0; i < array.length;i++){
			temp[i] = array[i];
		}
		array = temp;
	}

	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}
	
	public String toString(){
		String temp = "";
		for(int i = size; i >= 0;i--){
			temp = temp + array[i] + " ";
		}
		return temp;
	}

	@Override
	public int peek() {
        if(isEmpty())
            return null;
		return array[top];
	}

}
