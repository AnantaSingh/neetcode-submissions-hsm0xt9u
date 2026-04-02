public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        Map<Integer, Integer> count = new HashMap<>();

        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        for (int card : hand) {
            if (count.get(card) == 0) continue;

            for (int i = 0; i < groupSize; i++) {
                int needed = card + i;
                if (count.getOrDefault(needed, 0) == 0) return false;
                count.put(needed, count.get(needed) - 1);
            }
        }

        return true;
    }
}