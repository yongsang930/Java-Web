package vo;

public class ProductVO {
	private String id;
	private String nick;
	private int price;

	public ProductVO() {
		super();
	}

	public ProductVO(String id, String nick, int price) {
		super();
		this.id = id;
		this.nick = nick;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", nick=" + nick + ", price=" + price + "]";
	}
}
