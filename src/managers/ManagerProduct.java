package managers;

import io.ReadAndWrite;
import models.Product;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    File file = new File("/Users/johntoan98gmail.com/Desktop/module2_c0722g1/DemoCase/src/file_text/product.txt");
    ReadAndWrite<Product> readAndWrite = new ReadAndWrite<>();
    ArrayList<Product> products = readAndWrite.read(file);
    Scanner scanner = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public void add(Product product) {
        products.add(product);
        readAndWrite.write(file, products);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Product create() {
        int id;
        int index;
        while (true) {
            System.out.println("Nhập id :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index == -1) {
                break;
            }
            System.out.println("Nhập trùng id rồi.");
        }
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập price");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price);
    }

    public void edit() {
        System.out.println("Nhập id :");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index != -1) {
            products.set(index, create());
        }
    }
}
