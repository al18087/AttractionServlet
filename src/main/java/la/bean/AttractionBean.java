package la.bean;

public class AttractionBean {
	private int attractionId;
	private String attractionName;
	private int price;
	
	public AttractionBean(int attractionId, String attractionName, int price) {
		this.attractionId = attractionId;
		this.attractionName = attractionName;
		this.price = price;
	}
	
	public int getAttractionId() {
		return attractionId;
	}
	
	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}
	
	public String getAttractionName() {
		return attractionName;
	}
	
	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
