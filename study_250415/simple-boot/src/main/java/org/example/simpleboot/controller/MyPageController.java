package org.example.simpleboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.simpleboot.model.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @GetMapping
    public String myPage(Model model, HttpServletRequest httpServletRequest) {
        Member member = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        model.addAttribute("msg", member.getName());
        return "myPage";
    }
}
