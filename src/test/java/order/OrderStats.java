package order;

import edu.sm.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderStats {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        try {
            // 일별 주문 통계 출력
            System.out.println("=== 일별 주문 통계 ===");
            List<Map<String, Object>> dailyStats = orderService.getDailyOrderStats();
            for (Map<String, Object> stat : dailyStats) {
                // SQL 쿼리에서 사용하는 필드명에 맞추어 get() 수정
                System.out.printf("날짜: %s, 총 주문 수: %d, 총 매출: %,d원\n",
                        stat.get("order_date"),  // 날짜 필드명
                        stat.get("total_orders"),  // 주문 수 필드명
                        stat.get("total_sales")   // 매출 필드명
                );
            }

            // 월별 주문 통계 출력
            System.out.println("\n=== 월별 주문 통계 ===");
            List<Map<String, Object>> monthlyStats = orderService.getMonthlyOrderStats();
            for (Map<String, Object> stat : monthlyStats) {
                // SQL 쿼리에서 사용하는 필드명에 맞추어 get() 수정
                System.out.printf("년도: %d, 월: %d, 총 주문 수: %d, 총 매출: %,d원\n",
                        stat.get("order_year"),  // 연도 필드명
                        stat.get("order_month"), // 월 필드명
                        stat.get("total_orders"),  // 주문 수 필드명
                        stat.get("total_sales")   // 매출 필드명
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
