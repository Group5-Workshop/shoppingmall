package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;
import edu.sm.dao.CategoryDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class CategorySelect {
    public static void main(String[] args) throws Exception {
        ConnectionPool pool = ConnectionPool.create();
        Connection conn = pool.getConnection();

        try {
            CategoryService categoryService = new CategoryService(new CategoryDao());

            Category category = categoryService.get(2);  // 조회할 카테고리 ID 설정
            if (category != null) {
                System.out.println("카테고리 이름: " + category.getCategory_name());
                System.out.println("카테고리 설명: " + category.getCategory_detail());
            } else {
                System.out.println("카테고리를 찾을 수 없습니다.");
            }
        } finally {
            pool.releaseConnection(conn);
        }
    }
}
