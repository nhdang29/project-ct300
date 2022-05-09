package shopingcart;

import java.util.Scanner;

public class Item {
	private Product tenSanPham;
	private int soLuong;

	public Item() {
		tenSanPham = new Product();
		soLuong = 0;
	}
	
	public Item(Product tenSanPham, int soLuong) {
		this.tenSanPham = new Product(tenSanPham.getId(),tenSanPham.getTen(),tenSanPham.getGia());
		this.soLuong = soLuong;
	}

	public Product getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(Product tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void nhap() {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap san pham: ");
			tenSanPham.nhap();
			System.out.print("Nhap so luong: ");
			soLuong = Integer.parseInt(sc.nextLine());
	}
	
}
