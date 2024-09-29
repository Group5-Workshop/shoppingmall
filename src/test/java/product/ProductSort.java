package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSort {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        try {
            System.out.println("전체 상품 가격 오름차순으로 정렬:");
            List<Product> productsByPriceAsc = productService.getProductsSortedBy("price_asc", null);
            for (Product product : productsByPriceAsc) {
                System.out.println(product);
            }

            System.out.println("\n카테고리 ID 1 상품 가격 내림차순으로 정렬:");
            List<Product> productsByCategoryAndPriceDesc = productService.getProductsSortedBy("price_desc", 1);
            for (Product product : productsByCategoryAndPriceDesc) {
                System.out.println(product);
            }

            System.out.println("\n카테고리 ID 2 상품 리뷰 기준으로 정렬:");
            List<Product> productsByCategoryAndReview = productService.getProductsSortedBy("review", 2);
            for (Product product : productsByCategoryAndReview) {
                System.out.println(product);
            }

            System.out.println("\n상품 판매량 기준으로 정렬:");
            List<Product> productsBySalesCount = productService.getProductsSortedBy("sales_count", 1);
            for (Product product : productsBySalesCount) {
                System.out.println(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
