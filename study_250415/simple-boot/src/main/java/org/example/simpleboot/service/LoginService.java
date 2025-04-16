package org.example.simpleboot.service;

import org.example.simpleboot.model.entity.Member;
import org.example.simpleboot.model.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> check(String name) {
        List<Member> byName = memberRepository.findByName(name);
        if (byName.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(byName.get(0));
    }

}
