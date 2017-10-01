package niit.ecommerce.main.MainBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	//Adding User To Database
	public boolean addUser(User user) {
		try{
		//Mapping Cart To User(Bi-Directional Relationship)
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		//Inserting User Info Into Database
		sessionFactory.getCurrentSession().persist(user);
		return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	//Updating User Info
	public boolean updateUser(User user) { 
		try{
			//Update User Info
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		return false;
		}
	}

	@Override
	//Deleting User By Setting Its Status As False
	public boolean deleteUser(String email) {
		//Get User By Email
		User user = getUserByUsername(email);
		//Setting User Status To False 
		user.setEnable(false);
		try{
			//Commiting The Changes
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		return false;
		}
	}

	@Override
	//Get User By EmailId Used To Login
	public User getUserByUsername(String email) {
		//Select User Using User Email Id
		String selectUserId = "From User where uemail=:parameter";
		//Creating Query
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUserId, User.class);
		//Setting Parameter For uemail
		query.setParameter("parameter",email);
		try{
		//Return Single Result	
		return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	//Get User By User Id
	public User getUserById(Long user_id) {
		//Select User By User Id
		String selectUserId = "From User where user_id=:parameter";
		//Creating Query
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUserId, User.class);
		//Setting Parameter For user_id
		query.setParameter("parameter", user_id);
		try{
			//Return Single Result
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@Override
	public User checkUserlogin(String pwd,String u_email)
	{
		//Select User By User Id
				String selectUser = "From User where password=:parameter1 and uemail=:parameter2";
				//Creating Query
				Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUser, User.class);
				//Setting Parameter For user_id and email
				query.setParameter("parameter1", pwd);
				query.setParameter("parameter2", u_email);
				try{
					//Return Single Result
					return query.getSingleResult();
				}
				catch(Exception e)
				{
					return null;
				}
	}

	@Override
	//Return List Of User That Are Active(Status = true) 
	public List<User> getActiveUser() {
		//Select User By User Id
		String selectActiveUser = "From User where enable = 'TRUE' and role = 'Customer'";
		//Creating Query
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectActiveUser, User.class);
		try{
			//Return Single Result
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<User> getAllUser() {
		//Select User By User Id
				String selectActiveUser = "From User where role = 'Customer'";
				//Creating Query
				Query<User> query = sessionFactory.getCurrentSession().createQuery(selectActiveUser, User.class);
				try{
					//Return Single Result
					return query.getResultList();
				}
				catch(Exception e)
				{
					return null;
				}
	}

	@Override
	//Get All Supplier
	public List<User> getAllSupplier() {
		//Select All Supplier
		String selectActiveSupplier = "From User where role=:parameter";
		//Creating Query
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier, User.class);
		query.setParameter("parameter", "Supplier");
		try{
			//Return Single Result
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
