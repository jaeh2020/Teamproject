package amdn.anywhere.domain;

public class MenuCate {
	private String menuCateCode;
	private String menuCateName;
	public String getMenuCateCode() {
		return menuCateCode;
	}
	public void setMenuCateCode(String menuCateCode) {
		this.menuCateCode = menuCateCode;
	}
	public String getMenuCateName() {
		return menuCateName;
	}
	public void setMenuCateName(String menuCateName) {
		this.menuCateName = menuCateName;
	}
	@Override
	public String toString() {
		return "MenuCate [menuCateCode=" + menuCateCode + ", menuCateName=" + menuCateName + "]";
	}
	
}
