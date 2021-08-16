package com.cgi.hasa;

public class Order {
    private int orderId;
    private double orderValue;
    //has-a - dependancy
    private Product product;

    public Order() {
    }

    public Order(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderValue=" + orderValue +
                ", product=" + product +
                '}';
    }

    public Order(int orderId, double orderValue, Product product) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
