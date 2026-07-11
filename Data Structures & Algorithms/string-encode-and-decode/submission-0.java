class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int slash = s.indexOf('#', i);
            int len = Integer.parseInt(s.substring(i, slash));
            String word = s.substring(slash + 1, slash + 1 + len);
            list.add(word);
            i = slash + 1 + len;
        }
        return list;
        
    }
}
