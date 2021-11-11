package io.houssam.ds.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {
	private int capacity = 10;
	private int size = 0;
	private int[] items = new int[capacity];
	
	/******** Utilities Methods ********/
	private int getLeftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}
	private int getRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private int leftChild(int index) {
		if (!hasLeftChild(index)) throw new IndexOutOfBoundsException();
		return items[getLeftChildIndex(index)];
	}
	private int rightChild(int index) {
		if (!hasRightChild(index)) throw new IndexOutOfBoundsException();
		return items[getRightChildIndex(index)];
	}
	private int parent(int index) {
		if (!hasParent(index)) throw new IndexOutOfBoundsException();
		return items[getParentIndex(index)];
	}
	
	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	
	private void ensureCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *= 2;
		}
	}
	
	private void heapifyUp() {
		int index = size - 1;
		
		while (hasParent(index) && items[index] < parent(index)) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		
		// Check for childrens
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}
	
	/******** Heap Methods ********/
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int value) {
		ensureCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}
	
	/******** Accessors ********/
	public int getSize() {
		return size;
	}
	
	// This method returns items of heap for testing purpose
	public int[] getItems() {
		return Arrays.copyOf(items, size);
	}
}
