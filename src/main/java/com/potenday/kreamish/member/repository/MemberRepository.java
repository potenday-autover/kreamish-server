package com.potenday.kreamish.member.repository;

import com.potenday.kreamish.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.memberRole where m.memberId = :memberId")
    Optional<Member> findMemberWithMemberRole(@Param("memberId") Long memberId);

    Page<Member> findByMemberRoleIsNotNull(Pageable pageable);
}
