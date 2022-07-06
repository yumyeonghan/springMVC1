package hello.servelt.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    //싱글톤(private)으로 인해 new 생성 불가
    MemberRepository memberRepository=MemberRepository.getInstance();

    @AfterEach //테스트가 끝나면 초기화
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello",20);

        Member saveMember =memberRepository.save(member);

        Member findMember=memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        Member member1=new Member("member1",30);
        Member member2=new Member("member2",30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> all = memberRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(2);
        Assertions.assertThat(all).contains(member1,member2); //member1, member2 객체가 들어있는지 확인

    }


}