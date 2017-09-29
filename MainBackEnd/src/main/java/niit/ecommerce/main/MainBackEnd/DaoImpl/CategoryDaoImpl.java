package niit.ecommerce.main.MainBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.CategoryDao;
import niit.ecommerce.main.MainBackEnd.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	//Add New Categories
	public boolean addCategory(Category category) {
		try{
			//Query To Add New Category
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	//Updating Existing Category
	public boolean updateCategory(Category category) {
		try{
			//Query To Update Category
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	//Deleting A Category
	public boolean deleteCategory(long category_id) {
		//Creating Query To Delete The Category
		String deleteCategory = "Delete From Category where category_id=:parameter";
		Query<Category> query  = sessionFactory.getCurrentSession().createQuery(deleteCategory, Category.class);
		//Setting parameter to category id
		query.setParameter("parameter", category_id);
		try{
		//Deleting The Category
		System.out.println(query.executeUpdate());
		return true;
	}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}
	
	@Override
	//Select List Of All Category
	public List<Category> getAllCategory() {
		String selectAllCategory = "From Category";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectAllCategory, Category.class);
		try{
			//Return List Of Category 
			return query.getResultList();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	//Get All Category By Category Name
	public List<Category> getAllCategoryByCategoryName(String category) {
		//Creating Query
		String selectByCategory = "From Category where category_name=:parameter";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectByCategory, Category.class);
		//Setting parameter to category name
		query.setParameter("parameter", category);
		try{
			//Return List Of Category 
			return query.getResultList();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	//Get All Category By Category Name
	public Category getCategoryBySubCategoryName(String subCategory) {
		//Creating Query
		String getCategory = "From Category where subcategory_name=:parameter";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(getCategory, Category.class);
		//Setting parameter to SubCategory Name
		query.setParameter("parameter", subCategory);
		try {
			return query.getSingleResult();
		} 
		catch (Exception e) {
			return null;
		}
	}

}
