/*
 * It is a java file that stores the user input in required field.
 */

package uidai;

public class UserInput {
	
	private String aadharNo;
	private String hNo;
	private String street;
	private String area;
	private String landmark;
	private String town;
	private String subDistrict;
	private String district;
	private String state;
	private String pin;
	
	public UserInput(String aadharNo, String hNo, String street, String area, String landmark, String town,
			String subDistrict, String district, String state, String pin) {
		
		this.aadharNo = aadharNo;
		this.hNo = hNo;
		this.street = street;
		this.area = area;
		this.landmark = landmark;
		this.town = town;
		this.subDistrict = subDistrict;
		this.district = district;
		this.state = state;
		this.pin = pin;
	}

	 
	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String gethNo() {
		return hNo;
	}

	public void sethNo(String hNo) {
		this.hNo = hNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}	
}