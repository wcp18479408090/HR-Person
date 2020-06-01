package com.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2020-05-15 07:41:07
 */
@Data
public class Dept implements Serializable {
    private static final long serialVersionUID = -93642401111435139L;
    
    private Integer dId;
    
    private String dName;
    
    private String dDesc;

    //状态

    private int  statu;

}