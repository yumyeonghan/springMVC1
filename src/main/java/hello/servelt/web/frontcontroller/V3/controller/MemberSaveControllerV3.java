package hello.servelt.web.frontcontroller.V3.controller;

import hello.servelt.domain.member.Member;
import hello.servelt.domain.member.MemberRepository;
import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.V3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paraMap) {
        String username = paraMap.get("username");
        int age = Integer.parseInt(paraMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);
        return mv;

    }
}
