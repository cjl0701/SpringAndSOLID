package hello.core.lombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Getter
@Setter
@ToString
class LombokTest {
    private int age;
    private String name;

    @Test
    void lomboktest() {
        LombokTest lombokTest = new LombokTest();
        lombokTest.setName("name by setter");
        Assertions.assertThat(lombokTest.getAge()).isEqualTo(0);
        Assertions.assertThat(lombokTest.getName()).isEqualTo("name by setter");
        System.out.println("lombokTest = " + lombokTest);//toString()
    }

}
