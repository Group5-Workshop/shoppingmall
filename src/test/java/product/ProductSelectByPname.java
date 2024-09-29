package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSelectByPname {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        try {
            String searchName = "스마"; // 조회할 상품명 (부분 일치)
            List<Product> products = productService.getByName(searchName);

            // 상품명으로 조회된 결과 출력
            for (Product product : products) {
                System.out.println("====================================");
                System.out.println("상품 ID: " + product.getPid());
                System.out.println("상품명: " + product.getPname());
                System.out.println("가격: " + product.getPrice());
                System.out.println("재고: " + product.getCnt());
                System.out.println("설명: " + product.getContent());
                System.out.println("====================================\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
