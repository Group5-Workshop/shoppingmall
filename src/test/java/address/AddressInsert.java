package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;

public class AddressInsert {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        // 테스트용 주소 데이터 생성
        Address newAddress = Address.builder()
                .cid(1) // 고객 ID
                .aname("김철수")
                .address("서울시 강남구")
                .addressDetail("아파트 101호")
                .zipCode("123456")
                .phone("01012345678")
                .build();

        try {
            addressService.add(newAddress);
            System.out.println("주소 추가 성공: " + newAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
