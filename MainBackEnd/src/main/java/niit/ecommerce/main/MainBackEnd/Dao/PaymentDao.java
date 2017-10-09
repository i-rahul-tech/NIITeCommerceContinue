package niit.ecommerce.main.MainBackEnd.Dao;

import niit.ecommerce.main.MainBackEnd.dto.Payment;
import niit.ecommerce.main.MainBackEnd.dto.User;

public interface PaymentDao {
	public Payment getPaymentDetails(User user);
	public boolean add(Payment payment);
}
