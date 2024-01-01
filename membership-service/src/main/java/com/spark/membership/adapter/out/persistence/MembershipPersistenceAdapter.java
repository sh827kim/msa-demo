package com.spark.membership.adapter.out.persistence;

import com.spark.common.PersistenceAdapter;
import com.spark.membership.application.port.out.FindMembershipPort;
import com.spark.membership.application.port.out.ModifyMembershipPort;
import com.spark.membership.application.port.out.RegisterMembershipPort;
import com.spark.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final MembershipRepository membershipRepository;
    @Override
    public MembershipEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                new MembershipEntity(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorpValue()
                )
        );
    }

    @Override
    public Optional<MembershipEntity> findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()));
    }


    @Override
    public MembershipEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        MembershipEntity entity = membershipRepository.findById(Long.parseLong(membershipId.getMembershipId())).orElseThrow();

        entity.changeName(membershipName.getNameValue());
        entity.changeEmail(membershipEmail.getEmailValue());
        entity.changeAddress(membershipAddress.getAddressValue());
        entity.changeIsValid(membershipIsValid.isValidValue());
        entity.changeIsCorp(membershipIsCorp.isCorpValue());

        return membershipRepository.save(entity);
    }
}
