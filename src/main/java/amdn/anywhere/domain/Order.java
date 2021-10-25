package amdn.anywhere.domain;


public class Order {
	private String oCode;
	private String bookCode;
	private String userId;
	private String storeCode;
	private String menuCode;
	private int oCount;
	private int menuTotalPrice;
	private String oRequest;
	private String payGroCode;
	private int oTotalPrice;
	private String orderSignTime;
	private String orderCompTime;
	private String orderStateCode;
	private String storeTableCode;
	private String tabelStateCode;
	private Menu menu;
	private Store store;
	private Book book;
	private Payment payment;
	private Storesearch storeSearch;
	private Statement statement;
	public String getoCode() {
		return oCode;
	}
	public void setoCode(String oCode) {
		this.oCode = oCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public int getoCount() {
		return oCount;
	}
	public void setoCount(int oCount) {
		this.oCount = oCount;
	}
	public int getMenuTotalPrice() {
		return menuTotalPrice;
	}
	public void setMenuTotalPrice(int menuTotalPrice) {
		this.menuTotalPrice = menuTotalPrice;
	}
	public String getoRequest() {
		return oRequest;
	}
	public void setoRequest(String oRequest) {
		this.oRequest = oRequest;
	}
	public String getPayGroCode() {
		return payGroCode;
	}
	public void setPayGroCode(String payGroCode) {
		this.payGroCode = payGroCode;
	}
	public int getoTotalPrice() {
		return oTotalPrice;
	}
	public void setoTotalPrice(int oTotalPrice) {
		this.oTotalPrice = oTotalPrice;
	}
	public String getOrderSignTime() {
		return orderSignTime;
	}
	public void setOrderSignTime(String orderSignTime) {
		this.orderSignTime = orderSignTime;
	}
	public String getOrderCompTime() {
		return orderCompTime;
	}
	public void setOrderCompTime(String orderCompTime) {
		this.orderCompTime = orderCompTime;
	}
	public String getOrderStateCode() {
		return orderStateCode;
	}
	public void setOrderStateCode(String orderStateCode) {
		this.orderStateCode = orderStateCode;
	}
	public String getStoreTableCode() {
		return storeTableCode;
	}
	public void setStoreTableCode(String storeTableCode) {
		this.storeTableCode = storeTableCode;
	}
	public String getTabelStateCode() {
		return tabelStateCode;
	}
	public void setTabelStateCode(String tabelStateCode) {
		this.tabelStateCode = tabelStateCode;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Storesearch getStoreSearch() {
		return storeSearch;
	}
	public void setStoreSearch(Storesearch storeSearch) {
		this.storeSearch = storeSearch;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	@Override
	public String toString() {
		return "Order [oCode=" + oCode + ", bookCode=" + bookCode + ", userId=" + userId + ", storeCode=" + storeCode
				+ ", menuCode=" + menuCode + ", oCount=" + oCount + ", menuTotalPrice=" + menuTotalPrice + ", oRequest="
				+ oRequest + ", payGroCode=" + payGroCode + ", oTotalPrice=" + oTotalPrice + ", orderSignTime="
				+ orderSignTime + ", orderCompTime=" + orderCompTime + ", orderStateCode=" + orderStateCode
				+ ", storeTableCode=" + storeTableCode + ", tabelStateCode=" + tabelStateCode + ", menu=" + menu
				+ ", store=" + store + ", book=" + book + ", payment=" + payment + ", storeSearch=" + storeSearch
				+ ", statement=" + statement + "]";
	}

	
}