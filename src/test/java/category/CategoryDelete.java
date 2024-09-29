package category;

import edu.sm.service.CategoryService;
import edu.sm.dao.CategoryDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class CategoryDelete {
    public static void main(String[] args) throws Exception {
        ConnectionPool pool = ConnectionPool.create();
        Connection conn = pool.getConnection();

        try {
            CategoryService categoryService = new CategoryService(new CategoryDao());

            int categoryIdToDelete = 2;  // 삭제할 카테고리 ID 설정

            boolean deleted = categoryService.remove(categoryIdToDelete);
            if (deleted) {
                System.out.println("카테고리가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("카테고리가 존재하지 않거나 삭제할 수 없습니다.");
            }
        } catch (Exception e) {
            // 예외 처리 추가
            System.err.println("카테고리 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();  // 스택 트레이스 출력
        } finally {
            pool.releaseConnection(conn);
        }
    }
}
