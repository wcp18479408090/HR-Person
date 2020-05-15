package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (UserS)实体类
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
@Data
public class UserS implements Serializable {
    private static final long serialVersionUID = -61104194168639645L;
    
    private Integer uId;
    
    private String uLoginname;
    
    private String uPass;
    
    private String uName;
    
    private Integer uState;
    
    private String uDate;




}