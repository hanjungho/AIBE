package org.example.simpleboot.service;

import org.example.simpleboot.model.entity.Member;
import org.example.simpleboot.model.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class NewService {

    private final MemberRepository memberRepository;

    public NewService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean create(Member member) {
        if (duplicateNameCheck(member.getName())) {
            return false;
//            return "중복된 이름입니다. 다른 이름을 입력해주세요.";
        } else {
            memberRepository.save(member);
            return true;
//            return "회원가입에 성공했습니다.";
        }
    }

    public boolean duplicateNameCheck(String name) {
        return memberRepository.findAll().stream()
                .anyMatch(member -> member.getName().equals(name));
    }
}
