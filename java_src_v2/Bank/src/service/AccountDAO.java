package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.InsufficientMoneyException;
import exception.InvalidBalanceException;
import exception.NotFoundAccountException;
import exception.NotFoundNameException;
import vo.AccountVO;

public class AccountDAO implements Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // connection��ü����
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void discon() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void insertAccount(AccountVO vo) {

		con();
		String sql = "insert into bank values(?,?,?) ";
		try {

			if (vo.getBalance() <= 0) {
				throw new InsufficientMoneyException("입금액이 0이하 입니다.");
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAccountNumber());
			pstmt.setString(2, vo.getAccountName());
			pstmt.setInt(3, vo.getBalance());
			int result = pstmt.executeUpdate();
			System.out.println((result == 1) ? "계좌생성 완료" : "계좌생성 실패");

		} catch (InsufficientMoneyException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public AccountVO findAccount(String accNum) {
		con();
		AccountVO vo = null;
		try {

			if (!findAccountExist(accNum)) {
				throw new NotFoundAccountException("존재하지 않는 계좌");
			}
			String sql = "select accountnumber, accountname, balance+10000 from bank where accountnumber = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accNum);
			rs = pstmt.executeQuery();
			if (rs.next())
				vo = new AccountVO(rs.getString(1), rs.getString(2), rs.getInt(3));

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (NotFoundAccountException ne) {
			ne.printStackTrace();
		}
		discon();
		return vo;
	}

	@Override
	public int depositMoney(String accNum, int money) {
		con();
		String sql = "update bank set balance=(balance+?) where accountnumber = ?";

		try {
			if (!findAccountExist(accNum)) {
				throw new NotFoundAccountException("존재하지 않는 계좌");
			}
			if (money <= 0) {
				throw new InsufficientMoneyException("입금액이 0이하 입니다.");
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, accNum);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (NotFoundAccountException ne) {
			ne.printStackTrace();
		} catch (InsufficientMoneyException ie) {
			ie.printStackTrace();
		}
		discon();
		return money;
	}

	@Override
	public int withDrawMoney(String accNum, int money) {
		con();
		String sql = "update bank set balance=(balance-?)where accountnumber = ? and balance >= ?";

		if (!findAccountExist(accNum)) {
			try {
				throw new NotFoundAccountException("존재하지 않는 계좌");
			} catch (NotFoundAccountException ne) {
				ne.printStackTrace();
			}
		}
		if (money <= 0) {
			try {
				throw new InsufficientMoneyException("출금액이 0이하 입니다.");
			} catch (InsufficientMoneyException ie) {
				ie.printStackTrace();
			}
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			pstmt.setString(2, accNum);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			pstmt.setInt(3, money);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		int result = 0;
		try {
			result = pstmt.executeUpdate();
			System.out.println("출금 완료");
		} catch (SQLException se) {
			se.printStackTrace();
		}
//		System.out.println((result == 1) ? "계좌생성 완료" : "계좌생성 실패");

		if (result == 0) {
			try {
				throw new InvalidBalanceException("잔액 부족");
			} catch (InvalidBalanceException ie) {
				ie.printStackTrace();
			}
		}

		discon();
		return money;
	}

	@Override
	public int sumAccount(String name) {
		con();
		int sum = 0;
		try {
			if (!findNameExist(name)) {
				throw new NotFoundNameException("찾는 사람이 없음");
			}
		} catch (NotFoundNameException e) {
			e.printStackTrace();
		}

		String sql = "select sum(balance) from bank where accountName = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
		} catch (SQLException se) {
			se.printStackTrace();
		}

		try {
			rs = pstmt.executeQuery();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			rs.next();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			sum = rs.getInt(1);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		discon();
		return sum;
	}

	@Override
	public int avgAccount(String name) {
		con();
		int avg = 0;
		try {
			if (!findNameExist(name)) {
				throw new NotFoundNameException("찾는 사람이 없음");
			}
		} catch (NotFoundNameException e) {
			e.printStackTrace();
		}
		String sql = "select avg(balance) from bank where accountName = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
		} catch (SQLException se) {
			se.printStackTrace();
		}

		try {
			rs = pstmt.executeQuery();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			rs.next();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			avg = rs.getInt(1);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		discon();
		return avg;

	}

	@Override
	public boolean findNameExist(String accountName) {
		boolean flag = false;
		String sql = "select accountname from bank where accountname = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			flag = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean findAccountExist(String accountNumber) {
		boolean flag = true;

		String sql = "select accountNumber from bank where accountnumber = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			flag = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

}
