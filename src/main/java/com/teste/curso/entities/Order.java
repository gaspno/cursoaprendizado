package com.teste.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.teste.curso.entities.enums.OrderStatus;




@Entity
@Table(name="TB__Order")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'-HH:mm:ss'Z'",timezone="GMT")
	private Instant moment;	
	private Integer orderStatus;
	@JoinColumn(name="cliente_id")
	@ManyToOne	
	private User cliente;
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)	
	private Payment payment;
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@OneToMany(mappedBy = "Id.Order")
	private Set<OrderItem> items=new HashSet<>();
	

	public Set<OrderItem> getItems() {
		return items;
	}

	public Order() {
		
	}

	public Order(Long id, Instant moment,OrderStatus OrderStatus, User cliente) {
		super();
		Id = id;
		setOrderStatus(OrderStatus);
		this.moment = moment;
		this.cliente = cliente;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	public double getTotal() {
		double sum=0.0;
		for(OrderItem x:items) {
			sum+=x.getPrice();
		}
		return sum;
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
		Order other = (Order) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus!=null)
		this.orderStatus =orderStatus.getCode();
	}
	
	
	

}
