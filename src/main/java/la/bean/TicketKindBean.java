package la.bean;

public class TicketKindBean {
	private int ticketId;
	private String ticketName;
	private int price;
	
	public TicketKindBean(int ticketId, String ticketName, int price) {
		this.ticketId = ticketId;
		this.ticketName = ticketName;
		this.price = price;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getTicketName() {
		return ticketName;
	}
	
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
