package hello.core.scan;

import hello.core.member.MemberService;
import hello.core.AutoAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        //스프링 컨테이너를 만드는 부분
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);//파라미터로 넣으면 즉시 빈으로 등록된다
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
