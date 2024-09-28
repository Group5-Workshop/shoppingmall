package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;

public class AddressUpdate {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        Address updatedAddress = Address.builder()
                .aid(1) // 수정할 주소의 ID
                .aname("김영수") // 수정된 이름
                .address("서울시 서초구")
                .addressDetail("빌라 303호")
                .zipCode("543210")
                .phone("01099998888")
                .build();

        try {
            addressService.modify(updatedAddress);
            System.out.println("주소 수정 성공: " + updatedAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
