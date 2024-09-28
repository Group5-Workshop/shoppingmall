package edu.sm.dao;

import edu.sm.dto.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    private Connection conn;

    // 생성자를 통해 Connection 주입
    public ReviewDao(Connection conn) {
        this.conn = conn;
    }

    // 리뷰 삽입 메서드
    public void insert(Review review) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO review (pid, cid, rate, title, content, img, rdate) VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, review.getPid());
        ps.setInt(2, review.getCid());
        ps.setInt(3, review.getRate());
        ps.setString(4, review.getTitle());
        ps.setString(5, review.getContent());
        ps.setString(6, review.getImg());
        ps.setTimestamp(7, review.getRdate());
        ps.executeUpdate();
    }

    // 리뷰 수정 메서드
    public void update(Review review) throws Exception {
        PreparedStatement ps = conn.prepareStatement("UPDATE review SET pid=?, cid=?, rate=?, title=?, content=?, img=?, rdate=? WHERE rid=?");
        ps.setInt(1, review.getPid());
        ps.setInt(2, review.getCid());
        ps.setInt(3, review.getRate());
        ps.setString(4, review.getTitle());
        ps.setString(5, review.getContent());
        ps.setString(6, review.getImg());
        ps.setTimestamp(7, review.getRdate());
        ps.setInt(8, review.getRid());
        ps.executeUpdate();
    }

    // 리뷰 삭제 메서드
    public void delete(int rid) throws Exception {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM review WHERE rid=?");
        ps.setInt(1, rid);
        ps.executeUpdate();
    }

    // 특정 리뷰 조회 메서드
    public Review selectOne(int rid) throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM review WHERE rid=?");
        ps.setInt(1, rid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return Review.builder()
                    .rid(rs.getInt("rid"))
                    .pid(rs.getInt("pid"))
                    .cid(rs.getInt("cid"))
                    .rate(rs.getInt("rate"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .img(rs.getString("img"))
                    .rdate(rs.getTimestamp("rdate"))
                    .build();
        }
        return null;
    }

    // 모든 리뷰 조회 메서드
    public List<Review> selectAll() throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM review");
        ResultSet rs = ps.executeQuery();
        List<Review> reviews = new ArrayList<>();
        while (rs.next()) {
            reviews.add(Review.builder()
                    .rid(rs.getInt("rid"))
                    .pid(rs.getInt("pid"))
                    .cid(rs.getInt("cid"))
                    .rate(rs.getInt("rate"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .img(rs.getString("img"))
                    .rdate(rs.getTimestamp("rdate"))
                    .build());
        }
        return reviews;
    }
}
