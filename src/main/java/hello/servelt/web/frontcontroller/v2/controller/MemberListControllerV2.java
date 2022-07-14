package hello.servelt.web.frontcontroller.v2.controller;

import hello.servelt.domain.member.Member;
import hello.servelt.domain.member.MemberRepository;
import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        // key, value
        request.setAttribute("members",members);

        MyView myView = new MyView("/WEB-INF/views/members.jsp");
        return myView;

    }
}
