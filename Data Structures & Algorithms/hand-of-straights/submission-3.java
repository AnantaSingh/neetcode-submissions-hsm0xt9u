//SAW VIDEO AND copy pasted submit

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }
        
        Arrays.sort(hand);
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        
        for (int card : hand) {
            if (count.get(card) == 0) {
                continue;  // Already used
            }
            
            for (int i = 0; i < groupSize; i++) {
                int needed = card + i;
                
                if (!count.containsKey(needed) || count.get(needed) == 0) {
                    return false;
                }
                
                count.put(needed, count.get(needed) - 1);
            }
        }
        
        return true;
    }
}