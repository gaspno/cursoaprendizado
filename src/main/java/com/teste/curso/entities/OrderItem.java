package com.teste.curso.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.curso.entities.pk.OrderItemPK;

@Entity
@Table(name="TB_Order_Item")
public class OrderItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId	
	private OrderItemPK Id=new OrderItemPK();
	
	private int Quantity;
	private double price;
	
	
	public OrderItem(Order order,Product product,int quantity, double price) {
		super();
		Id.setOrder(order);
		Id.setProduct(product);
		Quantity = quantity;
		this.price = price;
	}


	public OrderItem() {
	
	}
	
	@JsonIgnore
	public Order getOrder() {
		
		return Id.getOrder();
	}
	
	public void setOrder(Order order) {
		Id.setOrder(order);
	}
	
	public Product getProduct() {
		
		return Id.getProduct();
	}
	
	public void setProduct(Product product) {
		Id.setProduct(product);
	}


	
	


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
	
	
	

}
