package address;

import edu.sm.service.AddressService;
import edu.sm.dao.AddressDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class AddressDelete {
    public static void main(String[] args) {
        try {
            // ConnectionPool에서 Connection을 가져옴
            ConnectionPool pool = ConnectionPool.create();  // ConnectionPool을 사용하여 연결 생성
            Connection conn = pool.getConnection();

            AddressService addressService = new AddressService(new AddressDao(conn));

            int aid = 1;  // 삭제할 주소 ID

            addressService.removeAddress(aid);
            System.out.println("주소가 성공적으로 삭제되었습니다.");

            // 작업이 끝난 후 Connection을 반납
            pool.releaseConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
