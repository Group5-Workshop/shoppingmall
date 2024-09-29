package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductInsert {
    public static void main(String[] args) {
        try {
            ProductService productService = new ProductService();

            // 새로운 상품 생성
            Product product = Product.builder()
                    .categoryId(1)
                    .disId(1)
                    .pname("새로운 상품")
                    .price(50000)
                    .cnt(10)
                    .img1("img1.jpg")
                    .img2("img2.jpg")
                    .img3("img3.jpg")
                    .img4("img4.jpg")
                    .content("이것은 새로운 상품입니다.")
                    .isPublic(true)
                    .build();

            // 상품을 추가
            Product insertedProduct = productService.add(product);
            if (insertedProduct != null) {
                System.out.println("상품 추가 성공: " + insertedProduct);
            } else {
                System.out.println("상품 추가 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
