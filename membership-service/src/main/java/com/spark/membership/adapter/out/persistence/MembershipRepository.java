package com.spark.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<MembershipEntity, Long> {
}
