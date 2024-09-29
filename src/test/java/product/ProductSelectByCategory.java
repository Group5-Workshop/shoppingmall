package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSelectByCategory {
    public static void main(String[] args) {
        // ProductService 인스턴스 생성
        ProductService productService = new ProductService();

        try {
            // 특정 카테고리 ID로 상품을 조회 (예: categoryId = 1)
            int categoryId = 1;
            List<Product> products = productService.getProductsByCategory(categoryId);

            // 조회 결과 출력
            System.out.println("카테고리 " + categoryId + "에 속하는 상품 목록:");
            for (Product product : products) {
                System.out.println("=========================================");
                System.out.println("상품 ID: " + product.getPid());
                System.out.println("상품명: " + product.getPname());
                System.out.println("가격: " + product.getPrice());
                System.out.println("이미지1: " + product.getImg1());
                System.out.println("설명: " + product.getContent());
                System.out.println("=========================================\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
