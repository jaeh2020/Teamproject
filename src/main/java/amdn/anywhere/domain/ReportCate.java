package amdn.anywhere.domain;

public class ReportCate {
	private String reportCateCode;
	private String reportCate;
	
	public String getReportCateCode() {
		return reportCateCode;
	}
	public void setReportCateCode(String reportCateCode) {
		this.reportCateCode = reportCateCode;
	}
	public String getReportCate() {
		return reportCate;
	}
	public void setReportCate(String reportCate) {
		this.reportCate = reportCate;
	}
	@Override
	public String toString() {
		return "ReportCate [reportCateCode=" + reportCateCode + ", reportCate=" + reportCate + "]";
	}
	
	

}
