package niit.ecommerce.main.MainBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.ecommerce.main.MainBackEnd.Dao.SupplierDao;
import niit.ecommerce.main.MainBackEnd.dto.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	@Override
	//Adding Supplier To Database
	public boolean addSupplier(Supplier supplier) {
		try{
		//Inserting Supplier Info Into Database
		sessionFactory.getCurrentSession().persist(supplier);
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
	//Updating Supplier Info
	public boolean updateSupplier(Supplier supplier) { 
		try{
			//Update Supplier Info
			sessionFactory.getCurrentSession().update(supplier);
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
	//Deleting Supplier By Setting Its Status As False
	public boolean deleteSupplier(String email) {
		//Get Supplier By Email
		Supplier Supplier = getSupplierBySuppliername(email);
		//Setting Supplier Status To False 
		Supplier.setEnable(false);
		try{
			//Committing The Changes
			sessionFactory.getCurrentSession().update(Supplier);
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
	//Get Supplier By EmailId Used To Login
	public Supplier getSupplierBySuppliername(String email) {
		//Select Supplier Using Supplier Email Id
		String selectSupplierId = "From Supplier where semail=:parameter";
		//Creating Query
		Query<Supplier> query = sessionFactory.getCurrentSession().createQuery(selectSupplierId, Supplier.class);
		//Setting Parameter For semail
		query.setParameter("parameter",email);
		try{
			//Return Single Result	
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	//Get Supplier By Supplier Id
	public Supplier getSupplierById(Long supplier_id) {
		//Select Supplier By Supplier Id
		String selectSupplierId = "From Supplier where supplier_id=:parameter";
		//Creating Query
		Query<Supplier> query = sessionFactory.getCurrentSession().createQuery(selectSupplierId, Supplier.class);
		//Setting Parameter For Supplier_id
		query.setParameter("parameter", supplier_id);
		try{
			//Return Single Result
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@Override
	public Supplier checkSupplierLogin(String s_email,Long s_id)
	{
		//Select Supplier By Supplier Id
		String selectSupplier = "From Supplier where supplier_id=:parameter1 and semail=:parameter2";
		//Creating Query
		Query<Supplier> query = sessionFactory.getCurrentSession().createQuery(selectSupplier, Supplier.class);
		//Setting Parameter For Supplier_id and email
		query.setParameter("parameter1", s_id);
		query.setParameter("parameter2", s_email);
		try{
			//Return Single Result
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	//Return List Of Supplier That Are Active(Status = true) 
	public List<Supplier> getActiveSupplier() {
		//Select All Active Supplier 
		String selectActiveSupplier = "From Supplier where enable = 'TRUE'";
		//Creating Query
		Query<Supplier> query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier, Supplier.class);
		try{
			//Return Single Result
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	//Get All Supplier
	public List<Supplier> getAllSupplier() {
		//Select All Supplier
		String selectActiveSupplier = "From Supplier";
		//Creating Query
		Query<Supplier> query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier, Supplier.class);
		try{
			//Return Single Result
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
	
}
