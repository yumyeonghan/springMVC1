package hello.servelt.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // jsp 경로
        String viewPath="/WEB-INF/views/new-form.jsp";

        // 컨트롤러에서 뷰로 경로 이동할때 사용됨.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 서블릿에서 jsp 호출 할 수 있음.
        dispatcher.forward(request, response);
    }
}
