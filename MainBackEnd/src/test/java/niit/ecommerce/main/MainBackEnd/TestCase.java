package niit.ecommerce.main.MainBackEnd;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.ecommerce.main.MainBackEnd.Dao.CartDao;
import niit.ecommerce.main.MainBackEnd.Dao.CartItemDao;
import niit.ecommerce.main.MainBackEnd.Dao.CategoryDao;
import niit.ecommerce.main.MainBackEnd.Dao.PaymentDao;
import niit.ecommerce.main.MainBackEnd.Dao.ProductDao;
import niit.ecommerce.main.MainBackEnd.Dao.ReviewDao;
import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.CartItem;
import niit.ecommerce.main.MainBackEnd.dto.Category;
import niit.ecommerce.main.MainBackEnd.dto.Payment;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.Review;
import niit.ecommerce.main.MainBackEnd.dto.User;

public class TestCase {

	Scanner sc = new Scanner(System.in);

	private static AnnotationConfigApplicationContext context;

	static UserDao userDao;
	static ProductDao productDao;
	static CartDao cartDao;
	static CartItemDao cartItemDao;
	static CategoryDao categoryDao;
	static PaymentDao paymentDao;
	
	static ReviewDao reviewDao;
	User user;
	Product product;
	Cart cart;
	CartItem cartitem;
	Category category;
	Payment payment;
	Review review;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("niit.ecommerce.main.MainBackEnd");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");
		productDao = (ProductDao) context.getBean("productDao");
		cartItemDao = (CartItemDao) context.getBean("cartItemDao");
		cartDao = (CartDao) context.getBean("cartDao");
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		reviewDao = (ReviewDao) context.getBean("reviewDao");
		paymentDao = (PaymentDao) context.getBean("paymentDao");
	}

	//@Test
	public void test1() {
		// Test For Adding New User
		user = new User();

		user.setUfname("rahul");
		user.setUlname("kaushik");
		user.setGender("Male");
		user.setContact("9500000020");
		user.setUemail("rahul113@gmail.com");
		user.setEnable(true);
		user.setPassword("rahul");
		user.setRole("Customer");
		user.setAddress("New Delhi");
		user.setDob("12/05/1995");
		user.setState("New Delhi");
		user.setCountry("India");
		user.setStatus("1");
		assertEquals(true, userDao.addUser(user));
	}

	//@Test
	public void test2() {
		// Test For Adding Category
		category = new Category();

		String subcategory_name;
		System.out.println("Enter Sub Category");
		subcategory_name = sc.nextLine();

		category.setCategory_name("Books");
		category.setSubcategory_name(subcategory_name);
		assertEquals(true, categoryDao.addCategory(category));
	}

	//@Test
	public void test4() {
		// Test For Adding Product
		user = userDao.getUserById(new Long(13));
		category = categoryDao.getCategoryBySubCategoryName("Mobile");
		product = new Product();
		product.setUser(user);
		product.setCategory(category);
		product.setProd_brand("Samsung");
		product.setProd_name("samsung sq756");
		product.setProd_description("Black Color, 42'' Full HD Display Smart Tv");
		product.setProdImg_url("/resources/images/Items/Samsung_LED_1.jpg");
		product.setQuantity(30);
		product.setPrice(49999);
		assertEquals(true, productDao.addProduct(product));
	}

	// @Test
	public void test5() {
		// Test for searching a product
		user = userDao.getUserById(new Long(1));
		List<Product> listp1 = productDao.getProductByProductName("LE");

		for (Product p : listp1) {
			System.out.println(p.toString());
		}
	}

	// @Test
	public void test6() {
		// Test For Checking Useful Login
		String uemail, upwd;
		System.out.println("Enter Your Email Id");
		uemail = sc.nextLine();
		System.out.println("Enter Your Password");
		upwd = sc.nextLine();
		uemail = uemail.toLowerCase();
		uemail = uemail.trim();
		user = userDao.checkUserlogin(upwd, uemail);
		if (user != null) {
			if (user.getEnable() == true && user.getRole().equalsIgnoreCase("Admin")) {
				System.out.println("Welcome Admin------>" + user.getUfname());
			} else if (user.getEnable() == true && user.getRole().equalsIgnoreCase("Customer")) {
				System.out.println("Welcome Customer------>" + user.getUfname());
			} else {
				System.out.println("Your Account Have Been Deactivated Due To Inactivity Please Activate It...");
			}
		} else {
			System.out.println("Username Or Password Incorrect");
		}
	}

	// @Test
	public void test7() {
		// Test for adding product to CartItem
		user = userDao.getUserById(new Long(1));
		cart = user.getCart();
		product = productDao.getProductByProductId(new Long(1));
		cartitem = new CartItem();
		cartitem.setCart(cart);
		cartitem.setProduct(product);
		cartitem.setSell_quantity(2);
		cartitem.setTotal_price(product.getPrice() * cartitem.getSell_quantity());
		assertEquals(true, cartItemDao.addCartItem(cartitem));
		test9();
	}

	//@Test
	public void test8() {
		// Test for updating product to CartItem and updating cart
		user = userDao.getUserById(new Long(4));
		cart = user.getCart();
		product = productDao.getProductByProductId(new Long(6));
		cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
		long price = product.getPrice();
		cartitem.setSell_quantity(2);
		cartitem.setTotal_price(price * cartitem.getSell_quantity());
		System.out.println(cartitem.toString());
		assertEquals(true, cartItemDao.updateCartItem(cartitem));
		test9();
	}

	// @Test
	public void test9() {
		// Test for updating Cart
		user = userDao.getUserById(new Long(1));
		cart = user.getCart();
		cart.setCartItemCount(cartItemDao.getTotalQuantity(cart));
		cart.setGrandTotal(cartItemDao.getGrandTotal(cart));
		assertEquals(true, cartDao.updateCart(cart));
	}

	// @Test
	public void test10() {
		// Test for updating User
		user = userDao.getUserById(new Long(1));
		user.setContact("9582887679");
		assertEquals(true, userDao.updateUser(user));
	}

	

	// @Test
	public void test12() {
		// Test for updating Product Info
		product = productDao.getProductByProductId(new Long(2));
		product.setQuantity(90);
		assertEquals(true, productDao.updateProduct(product));
	}

	// @Test
	public void test13() {
		// Test To Delete User
		assertEquals(true, userDao.deleteUser("amit@gmail.com"));
	}

	// @Test
	public void test14() {
		// Test For Deleting Product
		assertEquals(true, productDao.deleteProduct(new Long(5)));
	}

	

	// @Test
	public void test16() {
		// Test For Deleting Single CartItem
		user = userDao.getUserById(new Long(1));
		cart = user.getCart();
		product = productDao.getProductByProductId(new Long(3));
		cartitem = cartItemDao.getCartItemByCartIdAndProductId(cart, product);
		assertEquals(true, cartItemDao.deleteCartItem(cartitem.getCartItem_Id()));
		test9();
	}

	// @Test
	public void test17() {
		// Test for Checkout
		user = userDao.getUserById(new Long(1));
		cart = user.getCart();
		List<CartItem> listc = cartItemDao.cartItemGetByCart(cart);
		for (CartItem ci : listc) {
			Product p = ci.getProduct();
			p.setQuantity(p.getQuantity() - ci.getSell_quantity());
			assertEquals(true, productDao.updateProduct(p));
		}
		cart.setCartItemCount(0);
		cart.setGrandTotal(0);
		assertEquals(true, cartDao.updateCart(cart));
		assertEquals(true, cartDao.deleteAllCartItems(cart));
	}

	// @Test
	public void test18() {
		// Test For Diplaying All Product
		List<Product> listp = productDao.getAllProduct();
		System.out.println("---------All Products----------");
		for (Product p : listp) {
			System.out.println(p.toString());
		}

		System.out.println("----------All Active Products----------");
		List<Product> listp1 = productDao.getActiveProducts();
		for (Product p : listp1) {
			System.out.println(p.toString());
		}
		category = categoryDao.getCategoryBySubCategoryName("Mobile");
		System.out.println("----------All Active Products By Category----------");
		List<Product> listp2 = productDao.getActiveProductByCategory(category);
		for (Product p : listp2) {
			System.out.println(p.toString());
		}
	}

	// @Test
	public void test19() {
		// Test For Displaying All CartItem For A User
		user = userDao.getUserById(new Long(1));
		cart = user.getCart();
		List<CartItem> listc = cartItemDao.cartItemGetByCart(cart);
		System.out.println("------List Of CartItem For " + user.getUfname() + "--------------");
		for (CartItem c : listc) {
			System.out.println(c.toString());
		}
	}

	// @Test
	public void test20() {
		// Test For Displaying All Users
		System.out.println("---------All Users------------");
		List<User> listu = userDao.getAllUser();
		for (User u : listu) {
			System.out.println(u.toString());
		}

		System.out.println("---------All Active Users------------");
		List<User> listu1 = userDao.getActiveUser();
		for (User u : listu1) {
			System.out.println(u.toString());
		}

		System.out.println("---------All Inactive Users------------");
		for (User u : listu) {
			if (u.getEnable().equals(false)) {
				System.out.println(u.toString());
			}
		}
	}

	
	//@Test
	public void test22() {
		Product product = productDao.getProductByProductId(new Long(1));
		review = new Review();
		review.setProduct(product);
		review.setRating(3);
		review.setReview("Very Expensive");
		assertEquals(true, reviewDao.addReview(review));
	}
}
