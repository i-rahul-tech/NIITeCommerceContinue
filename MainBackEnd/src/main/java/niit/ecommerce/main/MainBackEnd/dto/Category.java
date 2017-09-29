package niit.ecommerce.main.MainBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable{
		private final static long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long category_id;
		
		private String category_name;
		
		@Column(unique = true)
		private String subcategory_name;

		public Long getCategory_id() {
			return category_id;
		}

		public void setCategory_id(Long category_id) {
			this.category_id = category_id;
		}

		public String getCategory_name() {
			return category_name;
		}

		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}

		public String getSubcategory_name() {
			return subcategory_name;
		}

		public void setSubcategory_name(String subcategory_name) {
			this.subcategory_name = subcategory_name;
		}
		
		

}
