package model;

import java.sql.Date;

public class Board {
	private int b_num;
	private String b_img;
	private String b_title;
	private String b_id;
	private Date b_date;
	private String b_content;
	private String b_type;
	private String b_pname;

	public Board() {
		super();
	}

	public Board(int b_num, String b_img, String b_title, String b_id, Date b_date, String b_content, String b_type,
			String b_pname) {
		super();
		this.b_num = b_num;
		this.b_img = b_img;
		this.b_title = b_title;
		this.b_id = b_id;
		this.b_date = b_date;
		this.b_content = b_content;
		this.b_type = b_type;
		this.b_pname = b_pname;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_img() {
		return b_img;
	}

	public void setB_img(String b_img) {
		this.b_img = b_img;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public String getB_pname() {
		return b_pname;
	}

	public void setB_pname(String b_pname) {
		this.b_pname = b_pname;
	}

	@Override
	public String toString() {
		return "Board [b_num=" + b_num + ", b_img=" + b_img + ", b_title=" + b_title + ", b_id=" + b_id + ", b_date="
				+ b_date + ", b_content=" + b_content + ", b_type=" + b_type + ", b_pname=" + b_pname + "]";
	}

}
