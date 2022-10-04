package views;

import managers.ManagerAccount;
import models.Account;

import java.util.Scanner;

public class MenuLogin {
    Scanner scanner = new Scanner(System.in);
    ManagerAccount managerAccount = new ManagerAccount();
    MenuProduct menuProduct = new MenuProduct();

    public void menu() {
        while (true) {
            System.out.println("Chào mừng bạn đến với chúng tôi.");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Account account = managerAccount.login();
                    if (account != null && account.getRole().equals("admin")) {
                        menuProduct.menu();
                    }
                    break;
                case 2:
                    managerAccount.register();
                    break;
                case 3:
                    return;
            }
        }
    }
}
