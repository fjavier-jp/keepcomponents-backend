package fjavierjp.keepcomponents.backend.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "articles")
@JsonIgnoreProperties("purchases")
public class Article implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Name cannot be null")
	@Column(nullable = false)
	@Size(max = 150)
	private String name;

	@NotNull(message = "Description cannot be null")
	@Column(nullable = false)
	@Size(max = 150)
	private String description;

	@NotNull(message = "Price cannot be null")
	@Column(nullable = false)
	private double price;

	@NotNull(message = "Stock cannot be null")
	@Column(nullable = false)
	private double stock;

	@NotNull(message = "Type cannot be null")
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private ArticleType type;

	@NotNull(message = "Provider cannot be null")
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Provider provider;

	@NotNull(message = "Date cannot be null")
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
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
