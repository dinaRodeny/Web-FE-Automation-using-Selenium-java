package models;

import com.github.javafaker.Faker;

public class FakerDataUser {
	public String malefemale_status;
	public String firstname;
	public String lastname;
	public String day;
	public String month;
	public String year;
	public String email;
	public String companyname;
	public String password;
	public String address1;
	public String address2;
	public String country;
	public String state;
	public String city;
	public String zipcode;
	public String mobile;
	public String creditcardnumber;
	public boolean newsletter_status;
	public boolean specialoffers_status;
	public Faker faker;
	
	public FakerDataUser()
	{
		faker = new Faker();
		malefemale_status = faker.random().nextBoolean()?"m":"F";
		firstname = faker.name().firstName();
		lastname = faker.name().lastName();
		day = faker.random().nextInt(1, 30).toString();
		month = faker.random().nextInt(1, 12).toString();
		year = faker.random().nextInt(1912, 2022).toString();
		email = faker.internet().emailAddress();
		companyname = faker.company().name();
		newsletter_status = faker.random().nextBoolean();
		specialoffers_status = faker.random().nextBoolean();
		password = faker.internet().password();
		address1 = faker.address().streetAddress();
		address2 = faker.address().streetAddress();
		state = faker.address().state();
		zipcode = faker.address().zipCode();
		country = "Canada";
		city = faker.address().city();
		mobile = faker.phoneNumber().cellPhone();
		creditcardnumber = faker.finance().creditCard();
	}
	public void setMalefemale_status(String malefemale_status) {
		this.malefemale_status = malefemale_status;
	}
	public String getMalefemale_status() {
		return malefemale_status;
	}	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isNewsletter_status() {
		return newsletter_status;
	}
	public void setNewsletter_status(boolean newsletter_status) {
		this.newsletter_status = newsletter_status;
	}
	public boolean getNewsletter_status() {
		return newsletter_status;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isSpecialoffers_status() {
		return specialoffers_status;
	}
	public void setSpecialoffers_status(boolean specialoffers_status) {
		this.specialoffers_status = specialoffers_status;
	}
	public String getCreditcardnumber() {
		return creditcardnumber;
	}
	public void setCreditcardnumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}
	
}
