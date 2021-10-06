package step2;

public class FriendVO {
	
	private String name;
	private String addr;
	private int money;
	
	public FriendVO(String name, String addr, int money) {
		super();
		this.name = name;
		this.addr = addr;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "FriendVO [name=" + name + ", addr=" + addr + ", money=" + money + "]";
	}
}
