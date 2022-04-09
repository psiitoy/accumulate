package org.sprintdragon.algorithm.jg;

public class MaxHeap {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public MaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //O(N*LogN)
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public void push(int val) {
        if (heapSize == limit) {
            throw new RuntimeException("heap size limit:" + limit);
        }
        heap[heapSize] = val;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        int ret = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ret;
    }

    private void heapify(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            largest = heap[largest] > heap[index] ? largest : index;
            if (index == largest) {
                break;
            }
            swap(heap, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    private void swap(int[] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
