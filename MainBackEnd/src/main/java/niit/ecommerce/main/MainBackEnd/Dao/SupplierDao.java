package niit.ecommerce.main.MainBackEnd.Dao;

import java.util.List;

import niit.ecommerce.main.MainBackEnd.dto.Supplier;

public interface SupplierDao {
	public Supplier getSupplierBySuppliername(String email);

	boolean addSupplier(Supplier supplier);

	boolean updateSupplier(Supplier supplier);

	boolean deleteSupplier(String email);

	public Supplier getSupplierById(Long supplier_id);
	
	public Supplier checkSupplierLogin(String s_email,Long s_id);
	
	public List<Supplier> getAllSupplier();
	
	public List<Supplier> getActiveSupplier();

}
