package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;
import edu.sm.dao.CategoryDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class CategorySelectAll {
    public static void main(String[] args) throws Exception {
        ConnectionPool pool = ConnectionPool.create();
        Connection conn = pool.getConnection();

        try {
            CategoryService categoryService = new CategoryService(new CategoryDao());

            List<Category> categories = categoryService.getAll();
            for (Category category : categories) {
                System.out.println("카테고리 ID: " + category.getCategory_id());
                System.out.println("카테고리 이름: " + category.getCategory_name());
                System.out.println("카테고리 설명: " + category.getCategory_detail());
                System.out.println("--------------------------");
            }
        } finally {
            pool.releaseConnection(conn);
        }
    }
}
