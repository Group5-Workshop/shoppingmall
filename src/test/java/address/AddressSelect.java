package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;
import edu.sm.dao.AddressDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class AddressSelect {
    public static void main(String[] args) {
        try {
            // ConnectionPool에서 Connection을 가져옴
            ConnectionPool pool = ConnectionPool.create();  // ConnectionPool을 사용하여 연결 생성
            Connection conn = pool.getConnection();

            AddressService addressService = new AddressService(new AddressDao(conn));

            int aid = 1;  // 조회할 주소 ID

            Address address = addressService.getAddress(aid);
            if (address != null) {
                System.out.println("이름: " + address.getAname());
                System.out.println("주소: " + address.getAddress());
                System.out.println("상세주소: " + address.getAddress_detail());
                System.out.println("우편번호: " + address.getZip_code());
            } else {
                System.out.println("해당 주소가 존재하지 않습니다.");
            }

            // 작업이 끝난 후 Connection을 반납
            pool.releaseConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
