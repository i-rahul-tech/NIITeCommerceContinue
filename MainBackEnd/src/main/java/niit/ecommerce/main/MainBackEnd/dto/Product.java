package niit.ecommerce.main.MainBackEnd.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Product")
public class Product implements Serializable{
	private final static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prod_id;
	
	private String prod_brand;
	
	private String prod_name;
	
	private String prod_description;
	
	private String prodImg_url;
	
	private long price;
	
	private int quantity;
	
	private boolean activeIs = true;//ActiveIs = true;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "supplier_id")
	private User user;

	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_brand() {
		return prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_description() {
		return prod_description;
	}

	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}

	public String getProdImg_url() {
		return prodImg_url;
	}

	public void setProdImg_url(String prodImg_url) {
		this.prodImg_url = prodImg_url;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActiveIs() {
		return activeIs;
	}

	public void setActiveIs(boolean activeIs) {
		this.activeIs = activeIs;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_brand=" + prod_brand + ", prod_name=" + prod_name
				+ ", prod_description=" + prod_description + ", prodImg_url=" + prodImg_url + ", price=" + price
				+ ", quantity=" + quantity + ", activeIs=" + activeIs + ", category=" + category + "]";
	}
}
