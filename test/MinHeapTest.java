import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeapTest {
    @Test
    void shouldGetTheRightResults() {
        List<Integer> numbers = new ArrayList<>(List.of(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
        MinHeap minHeap = new MinHeap(numbers);
        minHeap.insert(76);
        assertEquals(-5, minHeap.peek());
        assertEquals(-5, minHeap.remove());
        assertEquals(2, minHeap.peek());
        assertEquals(2, minHeap.remove());
        assertEquals(6, minHeap.peek());
    }
}