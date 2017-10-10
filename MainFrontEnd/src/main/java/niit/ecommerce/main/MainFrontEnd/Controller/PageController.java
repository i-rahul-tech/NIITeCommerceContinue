package niit.ecommerce.main.MainFrontEnd.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import niit.ecommerce.main.MainBackEnd.Dao.CartDao;
import niit.ecommerce.main.MainBackEnd.Dao.CartItemDao;
import niit.ecommerce.main.MainBackEnd.Dao.CategoryDao;
import niit.ecommerce.main.MainBackEnd.Dao.ProductDao;
import niit.ecommerce.main.MainBackEnd.Dao.ReviewDao;
import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.CartItem;
import niit.ecommerce.main.MainBackEnd.dto.Category;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.Review;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Controller
public class PageController {

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

	@RequestMapping(value = { "/", "/index", "/home" })
	public String index(Principal principal, Model model, HttpSession session) {
		System.out.println("Hello From Index");
		if (principal != null) {

			User user = userDao.getUserByUsername(principal.getName());
			System.out.println("Role: "+user.getRole());
			if (user.getRole().equalsIgnoreCase("Admin")) {
				model.addAttribute("uname", user.getUfname());
				session.setAttribute("username", user.getUfname());
				return "admin/adminIndex";
			} 
			else if (user.getRole().equalsIgnoreCase("Customer")) {
				System.out.println("Hello From Customer.......");
				if (user.getStatus().equals("1")) {
					model.addAttribute("uemail", principal.getName());
					model.addAttribute("uname", user.getUfname());
					session.setAttribute("username", user.getUfname());
					return "user/userindex";
				}
				else
				{
					return "user/activate";
				}
			}
				else if (user.getRole().equalsIgnoreCase("Supplier")) {
					System.out.println("Hello From Supplier.......");
					if (user.getStatus().equals("1")) {
						List<Product> pro = productDao.getAllProductBySupplier(user);
						model.addAttribute("uemail", principal.getName());
						model.addAttribute("uname", user.getUfname());
						model.addAttribute("total",pro.size());
						model.addAttribute("supplier",user);
						session.setAttribute("username", user.getUfname());
						return "supplier/sindex";
					}
					else {
						model.addAttribute("uname", user.getUfname());
						return "user/activate";
					}
				}
			}
		return "index";
	}

	@RequestMapping("/activateuser")
	public String activateUser(Principal p, Model map, HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		User user = userDao.getUserByUsername(p.getName());
		user.setStatus("1");
		Boolean b = userDao.updateUser(user);
		if (b) {
			map.addAttribute("msg","Account Activated Successfully....Please Login Again To Continue!!!!!");
			return "Login";
		}
		else
		{
			map.addAttribute("msg","ooopssss......Try Again....");
			return "redirect:" + referer;
		}
			
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model,Principal p) {
		if (error != null) {
			model.addAttribute("err", "Authentication Failed - Invalid Credentials!");
		}
		else if(logout != null)
		{
			model.addAttribute("err", "You Have Been Succesfully Logged Out!!!");
			return"Login";
		}
		return "Login";
	}

	@RequestMapping(value = { "/login/user" })
	public String userlogin() {
		return "Login";
	}

