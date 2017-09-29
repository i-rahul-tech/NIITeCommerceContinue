package niit.ecommerce.main.MainBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.ReviewDao;
import niit.ecommerce.main.MainBackEnd.dto.Cart;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.Review;
import niit.ecommerce.main.MainBackEnd.dto.User;

@Repository("reviewDao")
@Transactional
public class ReviewDaoImpl implements ReviewDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Review> getAllReviewByProduct(Product product) {
		//Select Review By Product Id
		String selectAllReview = "From Review where product_id =:parameter";
		//Creating Query
		Query<Review> query = sessionFactory.getCurrentSession().createQuery(selectAllReview, Review.class);
		query.setParameter("parameter", product);
		try{
			//Return Result List
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean addReview(Review review) {
		try{
			//Inserting User Info Into Database
			sessionFactory.getCurrentSession().save(review);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex);
				return false;
			}
	}

	@Override
	public boolean deleteReview(Long review_id) {
		//Creating Query
				String deleteCartItem = "Delete from review where review_id=:parameter";
				Query<?> query = sessionFactory.getCurrentSession().createQuery(deleteCartItem);
				query.setParameter("parameter", review_id);
				try {
					// Delete the cartItem to the database
					query.executeUpdate();
					return true;
				} catch (Exception ex) {
					ex.printStackTrace();
					return false;
				}
	}
}
