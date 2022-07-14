package hello.servelt.web.frontcontroller.v1.controller;

import hello.servelt.domain.member.Member;
import hello.servelt.domain.member.MemberRepository;
import hello.servelt.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {
    MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        int age=Integer.parseInt(request.getParameter("age"));

        Member member=new Member(username,age);
        memberRepository.save(member);

        //Model 에 비즈니스 로직을 호출해서 얻은 데이터 결과를 담아줘야한다.(컨트롤러에서-서블릿)
        request.setAttribute("member",member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);

    }
}
