package edu.sm.service;

import edu.sm.dao.ReviewDao;
import edu.sm.dto.Review;
import java.util.List;

public class ReviewService {
    private ReviewDao reviewDao;

    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    // 리뷰 추가
    public void addReview(Review review) throws Exception {
        reviewDao.insert(review);
    }

    // 리뷰 수정
    public void modifyReview(Review review) throws Exception {
        reviewDao.update(review);
    }

    // 리뷰 삭제
    public void removeReview(int rid) throws Exception {
        reviewDao.delete(rid);
    }

    // 특정 리뷰 조회
    public Review getReview(int rid) throws Exception {
        return reviewDao.selectOne(rid);
    }

    // 모든 리뷰 조회
    public List<Review> getAllReviews() throws Exception {
        return reviewDao.selectAll();
    }
}
