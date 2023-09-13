package com.potenday.kreamish.member.service;

import com.potenday.kreamish.member.dto.MemberDetailResponseDto;
import com.potenday.kreamish.member.dto.MemberRegisterRequestDto;
import com.potenday.kreamish.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberService {

    Optional<Member> getMemberById(Long memberId);

    Long registerMember(MemberRegisterRequestDto registerDto);

    MemberDetailResponseDto getMemberWithMemberRole(Long memberId);

    Page<MemberDetailResponseDto> getMemberPageList(Pageable pageable);
}
