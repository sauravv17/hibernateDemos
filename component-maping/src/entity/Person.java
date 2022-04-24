package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	private static final boolean False = false;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID;
	
	@Column(nullable=False)
	String name;
	
	@Embedded
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides( {
		@AttributeOverride(name="street",column=@Column(name="billing_street")),
		@AttributeOverride(name="city",column=@Column(name="billing_city")),
		@AttributeOverride(name="zipcode",column=@Column(name="billing_zipcode")),
	})
	private Address billingAddress;

	public Person(String name, Address homeAddress, Address billingAddress) {
		this.name = name;
		this.homeAddress = homeAddress;
		this.billingAddress = billingAddress;
	}
}
