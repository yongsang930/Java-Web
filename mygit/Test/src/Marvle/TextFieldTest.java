package Marvle;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFieldTest {
	public static void main(String[] args) {
		String[] arr = { "yongsang930", "12345" };

		Frame f = new Frame("Login");
		f.setSize(500, 90);
		f.setLayout(new FlowLayout());

		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);

		TextField id = new TextField(10);
		TextField pwd = new TextField(10);

		pwd.setEchoChar('*');

		Button btn = new Button("login");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ID: " + id.getText() + ", PW: " + pwd.getText());
				if (arr[0].equals(id.getText())) {
					if (arr[1].equals(pwd.getText())) {
						System.out.println("로그인이 완료되었다!");
					} else {
						{
							System.out.println("PW가 잘못되었다! 다시 입력해야할 것 같다...");
						}
					}
				} else {
					System.out.println("ID가 확인되질 않는다! 회원가입을 해야할 것 같다...");
				}
			}
		});

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(btn);

		f.setVisible(true);
	}
}
