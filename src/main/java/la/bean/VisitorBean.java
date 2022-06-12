package la.bean;

public class VisitorBean {
	private int visitorId;
	private int ticketId;
	private String visitorDate;
	private String visitorTime;
	private String exitTime;
	
	public VisitorBean(int visitorId, int ticketId, String visitorDate, 
			String visitorTime, String exitTime) {
		this.visitorId = visitorId;
		this.ticketId = ticketId;
		this.visitorDate = visitorDate;
		this.visitorTime = visitorTime;
		this.exitTime = exitTime;
	}
	
	public int getVisitorId() {
		return visitorId;
	}
	
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getVisitorDate() {
		return visitorDate;
	}
	
	public void setVisitorDate(String visitorDate) {
		this.visitorDate = visitorDate;
	}
	
	public String getVisitorTime() {
		return visitorTime;
	}
	
	public void setVisitorTime(String visitorTime) {
		this.visitorTime = visitorTime;
	}
	
	public String getExitTime() {
		return exitTime;
	}
	
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	
}
