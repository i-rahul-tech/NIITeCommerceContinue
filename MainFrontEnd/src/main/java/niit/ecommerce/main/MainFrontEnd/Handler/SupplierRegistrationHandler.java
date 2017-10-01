package niit.ecommerce.main.MainFrontEnd.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Component
public class SupplierRegistrationHandler {

	@Autowired
	UserDao userDao;

	public User initFlow() {
		return new User();
	}

	public String saveUser(User user) {
		try{
			user.setRole("Supplier");
			user.setEnable(true);
			Boolean b = userDao.addUser(user);
			if(b)
			{
			return "success";
			}
			else{
			return "failure";
		}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return "failure";
		}
	}

	public String validateDetails(User user, MessageContext messageContext) {
		String status = "success";
		if (user.getUfname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("ufname").defaultText("First Name cannot be Empty").build());
			status = "failure";
		}
		if (user.getS_comp_name().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("s_comp_name").defaultText("Company Name cannot be Empty").build());
			status = "failure";
		}
		if (user.getGender().equals("null")) {
			messageContext.addMessage(
					new MessageBuilder().error().source("gender").defaultText("Please Select Gender").build());
			status = "failure";
		}
		if (user.getUemail().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("uemail").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if (user.getPassword().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		if (user.getDob().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("dob").defaultText("Date Of Birth cannot be Empty").build());
			status = "failure";
		}
		if (user.getContact().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("contact").defaultText("Contact cannot be Empty").build());
			status = "failure";
		}
		if (user.getAddress().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("address").defaultText("Address cannot be Empty").build());
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
		return status;
	}
}
