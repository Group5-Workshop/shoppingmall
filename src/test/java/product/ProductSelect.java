package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductSelect {

    @Test
    public void testProductSelect() throws Exception {
        ProductService productService = new ProductService();

        // 상품 ID 1로 조회
        int pid = 1;
        Product product = productService.get(pid);

        assertNotNull(product);
        System.out.println("조회된 상품: " + product);
    }
}
