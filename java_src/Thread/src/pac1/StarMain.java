package pac1;

import java.util.*;
public class StarMain {
	public static State s=new State();
	public static Enemy e=new Enemy();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x, y, i;
		boolean flag=true;
		System.out.println("game start");
		e.start();
		for(i=0;i<s.vp.size();i++)
			s.vp.elementAt(i).start();
		
		while(StarMain.e.energy>0 && StarMain.e.energy<5000){
			s.print();
			System.out.println("������ ������ : "+e.energy);
			System.out.println("menu");
			System.out.println("1. ����");
			System.out.println("2. ����");
			x=sc.nextInt();
			switch(x){
			case 1:
				System.out.println("1. ���");
				System.out.println("2. ����");
				y=sc.nextInt();
				if(y==1)
					s.makeP();
				else
					s.makeS();
				break;
			case 2:
				if(s.vs.size()<=0)
					System.out.println("���簡 �����ϴ�.");
				else{
					for(i=0;i<s.vs.size();i++)
						s.vs.elementAt(i).attack();
				}
			}
		}
	}

}

