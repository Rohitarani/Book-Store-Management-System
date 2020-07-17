package com.cg.bookStore.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="bookstore_order")
public class OrderInformation {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderIdGenerator")
	@SequenceGenerator(name="orderIdGenerator", initialValue=1000)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName = "customer_id")
	private CustomerInformation customerDetails = new CustomerInformation();

	@Column(name="shipping_address")
	private String shippingAddress;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="subtotal")
	private float subTotal;
	
	@Column(name="total")
	private float total;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public CustomerInformation getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerInformation customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	

}
