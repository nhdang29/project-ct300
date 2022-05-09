package shopingcart;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	private String ten;
	private Scanner sc = new Scanner(System.in);
	
	public Admin() {
		ten = new String();
	}
	
	public Admin(String ten) {
		// TODO Auto-generated constructor stub
		this.ten = ten;
	}
	
		
	public void admin_add_product(ArrayList<Product> arr) {
		Product sp = new Product();
		sp.nhap();
		arr.add(sp);
	}
	
	public void admin_del_product(ArrayList<Product> arr) {
		System.out.print("Nhap vao san pham muon xoa: ");
		String sp = sc.nextLine();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getTen().equalsIgnoreCase(sp)) arr.remove(i);
		}
	}
	
	public void admin_update_product(ArrayList<Product> arr) {
		System.out.print("Nhap vao san pham muon thay doi gia: ");
		String sp = sc.nextLine();
		System.out.print("Nhap gia moi: ");
		int gia = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getTen().equalsIgnoreCase(sp)) arr.get(i).setGia(gia);
		}
	}
	
	public String getTen() {
		return this.ten;
	}
	

}
