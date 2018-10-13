package com.hhg.jerry.form;

import javax.validation.constraints.NotEmpty;

/**
 * Created by lina on 2018/10/12.
 */
public class OrderForm {

    @NotEmpty(message = "name can't be null")
    private String name;

    @NotEmpty(message = "phone can't be null")
    private String phone;

    @NotEmpty(message = "address can't be null")
    private String address;

    @NotEmpty(message = "openid can't be null")
    private String openid;

    @NotEmpty(message = "items can't be null")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
