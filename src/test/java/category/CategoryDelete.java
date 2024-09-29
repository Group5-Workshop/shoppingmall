package category;

import edu.sm.service.CategoryService;

public class CategoryDelete {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        try {
            boolean result = categoryService.remove(1); // 삭제할 카테고리 ID
            if (result) {
                System.out.println("카테고리 삭제 성공");
            } else {
                System.out.println("카테고리 삭제 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
