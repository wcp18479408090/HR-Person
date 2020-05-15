package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2020-05-15 07:41:49
 */
@Data
public class Emp implements Serializable {
    private static final long serialVersionUID = 153766041213227092L;
    
    private Integer eId;
    
    private String eName;
    
    private String eSex;
    
    private String eIphone;
    
    private String eCar;
    
    private String eEmail;
    
    private String eAddres;
    
    private String eRecord;
    
    private Dept dept;
    
    private Job job;
    
    private String eDate;



}