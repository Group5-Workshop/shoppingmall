package edu.sm.dao;

import edu.sm.dto.Customer;
import edu.sm.frame.Dao;

import java.sql.Connection;

public class CustomerDao implements Dao<Integer, Customer> {
    @Override
    public Customer insert(Customer customer, Connection con) throws Exception {
        return null;
    }

    @Override
    public Customer update(Customer customer, Connection con) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Integer integer, Connection con) throws Exception {
        return false;
    }

    @Override
    public Customer select(Integer integer, Connection con) throws Exception {
        return null;
    }
}
