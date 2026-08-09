class TimeMap {
    static class Pair{
        String value;
        int time;

        Pair(String value, int time){
            this.value = value;
            this.time = time;
        }
    }

    private final Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<Pair> list, int timestamp){
        int l = 0;
        int r = list.size() - 1;
        String res = "";

        while(l <= r){
            int mid = l + (r - l)/2;
            if(list.get(mid).time <= timestamp){
                res = list.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
