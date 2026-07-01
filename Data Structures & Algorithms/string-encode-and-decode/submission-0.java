class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word: strs){
            sb.append(word.length()).append("#").append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList();
        int i = 0;
        int j = 0;
        while(j < str.length()){
            j++;
            if(str.charAt(j) == '#'){
                int jump = Integer.parseInt(str.substring(i, j));
                i = j+jump+1;
                res.add(str.substring(j+1, i)); 
                j = i;
            }
        }
        return res;

    }
}
