package com.bravo.system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Order")
public class OrderEntity {

    @Id
    private String id;
    private String site;
    private float totalPrice;
    private Date dueDate;
    private Date orderDate;
    private String orderStatus;
    private String supplier;
    private String supplierStatus;
    private String approvelNote;
    private String approvelManager;
    private String deliveryNote;
    private String inquiry;
    private String inquiryReply;

//    public OrderEntity(String id, String site, float totalPrice, Date dueDate, Date orderDate, String orderStatus, String supplier, String supplierStatus, String approvelNote, String approvelManager, String deliveryNote, String inquiry, String inquiryReply) {
//        this.id = id;
//        this.site = site;
//        this.totalPrice = totalPrice;
//        this.dueDate = dueDate;
//        this.orderDate = orderDate;
//        this.orderStatus = orderStatus;
//        this.supplier = supplier;
//        this.supplierStatus = supplierStatus;
//        this.approvelNote = approvelNote;
//        this.approvelManager = approvelManager;
//        this.deliveryNote = deliveryNote;
//        this.inquiry = inquiry;
//        this.inquiryReply = inquiryReply;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getApprovelNote() {
        return approvelNote;
    }

    public void setApprovelNote(String approvelNote) {
        this.approvelNote = approvelNote;
    }

    public String getApprovelManager() {
        return approvelManager;
    }

    public void setApprovelManager(String approvelManager) {
        this.approvelManager = approvelManager;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getInquiryReply() {
        return inquiryReply;
    }

    public void setInquiryReply(String inquiryReply) {
        this.inquiryReply = inquiryReply;
    }
}
