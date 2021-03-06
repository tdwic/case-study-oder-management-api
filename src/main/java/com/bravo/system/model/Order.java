package com.bravo.system.model;
import com.bravo.system.entity.ProductEntity;

import java.util.Date;
import java.util.List;

public class Order {

    private String id;
    private List<ProductEntity> items;
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
    private String siteManager;

    public String getSiteManager() {
        return siteManager;
    }

    public void setSiteManager(String siteManager) {
        this.siteManager = siteManager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductEntity> getItems() {
        return items;
    }

    public void setItems(List<ProductEntity> items) {
        this.items = items;
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
