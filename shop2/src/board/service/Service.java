package board.service;

import java.util.ArrayList;

import model.Board;

public interface Service {
	void writeBoard(Board b);	//�� �ۼ�

	Board getBoard(int num);	//�� �˻�

	ArrayList<Board> getAll();				//�� ��ü �˻�

	void editBoard(Board b);	//�� ����

	void delBoard(int num);		//�� ����
}
