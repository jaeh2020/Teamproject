package amdn.anywhere.domain;

public class Store {
	private String storeCode;
	private String storeName;
	private String bizCode;
	private String bizId;
	private String storeLocation;
	private String storeTime;
	private String storePhone;
	private String mainCateCode;
	private String mainCateCode2;
	private String storeHoliday;
	private String storeTasteAgree;
	private String storeExposAgree;
	private String storePhoto;
	private String storeTableNum;
	private String storeOccupancy;
	private Waiting waiting;
	private FoodMainCate foodMainCate;
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public String getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getMainCateCode() {
		return mainCateCode;
	}
	public void setMainCateCode(String mainCateCode) {
		this.mainCateCode = mainCateCode;
	}
	public String getMainCateCode2() {
		return mainCateCode2;
	}
	public void setMainCateCode2(String mainCateCode2) {
		this.mainCateCode2 = mainCateCode2;
	}
	public String getStoreHoliday() {
		return storeHoliday;
	}
	public void setStoreHoliday(String storeHoliday) {
		this.storeHoliday = storeHoliday;
	}
	public String getStoreTasteAgree() {
		return storeTasteAgree;
	}
	public void setStoreTasteAgree(String storeTasteAgree) {
		this.storeTasteAgree = storeTasteAgree;
	}
	public String getStoreExposAgree() {
		return storeExposAgree;
	}
	public void setStoreExposAgree(String storeExposAgree) {
		this.storeExposAgree = storeExposAgree;
	}
	public String getStorePhoto() {
		return storePhoto;
	}
	public void setStorePhoto(String storePhoto) {
		this.storePhoto = storePhoto;
	}
	public String getStoreTableNum() {
		return storeTableNum;
	}
	public void setStoreTableNum(String storeTableNum) {
		this.storeTableNum = storeTableNum;
	}
	public String getStoreOccupancy() {
		return storeOccupancy;
	}
	public void setStoreOccupancy(String storeOccupancy) {
		this.storeOccupancy = storeOccupancy;
	}
	public Waiting getWaiting() {
		return waiting;
	}
	public void setWaiting(Waiting waiting) {
		this.waiting = waiting;
	}
	public FoodMainCate getFoodMainCate() {
		return foodMainCate;
	}
	public void setFoodMainCate(FoodMainCate foodMainCate) {
		this.foodMainCate = foodMainCate;
	}
	@Override
	public String toString() {
		return "Store [storeCode=" + storeCode + ", storeName=" + storeName + ", bizCode=" + bizCode + ", bizId="
				+ bizId + ", storeLocation=" + storeLocation + ", storeTime=" + storeTime + ", storePhone=" + storePhone
				+ ", mainCateCode=" + mainCateCode + ", mainCateCode2=" + mainCateCode2 + ", storeHoliday="
				+ storeHoliday + ", storeTasteAgree=" + storeTasteAgree + ", storeExposAgree=" + storeExposAgree
				+ ", storePhoto=" + storePhoto + ", storeTableNum=" + storeTableNum + ", storeOccupancy="
				+ storeOccupancy + ", waiting=" + waiting + ", foodMainCate=" + foodMainCate + "]";
	}
	
	
	
}
