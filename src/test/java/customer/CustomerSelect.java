package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

import java.util.List;

public class CustomerSelect {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        int id = 20; // ID로 고객 검색
        Customer customer = null;

        // ID로 고객 검색 테스트
        try {
            customer = customerService.get(id);
            System.out.println("ID로 검색된 고객: " + customer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 이름으로 고객 검색 테스트
        String searchName = "철수"; // 검색할 이름
        List<Customer> customersByName = null;

        try {
            customersByName = customerService.getByName(searchName);
            System.out.println("\n이름 '" + searchName + "'으로 검색된 고객 목록:");
            for (Customer cust : customersByName) {
                System.out.println(cust);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
