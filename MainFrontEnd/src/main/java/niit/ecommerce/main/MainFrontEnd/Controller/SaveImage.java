package niit.ecommerce.main.MainFrontEnd.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import niit.ecommerce.main.MainBackEnd.Dao.CartDao;
import niit.ecommerce.main.MainBackEnd.Dao.CartItemDao;
import niit.ecommerce.main.MainBackEnd.Dao.CategoryDao;
import niit.ecommerce.main.MainBackEnd.Dao.ProductDao;
import niit.ecommerce.main.MainBackEnd.Dao.ReviewDao;
import niit.ecommerce.main.MainBackEnd.Dao.SupplierDao;
import niit.ecommerce.main.MainBackEnd.Dao.UserDao;
import niit.ecommerce.main.MainBackEnd.dto.Product;
import niit.ecommerce.main.MainBackEnd.dto.Supplier;

@Controller
public class SaveImage {

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
	SupplierDao supplierDao;

	@Autowired
	ReviewDao reviewDao;

	private static final String UPLOAD_DIRECTORY = "resources/images";

	@RequestMapping("/uploadimage")
	public String upload() {
		return "uploadimage";
	}

	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public String saveimage(Model map,@RequestParam CommonsMultipartFile file,@RequestParam("pid") Long pid, HttpSession session, Principal p, HttpServletRequest req) throws Exception {
		String refer = req.getHeader("Referer");
		Supplier s = supplierDao.getSupplierBySuppliername(p.getName());
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY)+"\\"+s.getS_comp_name()+"_"+s.getSupplier_id();
		File dir = new File(path);
		if(dir.exists())
		{
			String filename = file.getOriginalFilename();
			String imgpath = "/resources/images/"+s.getS_comp_name()+"_"+s.getSupplier_id()+"/"+filename;
			//TO SAVE IMAGE TO LOCATION
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			Product pro = productDao.getProductByProductId(pid);
			pro.setProdImg_url(imgpath);
			productDao.updateProduct(pro);
			map.addAttribute("err","Product Successfully Added....");
			return "admin/productadded";
		}
		else
		{
		dir.mkdir();
		String filename = file.getOriginalFilename();
		filename = filename;
		String imgpath = "/resources/images/"+s.getS_comp_name()+"_"+s.getSupplier_id()+"/"+filename;
		System.out.println(imgpath);
        
		//TO SAVE IMAGE TO LOCATION
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		Product pro = productDao.getProductByProductId(pid);
		pro.setProdImg_url(imgpath);
		productDao.updateProduct(pro);
		map.addAttribute("err","Product Successfully Added....");
		return "admin/productadded";
		}
	}
}
