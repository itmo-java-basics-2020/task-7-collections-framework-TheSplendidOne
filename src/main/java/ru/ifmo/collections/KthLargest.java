package ru.ifmo.collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final Queue<Integer> minHeap;

    public KthLargest(int k, int[] numbers) {
        minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.add(number);
        }

        while (minHeap.size() != k) {
            minHeap.remove();
        }
    }

    public int add(int val) {
        if (val > minHeap.element()) {
            minHeap.remove();
            minHeap.add(val);
        }
        return minHeap.element();
    }
}