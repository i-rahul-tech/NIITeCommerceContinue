package niit.ecommerce.main.MainFrontEnd.Handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import niit.ecommerce.main.MainBackEnd.Dao.CartDao;
import niit.ecommerce.main.MainBackEnd.Dao.CartItemDao;
import niit.ecommerce.main.MainBackEnd.Dao.ProductDao;
import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.CartItem;
import niit.ecommerce.main.MainBackEnd.dto.Payment;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Component
public class CheckoutHandler {
	@Autowired
	UserDao userDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	ProductDao productDao;

	public User initCart(Long user_id) {
		/*
		 * cart = user.getCart(); System.out.println("Cart grand total : " +
		 * cart.getGrandTotal());
		 */
		return userDao.getUserById(user_id);
	}

	public Cart initCartByUser(Long user_id) {
		User user = userDao.getUserById(user_id);
		return user.getCart();
	}

	public Payment initPaymentByUserid(Long user_id) {
		User user = userDao.getUserById(user_id);
		Payment payment = new Payment();
		payment.setUser(user);
		return payment;
	}

	public boolean emptyCart(Cart cart) {
		cart.setGrandTotal(0);
		cart.setCartItemCount(0);
		try {
			cartDao.updateCart(cart);
			cartDao.deleteAllCartItems(cart);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public String saveDetails(User user) {
		Cart cart = user.getCart();
		List<CartItem> listc = cartItemDao.cartItemGetByCart(cart);
		for (CartItem ci : listc) {
			Product p = ci.getProduct();
			p.setQuantity(p.getQuantity() - ci.getSell_quantity());
			productDao.updateProduct(p);
		}
		boolean status2 = emptyCart(user.getCart());
		// boolean status1 = userDao.update(user);

		if (status2) {
			return "success";
		} else {
			return "failure";
		}
	}

	// only for address
	public String addressValidateDetails(User user, MessageContext messageContext) {
		String status = "success";

		if (user.getAddress().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("address").defaultText("address cannot be Empty").build());
			status = "failure";
		}

		if (user.getUfname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("ufname").defaultText("name cannot be Empty").build());
			status = "failure";
		}
		if (user.getUemail().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("uemail").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if (user.getPassword() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}

		if (user.getContact().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("contact").defaultText("Contact cannot be Empty").build());
			status = "failure";
		}

		if (user.getPincode().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("pincode").defaultText("Pincode cannot be Empty").build());
			status = "failure";
		}

		if (user.getState().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("state").defaultText("State cannot be Empty").build());
			status = "failure";
		}

		if (user.getCountry().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("country").defaultText("Country cannot be Empty").build());
			status = "failure";
		}
		if (user.getRole() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("role").defaultText("Role cannot be Empty").build());
			status = "failure";
		}
		if (user.getEnable() == false) {
			messageContext.addMessage(
					new MessageBuilder().error().source("enabled").defaultText("Enabled cannot be Empty").build());
			status = "failure";
		}
		return status;
	}

	public String paymentValidateDetails(Payment payment, MessageContext messageContext) {
		System.out.println(
				"Hello from paymentValidateDetails" + "Card No= " + payment.getCardno() + "CVV= " + payment.getCvv());
		String status = "success";
		if (payment.getCardno().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("cardno").defaultText("Card no cannot be Empty").build());
			status = "failure";
		}
		else if(!payment.getCardno().isEmpty())
		{
			String card = payment.getCardno();
			char c[] = card.toCharArray();
			if(c.length<16)
			{
				messageContext.addMessage(
						new MessageBuilder().error().source("cardno").defaultText("Not A Valid Card No.").build());
				status = "failure";
			}
		}
		if (payment.getCardName().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("cardName").defaultText("Name cannot be Empty").build());
			status = "failure";
		}
		if (payment.getMm() == 0) {
			messageContext.addMessage(
					new MessageBuilder().error().source("mm").defaultText("Expire month cannot be Empty").build());
			status = "failure";
		}
		else if(payment.getMm() != 0)
		{
			int mm = payment.getMm();
			if(mm<0 || mm>12)
			{
				messageContext.addMessage(
						new MessageBuilder().error().source("mm").defaultText("Not A Valid Month").build());
				status = "failure";
			}
		}
		if (payment.getYy() == 0) {
			messageContext.addMessage(
					new MessageBuilder().error().source("yy").defaultText("Expire year cannot be Empty").build());
			status = "failure";
		}
		else if(payment.getYy() != 0)
		{
			int yy = payment.getYy();
			if(yy<2017)
			{
				messageContext.addMessage(
						new MessageBuilder().error().source("yy").defaultText("Not A Valid Year").build());
				status = "failure";
			}
		}
		if (payment.getCvv() == null) {
			messageContext
					.addMessage(new MessageBuilder().error().source("cvv").defaultText("Please Enter CVV No").build());
			status = "failure";
		}
		else if(payment.getCvv() != null)
		{
			int cvv = payment.getCvv();
			int b=Integer.toString(cvv).length();
			if(b != 3)
			{
				messageContext.addMessage(
						new MessageBuilder().error().source("cvv").defaultText("CVV Should Be Of 3 Digit").build());
				status = "failure";
			}
		}
		return status;
	}
	
}
