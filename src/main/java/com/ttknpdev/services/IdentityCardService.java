package com.ttknpdev.services;

import com.ttknpdev.entities.IdentityCard;
import com.ttknpdev.exceptions.handler.ContentNotAllowed;
import com.ttknpdev.repositoties.IdentityCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityCardService {
    private IdentityCardRepository identityCardRepository;
    @Autowired
    public IdentityCardService(IdentityCardRepository identityCardRepository) {
        this.identityCardRepository = identityCardRepository;
    }
    public List<IdentityCard> retrieveAllIdentityCard() {
        return identityCardRepository.findAll();
    }

    public IdentityCard retrieveIdentityCard(String cidNumber) {
        // for test my exception
        // if cidNumber is not found it will throw my exception
        return identityCardRepository
                .findById(cidNumber)
                .orElseThrow(() -> {
            throw new ContentNotAllowed("There is no cid number "+cidNumber+".");
        });
    }

    public Boolean addIdentityCard(IdentityCard identityCard) {
        return identityCardRepository.save(identityCard).getCidNumber() != null;
        /*
        ------- demo requested look like.
        {
            "cidNumber": "1102003083199",
            "bornDate": "1997-11-30",
            "address": "311 soi.2 KBV. village nonthaburi-bangyai 10150",
            "customer": {
                "cid": "C003",
                "firstname": "Max",
                "lastname": "Slider"
            }
        }

        ------- command response jpa query look like.
        Hibernate: select ic1_0.cid_number,ic1_0.address,ic1_0.born_date,c1_0.cid,c1_0.firstname,c1_0.lastname from identity_cards ic1_0 left join customers c1_0 on c1_0.cid=ic1_0.cid where ic1_0.cid_number=?
        Hibernate: select c1_0.cid,c1_0.firstname,c1_0.lastname from customers c1_0 where c1_0.cid=?
        ------- Focus!! it inserts @OneToOne() properties first.
        Hibernate: insert into customers (firstname,lastname,cid) values (?,?,?)
        Hibernate: insert into identity_cards (address,born_date,cid,cid_number) values (?,?,?,?)
        */
    }

    public Boolean removeIdentityCard(String cidNumber) {
        return identityCardRepository.findById(cidNumber).map(identityCard -> {
            identityCardRepository.delete(identityCard);
            return true;
        }).orElse(false);
        /*
        ------- demo requested look like. /delete?cidNumber=1102033266
        Hibernate: delete from identity_cards where cid_number=?
        Hibernate: delete from customers where cid=?

        ------- command response jpa query look like.
        Hibernate: delete from identity_cards where cid_number=?
        Hibernate: delete from customers where cid=?
        */

    }

    public Boolean editIdentityCard(String cidNumber,IdentityCard identityCard) {
        return identityCardRepository.findById(cidNumber).map(identityCardFound -> {
            // identityCardFound.setCidNumber(identityCard.getCidNumber()); // pk should not change if you want text to me
            identityCardFound.setAddress(identityCard.getAddress());
            identityCardFound.setBornDate(identityCard.getBornDate());
            identityCardRepository.save(identityCardFound);
            return true;
        }).orElse(false);
    }

}
