package org.example.simpleboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.simpleboot.model.dto.MemberForm;
import org.example.simpleboot.model.entity.Member;
import org.example.simpleboot.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        model.addAttribute("msg", "로그인 페이지 입니다.");
        model.addAttribute("memberForm", new MemberForm(null, ""));
        return "login";
    }

    @PostMapping
    public String checkLogin(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, MemberForm memberForm) {
        String name = memberForm.name();
        Optional<Member> check = loginService.check(name);
        if (check.isPresent()) {
            Member member = check.get();
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginMember", member);
            redirectAttributes.addFlashAttribute("alertMsg", "로그인 성공");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("alertMsg", "로그인 실패");
            return "redirect:/login";
        }
    }
}
