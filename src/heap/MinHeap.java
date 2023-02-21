package heap;

import java.util.Arrays;

public class MinHeap {
    int arr[];
    int heapSize;
    int capacity;

    public MinHeap(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        heapSize = 0;
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    public int getMinimum() {
        return heapSize > 0 ? arr[0] : -1;
    }

    public void insertKey(int key) {
        if(heapSize == capacity) {
            throw new IllegalArgumentException("Capacity overflow");
        } else if (heapSize == 0) {
            arr[0] = key;
        } else {
            arr[heapSize] = key;
            for (int i = heapSize; i >= 0; ) {
                int parent = (heapSize - 1) / 2;

                if (arr[parent] <= arr[i]) {
                    break;
                } else {
                    swap(i, parent);
                }

                i = parent;
            }

        }
        heapSize++;
    }

    public int pop() {
        int smallest = getMinimum();
        arr[0] = arr[heapSize - 1];
        heapSize--;
        heapify(0);
        return smallest;
    }

    private void heapify(int i) {
        if(i >= heapSize) {
            return;
        }

        int l = (i*2)+1;
        int r = (i*2)+2;
        int smallest = i;

        if (l < heapSize && arr[l] < arr[i]) {
            smallest = l;
        }

        if(r < heapSize && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if(i != smallest) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(50);
        h.insertKey(3);
        h.printHeap();
        h.insertKey(2);
        h.printHeap();
        System.out.println("Pop:" + h.pop());
        h.printHeap();
        //h.deleteKey(1);
        h.insertKey(15);
        h.printHeap();
        h.insertKey(5);
        h.printHeap();
        System.out.println("Pop:" + h.pop());
        h.printHeap();
        h.insertKey(4);
        h.printHeap();
        h.insertKey(45);
        h.printHeap();

    }
}
