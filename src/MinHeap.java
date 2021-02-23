import java.util.List;

public class MinHeap {
    List<Integer> heap;

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    // Two approaches
    // 1. sift down method - sift down from the last parent
    //    - This is in place, no new array
    //    - O(N) , most of the sift down is at the lower nodes
    // 2. sift up - O(NlogN) most node at the bottom are sifting up (logN time)
    public List<Integer> buildHeap(List<Integer> array) {
        int lastParentIdx = (array.size() - 2) / 2;
        while (lastParentIdx >= 0) {
            siftDown(lastParentIdx, array.size() - 1, array);
            lastParentIdx--;
        }
        return array;
    }

    // Remember to update your indexes!!!
    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int leftChild = (2 * currentIdx) + 1;
        if (leftChild > endIdx) {
            return;
        }
        // there is at least a child from here
        int smallerChildIdx = leftChild;
        int rightChild = (2 * currentIdx) + 2;
        if (rightChild <= endIdx) {
            smallerChildIdx = heap.get(leftChild) < heap.get(rightChild) ? leftChild : rightChild;
        }

        if (heap.get(smallerChildIdx) < heap.get(currentIdx)) {
            swap(smallerChildIdx, currentIdx, heap);
            siftDown(smallerChildIdx, endIdx, heap);
        }

    }

    // NOTE: remember to update your current and parent indexes!
    public void siftUp(int currentIdx, List<Integer> heap) {
        // get parent index
        int parentIdx = (currentIdx - 1) / 2;
        // move up while child is smaller than parent
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        // 1. replace top node with last node, return prev min.
        int last = heap.size()-1;
        swap(last, 0, heap);
        int prevMin = heap.remove(last);
        // 2. sift down
        siftDown(0, heap.size()-1, heap);

        return prevMin;
    }

    public void insert(int value) {
        // add it to the end of the heap
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    public void swap (int childIdx, int parentIdx, List<Integer> heap) {
        int child = heap.get(childIdx);
        heap.set(childIdx, heap.get(parentIdx));
        heap.set(parentIdx, child);
    }
}
