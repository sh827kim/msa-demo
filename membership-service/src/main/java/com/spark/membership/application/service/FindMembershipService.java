package com.spark.membership.application.service;


import com.spark.common.UseCase;
import com.spark.membership.adapter.out.persistence.MembershipMapper;
import com.spark.membership.application.port.in.FindMembershipCommand;
import com.spark.membership.application.port.in.FindMembershipUseCase;
import com.spark.membership.application.port.out.FindMembershipPort;
import com.spark.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional(readOnly = true)
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership findMembership(FindMembershipCommand command) {
        var entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(entity.orElseThrow());
    }
}
