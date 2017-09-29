package niit.ecommerce.main.MainBackEnd.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CartItem")
public class CartItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartItem_Id;

	private int sell_quantity;

	private long total_price;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")
	private Product product;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cart cart;

	public Long getCartItem_Id() {
		return cartItem_Id;
	}

	public void setCartItem_Id(Long cartItem_Id) {
		this.cartItem_Id = cartItem_Id;
	}

	public int getSell_quantity() {
		return sell_quantity;
	}

	public void setSell_quantity(int sell_quantity) {
		this.sell_quantity = sell_quantity;
	}

	public long getTotal_price() {
		return total_price;
	}

	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartItem [cartItem_Id=" + cartItem_Id + ", sell_quantity=" + sell_quantity + ", total_price="
				+ total_price + "]";
	}
	
}
