class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> dic = new HashMap<>();
        List<List<String>> lst = new ArrayList<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(dic.containsKey(sorted)){
                int idx = dic.get(sorted);
                lst.get(idx).add(word);
            } else{
                dic.put(sorted, lst.size());
                lst.add(new ArrayList<String>());
                lst.get(lst.size()-1).add(word);
            }
        }
        return lst;
    }
}
