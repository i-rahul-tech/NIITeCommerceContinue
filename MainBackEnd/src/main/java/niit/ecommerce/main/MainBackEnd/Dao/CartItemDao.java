package niit.ecommerce.main.MainBackEnd.Dao;

import java.util.List;

import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.CartItem;
import niit.ecommerce.main.MainBackEnd.dto.Product;



public interface CartItemDao {
	public boolean searchCartItemByCartIdAndProductId(Cart cart, Product product);

	public CartItem getCartItemByCartIdAndProductId(Cart cart, Product product);

	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(Long cartItem_Id);

	public CartItem getCartItemByCartItem_Id(Long cartItem_Id);
	
	public long getGrandTotal(Cart cart);
	
	public int getTotalQuantity(Cart cart);
}
