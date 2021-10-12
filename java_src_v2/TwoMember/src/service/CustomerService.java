package service;


import vo.Customer;

public class CustomerService {

		private Dao2 dao2;
		
		public CustomerService(){
			dao2 = new CusDAO();
		}
		public void insert(Customer b) {
			dao2.Cusinsert(b);
		}

		public void printAll() {
			System.out.println(dao2.CusselectAll());
		}

		public Customer findbook(String name) {
			return dao2.Cusselect(name);
		}

		public void deletebook(String name) {
			dao2.Cusdelete(name);
		}

		public void updatebook(Customer b) {
			dao2.Cusupdate(b);
		}




}

