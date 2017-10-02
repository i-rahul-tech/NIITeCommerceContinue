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
public class AdminController {

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

	@RequestMapping(value = { "/admin/updatepwd" })
	public String adminupdatepwdpage(Principal principal, Model map) {
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("uname", user.getUfname());
		map.addAttribute("upwd", user.getPassword());
		return "admin/updatepassword";
	}

	@RequestMapping(value = { "/admin/updatepassword" }, method = RequestMethod.POST)
	public String adminUpdateUser(@RequestParam("oldpwd") String oldpwd, @RequestParam("newpwd") String newpwd,
			Principal principal, Model map, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		User user = userDao.getUserByUsername(principal.getName());

		if (user.getPassword().equals(oldpwd)) {
			user.setPassword(newpwd);
			Boolean b = userDao.updateUser(user);
			if (b) {
				map.addAttribute("msg", "Password Changed Successfully");
				return "redirect:" + referer;
			} else {
				map.addAttribute("msg", "Oops.......Something Went Wrong...Try Again Later...");
				return "redirect:" + referer;
			}
		} else {
			map.addAttribute("pname", user.getUfname());
			return "redirect:" + referer;
		}
	}

	@RequestMapping("/viewuser")
	public String viewAllUser(Model map, Principal principal) {
		List<User> userlist = userDao.getAllUser();
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("user", userlist);
		map.addAttribute("uname", user.getUfname());
		return "admin/user";
	}

	@RequestMapping("/updateuser")
	public String updateUserStatus(@RequestParam("uid") Long uid, Model map, HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		User user = userDao.getUserById(uid);
		if (user.getStatus().equals("1")) {
			user.setStatus("0");
			userDao.updateUser(user);
			map.addAttribute("msg", "User Disabled");
			return "redirect:" + referer;
		} else if (user.getStatus().equals("0")) {
			user.setStatus("1");
			userDao.updateUser(user);
			map.addAttribute("msg", "User Enabled");
			return "redirect:" + referer;
		} else {
			map.addAttribute("msg", "Error Occured");
			return "redirect:" + referer;
		}
	}

	@RequestMapping("/viewsupplier")
	public String viewAllSupplier(Model map, Principal principal) {
		List<User> supplierlist = userDao.getAllSupplier();
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("supplier", supplierlist);
		map.addAttribute("uname", user.getUfname());
		return "admin/supplier";
	}

	@RequestMapping("/updatesupplier")
	public String updateSupplierStatus(@RequestParam("uid") Long uid,
			@RequestParam(value = "msg", required = false) String msg1, Model map, HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		User user = userDao.getUserById(uid);
		if (msg1 != "") {
			map.addAttribute("msg", null);
		}
		if (user.getEnable().equals(true)) {
			user.setEnable(false);
			List<Product> product = productDao.getAllProductBySupplier(user);
			for (Product p : product) {
				p.setActiveIs(false);
				productDao.updateProduct(p);
			}
			userDao.updateUser(user);
			map.addAttribute("msg", "Supplier Disabled");
			return "redirect:" + referer;
		} else if (user.getEnable().equals(false)) {
			user.setEnable(true);
			List<Product> product = productDao.getAllProductBySupplier(user);
			for (Product p : product) {
				p.setActiveIs(true);
				productDao.updateProduct(p);
			}
			userDao.updateUser(user);
			map.addAttribute("msg", "Supplier Enabled");
			return "redirect:" + referer;
		} else {
			map.addAttribute("msg", "Error Occured");
			return "redirect:" + referer;
		}
	}

	@RequestMapping(value = { "/admin/updateinfo" }, method = RequestMethod.GET)
	public String adminupdatepage(Principal principal, Model map) {
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("user", user);
		map.addAttribute("uname", user.getUfname());
		return "admin/updateinfo";
	}

	@RequestMapping(value = { "/admin/updateuserinfo" }, method = RequestMethod.POST)
	public String adminUpdateUser(@RequestParam("dob") String dob, @RequestParam("contact") String contact,
			@RequestParam("address") String address, @RequestParam("state") String state,
			@RequestParam("pincode") String pincode, Principal principal, Model map, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		User user = userDao.getUserByUsername(principal.getName());

		user.setDob(dob);
		user.setContact(contact);
		user.setPincode(pincode);
		user.setAddress(address);
		user.setState(state);

		Boolean b = userDao.updateUser(user);
		if (b) {
			map.addAttribute("msg", "Your Information Have Been Successfuly Updated");
			return "redirect:" + referer;
		} else {
			map.addAttribute("msg", "Oops.......Something Went Wrong...Try Again Later...");
			return "redirect:" + referer;
		}
	}

	@RequestMapping("/viewproduct")
	public String viewAllProduct(Model map, Principal principal) {
		List<Product> productlist = productDao.getAllProduct();
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("product", productlist);
		map.addAttribute("uname", user.getUfname());
		return "admin/product";
	}

	@RequestMapping("/updateproduct")
	public String updateProduct(@RequestParam("pid") Long pid, Model map, HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		System.out.println("ContextPath" + req.getRequestURI());
		Product product = productDao.getProductByProductId(pid);
		User s = product.getUser();
		if (s.getEnable().equals(false)) {
			map.addAttribute("err", "The Product Cannot Be Enabled Because The Supplier Is Deactivated...");
			return "redirect:" + referer;
		} else if (product.isActiveIs() == (true)) {
			product.setActiveIs(false);
			productDao.updateProduct(product);
			return "redirect:" + referer;
		} else if (product.isActiveIs() == (false)) {
			product.setActiveIs(true);
			productDao.updateProduct(product);
			return "redirect:" + referer;
		}

		else {
			return "redirect:" + referer;
		}
	}

	@RequestMapping("addproduct")
	public String toaddProduct(Principal p, Model m) {
		User user = userDao.getUserByUsername(p.getName());
		m.addAttribute("uname", user.getUfname());
		return "admin/addproduct";
	}

	@RequestMapping(value = { "adminaddproduct" }, method = RequestMethod.POST)
	public String adminAddProduct(@RequestParam("prodbrand") String brand, @RequestParam("prodname") String prodname,
			@RequestParam("description") String description, @RequestParam("price") long price,
			@RequestParam("quantity") int quantity, @RequestParam("subcategory") String cat_name, Principal p,
			Model map, HttpServletRequest req) {
		String refer = req.getHeader("Referer");
		Product product = new Product();
		product.setProd_brand(brand);
		prodname = prodname.toLowerCase();
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
			return ("admin/uploadimage");
		} else {
			map.addAttribute("err", "Product Could Not Be Added............");
			return "redirect:" + refer;
		}
	}
	
	@RequestMapping("updateproduct1")
	public String toUpdateProduct(@RequestParam("pid") Long pid, Model map, Principal p)
	{
		User user = userDao.getUserByUsername(p.getName());
		map.addAttribute("user",user);
		map.addAttribute("uname", user.getUfname());
		Product product = productDao.getProductByProductId(pid);
		map.addAttribute("product",product);
		return "admin/updateproduct";
	}
	
	@RequestMapping("productupdate")
	public String UpdateProduct(@RequestParam("pid") Long pid,@RequestParam("prodbrand") String brand, @RequestParam("prodname") String prodname,
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
				return ("admin/uploadimage");
			}
			else
			{
				return "admin/productadded";
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
