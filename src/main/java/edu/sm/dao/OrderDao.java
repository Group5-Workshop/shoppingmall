package edu.sm.dao;

import edu.sm.dto.Order;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Dao<Integer, Order> {

    @Override
    public Order insert(Order order, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.INSERT_ORDERS);
            ps.setInt(1, order.getCid());
            ps.setString(2, order.getOname());
            ps.setString(3, order.getAddress());
            ps.setString(4, order.getAddressDetail());
            ps.setString(5, order.getZipCode());
            ps.setString(6, order.getPhone());
            ps.setString(7, order.getMsg());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return order;
    }

    @Override
    public Order update(Order order, Connection conn) throws Exception {
        throw new UnsupportedOperationException("주문 삭제 후 다시 주문부탁");
    }

    @Override
    public boolean delete(Integer oid, Connection conn) throws Exception {
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            ps = conn.prepareStatement(Sql.DELETE_ORDERS);
            ps.setInt(1, oid);
            int result = ps.executeUpdate();
            if (result == 1) flag = true;
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return flag;
    }

    @Override
    public Order select(Integer oid, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ORDER_BY_ID);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order(
                        rs.getInt("oid"),
                        rs.getInt("cid"),
                        rs.getString("ostatus"),
                        rs.getString("oname"),
                        rs.getString("address"),
                        rs.getString("address_detail"),
                        rs.getString("zip_code"),
                        rs.getString("phone"),
                        rs.getString("msg"),
                        rs.getTimestamp("odate")
                );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return order;
    }

    @Override
    public List<Order> select(Connection conn) throws Exception {
        List<Order> orders = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ALL_ORDERS);
            rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("oid"),
                        rs.getInt("cid"),
                        rs.getString("ostatus"),
                        rs.getString("oname"),
                        rs.getString("address"),
                        rs.getString("address_detail"),
                        rs.getString("zip_code"),
                        rs.getString("phone"),
                        rs.getString("msg"),
                        rs.getTimestamp("odate")
                ));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return orders;
    }
    public List<Order> selectOrdersByStatus(String status, Connection conn) throws Exception {
        List<Order> orders = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ORDERS_BY_STATUS); // SQL 쿼리 실행
            ps.setString(1, status); // 상태를 파라미터로 설정
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOid(rs.getInt("oid"));
                order.setOname(rs.getString("oname"));
                order.setOdate(rs.getTimestamp("odate"));
                orders.add(order);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return orders;
    }

    public void updateOrderStatus(int oid, String status, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.UPDATE_ORDERS_OSTATUS); // SQL 쿼리 실행
            ps.setString(1, status); // 새로운 상태 설정
            ps.setInt(2, oid);       // 주문 번호 설정
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }

    // 특정 회원의 주문 목록을 조회하는 메서드
    public List<Order> selectByCid(int cid, Connection conn) throws Exception {
        List<Order> orders = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ORDERS_BY_CID);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("oid"),
                        rs.getInt("cid"),
                        rs.getString("ostatus"),
                        rs.getString("oname"),
                        rs.getString("address"),
                        rs.getString("address_detail"),
                        rs.getString("zip_code"),
                        rs.getString("phone"),
                        rs.getString("msg"),
                        rs.getTimestamp("odate")
                ));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return orders;
    }
}
