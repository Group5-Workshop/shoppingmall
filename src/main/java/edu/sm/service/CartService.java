package edu.sm.service;

import edu.sm.dao.CartDao;
import edu.sm.dto.Cart;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartService implements MService<Integer, Cart> {
    CartDao dao;
    ConnectionPool cp;

    public CartService() {
        dao = new CartDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cart add(Cart cart) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(cart, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return cart;
    }

    @Override
    public Cart modify(Cart cart) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.update(cart, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return cart;
    }

    @Override
    public Boolean remove(Integer cartId) throws Exception {
        Connection conn = cp.getConnection();
        Boolean result = false;
        try {
            conn.setAutoCommit(false);
            result = dao.delete(cartId, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            System.err.println(e.getMessage());
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return result;
    }

    @Override
    public Cart get(Integer cartId) throws Exception {
        Connection conn = cp.getConnection();
        Cart cart = null;
        try {
            cart = dao.select(cartId, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return cart;
    }

    @Override
    public List<Cart> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Cart> carts = null;
        try {
            carts = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return carts;
    }
}
