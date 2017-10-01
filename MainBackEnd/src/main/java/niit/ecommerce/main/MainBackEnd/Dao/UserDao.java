package niit.ecommerce.main.MainBackEnd.Dao;

import java.util.List;

import niit.ecommerce.main.MainBackEnd.dto.User;

public interface UserDao {
	
	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(String email);
	
	public User getUserByUsername(String email);

	public User getUserById(Long user_id);
	
	public User checkUserlogin(String pwd,String u_email);
	
	public List<User> getAllUser();
	
	public List<User> getActiveUser();
	
	public List<User> getAllSupplier();
}
