package shopingcart;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	private String ten;
	private ArrayList<Item> cart;

	public User() {
		ten = new String();
		cart = new ArrayList<Item>();
	}

	public User(String ten) {
		// TODO Auto-generated constructor stub
		this.ten = ten;
		cart = new ArrayList<Item>();
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}

	public void addItem(ArrayList<Product> menu) {
		Item item = inputItem(menu);
		if (item != null)
			cart.add(item);
	}

	public Item inputItem(ArrayList<Product> menu) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ten san pham can them: ");
		String name = sc.nextLine();
		System.out.print("So luong: ");
		int soLuong = sc.nextInt();
		for (Product each : menu) {
			if (each.getTen().equals(name)) {
				Item item = new Item(each, soLuong);
				return item;
			}
		}
		return null;
	}

	public void showCart() {
		System.out.println("============GIO HANG==============");
		if (cart.isEmpty()) {
			System.out.println("Gio hang rong!");
		} else {
			cartDetail();
		}
		System.out.println("==================================");
	}

	public void cartDetail() {
		System.out.println("Ten\t\tGia\tSo luong");
		for (Item each : cart) {
			String name = each.getTenSanPham().getTen();
			int price = each.getTenSanPham().getGia();
			int quantity = each.getSoLuong();
			System.out.println(name + "\t\t " + price + "\t " + quantity);
		}
	}

	public void findItem(ArrayList<Product> menu) {
		System.out.println("========Tim san pham=========");
		System.out.println("1. Tim san pham trong menu");
		System.out.println("2. Tim san pham trong gio hang");
		Scanner sc = new Scanner(System.in);
		System.out.print("Lua chon cua ban: ");
		int luaChon = sc.nextInt();
		if (luaChon == 1)
			findItemFromMenu(menu);
		else if (luaChon == 2) {
			System.out.print("Nhap ten san pham can tim: ");
			sc.next();
			String name = sc.nextLine();
			Item item = findItemFromCart(name);
			if (item != null)
				System.out.println(item.getTenSanPham().getTen() + "\t\t" + item.getTenSanPham().getGia() + "\t"
						+ item.getSoLuong());
			else
				System.out.println("San pham khong co trong gio hang!");
		} else {
			System.out.println("lua chon khong hop le");
		}

	}

	public void findItemFromMenu(ArrayList<Product> menu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten san pham can tim: ");
		String nameFind = sc.nextLine();
		for (Product each : menu) {
			if (each.getTen().equals(nameFind)) {
				System.out.println("==============San pham can tim==============");
				System.out.println("\tTen: \t\t\tGia:");
				String name = each.getTen();
				int price = each.getGia();
				System.out.println("\t" + name + "\t\t\t" + price);
				System.out.println("============================================");
			}
		}
	}

	public void remove() {
		showCart();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten san pham can xoa ra khoi gio hang: ");
		String name = sc.nextLine();
		Item item = findItemFromCart(name);
		cart.remove(item);
	}

	public Item findItemFromCart(String name) {
		for (Item each : cart) {
			if (each.getTenSanPham().getTen().equals(name))
				return each;
		}
		return null;
	}

	public void changeQuantity() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Chon ten san pham can thay doi so luong: ");
		String name = sc.nextLine();
		System.out.print("Nhap so luong moi: ");
		int quantity = sc.nextInt();
		for (Item each : cart) {
			if (each.getTenSanPham().getTen().equals(name))
				each.setSoLuong(quantity);
		}
	}
}
