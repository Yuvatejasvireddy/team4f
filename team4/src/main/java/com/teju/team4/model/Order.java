package com.teju.team4.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Long id;

    // Array of product IDs
    @Column(name = "p_id", nullable = false)    
    private List<Long> p_id;

    // Array of quantities corresponding to product IDs
    @Column(name = "p_qty", nullable = false)
    private List<Integer> p_qty;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staff;
    
    private String payment_mode;

    public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	

	public Order(Long id, List<Long> p_id, List<Integer> p_qty, Staff staff, String payment_mode, LocalDate orderDate,
			LocalDate deliveryDate, String status) {
		super();
		this.id = id;
		this.p_id = p_id;
		this.p_qty = p_qty;
		this.staff = staff;
		this.payment_mode = payment_mode;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
	}

	public List<Long> getP_id() {
		return p_id;
	}

	public void setP_id(List<Long> p_id) {
		this.p_id = p_id;
	}

	public List<Integer> getP_qty() {
		return p_qty;
	}

	public void setP_qty(List<Integer> p_qty) {
		this.p_qty = p_qty;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "o_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "o_delivery")
    private LocalDate deliveryDate;

    @Column(name = "status", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'placed'")
    private String status;

    // Constructors, getters, and setters
    public Order() {
        // Default constructor
    }

   

	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

    // Getters and setters for all attributes
    // Omitted for brevity
}



