package com.spark.membership.adapter.in.web;

import com.spark.common.WebAdapter;
import com.spark.membership.application.port.in.RegisterMembershipCommand;
import com.spark.membership.application.port.in.RegisterMembershipUseCase;;
import com.spark.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    public ResponseEntity<Membership> registerMembership(@RequestBody RegisterMembershipRequest request) {

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(registerMembershipUseCase.registerMembership(command));
    }
}
