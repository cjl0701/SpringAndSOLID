package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //final: 직접 할당하든 생성자로 할당하든 변수가 생성될 때부터 지정되야 함
    private final MemberRepository memberRepository;

    // 생성자 주입: 생성자를 통해 의존성 주입
   public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
