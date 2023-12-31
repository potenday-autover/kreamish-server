package com.potenday.kreamish.member.service;

import com.potenday.kreamish.member.entity.MemberRole;
import com.potenday.kreamish.member.repository.MemberRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.potenday.kreamish.member.dto.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberRoleServiceImpl implements MemberRoleService {

    private final MemberRoleRepository memberRoleRepository;

    @Override
    public MemberRoleRegisterResponseDto saveMemberRole(
        MemberRoleRegisterRequestDto requestDto
    ) {
        String name = requestDto.getName();

        MemberRole memberRole = MemberRole.builder()
            .name(name)
            .build();

        if (memberRoleRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException(
                String.format("이미 존재하는 이름의 MemberRole 입니다. memberRoleId -> %s", name)
            );
        }

        memberRoleRepository.save(memberRole);
        return MemberRoleRegisterResponseDto.builder()
            .memberRoleId(memberRole.getMemberRoleId())
            .name(memberRole.getName())
            .build();
    }

    @Override
    public MemberRoleUpdateResponseDto updateMember(MemberRoleUpdateRequestDto requestDto) {
        MemberRole memberRole = memberRoleRepository.findById(requestDto.getMemberRoleId())
            .orElseThrow(() -> new NoSuchElementException("memberRoleId 로 해당 MemberRole 을 찾을 수 없습니다."));

        String prevName = memberRole.getName();
        memberRole.changeName(requestDto.getName());

        return MemberRoleUpdateResponseDto.builder()
            .memberRoleId(memberRole.getMemberRoleId())
            .prevName(prevName)
            .afterName(memberRole.getName())
            .build();
    }

    @Override
    public MemberRoleDetailResponseDto getMemberRole(Long memberRoleId) {
        MemberRole memberRole = memberRoleRepository.findById(memberRoleId)
            .orElseThrow(() -> new NoSuchElementException("memberRoleId 로 해당 MemberRole 을 찾을 수 없습니다."));

        return MemberRoleDetailResponseDto.builder()
            .memberRoleId(memberRole.getMemberRoleId())
            .name(memberRole.getName())
            .build();
    }

    @Override
    public List<MemberRoleDetailResponseDto> getAllMemberRoles() {
        return memberRoleRepository.findAll()
            .stream().map(role -> MemberRoleDetailResponseDto.builder()
                .memberRoleId(role.getMemberRoleId())
                .name(role.getName())
                .build()).collect(Collectors.toList()
            );
    }
}
