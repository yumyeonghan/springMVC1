package hello.servelt.web.frontcontroller.v1.controller;

import hello.servelt.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // jsp 경로
        String viewPath="/WEB-INF/views/new-form.jsp";

        // 컨트롤러에서 뷰로 경로 이동할때 사용됨.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 서블릿에서 jsp 호출 할 수 있음.
        dispatcher.forward(request, response);
    }
}
