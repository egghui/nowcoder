/**
 * Created by 李丹慧 on 2017/4/6.
 */
import java.util.*;

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if (lena != lenb) {
            return false;
        }
        HashMap mapa = new HashMap<Character, Integer>();
        HashMap mapb = new HashMap<Character, Integer>();

        toMap(mapa, A, lena);
        toMap(mapb, B, lenb);

        Iterator iter = mapa.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();

            if (!value.equals(mapb.get(key))) {
                return false;
            }
        }
        return true;
    }

    public void toMap(HashMap<Character, Integer> map, String str, int len) {
        for (int i = 0; i < len; i ++) {
            char c = str.charAt(i);
            int value = map.get(c)==null ? 0 : map.get(c);
            map.put(c, ++value);
        }
    }
}