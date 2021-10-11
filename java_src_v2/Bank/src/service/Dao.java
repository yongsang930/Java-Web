package service;

import vo.AccountVO;

public interface Dao {
	void con();
	void discon();
	void insertAccount(AccountVO vo);
	AccountVO findAccount(String accNum);
	int depositMoney(String accNum, int money);
	int withDrawMoney(String accNum, int money);
	int sumAccount(String name);
	int avgAccount(String name);
	//int createTransfer(String sendAccount, String receiveAccount, int money);
	boolean findNameExist(String accountName);
	boolean findAccountExist(String accountNumber);
}
