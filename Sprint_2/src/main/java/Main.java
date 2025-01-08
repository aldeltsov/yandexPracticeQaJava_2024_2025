import model.Apple;
import model.Food;
import model.Meat;
import model.constants.Colour;
import service.ShoppingCart;

/**
 * Отдельно от пакетов создай класс Main с методом main.
 * В методе main реализуй следующую логику:
 * Инициализируй данные. Для этого создай объекты:
 * Мясо в количестве 5 кг по цене 100 рублей за кг;
 * Яблоки красные в количестве 10 кг по цене 50 рублей;
 * Яблоки зелёные в количестве 8 кг по цене 60 рублей.
 *
 * Создай массив продуктов из этих элементов и проинициализируй корзину с помощью созданного массива.
 *
 * Посчитай и выведи на экран значения для созданной корзины:
 * общую сумму товаров без скидки,
 * общую сумму товаров со скидкой,
 * сумму всех вегетарианских продуктов без скидки.
 */

public class Main {

    public static void main(String[] args) {
    Meat meat = new Meat(5,100);
    Apple redApple = new Apple(10,50, Colour.RED);
    Apple greenApple = new Apple(8,60, Colour.GREEN);

    Food[] foods = {meat, redApple, greenApple};

    ShoppingCart shoppingCart = new ShoppingCart(foods);

    System.out.println("Общая сумма товаров без скидки - " + shoppingCart.totalPrice());
    System.out.println("Общая сумма товаров со скидкой - " + shoppingCart.totalDiscountPrice());
    System.out.println("Сумма всех вегетарианских продуктов без скидки - " + shoppingCart.totalAllVegFoodPrice());
    }

}

/**
 * Все переменные класса должны быть недоступны извне, если не указано иное.
 * Доступ к ним реализуй через известные тебе методы: создавай только те, которые действительно нужны для реализации описанной функциональности.
 */