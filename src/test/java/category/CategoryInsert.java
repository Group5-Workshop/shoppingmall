package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;
import edu.sm.dao.CategoryDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class CategoryInsert {
    public static void main(String[] args) throws Exception {
        ConnectionPool pool = ConnectionPool.create();
        Connection conn = pool.getConnection();

        try {
            CategoryService categoryService = new CategoryService(new CategoryDao());

            Category category = Category.builder()
                    .category_name("전자기기")
                    .category_detail("휴대폰, 노트북, 태블릿 등")
                    .build();

            categoryService.add(category);
            System.out.println("카테고리가 성공적으로 삽입되었습니다.");
        } finally {
            pool.releaseConnection(conn);
        }
    }
}
