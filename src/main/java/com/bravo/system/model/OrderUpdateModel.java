package com.bravo.system.model;

public class OrderUpdateModel {

    private String status;
    private String orderno;


    public String getOrderno() {
        return orderno;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
