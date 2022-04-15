package baseball.missionutil;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadLineTest {

    @Test
    void readLineTest() {

        //given:
        String inputString = "name";
        InputStream in = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        //when:
        String read = readLine();

        //then:
        assertThat(read)
                .isEqualTo("name");
    }
}
