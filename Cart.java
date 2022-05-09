package shopingcart;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cart {
	static Scanner sc = new Scanner(System.in);
	public static int luaChon() {
		System.out.print("Lua chon cua ban la: ");
		int c;
		c = Integer.parseInt(sc.nextLine());
		return c;
	}
		
	public static void showMenu(ArrayList<Product> ds) {
		System.out.println("================MENU=================");
		for(int i = 0; i < ds.size() ; i++) {
			System.out.println( (i+1)+". "+ ds.get(i).getTen()+"    \t\t\t"+ds.get(i).getGia());
		}
		
		System.out.println("=====================================");
	}
	
	public static void main(String[] args) {
		ArrayList<Product> menu = new ArrayList<Product> ();
		menu.add(new Product("cfs","cafe sua",12000));
		menu.add(new Product("cfd","cafe den",10000));
		menu.add(new Product("ts","tra sua",22000));
		menu.add(new Product("tx","tra xanh",22000));
		menu.add(new Product("ccs","ca cao",18000));
		menu.add(new Product("st","sting",10000));
		

		// bat dau chuong trinh
		int luachon;
		
		do {
			System.out.println("Moi ban chon nguoi dung:\n1. Admin\n2. Mua Hang\n**Chon so bat ki de thoat");
			luachon = luaChon();
			
			String ten;
			if(luachon == 1 ) { // Admin
				System.out.print("Ten cua ban la: ");
				ten = sc.nextLine();
				//tao admin moi
				Admin admin = new Admin(ten);
				System.out.println("\nAdmin: "+admin.getTen());
				int ch;
				do {
					System.out.println("==============Cong Viec==============");
					System.out.println("1. Them san pham");
					System.out.println("2. Xoa san pham");
					System.out.println("3. Thay doi gia san pham");
					System.out.println("4. In menu");
					System.out.println("5. Thoat");
					System.out.println("=====================================");
					ch = luaChon();
					
					switch(ch) { // kiem tra lua chon cua admin
					case 1:
						admin.admin_add_product(menu);
						break;
					case 2:
						showMenu(menu);
						admin.admin_del_product(menu);
						showMenu(menu);
						break;
					case 3:
						showMenu(menu);
						admin.admin_update_product(menu);
						showMenu(menu);
						break;
					case 4:
						showMenu(menu);
						break;
					case 5:
						System.out.println("Dang thoat ...");
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Da thoat!!!\n\n");
						break;
					default:
						System.out.println("Hanh dong khong hop le !!!");
						break;
					}
				} while (ch != 5); // kiem tra lua chon cua admin
				
				
			} else if(luachon == 2 ) { // User
				System.out.print("Ten cua ban la: ");
				ten = sc.nextLine();
				//Tao user moi
				User user = new User(ten);
				System.out.println("\nHello: "+user.getTen());
				int ch;
				System.out.println("===============Ban muon lam gi================");
				do {
					System.out.println("1. Tim san pham");
					System.out.println("2. Them san pham");
					System.out.println("3. Xem gio hang");
					System.out.println("4. Thay doi so luong");	
					System.out.println("5. Xoa san pham");
					System.out.println("6. Thoat");
					System.out.println("==============================================");
					ch = luaChon();

					switch(ch) { // kiem tra lua chon cua user
					case 1:
						showMenu(menu);
						user.findItem(menu);
						break;
					case 2:
						showMenu(menu);
						user.addItem(menu);
						break;
					case 3:
						user.showCart();
						break;
					case 4:
						user.showCart();
						user.changeQuantity();
						break;
					case 5:
						user.remove();
						break;
					case 6:
						System.out.println("Dang thoat ...");
						try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Tam biet "+ten+"\n\n");
						break;
					default:
						System.out.println("Hanh dong khong hop le !!!");
						break;
					}
					
				} while(ch != 6); // kiem tra lua chon cua user

			} else System.out.println("Ket thuc chuong trinh !!!");
		} while (luachon == 1 || luachon == 2);
	}

}
