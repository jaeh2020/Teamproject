package amdn.anywhere.domain;

public class Sales {
	public String sales;

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sales [sales=").append(sales).append("]");
		return builder.toString();
	}
	
}
