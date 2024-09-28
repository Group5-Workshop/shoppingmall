package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

public class CustomerUpdate {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        int id = 20;

        // Customer 객체 생성
        Customer cust = Customer.builder()
                .cid(id)
                .cname("홍길동")           // 이름 수정
                .phone("01012341234")     // phone 필드 수정 (phone_num -> phone)
                .email("test@naver.com")  // 이메일 수정
                .nick_name("낄똥")        // 닉네임 수정
                .build();

        try {
            customerService.modify(cust);  // 수정 메서드 호출
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
