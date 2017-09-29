package niit.ecommerce.main.MainBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier implements Serializable {
	private final static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplier_id;

	private String sname;
	@Column(unique = true)
	private String semail;
	private String gender;
	@Column(unique = true)
	private String s_comp_name;
	private String password;
	private String address;
	private String pincode;
	private String dob;
	private String state;
	private String country;
	private String contact;
	private Boolean enable = true;
	private String role = "Supplier";

	public long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getS_comp_name() {
		return s_comp_name;
	}

	public void setS_comp_name(String s_comp_name) {
		this.s_comp_name = s_comp_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", sname=" + sname + ", semail=" + semail + ", s_comp_name="
				+ s_comp_name + ", password=" + password + ", address=" + address + ", contact=" + contact + ", enable="
				+ enable + "]";
	}

}
