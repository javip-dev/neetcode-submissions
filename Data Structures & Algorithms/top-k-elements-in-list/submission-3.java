class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> buckets = new HashMap<Integer, Integer>();
        int[] res = new int[k];

        // Put array elements in diferent buckets
        for (int i = 0; i < n; i++){
            if(buckets.containsKey(nums[i])){
                int val = buckets.get(nums[i]);
                buckets.put(nums[i], ++val);
            } else {
                buckets.put(nums[i], 1);
            }
        }
        // TODO: order the elements based on the bucket frecuency and return the top k elements
        // Iterate over hashmap get the k most frequent elements
        int[] sortedKeys = buckets.entrySet().stream()
                            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())                            .mapToInt(Map.Entry::getKey)
                            .toArray();

        for (int i = 0; i < k; i++){
            res[i] = sortedKeys[i];
        }
        return res;
    }
}
