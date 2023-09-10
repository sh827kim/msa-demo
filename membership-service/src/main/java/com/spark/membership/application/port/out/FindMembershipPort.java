package com.spark.membership.application.port.out;

import com.spark.membership.adapter.out.persistence.MembershipEntity;
import com.spark.membership.domain.Membership;

import java.util.Optional;

public interface FindMembershipPort {

    Optional<MembershipEntity> findMembership(Membership.MembershipId membershipId);
}
