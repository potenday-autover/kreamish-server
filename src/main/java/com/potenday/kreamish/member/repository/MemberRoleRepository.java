package com.potenday.kreamish.member.repository;

import com.potenday.kreamish.member.entity.MemberRole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {

}
