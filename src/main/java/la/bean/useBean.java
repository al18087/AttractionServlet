package la.bean;

public class useBean {
	private int visitorId;
	private String useTime;
	private int attractionId;
	
	public useBean(int visitorId, String useTime, int attractionId) {
		this.visitorId = visitorId;
		this.useTime = useTime;
		this.attractionId = attractionId;
	}
	
	public int getVisitorId() {
		return visitorId;
	}
	
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	
	public String getUseTime() {
		return useTime;
	}
	
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	
	public int getAttractionId() {
		return attractionId;
	}
	
	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}
}
