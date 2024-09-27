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
        conn.setAutoCommit(false);
        return customer;
    }

    @Override
    public Customer modify(Customer customer) throws Exception {
        return null;
    }

    @Override
    public Boolean remove(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Customer get(Integer integer) throws Exception {
        return null;
    }
}
