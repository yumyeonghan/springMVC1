package hello.servelt.web.frontcontroller.V3;

import hello.servelt.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paraMap);
}
