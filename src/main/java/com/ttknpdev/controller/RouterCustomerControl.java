package com.ttknpdev.controller;

import com.ttknpdev.constant.CommonStatus;
import com.ttknpdev.entities.Customer;
import com.ttknpdev.logging.MyLog4j;
import com.ttknpdev.entity.ResponseObject;
import com.ttknpdev.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class RouterCustomerControl {
    private CustomerService customerService;
    private MyLog4j myLog4j;
    @Autowired
    public RouterCustomerControl(CustomerService customerService) {
        this.customerService = customerService;
        myLog4j = new MyLog4j(RouterCustomerControl.class);
    }

    @GetMapping(value = "/reads")
    private ResponseEntity<ResponseObject> reads() {
        List<Customer> customers = customerService.retrieveAllCustomers();
        // myLog4j.log.info("customer[0] stores {}",customers.get(0));
        return ResponseEntity.ofNullable(ResponseObject.<List<Customer>>builder()
                .status((short) CommonStatus.ACCEPTED[0])
                .info((String) CommonStatus.ACCEPTED[1])
                .data(customers)
                .build()
        );
    }
}
