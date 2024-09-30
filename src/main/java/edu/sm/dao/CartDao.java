package edu.sm.dao;

import edu.sm.dto.Cart;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao implements Dao<Integer, Cart> {

    @Override
    public Cart insert(Cart cart, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.INSERT_CART);
            ps.setInt(1, cart.getCid());
            ps.setInt(2, cart.getPid());
            ps.setInt(3, cart.getCnt());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return cart;
    }
    @Override
    public Cart update(Cart cart, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.UPDATE_CART_CNT);
            ps.setInt(1, cart.getCnt());
            ps.setInt(2, cart.getCid());
            ps.setInt(3, cart.getPid());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return cart;
    }

    @Override
    public boolean delete(Integer cartId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("removeByCidPid 를 사용하세요");
    }

    @Override
    public Cart select(Integer cartId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("지원되지 않는 기능");
    }

    @Override
    public List<Cart> select(Connection conn) throws Exception {
        throw new UnsupportedOperationException("지원되지 않는 기능");
    }

    public List<Cart> selectByCid(Integer cid, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cart> carts = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.SELECT_CART_BY_CID);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                carts.add(new Cart(
                        rs.getInt("cart_id"),
                        rs.getInt("cid"),
                        rs.getInt("pid"),
                        rs.getInt("cnt")
                ));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return carts;
    }

    public boolean deleteByCidPid(Integer cid, Integer pid, Connection conn) throws Exception {
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            ps = conn.prepareStatement(Sql.DELETE_CART_BY_CID_PID);
            ps.setInt(1, cid);
            ps.setInt(2, pid);
            int result = ps.executeUpdate();
            if (result == 1) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return flag;
    }

}