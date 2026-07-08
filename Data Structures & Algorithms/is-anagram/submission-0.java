class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sa = s.toLowerCase().toCharArray();
        char[] ta = t.toLowerCase().toCharArray();
        
        Arrays.sort(sa);
        Arrays.sort(ta);

        return Arrays.equals(sa,ta);
    }
}
