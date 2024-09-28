package edu.sm.dao;

import edu.sm.dto.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    private Connection conn;

    public AddressDao(Connection conn) {
        this.conn = conn;
    }

    // 주소 삽입
    public void insertAddress(Address address) throws SQLException {
        String sql = "INSERT INTO address (cid, aname, address, address_detail, zip_code) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, address.getCid());
            ps.setString(2, address.getAname());
            ps.setString(3, address.getAddress());
            ps.setString(4, address.getAddress_detail());
            ps.setString(5, address.getZip_code());
            ps.executeUpdate();
        }
    }

    // 주소 업데이트
    public void updateAddress(Address address) throws SQLException {
        String sql = "UPDATE address SET aname=?, address=?, address_detail=?, zip_code=? WHERE aid=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, address.getAname());
            ps.setString(2, address.getAddress());
            ps.setString(3, address.getAddress_detail());
            ps.setString(4, address.getZip_code());
            ps.setInt(5, address.getAid());
            ps.executeUpdate();
        }
    }

    // 주소 삭제
    public void deleteAddress(int aid) throws SQLException {
        String sql = "DELETE FROM address WHERE aid=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, aid);
            ps.executeUpdate();
        }
    }

    // 하나의 주소 조회
    public Address selectOneAddress(int aid) throws SQLException {
        String sql = "SELECT * FROM address WHERE aid=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, aid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Address(
                            rs.getInt("aid"),
                            rs.getInt("cid"),
                            rs.getString("aname"),
                            rs.getString("address"),
                            rs.getString("address_detail"),
                            rs.getString("zip_code")
                    );
                }
            }
        }
        return null;
    }

    // 모든 주소 조회
    public List<Address> selectAllAddresses() throws SQLException {
        String sql = "SELECT * FROM address";
        List<Address> addresses = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Address address = new Address(
                        rs.getInt("aid"),
                        rs.getInt("cid"),
                        rs.getString("aname"),
                        rs.getString("address"),
                        rs.getString("address_detail"),
                        rs.getString("zip_code")
                );
                addresses.add(address);
            }
        }
        return addresses;
    }
}
