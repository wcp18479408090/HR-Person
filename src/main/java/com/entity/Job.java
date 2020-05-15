package com.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Job)实体类
 *
 * @author makejava
 * @since 2020-05-15 07:41:58
 */
@Data
public class Job implements Serializable {
    private static final long serialVersionUID = 669340848863931878L;
    
    private Integer jId;
    
    private String jName;
    
    private String jDesc;

    List<Emp> empList;




}