package niit.ecommerce.main.MainBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.CartItemDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.CartItem;
import niit.ecommerce.main.MainBackEnd.dto.Product;

@Repository("cartItemDao")
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	//Add Product CartItem
	public boolean addCartItem(CartItem cartItem) {
		try {
			// add cart item to the database
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}
	
	@Override
	//Update existing CartItem
	public boolean updateCartItem(CartItem cartItem) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}
	
	@Override
	//Delete Single CartItem 
	public boolean deleteCartItem(Long cartItem_Id) {
		//Creating Query
		String deleteCartItem = "Delete from CartItem where cartitem_id=:parameter";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(deleteCartItem);
		query.setParameter("parameter", cartItem_Id);
		try {
			// Delete the cartItem to the database
			query.executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	//Get All CartItem by Cart
	public List<CartItem> cartItemGetByCart(Cart cart) {
		//Creating Query
		String getAllCartItem = "From CartItem where cart=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(getAllCartItem, CartItem.class);
		query.setParameter("parameter", cart);
		try {
			//Return List Of CartItem
			return query.getResultList();
		} 
		catch (Exception e) {
			return null;
		}
	}

	@Override
	//Get CartItem By CartItem Id
	public CartItem getCartItemByCartItem_Id(Long cartItem_Id) {
		//Creating Query
		String getCartItem = "From CartItem where cartitem_id=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(getCartItem, CartItem.class);
		query.setParameter("parameter", cartItem_Id);
		try {
			//Return Single CartItem
			return query.getSingleResult();
		} 
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	//Search CartItem By Cart Id And Product Id
	public boolean searchCartItemByCartIdAndProductId(Cart cart, Product product) {
		//Creating Query
		String searchCartItem = "From CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(searchCartItem, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try {
			//Return Single CartItem 
			query.getSingleResult();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	//Get CartItem By Cart Id And Product Id
	public CartItem getCartItemByCartIdAndProductId(Cart cart, Product product) {
		//Creating Query
		String selectCartId = "FROM CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try {
			//return Single CartItem
			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	//Get Grand Total Of CartItem For A Cart
	public long getGrandTotal(Cart cart) {
		//Creating Query
		String selectTotalPrice = "From CartItem where cart_cart_id=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectTotalPrice, CartItem.class);
		query.setParameter("parameter", cart.getCart_Id());
		try {
			long total_price = 0;
			long total_quantity = 0;
			List<CartItem> list = query.getResultList();
			for(CartItem c : list)
			{
				total_price = total_price + c.getTotal_price();
				total_quantity = total_quantity + c.getSell_quantity();
			}
			return total_price;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	//Get Total Of Number of Items in CartItem For A Cart
	public int getTotalQuantity(Cart cart) {
		String selectTotalPrice = "From CartItem where cart_cart_id=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectTotalPrice, CartItem.class);
		query.setParameter("parameter", cart.getCart_Id());
		try {
			int total_quantity = 0;
			List<CartItem> list = query.getResultList();
			for(CartItem c : list)
			{
				total_quantity = total_quantity + c.getSell_quantity();
			}
			return total_quantity;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

}
