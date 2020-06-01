package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Document)实体类
 *
 * @author makejava
 * @since 2020-05-22 16:45:52
 */
@Data
public class Document implements Serializable {
    private static final long serialVersionUID = -72561787049564080L;
    
    private Integer dId;
    
    private String dFilename;
    
    private String dDate;
    
    private Integer uId;
    
    private String suffix;
    
    private Long size;
    
    private String filepash;




}