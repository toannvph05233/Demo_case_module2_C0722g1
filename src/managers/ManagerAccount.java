package managers;

import io.ReadAndWrite;
import models.Account;
import models.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    File file = new File("/Users/johntoan98gmail.com/Desktop/module2_c0722g1/DemoCase/src/file_text/account.txt");
    ReadAndWrite<Account> readAndWrite = new ReadAndWrite<>();
    //Tạo list đọc dữ liệu trong file
    ArrayList<Account> accounts = readAndWrite.read(file);
    Scanner scanner = new Scanner(System.in);

    public Account login() {
        System.out.println("Nhập username");
        String username = scanner.nextLine();
        System.out.println("Nhập password");
        String password = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void register() {
        String username;
        while (true) {
            System.out.println("Nhập username");
            username = scanner.nextLine();
            if (checkUserName(username)) {
                break;
            }
            System.out.println("Trùng username rồi");
        }
        System.out.println("Nhập password");
        String password = scanner.nextLine();
        System.out.println("Nhập role");
        String role = scanner.nextLine();
        accounts.add(new Account(username,password,role));
        readAndWrite.write(file,accounts);
    }

    public boolean checkUserName(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
