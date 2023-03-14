package entelect.training.incubator.service;

import entelect.training.incubator.spring.customer.model.Customer;

public interface CustomerServiceApi {
    Customer getCustomer(long customerId);
}
