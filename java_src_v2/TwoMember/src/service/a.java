package service;

import java.util.Scanner;

import vo.BookVO;
import vo.Customer;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag=true;
		boolean flag1=true;		
		boolean flag2=true;
		int menu2=0;
		String id;
		String title;
		String author;
		String publisher;
		int price;
		
		CustomerService ser = new CustomerService();
		BookService service = new BookService();
        
		
		while(flag1){
			System.out.println("1.고객 2.책");
			int menu1 = sc.nextInt();
			switch(menu1){
			case 1:
				while(flag2){
					System.out.println("1.등록 2.검색 3.전체출력 4.삭제, 5.수정");
					menu2 = sc.nextInt();
					switch(menu2){
					case 1:
														
							break;
						case 2:
							
							break;
						
						case 3: 
							
							break;
						
						case 4: 
							
							break;
						case 5:
							
						
						case 6 :
							
						
						
						}
				}
				break;
						
			case 2:
				while(flag2){
					System.out.println("1.책등록 2.검색");
					menu2 = sc.nextInt();
					switch(menu2){
					case 1:
						
						break;
					case 2:
						

						
						break;
						
					case 3:
						
					   break;
					
					case 4:
					
					break;
					
					case 5:
						
				        break; 
					case 6:
						flag=false; 
					    break; 
					    
					}
				}
				break;
			}
		}
	}

}
