package com.spark.membership.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipEntity {

    @Id
    @GeneratedValue
    private Long membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isCorp;
    private boolean isValid;

    public MembershipEntity(String name, String email, String address, boolean isCorp, boolean isValid) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isCorp = isCorp;
        this.isValid = isValid;
    }

    public void changeName(String name) {
        if (isChanged(name, this.name)) this.name = name;
    }

    public void changeEmail(String email) {
        if (isChanged(email, this.email)) this.email = email;
    }

    public void changeAddress(String address) {
        if (isChanged(address, this.address)) this.address = address;
    }

    public void changeIsCorp(boolean isCorp) {
        if (this.isCorp != isCorp) this.isCorp = isCorp;
    }

    public void changeIsValid(boolean isValid) {
        if (this.isValid != isValid) this.isValid = isValid;
    }

    private boolean isChanged(String target, String value) {
        return target != null && !target.isEmpty() && !target.equals(value);
    }
}
