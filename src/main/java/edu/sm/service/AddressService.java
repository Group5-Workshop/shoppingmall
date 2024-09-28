package edu.sm.service;

import edu.sm.dao.AddressDao;
import edu.sm.dto.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressService {
    private AddressDao addressDao;

    // 기본 생성자: ConnectionPool을 통해 연결된 DAO 초기화
    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void addAddress(Address address) throws SQLException {
        addressDao.insertAddress(address);
    }

    public void modifyAddress(Address address) throws SQLException {
        addressDao.updateAddress(address);
    }

    public void removeAddress(int aid) throws SQLException {
        addressDao.deleteAddress(aid);
    }

    public Address getAddress(int aid) throws SQLException {
        return addressDao.selectOneAddress(aid);
    }

    public List<Address> getAllAddresses() throws SQLException {
        return addressDao.selectAllAddresses();
    }
}
