package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductUpdate {
    public static void main(String[] args) {
        try {
            ProductService productService = new ProductService();

            // 기존 상품 조회
            int pid = 21;
            Product product = productService.get(pid);

            if (product != null) {
                // 상품 정보 수정 ( 더 추가해서 다양한 속성들 업뎃 가능)
                product.setPrice(60000);
                product.setCnt(20);
                product.setPublic(false);
                Product updatedProduct = productService.modify(product);

                System.out.println("상품 수정 성공: " + updatedProduct);
            } else {
                System.out.println("상품 조회 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
