package views;

import managers.ManagerProduct;
import models.Product;

import java.util.Scanner;

public class MenuProduct {
    Scanner scanner = new Scanner(System.in);
    ManagerProduct managerProduct = new ManagerProduct();

    public void menu() {
        while (true) {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.show();
                    break;
                case 2:
                    Product product = managerProduct.create();
                    managerProduct.add(product);
                    break;
                case 3:
                    managerProduct.edit();
                    break;
                case 4:
                    break;
                case 5:
                    return;

            }
        }
    }
}
