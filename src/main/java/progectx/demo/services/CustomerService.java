package progectx.demo.services;

import progectx.demo.models.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer user);

    List<Customer> findAll();

    Customer findOneById(int id);
}

