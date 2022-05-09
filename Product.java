package shopingcart;

import java.util.Scanner;

public class Product {
	private String id, ten;
	private int gia;

	public Product() {
		id = new String();
		ten = new String();
		gia = 0;
	}

	public Product(String id, String ten, int gia) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.ten = ten;
		this.gia = gia;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ID: ");
		id = sc.nextLine();
		System.out.print("Nhap ten san pham: ");
		ten = sc.nextLine();
		System.out.print("Nhap gia san pham: ");
		gia = Integer.parseInt(sc.nextLine());

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

}
