package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] firms = {"timex", "tissot", "citizen"};
        String[][] brands = {{"weekender", "expedition"}, {"le locle", "t-touch"}, {"promaster", "eco-drive"}};
        ArrayList<String[]> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите ФИО:");
            String fio = scanner.nextLine();

            System.out.println("Введите email:");
            String email = scanner.nextLine();

            int phone = 0;
            while (true) {
                System.out.println("Введите номер телефона:");
                try {
                    phone = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException number) {
                    System.out.println("Некорректный номер телефона. Попробуйте еще раз.");
                }
            }

            System.out.println("Список доступных позиций в магазине:");
            for (int i = 0; i < firms.length; i++) {
                System.out.println(i + ": " + firms[i] + " - " + brands[i][0] + ", " + brands[i][1]);
            }

            int position = 0;
            while (true) {
                System.out.println("Выберите позицию товара:");
                try {
                    position = Integer.parseInt(scanner.nextLine());
                    if (position < 0 || position >= firms.length) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Некорректный номер позиции товара. Попробуйте еще раз.");
                }
            }

            int quantity = 0;
            while (true) {
                System.out.println("Введите количество:");
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException chislo) {
                    System.out.println("Некорректное количество. Попробуйте еще раз.");
                }
            }

            String[] customer = {fio, email, String.valueOf(phone), firms[position], brands[position][0], brands[position][1], String.valueOf(quantity)};
            customers.add(customer);

            System.out.println("Меню:\n1. Добавить заказчика\n2. Вывести информацию о заказах");
            System.out.println("Введите номер пункта меню:");
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 2) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (NumberFormatException | IndexOutOfBoundsException menu) {
                    System.out.println("Некорректный номер пункта меню. Попробуйте еще раз.");
                }
            }

            if (choice == 2) {
                System.out.println("Информация о заказчиках:");
                for (String[] c : customers) {
                    System.out.println("ФИО: " + c[0]);
                    System.out.println("Email: " + c[1]);
                    System.out.println("Номер телефона: " + c[2]);
                    System.out.println("Позиция товара: " + c[3] + " - " + c[4] + ", " + c[5]);
                    System.out.println("Количество: " + c[6]);
                    System.out.println();
                }
                break;
            }
        }
    }
}