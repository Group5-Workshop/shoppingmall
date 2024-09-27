package edu.sm.dao;

import edu.sm.dto.Customer;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao implements Dao<Integer, Customer> {
    @Override
    public Customer insert(Customer customer, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.insertCustomer);
            ps.setInt(1, customer.getCid());
            ps.setString(2, customer.getCustpwd());
            ps.setString(3, customer.getCname());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPhone_num());
            ps.setInt(6, customer.getBirth_day());
            ps.setString(7, customer.getNick_name());
            ps.setInt(8, customer.getGrade());
            ps.executeUpdate(); // 에러 발생 가능성 존재
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.mg_updateCustomer);
            ps.setString(1, customer.getCname());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone_num());
            ps.setString(4, customer.getNick_name());
            ps.setInt(5, customer.getCid());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer i, Connection conn) throws Exception {
        boolean flag = false;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.mg_deleteCustomer);
            ps.setInt(1, i);
            int result = ps.executeUpdate();
            if (result == 1) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return flag;
    }

    @Override
    public Customer select(Integer i, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            ps = conn.prepareStatement(Sql.selectUserInfo); // SQL 쿼리 사용
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCid(rs.getInt("cid")); // 컬럼 이름 정확히 확인
                customer.setEmail(rs.getString("email"));
                customer.setCname(rs.getString("cname"));
                customer.setPhone_num(rs.getString("phone_num"));
                customer.setBirth_day(rs.getInt("birth_date"));
                customer.setNick_name(rs.getString("nick_name"));
                customer.setGrade(rs.getInt("grade"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return customer;
    }

}
