package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;

import java.util.List;

public class CategorySelectAll {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        try {
            List<Category> categories = categoryService.get();  // 모든 카테고리 조회
            for (Category category : categories) {
                System.out.println("카테고리 정보: " + category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
