package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;
import edu.sm.dao.CategoryDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class CategoryUpdate {
    public static void main(String[] args) throws Exception {
        ConnectionPool pool = ConnectionPool.create();
        Connection conn = pool.getConnection();

        try {
            CategoryService categoryService = new CategoryService(new CategoryDao());

            Category category = Category.builder()
                    .category_id(2)  // 수정할 카테고리 ID 설정
                    .category_name("업데이트된 전자기기")
                    .category_detail("새로운 전자기기 세부 설명")
                    .build();

            categoryService.modify(category);
            System.out.println("카테고리가 성공적으로 업데이트되었습니다.");
        } finally {
            pool.releaseConnection(conn);
        }
    }
}
