package review;

import edu.sm.service.ReviewService;
import edu.sm.dao.ReviewDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class ReviewDelete {
    public static void main(String[] args) {
        try {
            // ConnectionPool에서 Connection을 가져옴
            ConnectionPool pool = ConnectionPool.create();
            Connection conn = pool.getConnection();

            ReviewService reviewService = new ReviewService(new ReviewDao(conn));

            // 리뷰 삭제 (리뷰 ID 5 삭제)
            reviewService.removeReview(5); // 삭제할 리뷰 ID 설정
            System.out.println("리뷰가 성공적으로 삭제되었습니다.");

            // Connection 반납
            pool.releaseConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
