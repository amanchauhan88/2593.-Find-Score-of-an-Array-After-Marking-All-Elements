

import java.util.PriorityQueue;
class Solution {
    public long findScore(int[] nums) {
        // Create a priority queue (min-heap) with (value, index) pairs
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare values
            }
            return Integer.compare(a[1], b[1]); // Compare indices if values are equal
        });

        // Populate the heap
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});
        }

        // Initialize variables
        boolean[] marked = new boolean[nums.length]; // To track marked elements
        long score = 0;

        // Process the heap
        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int value = current[0];
            int index = current[1];

            // Skip already marked elements
            if (marked[index]) {
                continue;
            }

            // Add the value to the score
            score += value;

            // Mark the current element and its adjacent ones if they exist
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index < nums.length - 1) {
                marked[index + 1] = true;
            }
        }

        return score;
    }
}
