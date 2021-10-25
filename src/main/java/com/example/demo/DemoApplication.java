package com.example.demo;

import com.example.demo.model.FoodList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

//
//	static void addFoodItem(){
//		String randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Curd Rice", "Rice with curd fried", 75, 0, randomId));
//		randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Plain Rice", "plain rice with sambar etc.,", 50, 0, randomId));
//		randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Gobi Rice", "Rice with gobi fried", 70, 0, randomId));
//		randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Veg Combo", "Vegetable rice", 60, 0, randomId));
//		randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Panneer Rice", "Fried rice with panneer", 80, 0, randomId));
//		randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Mushroom Rice", "Fried rice with Mushroom", 80, 0, randomId));
//		randomId = getUniqueId();
//		foodList.put(randomId, new FoodList("Chicken Rice", "Fried rice with Chicken", 90, 0, randomId));
//	}
	public static void main(String[] args) {
//		addFoodItem();
		SpringApplication.run(DemoApplication.class, args);
	}

	public static String getUniqueId(){
		return UUID.randomUUID().toString();
	}
}
