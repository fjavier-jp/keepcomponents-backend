package fjavierjp.keepcomponents.backend.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

public class Article implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	@Size(max = 150)
	private String name;
	
	@Column(nullable = false)
	@Size(max = 150)
	private String description;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double stock;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private ArticleType type;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Provider provider;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy = "purchase")
	private List<Purchase> purchases;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}
}
