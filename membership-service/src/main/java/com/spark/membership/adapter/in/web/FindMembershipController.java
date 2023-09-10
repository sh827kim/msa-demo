package com.spark.membership.adapter.in.web;

import com.spark.membership.application.port.in.FindMembershipCommand;
import com.spark.membership.application.port.in.FindMembershipUseCase;
import com.spark.membership.common.WebAdapter;
import com.spark.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String  membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        var membership = findMembershipUseCase.findMembership(command);

        return ResponseEntity.ok(membership);
    }
}
