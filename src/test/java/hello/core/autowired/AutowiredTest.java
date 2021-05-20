package hello.core.autowired;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        //빈으로 등록되며 @Autowired가 있으면 의존관계를 주입해준다
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean2.class);
        TestBean2 testBean2 = ac.getBean(TestBean2.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setBean1(Member bean1) {
            System.out.println("bean1 = " + bean1);
        }

        @Autowired
        public void setBean2(@Nullable Member bean2) {
            System.out.println("bean2 = " + bean2);
        }

        @Autowired
        public void setBean3(Optional<Member> bean3) {
            System.out.println("bean3 = " + bean3);
        }
    }

    static class TestBean2 {
        private final Member bean;

        //생성자 주입엔 @Autowired(required = false)를 쓸 수 없다
        @Autowired
        public TestBean2(@Autowired(required = false) Member bean) {
            this.bean = bean;
        }

        public Member getBean() {
            return bean;
        }
    }
}
