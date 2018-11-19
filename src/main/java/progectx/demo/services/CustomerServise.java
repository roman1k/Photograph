package progectx.demo.services;

import progectx.demo.models.Customer;

public interface CustomerServise {

    void  save (Customer customer);

    Customer createCustomer(String username, String password, String mail, String name, String lastName);


}
