package com.banking.controller;


import com.banking.dto.CustomerDto;
import com.banking.entity.Customer;
import com.banking.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class BankController {

    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService bankService;


   /* @Autowired
    private KafkaProducerService kafkaProducerService;
*/

    @PostMapping
    public ResponseEntity<CustomerDto> createAccount(@RequestBody Customer customer) {
        CustomerDto customerDto = bankService.addCustomer(customer);
        logger.info("CREATING CUSTOMER ACCOUNTS {}", customerDto);
        // kafkaProducerService.sendCustomerCreatedEvent(customerDto);
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.CREATED);
    }

    @GetMapping("/{aadharNumber}")
    public ResponseEntity<CustomerDto> getCustomerDetails(@PathVariable("aadharNumber") String aadharNumber) {
        CustomerDto fetchCustomer = bankService.getCustomer(aadharNumber);
        logger.info("FETCHING CUSTOMER ACCOUNTS DETAILS {}", fetchCustomer);
        return new ResponseEntity<CustomerDto>(fetchCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{aadharNumber}")
    public ResponseEntity<CustomerDto> removeCustomerDetails(@PathVariable("aadharNumber") String aadharNumber) {
        CustomerDto fetchCustomer = bankService.deleteCustomer(aadharNumber);
        logger.info("FETCHING CUSTOMER ACCOUNTS DETAILS {}", fetchCustomer);
        //    kafkaProducerService.sendCustomerDeletedEvent(fetchCustomer);
        return new ResponseEntity<CustomerDto>(fetchCustomer, HttpStatus.OK);
    }
}
