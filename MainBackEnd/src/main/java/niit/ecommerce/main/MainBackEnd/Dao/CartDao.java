package niit.ecommerce.main.MainBackEnd.Dao;

import niit.ecommerce.main.MainBackEnd.dto.Cart;

public interface CartDao {
	public boolean updateCart(Cart cart);

	public Cart getCartBycart_Id(Long cart_Id);

	public boolean deleteAllCartItems(Cart cart);
}
