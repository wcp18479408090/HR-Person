package com.entity;

import lombok.Data;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2020-05-18 21:03:02
 */
@Data
public class Notice implements Serializable {
    private static final long serialVersionUID = 250162583665283362L;
    
    private Integer nId;
    
    private String nName;
    
    private String nDesc;
    
    private String nDate;

    private  int state;

    private UserS userS;

//    public UserS getUserS() {
//        return userS;
//    }
//
//    public void setUserS(UserS userS) {
//        this.userS = userS;
//    }
//
//    public Integer getNId() {
//        return nId;
//    }
//
//    public void setNId(Integer nId) {
//        this.nId = nId;
//    }
//
//    public String getNName() {
//        return nName;
//    }
//
//    public void setNName(String nName) {
//        this.nName = nName;
//    }
//
//    public String getNDesc() {
//        return nDesc;
//    }
//
//    public void setNDesc(String nDesc) {
//        this.nDesc = nDesc;
//    }
//
//    public String getNDate() {
//        return nDate;
//    }
//
//    public void setNDate(String nDate) {
//        this.nDate = nDate;
//    }



}