package it.epicode.w5d1pratica;

import it.epicode.w5d1pratica.bean.Drink;
import it.epicode.w5d1pratica.bean.Menu;
import it.epicode.w5d1pratica.bean.Pizza;
import it.epicode.w5d1pratica.bean.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean("water")
    public Drink water(){
        Drink water = new Drink();
        water.setNome("Water");
        water.setCalorie(0);
        water.setPrezzo(1);
        return water;
    }
    @Bean("cocaCola")
    public Drink cocaCola(){
        Drink cocaCola = new Drink();
        cocaCola.setPrezzo(2);
        cocaCola.setNome("Coca Cola");
        cocaCola.setCalorie(200);
        return cocaCola;
    }
    @Bean("mozzarella")
    public Topping mozzarella(){
        Topping mozzarella = new Topping();
        mozzarella.setNome("Mozzarella");
        mozzarella.setCalorie(100);
        mozzarella.setPrezzo(2);
        return mozzarella;
    }

    @Bean("pomodoro")
    public Topping pomodoro(){
        Topping pomodoro = new Topping();
        pomodoro.setNome("Pomodoro");
        pomodoro.setCalorie(100);
        pomodoro.setPrezzo(2);
        return pomodoro;
    }

    @Bean("salame")
    public Topping salame(){
        Topping salame = new Topping();
        salame.setNome("Salame");
        salame.setCalorie(200);
        salame.setPrezzo(1);
        return salame;
    }
    @Bean("prosciutto")
    public Topping prosciutto(){
        Topping prosciutto = new Topping();
        prosciutto.setNome("Prosciutto");
        prosciutto.setCalorie(200);
        prosciutto.setPrezzo(2);
        return prosciutto;
    }

    @Bean("margherita")
    @Scope("prototype")
    public Pizza margherita(){
        Pizza margherita = new Pizza();
        margherita.setNome("Pizza Margherita");
        margherita.setCalorie(mozzarella().getCalorie()+ pomodoro().getCalorie());
        margherita.setPrezzo(mozzarella().getPrezzo()+ pomodoro().getPrezzo());
        margherita.setToppings(List.of(pomodoro(),mozzarella()));
        return margherita;
    }

    @Bean("margheritaSalame")
    public Pizza margheritaSalame(){
        Pizza margheritaSalame = margherita();
        margheritaSalame.setNome("Pizza Margherita con salame");
        margheritaSalame.setCalorie(margheritaSalame.getCalorie()+ salame().getCalorie());
        margheritaSalame.setPrezzo(margheritaSalame.getPrezzo()+ salame().getPrezzo());
        List<Topping> toppings = List.of(mozzarella(), pomodoro(), salame());
        margheritaSalame.setToppings(toppings);
        return margheritaSalame;
    }
    @Bean("menu")
    public Menu menu(){
        Menu menu = new Menu();
        menu.setToppings(List.of(mozzarella(),pomodoro(),prosciutto(),salame()));
        menu.setDrinks(List.of(water(),cocaCola()));
        menu.setPizze(List.of(margherita(), margheritaSalame()));
        return menu;
    }


}
