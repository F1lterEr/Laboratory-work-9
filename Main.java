package com.company;
import java.util.Scanner;
import java.util.Random;

interface Product{
    void displayName(String name);
    void displayPrice(double price);
    void displayRating(String rating);
}

interface User{
    void displayLogin(String login);
    void displayPassword(String login);
}

class Login implements User{
    public void displayLogin(String login){
        System.out.printf("Логин: %s", login);
    }
    public void displayPassword(String login){
        System.out.printf("Пароль: %s", login);
    }
}

class Balance implements User{
    Random randNumber = new Random();
    public void displayLogin(String login){
        System.out.printf("Логин: %s", login);
    }
    public void displayPassword(String login){
        System.out.printf("Пароль: %s", login);
    }
    public void displayBalance(){
        System.out.printf("Баланс: %d$ ", randNumber.nextInt(500));
    }
}

class History implements User{
    public void displayLogin(String login){
        System.out.printf("Логин: %s", login);
    }
    public void displayPassword(String login){
        System.out.printf("Пароль: %s", login);
    }
    String[] history = new String[] {
            "24 Апреля 2022 год | Товар: Клинок Ночи | Цена: 10300$\n",
            "29 Декабря 2021 год | Товар: Цвайхандер | Цена: 4500$\n",
            "8 Сентября 2021 год | Товар: Ветрянной Клинок | Цена: 8000$\n",
            "9 Июня 2021 год | Товар: Меч Огня | Цена: 5000$\n"};
    public void displayHistory(){
        System.out.println("Ваша история покупок: ");
        int length = history.length - 1;
        for(int c = 0; c <= length; c++){
            System.out.println(history[c]);
        }
    }
}

class Claymore implements Product{
    String name = "Клеймор";
    double price = 800.99;
    String rating = "6/10";
    public void displayName(String name){
        System.out.printf("Название товара: %s.", name);
    }
    public void displayPrice(double price){
        System.out.printf("Цена клеймора: %f.$", price);
    }
    public void displayRating(String rating){
        System.out.printf("Рейтинг данного товара: %s.", rating);
    }
}

class BladeOfChaos implements Product{
    String name = "Клинок Хаоса";
    double price = 19999;
    String rating = "9/10";
    public void displayName(String name){
        System.out.printf("Название товара: %s.", name);
    }
    public void displayPrice(double price){
        System.out.printf("Цена Клинка Хаоса: %f.$", price);
    }
    public void displayRating(String rating){
        System.out.printf("Рейтинг данного товара: %s.", rating);
    }
}

class StaffOfWisdom implements Product{
    String name = "Посох Мудрости";
    double price = 7000;
    String rating = "7/10";
    public void displayName(String name){
        System.out.printf("Название товара: %s.", name);
    }
    public void displayPrice(double price){
        System.out.printf("Цена Посоха Мудреца: %f.$", price);
    }
    public void displayRating(String rating){
        System.out.printf("Рейтинг данного товара: %s.", rating);
    }
}

class Cheque implements User, Product{
    public void start(){
        System.out.println("===== ЧЕК =====");
    }
    public void displayLogin(String login){
        System.out.printf("Логин: %s\n", login);
    }
    public void displayPassword(String login){
        System.out.printf("Пароль: %s\n", login);
    }
    public void displayName(String name){
        System.out.printf("Наименование товара: %s\n", name);
    }
    public void displayPrice(double price){
        System.out.printf("Стоимость товара: %.2f$\n", price);
    }
    public void displayRating(String rating){
        System.out.printf("Рейтинг товара: %s\n", rating);
    }
    public void end(){
        System.out.println("===============");
    }
}



public class Main {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.print("Введите название товара (Claymore, BladeOfChaos, StaffOfWisdom): ");
        String name = in.nextLine();
        System.out.print("Введите логин от аккаунта: ");
        String login = in.nextLine();
        System.out.print("Введите пароль от аккаунта: ");
        String password = in.nextLine();

        Claymore claymore = new Claymore();
        BladeOfChaos bladeOfChaos = new BladeOfChaos();
        StaffOfWisdom staffOfWisdom = new StaffOfWisdom();
        Balance balance = new Balance();
        History history = new History();
        Cheque cheque = new Cheque();
        balance.displayBalance();
        history.displayHistory();


        if("Claymore".equals(name)){
            cheque.start();
            cheque.displayLogin(login);
            cheque.displayPassword(password);
            cheque.displayName(claymore.name);
            cheque.displayPrice(claymore.price);
            cheque.displayRating(claymore.rating);
            cheque.end();
        }
        else if("StaffOfWisdom".equals(name)){
            cheque.start();
            cheque.displayLogin(login);
            cheque.displayPassword(password);
            cheque.displayName(staffOfWisdom.name);
            cheque.displayPrice(staffOfWisdom.price);
            cheque.displayRating(staffOfWisdom.rating);
            cheque.end();

        }
        else if("BladeOfChaos".equals(name)){
            cheque.start();
            cheque.displayLogin(login);
            cheque.displayPassword(password);
            cheque.displayName(bladeOfChaos.name);
            cheque.displayPrice(bladeOfChaos.price);
            cheque.displayRating(bladeOfChaos.rating);
            cheque.end();
        }
        else{
            System.out.println("Error");
        }
    }
}
