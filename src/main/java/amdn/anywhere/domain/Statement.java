package amdn.anywhere.domain;

public class Statement {
	private String stateCode;
	private String mainState;
	private String stateName;
	private Order order;
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getMainState() {
		return mainState;
	}
	public void setMainState(String mainState) {
		this.mainState = mainState;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Statement [stateCode=" + stateCode + ", mainState=" + mainState + ", stateName=" + stateName
				+ ", order=" + order + "]";
	}
	
	
	
}
