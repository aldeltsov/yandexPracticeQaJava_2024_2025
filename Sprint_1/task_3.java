package ru.restaurant;

public class Restaurant {

	int pearsCount;
	String[] menu = {"Шарлотка грушевая", "Компот грушевый", "Салат из груш и лисичек", "Рулет с грушами"};

	public void showMenu() {
      for (int i = 0; i < menu.length; i = i + 1) {
          System.out.println("Сегодня у нас в меню " + menu[i]);
      }
  }

	public void checkPears() { // объяви здесь метод checkPears() - он ничего не принимает и не возвращает {
	if (pearsCount < 5) {
        pearsCount = pearsCount + 5;
        System.out.println("Пора заказать ещё груш ");
    } else if (pearsCount >= 5) {
      System.out.println("Груш пока достаточно");
      }
    }
    
	public void cook(String name) {
        System.out.println("Готовим " + name);
        pearsCount = pearsCount - 1;
        
    }
}
    // объяви здесь метод checkPears() - он ничего не принимает и не возвращает {
	//	внутри метода опиши условие из задания (понадобится if - else)
	// }
    // объяви здесь метод cook с параметром String name - он ничего не возвращает {
	// }
