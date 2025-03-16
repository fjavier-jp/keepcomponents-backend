package fjavierjp.keepcomponents.backend.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties("purchases")
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Name cannot be null")
	@Column(nullable = false)
	@Size(max = 150)
	private String name;

	@NotNull(message = "Surname cannot be null")
	@Column(nullable = false)
	@Size(max = 150)
	private String surname;

	@NotNull(message = "Email cannot be null")
	@Email
	@Column(nullable = true, unique = true)
	private String email;

	@NotNull(message = "Phone cannot be null")
	@Column(nullable = false)
	@Size(max = 15)
	private String phone;
	
	@NotNull(message = "Date of birth cannot be null")
	@Column(nullable = false)
	private Date dob;

	@Size(max = 150)
	private String company;
	
	@Size(max = 150)
	private String position;
	
	@Size(max = 500)
	private String address;
	
	@Size(max = 10)
	private String postalCode;
	
	@Size(min = 2, max = 100)
	private String region;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Purchase> purchases;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public List<Purchase> getPurchases()
	{
		return purchases;
	}
}
