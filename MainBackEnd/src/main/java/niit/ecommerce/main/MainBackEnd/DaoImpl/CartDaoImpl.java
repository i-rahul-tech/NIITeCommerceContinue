package niit.ecommerce.main.MainBackEnd.DaoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.CartDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	@Override
	//Update Cart
	public boolean updateCart(Cart cart) {
		try{
			//Updating Cart Values
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;	
			}
	}

	@Override
	//Select Cart By Cart Id
	public Cart getCartBycart_Id(Long cart_Id) {
		//Creating select query
		String selectCart = "From Cart where cart_Id=:parameter";
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(selectCart, Cart.class);
		//Setting parameter value of cart id
		query.setParameter("parameter", cart_Id);
		try{
			//Return cart object as per the cart id
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	//Delete All Cart Items Corresponding To Cart
	public boolean deleteAllCartItems(Cart cart) {
		//Creating Delete Query
		String deleteCart = "Delete from CartItem where cart=:parameter";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(deleteCart);
		//Setting Parameter For Cart
		query.setParameter("parameter", cart);
		try{
		//Return true on successful Deletion  
		query.executeUpdate();
		return true;
		} 
		catch (Exception ex) {
		ex.printStackTrace();
		System.out.println(ex);
		return false;
	}
	}
}
