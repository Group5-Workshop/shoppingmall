package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

import java.util.List;

public class CustomerSelect {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        int id = 2;
        Customer customer = null;

        try {
            customer = customerService.get(id);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
