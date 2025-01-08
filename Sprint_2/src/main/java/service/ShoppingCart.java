package service;

import model.Apple;
import model.Discountable;
import model.Food;

/**
 * Пакет service. В нём создай класс для корзины — ShoppingCart.
 * Добавь в него поле — массив элементов из объектов типа Food.
 * Понадобится конструктор с одним параметром — массивом элементов Food.
 * С его помощью ты создашь объект корзины.
 * В классе ShoppingCart реализуй методы для работы с корзиной:
 * получить общую сумму товаров в корзине без скидки,
 * получить общую сумму товаров в корзине со скидкой,
 * получить общую сумму всех вегетарианских продуктов в корзине без скидки.
 */

public class ShoppingCart {
    private Food[] foods;

    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    public double totalPrice() {
        double total = 0;

        for (Food food : foods) {
            total += food.getPrice() * food.getAmount();
        }

        return total;
    }
    public double totalDiscountPrice() {
        double total = 0;

        for (Food food : foods) {
            double discount = (100 - food.getDiscount()) / 100;
            total += food.getPrice() * food.getAmount() * discount;
        }
        return total;

    }
    public double totalAllVegFoodPrice() {
        double total = 0;

        for (Food food : foods) {
            if (food.isVegetarian()){
            total += food.getPrice() * food.getAmount();
            }
        }
        return total;
    }
}
