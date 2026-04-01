
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2]; // [position, speed]
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>(); // holds times to reach target; non-decreasing

        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) / (double) cars[i][1];
             //System.out.println(cars[i][0] + " " + time);

            // If current time <= top time, it catches up → same fleet → keep the slower (top).
            if (stack.isEmpty() || (!stack.isEmpty() && time > stack.peek())) {
                // new fleet (can’t catch up to the one ahead)
                stack.push(time);
            }
        }

        return stack.size();
    }
}
