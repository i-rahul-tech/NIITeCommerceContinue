package niit.ecommerce.main.MainBackEnd.Dao;

import java.util.List;

import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.Review;

public interface ReviewDao {

	public List<Review> getAllReviewByProduct(Product product);
	
	public boolean addReview(Review review);
	
	public boolean deleteReview(Long review_id);
}
