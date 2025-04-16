package org.example.simpleboot.model.repository;

import org.example.simpleboot.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

//    Member save(Member member);
//    Optional<Member> findById(Long id);
//    Optional<Member> findByName(String name);
//    List<Member> findAll();

}
