package ru.ifmo.collections;

import java.util.PriorityQueue;
import java.util.Queue;

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