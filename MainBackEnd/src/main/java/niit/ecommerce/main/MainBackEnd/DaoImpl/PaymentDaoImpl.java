package niit.ecommerce.main.MainBackEnd.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.PaymentDao;
import niit.ecommerce.main.MainBackEnd.dto.Payment;
import niit.ecommerce.main.MainBackEnd.dto.User;



@Repository("paymentDao")
@Transactional
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Payment getPaymentDetails(User user) {
		return (Payment) sessionFactory.getCurrentSession().createQuery("from Payment where user=:user")
				.setParameter("user", user).getSingleResult();

	}

	@Override
	public boolean add(Payment payment) {
		try {
			sessionFactory.getCurrentSession().save(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}