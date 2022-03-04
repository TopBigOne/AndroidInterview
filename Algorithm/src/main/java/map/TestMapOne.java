package map;

import java.util.HashMap;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/24 12:54
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TestMapOne {
    public static void main(String[] args) {
        testOne();

    }

    private static void testOne() {
        System.out.println(" start  map test.");
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "65");
        if (map.containsKey("2")) {
            map.replace("2","46543654");
        }


        System.out.println("map result : " + map.toString());


    }
}
