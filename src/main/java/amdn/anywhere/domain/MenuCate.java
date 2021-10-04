package amdn.anywhere.domain;

public class MenuCate {
	private String menuCateCode;
	private String cateName;
	public String getMenuCateCode() {
		return menuCateCode;
	}
	public void setMenuCateCode(String menuCateCode) {
		this.menuCateCode = menuCateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "MenuCate [menuCateCode=" + menuCateCode + ", cateName=" + cateName + "]";
	}

}
