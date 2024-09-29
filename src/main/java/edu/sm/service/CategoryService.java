package edu.sm.service;

import edu.sm.dao.CategoryDao;
import edu.sm.dto.Category;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;

public class CategoryService implements MService<Integer, Category> {
    private CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    // 카테고리 추가
    @Override
    public Category add(Category category) throws Exception {
        try (Connection conn = ConnectionPool.create().getConnection()) {
            return categoryDao.insert(category, conn);
        }
    }

    // 카테고리 수정
    @Override
    public Category modify(Category category) throws Exception {
        try (Connection conn = ConnectionPool.create().getConnection()) {
            return categoryDao.update(category, conn);
        }
    }

    // 카테고리 삭제
    @Override
    public Boolean remove(Integer categoryId) throws Exception {
        try (Connection conn = ConnectionPool.create().getConnection()) {
            return categoryDao.delete(categoryId, conn);
        }
    }

    // 특정 카테고리 조회
    @Override
    public Category get(Integer categoryId) throws Exception {
        try (Connection conn = ConnectionPool.create().getConnection()) {
            return categoryDao.select(categoryId, conn);
        }
    }

    // 모든 카테고리 조회
    @Override
    public List<Category> get() throws Exception {
        try (Connection conn = ConnectionPool.create().getConnection()) {
            return categoryDao.select(conn);
        }
    }

    // 모든 카테고리 조회 (getAll 메서드)
    public List<Category> getAll() throws Exception {
        try (Connection conn = ConnectionPool.create().getConnection()) {
            return categoryDao.select(conn);
        }
    }
}
