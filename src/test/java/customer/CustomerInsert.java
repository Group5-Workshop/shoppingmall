package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

public class CustomerInsert {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Customer customer = Customer.builder()
                .custpwd("1234")
                .cname("bbb")
                .email("ascc@naver.com")
                .phone_num("01011111111")
                .birth_day(20010408)
                .nick_name("zizon")
                .build();

        try {
            customerService.add(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
