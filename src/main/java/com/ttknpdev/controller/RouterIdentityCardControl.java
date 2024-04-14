package com.ttknpdev.controller;

import com.ttknpdev.constant.CommonStatus;
import com.ttknpdev.entities.IdentityCard;
import com.ttknpdev.entity.ResponseObject;
import com.ttknpdev.services.IdentityCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/identity-card")
public class RouterIdentityCardControl {
    private IdentityCardService identityCardService;
    @Autowired
    public RouterIdentityCardControl(IdentityCardService identityCardService) {
        this.identityCardService = identityCardService;
    }
    @GetMapping(value = "/reads")
    private ResponseEntity<ResponseObject> reads() {
        return ResponseEntity.ofNullable(ResponseObject.<List<IdentityCard>>builder()
                .status((short) CommonStatus.ACCEPTED[0])
                .info((String) CommonStatus.ACCEPTED[1])
                .data(identityCardService.retrieveAllIdentityCard())
                .build()
        );
    }

    @GetMapping(value = "/read")
    private ResponseEntity<ResponseObject> read(@RequestParam String cidNumber) {
        return ResponseEntity.ofNullable(ResponseObject.<IdentityCard>builder()
                .status((short) CommonStatus.ACCEPTED[0])
                .info((String) CommonStatus.ACCEPTED[1])
                .data(identityCardService.retrieveIdentityCard(cidNumber))
                .build()
        );
    }

    @PostMapping(value = "/create")
    private ResponseEntity<ResponseObject> create(@RequestBody IdentityCard identityCard) {
        // this is amazing
        return ResponseEntity.ofNullable(ResponseObject.<Boolean>builder()
                .status((short) CommonStatus.CREATE[0])
                .info((String) CommonStatus.CREATE[1])
                .data(identityCardService.addIdentityCard(identityCard))
                .build()
        );
    }

    @DeleteMapping(value = "/delete")
    private ResponseEntity<ResponseObject> create(@RequestParam String cidNumber) {
        return ResponseEntity.ofNullable(ResponseObject.<Boolean>builder()
                .status((short) CommonStatus.CREATE[0])
                .info((String) CommonStatus.CREATE[1])
                .data(identityCardService.removeIdentityCard(cidNumber))
                .build()
        );
    }

    @PutMapping(value = "/update")
    private ResponseEntity<ResponseObject> update(@RequestBody IdentityCard identityCard,@RequestParam String cidNumber) {
        // this is amazing
        return ResponseEntity.ofNullable(ResponseObject.<Boolean>builder()
                .status((short) CommonStatus.ACCEPTED[0])
                .info((String) CommonStatus.ACCEPTED[1])
                .data(identityCardService.editIdentityCard(cidNumber,identityCard))
                .build()
        );
    }
}
