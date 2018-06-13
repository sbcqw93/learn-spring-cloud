package com.csc.learn.swagger.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
@ApiModel(value = "User")
public class User {
    private int id;
    @ApiModelProperty(name = "userName")
    private String userName;
    @ApiModelProperty(name = "sex")
    private int sex;
    @ApiModelProperty(name = "phone")
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