	@RequestMapping(value = { "/Books", "/Electronics", "/Fashion", "/Appliances" })
	public ModelAndView dropForward(@RequestParam("name") String cat_name, Model map, Principal principal) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname", user.getUfname());
		}
		ModelAndView mv = new ModelAndView("product1");
		Category category = categoryDao.getCategoryBySubCategoryName(cat_name);
		System.out.println("Hello From subcategory");
		List<Product> productlist = productDao.getActiveProductByCategory(category);
		map.addAttribute("prod_list", productlist);
		return mv;
	}

	@RequestMapping(value = { "/product/search" }, method = RequestMethod.GET)
	public ModelAndView searchProduct(@RequestParam("product_name") String pname, Model map, Principal principal) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname", user.getUfname());
		}
		ModelAndView mv = new ModelAndView("product1");
		List<Product> productList = productDao.getProductByProductName(pname);
		mv.addObject("prod_list", productList);
		return mv;
	}

	@RequestMapping("view/product")
	public ModelAndView viewProduct(Model map) {
		ModelAndView mv = new ModelAndView("product1");
		List<Product> listproduct = productDao.getActiveProducts();
		map.addAttribute("prod_list", listproduct);
		return mv;
	}

	@RequestMapping(value = { "/trending", "/product/display" })
	public ModelAndView prodisplay(@RequestParam("pid") Long pid, Model map, Principal principal) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname", user.getUfname());
		}
		ModelAndView mv = new ModelAndView("productdisplay");
		Product product = productDao.getProductByProductId(pid);
		List<Review> reviewlist = reviewDao.getAllReviewByProduct(product);
		map.addAttribute("product", product);
		map.addAttribute("review", reviewlist);
		return mv;
	}

	@RequestMapping("/user/usercart")
	public String viewCart(Principal principal, Model map) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			Cart cart = user.getCart();
			List<CartItem> cartlist = cartItemDao.cartItemGetByCart(cart);
			map.addAttribute("uname", user.getUfname());
			map.addAttribute("cartlist", cartlist);
			map.addAttribute("csize", cartlist.size());
			map.addAttribute("total", cart.getGrandTotal());
			return "user/usercart";
		}
		return "user/usercart";
	}

	@RequestMapping("/view/usercart")
	public String toViewCart(Model map, Principal principal) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname", user.getUfname());
		}
		return "user/usercart";
	}

	@RequestMapping("/user/product")
	public String addToCart(@RequestParam("pid") Long pid, Principal principal, Model map, HttpServletRequest request) {
		if (principal != null) {
			String referer = request.getHeader("Referer");
			System.out.println("referer" + referer);
			User user = userDao.getUserByUsername(principal.getName());
			Cart cart = user.getCart();
			Product product = productDao.getProductByProductId(pid);
			CartItem cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
			if (cartitem == null) {
				cartitem = new CartItem();
				cartitem.setCart(cart);
				cartitem.setProduct(product);
				cartitem.setSell_quantity(1);
				cartitem.setTotal_price(product.getPrice());
				Boolean b = cartItemDao.addCartItem(cartitem);
				if (b) {
					map.addAttribute("msg", "Product " + product.getProd_name() + " Added To Cart");
					cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
					cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
					cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
					cartDao.updateCart(cart);
					return "redirect:" + referer;
				} else {
					map.addAttribute("msg", "Something Went Wrong.....");
					return "redirect:" + referer;
				}
			} else {
				int newquant = cartitem.getSell_quantity() + 1;
				cartitem.setSell_quantity(newquant);
				cartitem.setTotal_price(product.getPrice() * newquant);
				Boolean b = cartItemDao.updateCartItem(cartitem);
				if (b) {
					map.addAttribute("msg", "One More Quantity Of " + product.getProd_name() + " Added To Cart");
					cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
					cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
					cartDao.updateCart(cart);
					return "redirect:" + referer;
				} else {
					map.addAttribute("msg", "Ohhh...Something Went Wrong...Try Adding From Cart");
					return "redirect:" + referer;
				}
			}
		}
		return "user/product";
	}

	@RequestMapping("/user/userproductdisplay")
	public String addToCartFromProductDisplayPage(@RequestParam("pid") Long pid,@RequestParam("quant") int quant, Principal principal, Model map,
			HttpServletRequest request) {
		if (principal != null) {
			String referer = request.getHeader("Referer");
			User user = userDao.getUserByUsername(principal.getName());
			Cart cart = user.getCart();
			Product product = productDao.getProductByProductId(pid);
			CartItem cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
			if (cartitem == null) {
				cartitem = new CartItem();
				cartitem.setCart(cart);
				cartitem.setProduct(product);
				cartitem.setSell_quantity(quant);
				cartitem.setTotal_price(product.getPrice());
				Boolean b = cartItemDao.addCartItem(cartitem);
				if (b) {
					map.addAttribute("msg", product.getProd_name() + " Added To Cart");
					cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
					cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
					cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
					cartDao.updateCart(cart);
					return "redirect:" + referer;
				} else {
					map.addAttribute("msg", "Something Went Wrong.....");
					return "redirect:" + referer;
				}
			} else {
				int newquant = quant;
				cartitem.setSell_quantity(newquant);
				cartitem.setTotal_price(product.getPrice() * newquant);
				Boolean b = cartItemDao.updateCartItem(cartitem);
				if (b) {
					map.addAttribute("msg", product.getProd_name() + " Added To Cart");
					cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
					cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
					cartDao.updateCart(cart);
					return "redirect:" + referer;
				} else {
					map.addAttribute("msg", "Ohhh...Something Went Wrong...Try Adding From Cart");
					return "redirect:" + referer;
				}
			}
		}
		return "user/userproductdisplay";
	}

	@RequestMapping(value = { "/refreshcart" }, method = RequestMethod.GET)
	public String refreshcart(@RequestParam("quantity") int quan, Model map, @RequestParam("pid") Long pid,
			Principal principal, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		User user = userDao.getUserByUsername(principal.getName());
		Cart cart = user.getCart();
		Product product = productDao.getProductByProductId(pid);
		CartItem cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
		cartitem.setSell_quantity(quan);
		cartitem.setTotal_price(product.getPrice() * quan);
		Boolean b = cartItemDao.updateCartItem(cartitem);
		if (b) {
			cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
			cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
			cartDao.updateCart(cart);
			return "redirect:" + referer;
		} else {;
			return "redirect:" + referer;
		}
	}

	@RequestMapping(value = { "/deletecartitem" })
	public String deleteSingleCartItem(@RequestParam("cartid") Long cid, Model map, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		CartItem cartitem = cartItemDao.getCartItemByCartItem_Id(cid);
		Cart cart = cartitem.getCart();
		Boolean b = cartItemDao.deleteCartItem(cid);
		if (b) {
			cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
			cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
			cartDao.updateCart(cart);
			return "redirect:" + referer;
		}
		return "redirect:" + referer;
	}

	@RequestMapping(value = { "/user/updateinfo" }, method = RequestMethod.GET)
	public String toupdatepage(Principal principal, Model map) {
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("user", user);
		map.addAttribute("uname", user.getUfname());
		return "user/updateinfo";
	}

	@RequestMapping(value = { "/updateuserinfo" }, method = RequestMethod.POST)
	public String toUpdateUser(@RequestParam("ufname") String ufname,@RequestParam("ulname") String ulname,@RequestParam("dob") String dob, @RequestParam("contact") String contact,
			@RequestParam("address") String address, @RequestParam("state") String state,
			@RequestParam("pincode") String pincode, Principal principal, Model map, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		User user = userDao.getUserByUsername(principal.getName());

		user.setUfname(ufname);
		user.setUlname(ulname);
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

	@RequestMapping(value = { "/user/updatepwd" })
	public String toupdatepwdpage(Principal principal, Model map) {
		User user = userDao.getUserByUsername(principal.getName());
		map.addAttribute("uname", user.getUfname());
		map.addAttribute("upwd", user.getPassword());
		return "user/updatepassword";
	}

	@RequestMapping(value = { "/updatepassword" }, method = RequestMethod.POST)
	public String toUpdateUser(@RequestParam("oldpwd") String oldpwd, @RequestParam("newpwd") String newpwd,
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
	
	@RequestMapping("/user/review")
	public String toReview( Principal principal, Model map, @RequestParam("pid") Long pid)
	{
		if(principal!=null)
		{
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname",user.getUfname());
			map.addAttribute("uid",user.getUser_id());
			Product p = productDao.getProductByProductId(pid);
			map.addAttribute("pname",p.getProd_name());
			map.addAttribute("pid",pid);
			return "user/review";
		}
		return "user/review";
	}
	
	@RequestMapping("/review")
	public String addReview( Principal principal, Model map, @RequestParam("pid") Long pid,
			@RequestParam("rating") int rating,@RequestParam("review") String ureview, HttpServletRequest req)
	{
		String referer = req.getHeader("Referer");
		User user =  userDao.getUserByUsername(principal.getName());
		Product product = productDao.getProductByProductId(pid);
		Review review = new Review();
		review.setProduct(product);
		review.setUser(user);
		review.setRating(rating);
		review.setReview(ureview);
		review.setName(user.getUfname()+" "+user.getUlname());
		Boolean b = reviewDao.addReview(review);
		if(b)
		{
			map.addAttribute("msg","Thanks For Your Review....");
			map.addAttribute("pid",pid);
			return "redirect:" + referer;
		}
		else
		{
			map.addAttribute("msg","Unable To Update Review.....Try Again Later...");
			map.addAttribute("pid",pid);
			return "redirect:" + referer;
		}
		
	}
	
	@RequestMapping("/checkoutData")
	public String getCheckout(Principal principal, Model map, HttpServletRequest req) {
		String ref = req.getHeader("Referer");
		User user = userDao.getUserByUsername(principal.getName());
		Cart cart = user.getCart();
		List<CartItem> cartitem = cartItemDao.cartItemGetByCart(cart);
		for(CartItem c : cartitem)
		{
			Product p = c.getProduct();
			if(p.getQuantity()<=0 )
			{
				map.addAttribute("oos",p.getProd_name()+ " Is Out Of Stock, Remove It From Cart To Continue...");
				return "redirect:" + ref;
			}
			else if(p.getQuantity()< c.getSell_quantity() )
			{
				map.addAttribute("oos",p.getProd_name()+ " Is Not Available In This Quantity, You can buy only " + p.getQuantity());
				return "redirect:" + ref;
			}
		}
		map.addAttribute("uname", user.getUfname());
		return "redirect:/checkout?user_id=" + user.getUser_id();
	}


	@RequestMapping("/aboutus")
	public String aboutus(Model map, Principal principal) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname", user.getUfname());
		}
		return "aboutus";
	}
	
	@RequestMapping("/print")
	public String printquant(@RequestParam("quant") String quant)
	{
		System.out.println("Quantity Is "+quant);
		return "";
	}
	
	@RequestMapping("/contactus")
	public String contactus(Model map, Principal principal) {
		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			map.addAttribute("uname", user.getUfname());
		}
		return "contactus";
	}
	
	@ModelAttribute("electronicsList")
	public List<Category> getElectronicList() {
		List<Category> electronicsList = categoryDao.getAllCategoryByCategoryName("Electronics");
		return electronicsList;
	}

	@ModelAttribute("appliancesList")
	public List<Category> getAppliancesList() {
		List<Category> appliancesList = categoryDao.getAllCategoryByCategoryName("Home Appliances");
		return appliancesList;
	}

	@ModelAttribute("fashionList")
	public List<Category> getFashionList() {
		List<Category> fashionList = categoryDao.getAllCategoryByCategoryName("Fashion");
		return fashionList;
	}

	@ModelAttribute("bookList")
	public List<Category> getBookList() {
		List<Category> bookList = categoryDao.getAllCategoryByCategoryName("Books");
		return bookList;
	}

	@ModelAttribute("proEightList")
	public List<Product> getproEightList() {
		List<Product> proEightList = productDao.select8Product();
		return proEightList;
	}

}
