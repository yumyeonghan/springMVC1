package hello.servelt.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="helloServlet", urlPatterns = "/hello") //url 을 통해 서블릿이 호출됨.
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("hello" );
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //url 을 통해 get 방식으로 들어온 파라미터 값을 가져옴.
        System.out.println("username = " + username);

        //밑에 두가지는 컨텐트 타입, 헤더 정보에 들어감
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //http 메세지 바디에 내용이 들어감.
        response.getWriter().write("hello"+ username);

    }
}
