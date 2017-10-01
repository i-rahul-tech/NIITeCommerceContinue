package niit.ecommerce.main.MainFrontEnd.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import niit.ecommerce.main.MainBackEnd.Dao.CartDao;
import niit.ecommerce.main.MainBackEnd.Dao.CartItemDao;
import niit.ecommerce.main.MainBackEnd.Dao.CategoryDao;
import niit.ecommerce.main.MainBackEnd.Dao.ProductDao;
import niit.ecommerce.main.MainBackEnd.Dao.ReviewDao;
import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.Category;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Controller
public class SupplierHandler {
	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	UserDao userDao;

	@Autowired
	CartItemDao cartItemDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	ReviewDao reviewDao;

	@RequestMapping("/sviewproduct")
	public String sViewProduct(Model map, Principal p) {
		User user = userDao.getUserByUsername(p.getName());
		map.addAttribute("uname", user.getUfname());
		List<Product> productList = productDao.getAllProductBySupplier(user);
		map.addAttribute("productList", productList);
		return "supplier/product";
	}

	@RequestMapping("saddproduct")
	public String tosupplierAddProduct(Principal p, Model m) {
		User user = userDao.getUserByUsername(p.getName());
		m.addAttribute("uname", user.getUfname());
		return "supplier/saddproduct";
	}

	@RequestMapping(value = { "saddproduct" }, method = RequestMethod.POST)
	public String supplieraddProduct(@RequestParam("prodbrand") String brand, @RequestParam("prodname") String prodname,
			@RequestParam("description") String description, @RequestParam("price") long price,
			@RequestParam("quantity") int quantity, @RequestParam("subcategory") String cat_name, Principal p,
			Model map, HttpServletRequest req) {
		String refer = req.getHeader("Referer");
		Product product = new Product();
		product.setProd_brand(brand);
		product.setProd_name(prodname);
		product.setProd_description(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		Category cat = categoryDao.getCategoryBySubCategoryName(cat_name);
		product.setCategory(cat);
		User s = userDao.getUserByUsername(p.getName());
		product.setUser(s);
		Boolean b = productDao.addProduct(product);
		if (b) {
			long id = product.getProd_id();
			System.out.println("Product Id" + id);
			map.addAttribute("prod_id", id);
			return ("supplier/suploadimage");
		} else {
			map.addAttribute("err", "Product Could Not Be Added............");
			return "redirect:" + refer;
		}
	}
	
	@RequestMapping("supdateproduct1")
	public String toSupdateProduct(@RequestParam("pid") Long pid, Model map, Principal p)
	{
		User user = userDao.getUserByUsername(p.getName());
		map.addAttribute("uname", user.getUfname());
		Product product = productDao.getProductByProductId(pid);
		map.addAttribute("product",product);
		return "supplier/supdateproduct";
	}
	
	@RequestMapping("sproductupdate")
	public String sUpdateProduct(@RequestParam("pid") Long pid,@RequestParam("prodbrand") String brand, @RequestParam("prodname") String prodname,
			@RequestParam("description") String description, @RequestParam("price") long price,
			@RequestParam("quantity") int quantity, @RequestParam("changeimg") String choice, Model map, Principal p, HttpServletRequest req)
	{
		String referer = req.getHeader("Referer");
		User user = userDao.getUserByUsername(p.getName());
		map.addAttribute("uname", user.getUfname());
		Product product = productDao.getProductByProductId(pid);
		product.setProd_brand(brand);
		product.setProd_name(prodname);
		product.setProd_description(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		Boolean b = productDao.updateProduct(product);
		if(b)
		{
			if(choice.equals("yes"))
			{
				long id = product.getProd_id();
				System.out.println("Product Id" + id);
				map.addAttribute("prod_id", id);
				return ("supplier/suploadimage");
			}
			else
			{
				return "supplier/sproductadded";
			}
		}
		else
		{
			map.addAttribute("msg", "Unable To Update Try Again Later");
			return "redirect:" + referer;
		}
	}


	@ModelAttribute("categoryList")
	public List<Category> getCategory(Model map) {
		List<Category> categoryList = categoryDao.getAllCategory();
		map.addAttribute("categoryList", categoryList);
		return categoryList;
	}
}
