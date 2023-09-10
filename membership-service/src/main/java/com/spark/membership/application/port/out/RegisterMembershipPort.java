package com.spark.membership.application.port.out;

import com.spark.membership.adapter.out.persistence.MembershipEntity;
import com.spark.membership.domain.Membership;

public interface RegisterMembershipPort {
    MembershipEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    );
}
