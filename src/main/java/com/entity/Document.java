package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Document)实体类
 *
 * @author makejava
 * @since 2020-05-15 07:41:37
 */
@Data
public class Document implements Serializable {
    private static final long serialVersionUID = 810258204410780096L;
    
    private Integer dId;
    
    private String dName;
    
    private String dFilename;
    
    private Object dDate;
    
    private UserS userS;



}