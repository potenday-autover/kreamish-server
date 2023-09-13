package com.potenday.kreamish.member.service;

import com.potenday.kreamish.member.dto.*;

import java.util.List;

public interface MemberRoleService {
    MemberRoleRegisterResponseDto saveMemberRole(MemberRoleRegisterRequestDto requestDto);

    MemberRoleUpdateResponseDto updateMember(MemberRoleUpdateRequestDto requestDto);

    MemberRoleDetailResponseDto getMemberRole(Long memberRoleId);

    List<MemberRoleDetailResponseDto> getAllMemberRoles();
}
