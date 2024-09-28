package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;
import edu.sm.dao.AddressDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddressInsert {
    public static void main(String[] args) throws Exception { // 예외를 던짐
        // ConnectionPool에서 Connection을 가져옴
        ConnectionPool pool = ConnectionPool.create();  // ConnectionPool을 사용하여 연결 생성
        Connection conn = pool.getConnection();

        try {
            AddressService addressService = new AddressService(new AddressDao(conn));

            Address address = new Address(0, 1, "김철수", "서울시 강남구", "아파트 101호", "123456");

            addressService.addAddress(address);

            System.out.println("주소가 성공적으로 삽입되었습니다.");
        } finally {
            // 작업이 끝난 후 Connection을 반납 (예외 발생해도 반납되도록 finally 사용)
            pool.releaseConnection(conn);
        }
    }
}
