class myQueue {
	
	int[] arr;
	int capacity;
	int rear;
	int front;
	public myQueue(int n) {
		arr = new int[n];
		capacity = n;
		rear = -1;
		front = 0;
	}
	
	public boolean isEmpty() {
		return  rear==-1;
	}
	
	public boolean isFull() {
		return rear == capacity - 1;
	}
	
	public void enqueue(int x) {
		if (isFull()) {
			return;
		}
		arr[++rear] = x;
	}
	
	public void dequeue() {
		if (isEmpty()) {
			return;
		}
		for (int i = 0; i < rear; i++) {
			arr[i] = arr[i + 1];
		}
		rear--;
	}
	
	public int getFront() {
		if (isEmpty()) {
			return - 1;
		}
		return arr[0];
	}
	
	public int getRear() {
		if (isEmpty()) {
			return - 1;
		}
		return arr[rear];
	}
}
