package vo;

import java.io.Serializable;

public class Member implements Serializable {

	private String Id;
	private String contents;

	public Member(String id, String contents) {
		super();
		Id = id;
		this.contents = contents;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Member [Id=" + Id + ", contents=" + contents + "]";
	}

}
