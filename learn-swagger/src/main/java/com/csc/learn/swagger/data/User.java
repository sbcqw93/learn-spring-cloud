package com.csc.learn.swagger.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Lihuan on 2018/6/12 0012.
 */
@ApiModel(value = "用户对象")
public class User {

    private int id;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "性别:1表示男,0表示女")
    private int sex;
    @ApiModelProperty(value = "手机号码")
    private String phone;

    public User() {
    }

    public User(String userName, int sex, String phone) {
        this.userName = userName;
        this.sex = sex;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
