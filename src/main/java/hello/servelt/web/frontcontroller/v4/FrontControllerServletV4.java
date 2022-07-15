package hello.servelt.web.frontcontroller.v4;

import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.V3.ControllerV3;
import hello.servelt.web.frontcontroller.V3.controller.MemberFormControllerV3;
import hello.servelt.web.frontcontroller.V3.controller.MemberListControllerV3;
import hello.servelt.web.frontcontroller.V3.controller.MemberSaveControllerV3;
import hello.servelt.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servelt.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servelt.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//프론트 컨트롤러
@WebServlet(name="frontControllerServletV4", urlPatterns = "/front-controller/v4/*") //v4 하위 어떤것(*)이 들어와도 호출 됨
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap =new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if(controller ==null){
            response.setStatus(404);
            return;
        }

        //paraMap 넘겨줘야함
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model=new HashMap<>(); //추가

        String viewName = controller.process(paramMap, model);

        MyView view = viewResolve(viewName);
        view.render(model, request, response);
    }

    private MyView viewResolve(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String > paramMap=new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
