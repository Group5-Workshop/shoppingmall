package address;

import edu.sm.service.AddressService;

public class AddressDelete {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        int addressId = 1; // 삭제할 주소 ID

        try {
            boolean result = addressService.remove(addressId);
            if (result) {
                System.out.println("주소 삭제 성공: ID " + addressId);
            } else {
                System.out.println("주소 삭제 실패: ID " + addressId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
