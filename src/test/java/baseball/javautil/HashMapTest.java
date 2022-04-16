package baseball.javautil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @DisplayName("HashMap contains 메소드 테스트")
    @Test
    public void mapContainsTest() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,4);

        boolean key = map.containsKey(1);
        boolean value = map.containsValue(4);

        System.out.println("key contains 1? : " + key);
        System.out.println("value contains 4? : " + value);
    }
}
