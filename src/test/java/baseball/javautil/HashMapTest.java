package baseball.javautil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {

    @DisplayName("HashMap contains 메소드 테스트")
    @Test
    public void mapContainsTest() {
        //given:
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 4);

        //when:
        boolean key = map.containsKey(1);
        boolean value = map.containsValue(4);

        //then:
        assertThat(map.containsKey(1))
                .isTrue();
        assertThat(map.containsValue(4))
                .isTrue();
    }
}
