package com.work.model.dto;

public class Center {

	private String centerName;
	
	private String facilityName;
	
	private String postcode;
	
	private String address;

	private String addressDetail;
	
	private String phoneNumber;
	
	private int firstVaccNum;
	
	private int secondVacNum;
	
	private int totalFirstVacc;
	
	private int totalSecondVacc;

	/**
	 * 
	 */
	public Center() {
	}

	
	/**
	 * @param centerName
	 * @param facilityName
	 * @param postcode
	 * @param address
	 * @param addressDetail
	 * @param phoneNumber
	 * @param firstVaccNum
	 * @param secondVacNum
	 * @param totalFirstVacc
	 * @param totalSecondVacc
	 */
	public Center(String centerName, String facilityName, String postcode, String address, String addressDetail,
			String phoneNumber, int firstVaccNum, int secondVacNum, int totalFirstVacc, int totalSecondVacc) {
		this.centerName = centerName;
		this.facilityName = facilityName;
		this.postcode = postcode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.phoneNumber = phoneNumber;
		this.firstVaccNum = firstVaccNum;
		this.secondVacNum = secondVacNum;
		this.totalFirstVacc = totalFirstVacc;
		this.totalSecondVacc = totalSecondVacc;
	}

	/**
	 * @return the centerName
	 */
	public String getCenterName() {
		return centerName;
	}

	/**
	 * @param centerName the centerName to set
	 */
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}

	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addressDetail
	 */
	public String getAddressDetail() {
		return addressDetail;
	}

	/**
	 * @param addressDetail the addressDetail to set
	 */
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	/**
	 * @return the firstVaccNum
	 */
	public int getFirstVaccNum() {
		return firstVaccNum;
	}


	/**
	 * @param firstVaccNum the firstVaccNum to set
	 */
	public void setFirstVaccNum(int firstVaccNum) {
		this.firstVaccNum = firstVaccNum;
	}


	/**
	 * @return the secondVacNum
	 */
	public int getSecondVacNum() {
		return secondVacNum;
	}


	/**
	 * @param secondVacNum the secondVacNum to set
	 */
	public void setSecondVacNum(int secondVacNum) {
		this.secondVacNum = secondVacNum;
	}


	/**
	 * @return the totalFirstVacc
	 */
	public int getTotalFirstVacc() {
		return totalFirstVacc;
	}


	/**
	 * @param totalFirstVacc the totalFirstVacc to set
	 */
	public void setTotalFirstVacc(int totalFirstVacc) {
		this.totalFirstVacc = totalFirstVacc;
	}


	/**
	 * @return the totalSecondVacc
	 */
	public int getTotalSecondVacc() {
		return totalSecondVacc;
	}


	/**
	 * @param totalSecondVacc the totalSecondVacc to set
	 */
	public void setTotalSecondVacc(int totalSecondVacc) {
		this.totalSecondVacc = totalSecondVacc;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((addressDetail == null) ? 0 : addressDetail.hashCode());
		result = prime * result + ((centerName == null) ? 0 : centerName.hashCode());
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + firstVaccNum;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + secondVacNum;
		result = prime * result + totalFirstVacc;
		result = prime * result + totalSecondVacc;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Center other = (Center) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressDetail == null) {
			if (other.addressDetail != null)
				return false;
		} else if (!addressDetail.equals(other.addressDetail))
			return false;
		if (centerName == null) {
			if (other.centerName != null)
				return false;
		} else if (!centerName.equals(other.centerName))
			return false;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (firstVaccNum != other.firstVaccNum)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (secondVacNum != other.secondVacNum)
			return false;
		if (totalFirstVacc != other.totalFirstVacc)
			return false;
		if (totalSecondVacc != other.totalSecondVacc)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(centerName);
		builder.append(", ");
		builder.append(facilityName);
		builder.append(", ");
		builder.append(postcode);
		builder.append(", ");
		builder.append(address);
		builder.append(", ");
		builder.append(addressDetail);
		builder.append(", ");
		builder.append(phoneNumber);
		builder.append(", ");
		builder.append(firstVaccNum);
		builder.append(", ");
		builder.append(secondVacNum);
		builder.append(", ");
		builder.append(totalFirstVacc);
		builder.append(", ");
		builder.append(totalSecondVacc);
		return builder.toString();
	}
	
	
	

}
