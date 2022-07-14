package hello.servelt.web.frontcontroller.V3.controller;

import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.V3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paraMap) {
        return new ModelView("new-form");
    }
}
