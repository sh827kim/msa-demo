package com.spark.membership.application.port.in;

import com.spark.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {
    @NotNull
    private String membershipId;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    @NotBlank
    private String address;
    @AssertTrue
    private boolean isValid;
    private boolean isCorp;

    public ModifyMembershipCommand(String membershipId, String name, String email, String address, boolean isValid, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;

        validateSelf();
    }
}
