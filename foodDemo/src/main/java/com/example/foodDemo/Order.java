package com.example.foodDemo;



import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private int order_id;

    private String customer_name;
    private String food_item;
    private int quantity;
    private double total_amount;
    private String order_date;
    private String order_status;
    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getFood_item() {
        return food_item;
    }
    public void setFood_item(String food_item) {
        this.food_item = food_item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}