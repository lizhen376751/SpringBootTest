package com.lizhen.sbtest.entry;


import javax.persistence.*;

/**
 * 对应数据库的实体类
 * Created by lizhen on 2018/2/7.
 */
@Table(name="ZMT_Usertype")
@Entity(name="ZMT_Usertype")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer ID;
    @Column(name = "Typename")
    private String TypeName;

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", TypeName='" + TypeName + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}
