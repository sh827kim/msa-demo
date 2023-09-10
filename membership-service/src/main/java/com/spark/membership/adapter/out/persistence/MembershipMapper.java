package com.spark.membership.adapter.out.persistence;

import com.spark.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {
    public Membership mapToDomainEntity(MembershipEntity membershipEntity) {
        return Membership.createMember(
                new Membership.MembershipId(membershipEntity.getMembershipId() + ""),
                new Membership.MembershipName(membershipEntity.getName()),
                new Membership.MembershipEmail(membershipEntity.getEmail()),
                new Membership.MembershipAddress(membershipEntity.getAddress()),
                new Membership.MembershipIsValid(membershipEntity.isValid()),
                new Membership.MembershipIsCorp(membershipEntity.isCorp())
        );
    }
}
