package com.hackathon.Tracker.Entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERTRACK")
public class Order {
@Id
@Column(name="ORDERID")
private int orderId;
@Column(name="BUYERID")
private int buyerId;
@Column(name="BUYERNAME")
private String buyerName;
@Column(name="AMOUNT")
private double amount;
@Column(name="ORDERPLACED")
private Date orderDate;
@Column(name="DELIVERYTIME")
private Time expectedTime;
@Column(name="DELIVERYAREA")
private String deliveryArea;
@Column(name="STATUS")
private String status;


public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getBuyerId() {
	return buyerId;
}
public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}
public String getBuyerName() {
	return buyerName;
}
public void setBuyerName(String buyerName) {
	this.buyerName = buyerName;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Time getExpectedTime() {
	return expectedTime;
}
public void setExpectedTime(Time expectedTime) {
	this.expectedTime = expectedTime;
}
public String getDeliveryArea() {
	return deliveryArea;
}
public void setDeliveryArea(String deliveryArea) {
	this.deliveryArea = deliveryArea;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
