package com.teste.curso.entities.pk;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.teste.curso.entities.Order;
import com.teste.curso.entities.Product;

@Embeddable
public class OrderItemPK implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order Order;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product Product;
	



	public Order getOrder() {
		return Order;
	}


	public void setOrder(Order order) {
		Order = order;
	}


	public Product getProduct() {
		return Product;
	}


	public void setProduct(Product product) {
		Product = product;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Order == null) ? 0 : Order.hashCode());
		result = prime * result + ((Product == null) ? 0 : Product.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (Order == null) {
			if (other.Order != null)
				return false;
		} else if (!Order.equals(other.Order))
			return false;
		if (Product == null) {
			if (other.Product != null)
				return false;
		} else if (!Product.equals(other.Product))
			return false;
		return true;
	}
	
	
	

}
