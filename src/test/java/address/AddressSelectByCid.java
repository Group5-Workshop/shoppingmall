package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;

import java.util.List;

public class AddressSelectByCid {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        int customerId = 1;  // 조회할 고객 ID

        try {
            List<Address> addressList = addressService.getByCustomerId(customerId);
            for (Address address : addressList) {
                System.out.println("====================================");
                System.out.println("ID: " + address.getAid());
                System.out.println("이름: " + address.getAname());
                System.out.println("주소: " + address.getAddress());
                System.out.println("상세주소: " + address.getAddressDetail());
                System.out.println("우편번호: " + address.getZipCode());
                System.out.println("전화번호: " + address.getPhone());
                System.out.println("====================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
