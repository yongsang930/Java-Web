package test;

import java.util.Scanner;

import service.BookService;
import service.CustomerService;
import vo.BookVO;
import vo.Customer;

public class TestCusBooService {

	public static void main(String[] args) {
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
        
		
		while(flag){
			flag2=true;
			System.out.println("1.고객 2.책");
			int menu1 = sc.nextInt();
			
			switch(menu1){
			case 1:
				while(flag2){
					System.out.println("1.등록 2.검색 3.전체출력 4.삭제, 5.수정 6.종료");
					menu2 = sc.nextInt();
					switch(menu2){
					case 1:
							
							System.out.println("이름입력 하세요 :" );
							
							String name=sc.next(); 
							System.out.println("주소를 입력하세요 :" );
							String addr=sc.next();
							System.out.println("전화번호를 입력하세요  :" );
							String tel=sc.next();
							
								ser.insert(new Customer(name,addr,tel));			
							break;
						case 2:
							System.out.println("이름을 입력하세요 :");
							name = sc.next();
							Customer m = ser.findbook(name);
							System.out.println(m);
							break;
						
						case 3: 
							ser.printAll();
							break;
						
						case 4: 
							System.out.println("삭제할 이름을 입력하세요 : ");
							name = sc.next();
							ser.deletebook(name);
							break;
						case 5:
							System.out.println("수정할 이름을 입력하세요 : ");
							name = sc.next();
							System.out.println("수정할 주소를 입력하세요 :");
							addr = sc.next();
							System.out.println("수정할 전화번호를 입력하세요 :");
							tel = sc.next();
							Customer m2 = new Customer(name,addr,tel);			
							ser.updatebook(m2); 
							break;
						case 6 :
							flag2=false; 
						
						
						}
				}
				break;
						
			case 2:
				while(flag1){
					System.out.println("1.책등록 2.검색 3.수정 4.삭제 5.전체출력 6.종료");
					menu2 = sc.nextInt();
					switch(menu2){
					case 1:
						System.out.println("아이디를 입력하세요 :");
						id = sc.next();
						System.out.println("책이름을 입력하세요 :");
						title = sc.next();
						System.out.println("저자를 입력하세요 :");
						author = sc.next();
						System.out.println("출판사를  입력하세요 :");
						publisher = sc.next();
						System.out.println("가격을 입력하세요 :");
						price = sc.nextInt();
						service.insert(new BookVO(id, title,author,publisher,price));
						break;
					case 2:
						System.out.println("아이디를 입력하세요 :");
						id = sc.next();
						BookVO m = service.findbook(id);

						System.out.println(m);
						break;
						
					case 3:
						System.out.println("수정할 id를 입력하세요 : ");
						id = sc.next();
						System.out.println("수정할 책이름을 입력하세요 :");
						title = sc.next();
						System.out.println("수정할 저자를 입력하세요 :");
						author = sc.next();
						System.out.println("수정할 출판사를 입력하세요 :");
						publisher = sc.next();
						System.out.println("수정할 가격을 입력하세요 :");
						price = sc.nextInt();
						BookVO m2 = new BookVO(id,title,author,publisher,price);			
						service.updatebook(m2); 
					   break;
					
					case 4:
					System.out.println("삭제할 id를 입력하세요 : ");
					id = sc.next();
					service.deletebook(id);
					break;
					
					case 5:
						service.printAll();
				        break; 
					
					case 6:
						flag1=false; 
					    break; 
					    
					}
				}
				break;
			}
		}
	}



	}


