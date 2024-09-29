package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;

public class CategoryInsert {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        Category category = Category.builder()
                .categoryName("전자제품")
                .categoryDetail("가전 및 전자 기기")
                .build();

        try {
            categoryService.add(category);
            System.out.println("카테고리 추가 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
