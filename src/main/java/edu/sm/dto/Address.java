package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {
    private int aid;
    private int cid;
    private String aname;
    private String address;
    private String address_detail;
    private String zip_code;
    }