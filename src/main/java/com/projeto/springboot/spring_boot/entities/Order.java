package com.projeto.springboot.spring_boot.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.springboot.spring_boot.entities.enums.OrderStatus;

import jakarta.persistence.*;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant date;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private User client;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> itens = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	public Order() {
		super();
	}

	public Order(Long id, Instant date, User client, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.date = date;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public double getTotal(){
		double sum = 0.0;
		for(OrderItem x : itens){
			sum += x.getSubTotal();
		}
		return sum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public OrderStatus getOrdeStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
	}

	public Set<OrderItem> getItens() {
		return itens;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
}
