package niit.ecommerce.main.MainBackEnd.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Payment implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int payment_id;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	@CreditCardNumber
	private String cardno;
	@NotEmpty
	private String cardName;
	@NotEmpty
	@Min(value = 01)
	@Max(value = 12)
	private int mm;
	@NotEmpty
	@Min(value = 18)
	@Max(value = 32)
	private int yy;
	@Transient
	@NotEmpty
	@Size(min = 3, max = 3)
	private Integer cvv;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getYy() {
		return yy;
	}

	public void setYy(int yy) {
		this.yy = yy;
	}



	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", user=" + user + ", cardno=" + cardno + ", cardName=" + cardName
				+ ", mm=" + mm + ", yy=" + yy + "]";
	}
}