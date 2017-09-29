package niit.ecommerce.main.MainBackEnd.Dao;

import java.util.List;

import niit.ecommerce.main.MainBackEnd.dto.Category;


public interface CategoryDao {

	public List<Category> getAllCategory();
	public Category getCategoryBySubCategoryName(String subCategory);
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(long category_id);
	public List<Category> getAllCategoryByCategoryName(String category);
}
