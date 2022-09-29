import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    HashMap<String, List<CustomPair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    class CustomPair {
        String value;
        int timestamp;
        public CustomPair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))  map.put(key, new ArrayList<>());
        map.get(key).add(new CustomPair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<CustomPair> list = map.get(key);
        String rez = search(list, timestamp);
        return rez;
    }
    public String search (List<CustomPair> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        int foundStamp = list.get(start).timestamp;
        return foundStamp <= timestamp ? list.get(start).value : "";
    }
    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */

    public static void main (String[] args) {
        TimeMap timeMap = new TimeMap();String rez = "";
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}