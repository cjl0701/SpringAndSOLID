package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 애플리케이션의 전체 동작 방식을 구성(config)하기 위해,
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
 * 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다
 **/
public class AppConfig {
    public MemberRepository memberRepository() { //역할
        return new MemoryMemberRepository(); //구현 클래스
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}