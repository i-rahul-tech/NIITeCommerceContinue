package niit.ecommerce.main.MainBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.ProductDao;
import niit.ecommerce.main.MainBackEnd.dto.Category;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	@Override
	//Add Product
	public boolean addProduct(Product product) {
		try{
			//Add Product To Database
			sessionFactory.getCurrentSession().save(product);
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
	//Update Product
	public boolean updateProduct(Product product) {
		try{
			//Update Product To Database
			sessionFactory.getCurrentSession().update(product);
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
	public boolean deleteProduct(Long id) {
		Product product = getProductByProductId(id);
		product.setActiveIs(false);
		try{
			sessionFactory.getCurrentSession().update(product);
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
	//Select Product By Product Id
	public Product getProductByProductId(Long product_id) {
		//Creating Query
		String selectProduct = "From Product where prod_id=:parameter";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectProduct, Product.class);
		//Setting parameter to product id
		query.setParameter("parameter", product_id);
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
	//Get All Product
	public List<Product> getAllProduct() {
		//Creating Query
		String getProduct = "From Product";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(getProduct,Product.class);
		try{
			//Return List Of Product
			return query.getResultList();
		}
		catch(Exception  e)
		{
		return null;
		}
	}

	@Override
	//Get All Active Products
	public List<Product> getActiveProducts() {
		//Creating Query
		String getProduct = "From Product where activeis=:parameter";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(getProduct,Product.class);
		query.setParameter("parameter", "TRUE");
		try{
			//Return List Of Product
			return query.getResultList();
		}
		catch(Exception  e)
		{
			return null;
		}
	}

	@Override
	//Select List Of Product By category That Are Active
	public List<Product> getActiveProductByCategory(Category category) {
		//Creating Query
		String selectProduct = "From Product where category_id=:parameter and activeis='TRUE'";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectProduct, Product.class);
		//Setting parameter to category
		query.setParameter("parameter", category);
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
	//Search Product By Name
	public List<Product> getProductByProductName(String search) {
		//Creating Query
		String selectProduct = "From Product where activeis='TRUE' and prod_name like lower(:parameter)";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectProduct, Product.class);
		query.setParameter("parameter", '%'+search+'%');
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
	public List<Product> select8Product() {
		String getProduct = "From Product where activeis=:parameter";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(getProduct,Product.class);
		query.setParameter("parameter", "TRUE");
		query.setFirstResult(0);
		query.setMaxResults(8);
		try{
			//Return List Of Product
			return query.getResultList();
		}
		catch(Exception  e)
		{
			return null;
		}
	}

	@Override
	public List<Product> getAllProductBySupplier(User user) {
		String getProduct = "From Product where supplier_id=:parameter";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(getProduct,Product.class);
		query.setParameter("parameter", user);
		try{
			//Return List Of Product
			return query.getResultList();
		}
		catch(Exception  e)
		{
			return null;
		}
	}
	
	
	
}
