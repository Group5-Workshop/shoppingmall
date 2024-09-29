package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSelectAll {
    public static void main(String[] args) {
        try {
            ProductService productService = new ProductService();

            // 전체 상품 조회
            List<Product> products = productService.get();

            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
                    System.out.println(product);
                }
            } else {
                System.out.println("상품이 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
