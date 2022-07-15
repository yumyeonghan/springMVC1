package hello.servelt.web.springmvc.v3;

import hello.servelt.domain.member.Member;
import hello.servelt.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 리퀘스트 맵핑 문제점은 요청이 get, post 상관없이 요청 받음
    //@RequestMapping(value = "/new-form", method = RequestMethod.GET) GET 인 경우에만 호출.
    // 너무 길어서 GetMapping, PostMapping 사용
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";

    }

    @RequestMapping(method=RequestMethod.GET)
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                                @RequestParam("age") int age,
                                Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member",member);

        return "save-result";
    }
}
