package edu.sm.dao;

import edu.sm.dto.Category;
import edu.sm.frame.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements Dao<Integer, Category> {

    // 카테고리 삽입
    @Override
    public Category insert(Category category, Connection conn) throws Exception {
        String sql = "INSERT INTO category (category_name, category_detail) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.getCategory_name());
            ps.setString(2, category.getCategory_detail());
            ps.executeUpdate();
            return category;
        }
    }

    // 카테고리 수정
    @Override
    public Category update(Category category, Connection conn) throws Exception {
        String sql = "UPDATE category SET category_name=?, category_detail=? WHERE category_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.getCategory_name());
            ps.setString(2, category.getCategory_detail());
            ps.setInt(3, category.getCategory_id());
            ps.executeUpdate();
            return category;
        }
    }

    // 카테고리 삭제
    @Override
    public boolean delete(Integer categoryId, Connection conn) throws Exception {
        String sql = "DELETE FROM category WHERE category_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            return ps.executeUpdate() > 0;
        }
    }

    // 특정 카테고리 조회
    @Override
    public Category select(Integer categoryId, Connection conn) throws Exception {
        String sql = "SELECT category_id, category_name, category_detail FROM category WHERE category_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Category.builder()
                        .category_id(rs.getInt("category_id"))
                        .category_name(rs.getString("category_name"))
                        .category_detail(rs.getString("category_detail"))
                        .build();
            }
        }
        return null;
    }

    // 모든 카테고리 조회
    @Override
    public List<Category> select(Connection conn) throws Exception {
        String sql = "SELECT category_id, category_name, category_detail FROM category";
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(Category.builder()
                        .category_id(rs.getInt("category_id"))
                        .category_name(rs.getString("category_name"))
                        .category_detail(rs.getString("category_detail"))
                        .build());
            }
        }
        return categories;
    }
}
