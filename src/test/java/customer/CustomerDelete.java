package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

public class CustomerDelete {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        int id = 18;
        Customer cust = Customer.builder()
                .cid(id)
                .build();

        try {
            customerService.remove(cust.getCid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
