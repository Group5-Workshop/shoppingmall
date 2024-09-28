package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import edu.sm.dao.ReviewDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class ReviewSelectAll {
    public static void main(String[] args) {
        try {
            // ConnectionPool에서 Connection을 가져옴
            ConnectionPool pool = ConnectionPool.create();
            Connection conn = pool.getConnection();

            ReviewService reviewService = new ReviewService(new ReviewDao(conn));

            // 모든 리뷰 조회
            List<Review> reviews = reviewService.getAllReviews();
            for (Review review : reviews) {
                System.out.println("리뷰 제목: " + review.getTitle());
                System.out.println("리뷰 내용: " + review.getContent());
                System.out.println("작성일: " + review.getRdate());
                System.out.println("----------------------------");
            }

            // Connection 반납
            pool.releaseConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
