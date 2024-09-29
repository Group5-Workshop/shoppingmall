package category;

import edu.sm.dto.Category;
import edu.sm.service.CategoryService;

public class CategoryUpdate {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        Category category = Category.builder()
                .categoryId(1) // 기존 ID로 수정
                .categoryName("가전제품")
                .categoryDetail("수정된 가전 및 전자 기기")
                .build();

        try {
            categoryService.modify(category);
            System.out.println("카테고리 수정 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
