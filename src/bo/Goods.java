package bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
	private String id;
	private String name;
	private int  price;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String oldDate) throws ParseException {
		SimpleDateFormat model = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = model.parse(oldDate);
		this.date = newDate;
	}
	public Goods() {
		super();
	}
	public Goods(String id, String name, int price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
	}
}
