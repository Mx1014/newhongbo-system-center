package com.nhb.system.user.controller;

import com.nhb.system.user.repository.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CustomerController {
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private List<Customer> customers;

    public CustomerController()
    {
        customers = new LinkedList<>();
        customers.add(new Customer(1, "Peter", "User1"));
        customers.add(new Customer(2, "Lucy", "User2"));
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer(@PathVariable int id)
    {
        logger.debug("reading customer with id " + id);
        Optional<Customer> customer = customers.stream().filter(customer1 -> customer1.getId() == id).findFirst();
        return customer.get();
    }

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerByPost(@RequestBody Map<String, String> ids)
    {
        String id = ids.get("id");
        logger.debug("reading customer with id " + id);
        Optional<Customer> customer = customers.stream().filter(customer1 -> customer1.getId() == Integer.valueOf(id)).findFirst();
        return customer.get();
    }
}
