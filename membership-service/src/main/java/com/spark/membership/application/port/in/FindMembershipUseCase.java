package com.spark.membership.application.port.in;

import com.spark.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}
