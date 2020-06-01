package com.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * (UserS)实体类
 *
 * @author makejava
 * @since 2020-05-18 21:01:33
 */
@Data
public class UserS implements Serializable {
    private static final long serialVersionUID = 396314956102425443L;
    
    private Integer uId;
    
    private String uLoginname;
    
    private String uPass;
    
    private String uName;
    
    private Integer uState;
    
    private String uDate;

    private Set <String> roles;

    private Set <String> powers;
//
//    public Integer getUId() {
//        return uId;
//    }
//
//    public void setUId(Integer uId) {
//        this.uId = uId;
//    }
//
//    public String getULoginname() {
//        return uLoginname;
//    }
//
//    public void setULoginname(String uLoginname) {
//        this.uLoginname = uLoginname;
//    }
//
//    public String getUPass() {
//        return uPass;
//    }
//
//    public void setUPass(String uPass) {
//        this.uPass = uPass;
//    }
//
//    public String getUName() {
//        return uName;
//    }
//
//    public void setUName(String uName) {
//        this.uName = uName;
//    }
//
//    public Integer getUState() {
//        return uState;
//    }
//
//    public void setUState(Integer uState) {
//        this.uState = uState;
//    }
//
//    public Object getUDate() {
//        return uDate;
//    }
//
//    public void setUDate(String uDate) {
//        this.uDate = uDate;
//    }

}