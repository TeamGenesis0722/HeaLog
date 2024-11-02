package Genesis.healog.service;

import Genesis.healog.domain.Member;
import Genesis.healog.repogitory.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("test");

        //when
        Long saveId = memberService.join(member);

        //then
        Member finalMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(finalMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("test");

        Member member2 = new Member();
        member2.setName("test");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


        //then
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }
}