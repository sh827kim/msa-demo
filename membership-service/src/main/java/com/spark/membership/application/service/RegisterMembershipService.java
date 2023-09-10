package com.spark.membership.application.service;

import com.spark.membership.adapter.out.persistence.MembershipMapper;
import com.spark.membership.application.port.in.RegisterMembershipCommand;
import com.spark.membership.application.port.in.RegisterMembershipUseCase;
import com.spark.membership.application.port.out.RegisterMembershipPort;
import com.spark.membership.common.UseCase;
import com.spark.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        var entity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );


        return membershipMapper.mapToDomainEntity(entity);
    }
}
