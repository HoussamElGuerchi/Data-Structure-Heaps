package io.houssam.ds.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.houssam.ds.heap.Heap;

class HeapsTest {
	private Heap heap;
	
	@BeforeEach
	public void init() {
		heap = new Heap();
		heap.add(15);
		heap.add(10);
		heap.add(20);
		heap.add(17);
		heap.add(25);
	}
	
	@Test
	void peekHeap() {
		assertEquals(10, heap.peek());
	}

	@Test
	void pollHeap() {
		assertAll(() -> {
			assertEquals(10, heap.poll());
			assertArrayEquals(new int[] {15, 17, 20, 25}, heap.getItems());
		});
	}
	
	@Test
	void addToHeap() {
		heap.add(9);
		assertArrayEquals(new int[] {9, 15, 10, 17, 25, 20}, heap.getItems());
	}

}
