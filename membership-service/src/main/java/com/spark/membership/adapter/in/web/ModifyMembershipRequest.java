package com.spark.membership.adapter.in.web;

import lombok.Getter;

@Getter
public class ModifyMembershipRequest {
    private String membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isCorp;
}
