package org.example.simpleboot.controller;

import org.example.simpleboot.model.dto.MemberForm;
import org.example.simpleboot.model.entity.Member;
import org.example.simpleboot.service.NewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/new")
public class NewController {

    private final NewService newService;

    public NewController(NewService newService) {
        this.newService = newService;
    }

    @GetMapping
    public String newMember(Model model) {
        model.addAttribute("msg", "회원가입 페이지 입니다.");
        model.addAttribute("memberForm", new MemberForm(null, ""));
        return "new";
    }

    @PostMapping
    public String createMember(RedirectAttributes redirectAttributes, MemberForm memberForm) {

        Member member = new Member();
        member.setName(memberForm.name());

        boolean bool = newService.create(member);
        if (bool) {
            redirectAttributes.addFlashAttribute("alertMsg", "회원가입에 성공했습니다.");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("alertMsg", "중복된 이름입니다. 다른 이름을 입력해주세요.");
            return "redirect:/new";
        }
    }
}
