package niit.ecommerce.main.MainBackEnd.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Cart")
public class Cart implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long cart_Id;

		private int cartItemCount;

		private long grandTotal;
		
		@OneToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "user_id")
		private User user;

		@JsonBackReference
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "cart")
		private List<CartItem> cartList = new ArrayList<CartItem>(0);

		public Long getCart_Id() {
			return cart_Id;
		}

		public void setCart_Id(Long cart_Id) {
			this.cart_Id = cart_Id;
		}

		public int getCartItemCount() {
			return cartItemCount;
		}

		public void setCartItemCount(int cartItemCount) {
			this.cartItemCount = cartItemCount;
		}

		public long getGrandTotal() {
			return grandTotal;
		}

		public void setGrandTotal(long grandTotal) {
			this.grandTotal = grandTotal;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<CartItem> getCartList() {
			return cartList;
		}

		public void setCartList(List<CartItem> cartList) {
			this.cartList = cartList;
		}
		
		


}
