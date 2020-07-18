package com.cg.bookStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="bookstore_cart")
@DynamicInsert
@DynamicUpdate
public class CartInformation {
	
	@Id
	@Column(name="customer_id")
	private int customerId;
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
