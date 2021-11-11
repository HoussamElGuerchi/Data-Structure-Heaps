package io.houssam.ds.heap;

public class Examples {
	
	public Examples() {
		exp01();
	}

	void exp01() {
		Heap heap = new Heap();
		heap.add(15);
		heap.add(10);
		heap.add(20);
		heap.add(17);
		heap.add(25);
		
		int[] items = heap.getItems();
		for (int item : items) {
			System.out.println(" - " + item);
		}
	}

	public static void main(String[] args) {
		new Examples();
	}

}
