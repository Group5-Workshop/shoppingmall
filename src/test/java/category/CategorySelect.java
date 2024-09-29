package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;

public class CategorySelect {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        try {
            Category category = categoryService.get(1); // 조회할 카테고리 ID
            System.out.println("카테고리 정보: " + category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
