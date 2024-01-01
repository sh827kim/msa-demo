package com.spark.membership.application.service;

import com.spark.common.UseCase;
import com.spark.membership.adapter.out.persistence.MembershipMapper;
import com.spark.membership.application.port.in.ModifyMembershipCommand;
import com.spark.membership.application.port.in.ModifyMembershipUseCase;
import com.spark.membership.application.port.out.ModifyMembershipPort;
import com.spark.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {

        var entity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );


        return membershipMapper.mapToDomainEntity(entity);
    }
}
