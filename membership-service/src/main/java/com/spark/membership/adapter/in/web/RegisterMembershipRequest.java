package com.spark.membership.adapter.in.web;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterMembershipRequest {
    private String name;
    private String email;
    private String address;
    private boolean isCorp;
}
