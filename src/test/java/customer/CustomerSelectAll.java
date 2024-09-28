package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerSelectAll {
    public static void main(String[] args) {
        // 전부 가져오기
        CustomerService customerService = new CustomerService();
        List<Customer> customers = new ArrayList<>();

        try {
            customers = customerService.get();
            // 예쁘게 출력
            for (Customer customer : customers) {
                System.out.print("ID: " + customer.getCid() + ", ");
                System.out.print("이름: " + customer.getCname() + ", ");
                System.out.print("이메일: " + customer.getEmail() + ", ");
                System.out.print("전화번호: " + customer.getPhone() + ", ");
                System.out.print("생년월일: " + customer.getBirth_date() + ", ");
                System.out.print("닉네임: " + customer.getNick_name() + ", ");
                System.out.print("등급: " + customer.getGrade() + ", ");
                System.out.println("가입일: " + customer.getJoin_date());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
