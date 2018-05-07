package com.batis.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer age;

    private Date birthdat;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String constellation;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return birthdat
     */
    public Date getBirthdat() {
        return birthdat;
    }

    /**
     * @param birthdat
     */
    public void setBirthdat(Date birthdat) {
        this.birthdat = birthdat;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return constellation
     */
    public String getConstellation() {
        return constellation;
    }

    /**
     * @param constellation
     */
    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", age=").append(age);
        sb.append(", birthdat=").append(birthdat);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", constellation=").append(constellation);
        sb.append("]");
        return sb.toString();
    }
}