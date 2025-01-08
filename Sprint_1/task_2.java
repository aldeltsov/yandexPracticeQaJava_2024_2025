package ru.restaurant;

public class Restaurant {
    int pearsCount;
	String[] menu = {"Шарлотка грушевая", "Компот грушевый", "Салат из груш и лисичек", "Рулет с грушами"};

	public void showMenu() { // объяви здесь метод showMenu {
	    // внутри метода в цикле перебирай элементы menu
		for (int i = 0; i < menu.length; i ++) { // for (...) {
		System.out.println("Сегодня у нас в меню " + menu[i]); // в теле цикла выводи строку "Сегодня у нас в меню " + menu[i]
        } // }
    } // }

}
