package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2020-05-15 07:42:07
 */
@Data
public class Notice implements Serializable {
    private static final long serialVersionUID = -47905449052015678L;
    
    private Integer nId;
    
    private String nName;
    
    private String nDesc;
    
    private Object nDate;
    
    private UserS userS;




}