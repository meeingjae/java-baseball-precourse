package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class AssertjTest {

    List<String> stringList = Arrays.asList("hi", "my", "name", "is", "minjae");
    Map<Long, String> map = new HashMap<>();

    @DisplayName("AssertJ - object test")
    @Test
    void objectTest() {
        Person a = new Person("c", 29L);
        Person b = new Person("c", 29L);

        assertThat(a).isEqualToComparingFieldByFieldRecursively(b);
    }

    @DisplayName("AssertJ - boolean test")
    @Test
    void booleanTest() {
        assertThat("".isEmpty()).isTrue();
    }

    @DisplayName("AssertJ - String Array test")
    @Test
    void stringArrayTest() {
        assertThat(stringList).contains("minjae", "hi");
    }

    @DisplayName("AssertJ - empty List Test")
    @Test
    void listEmptyTest() {
        assertThat(stringList).isNotEmpty();
    }

    @DisplayName("AssertJ - List start with some index test")
    @Test
    void listStartWithTest() {
        assertThat(stringList).startsWith("hi");
    }

    @DisplayName("AssertJ - complex condition List test ")
    @Test
    void listComplexTest() {
        assertThat(stringList)
                .contains("minjae", "hi")
                .isNotEmpty()
                .startsWith("hi")
                .containsSequence("name", "is", "minjae")
                .doesNotContainNull();
    }

    @DisplayName("AssertJ - character test")
    @Test
    void characterTest() {
        char c = 'b';

        assertThat(c)
                .isNotEqualTo('a')
                .isGreaterThan('a')
                .isLessThan('c')
                .inUnicode()
                .isLowerCase();
    }

    @DisplayName("AssertJ - interface test")
    @Test
    void interfaceTest() {
        assertThat(Runnable.class)
                .isInterface();
    }

    @DisplayName("AssertJ - assignable class test")
    @Test
    void assignableTest() {
        assertThat(Person.class)
                .isAssignableFrom(Male.class);
    }

    @DisplayName("AssertJ - Map test")
    @Test
    void mapTest() {
        map.put(2L, "A");

        assertThat(map)
                .isNotEmpty()
                .containsKey(2L)
                .doesNotContainKeys(3L, 4L)
                .contains(entry(2L, "A"))
                .doesNotContainEntry(3L, "B");
    }

    @DisplayName("AssertJ - functional test")
    @Test
    void functionalTest() {
        assertThat(stringList)
                .filteredOn(value -> value.equalsIgnoreCase("HI"))
                .containsOnly("hi");
    }

    public static class Person {

        private String name;
        private Long age;

        public Person(String name, Long age) {
            this.name = name;
            this.age = age;
        }
    }


    public static class Male extends Person {

        public Male(String name, Long age) {
            super(name, age);
        }
    }
}
