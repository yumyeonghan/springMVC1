package hello.servelt.web.frontcontroller.V3;

import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.V3.controller.MemberFormControllerV3;
import hello.servelt.web.frontcontroller.V3.controller.MemberListControllerV3;
import hello.servelt.web.frontcontroller.V3.controller.MemberSaveControllerV3;
import hello.servelt.web.frontcontroller.v2.ControllerV2;
import hello.servelt.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servelt.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servelt.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//프론트 컨트롤러
@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*") //v3 하위 어떤것(*)이 들어와도 호출 됨
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap =new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if(controller ==null){
            response.setStatus(404);
            return;
        }

        //paraMap 넘겨줘야함
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName(); //논리이름 new-form
        MyView view = viewResolve(viewName);
        view.render(mv.getModel(), request, response); //render 에 모델도 같이 넘겨줘야 함.
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
