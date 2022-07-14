package hello.servelt.web.frontcontroller.v2.controller;

import hello.servelt.domain.member.Member;
import hello.servelt.domain.member.MemberRepository;
import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        int age=Integer.parseInt(request.getParameter("age"));

        Member member=new Member(username,age);
        memberRepository.save(member);

        //Model 에 비즈니스 로직을 호출해서 얻은 데이터 결과를 담아줘야한다.(컨트롤러에서-서블릿)
        request.setAttribute("member",member);

        MyView myView = new MyView("/WEB-INF/views/save-result.jsp");
        return myView;
    }
}
