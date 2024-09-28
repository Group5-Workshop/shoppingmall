package edu.sm.service;

import edu.sm.dao.CustomerDao;
import edu.sm.dto.Customer;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerService implements MService<Integer, Customer> {
    CustomerDao dao;
    ConnectionPool cp;

    public CustomerService() {
        dao = new CustomerDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Customer add(Customer customer) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(customer, conn);
            conn.commit();
            System.out.println("Customer Service add 실행됨");
        } catch(Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }

        return customer;
    }

    @Override
    public Customer modify(Customer customer) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.update(customer, conn);
            System.out.println("Customer Service modify 실행됨");
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customer;
    }

    @Override
    public Boolean remove(Integer i) throws Exception {
        Connection conn = cp.getConnection();
        Boolean result = false;
        try {
            result = dao.delete(i, conn);
            System.out.println("Customer Service remove 실행됨");
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return result;
    }

    @Override
    public Customer get(Integer i) throws Exception {
        Connection conn = cp.getConnection();
        Customer customer = null;
        try {
            customer = dao.select(i, conn);
            System.out.println("Customer Service get 실행됨");
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customer;
    }
}













