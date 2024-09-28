package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import edu.sm.dao.ReviewDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class ReviewSelect {
    public static void main(String[] args) {
        try {
            // ConnectionPool에서 Connection을 가져옴
            ConnectionPool pool = ConnectionPool.create();
            Connection conn = pool.getConnection();

            ReviewService reviewService = new ReviewService(new ReviewDao(conn));

            // 리뷰 조회 (리뷰 ID 1 조회)
            Review fetchedReview = reviewService.getReview(1); // 조회할 리뷰 ID 설정
            if (fetchedReview != null) {
                System.out.println("리뷰 제목: " + fetchedReview.getTitle());
                System.out.println("리뷰 내용: " + fetchedReview.getContent());
                System.out.println("리뷰 작성일: " + fetchedReview.getRdate());
            } else {
                System.out.println("리뷰를 찾을 수 없습니다.");
            }

            // Connection 반납
            pool.releaseConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
