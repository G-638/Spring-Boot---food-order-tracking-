package com.example.demo.controller;

import com.example.demo.model.FoodItems;
import com.example.demo.model.FoodModel;
import com.example.demo.model.TableOrder;
import com.example.demo.service.TableOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    @Autowired
    TableOrderService tableOrderService;

    @RequestMapping("/signup")
    String singUp(){
        return "redirect:/api/foodorder/signup";
    }

    @GetMapping("/products/{table}")
    String products(@PathVariable("table") String tableid, Model model){
        List<FoodItems> foods =   tableOrderService.findAllTableData();
        LinkedHashSet<FoodItems> foodCart  = new LinkedHashSet<>();
        ArrayList<TableOrder> order =  tableOrderService.findByTableId(tableid);
        int total =0;
//        For future reference,
//        AtomicInteger total= new AtomicInteger(0);
        order.forEach(
                it -> {
                    foods.forEach(
                            foodItems -> {
                                if(it.getUid().equals(foodItems.getUid())){
                                    foodItems.setQty(it.getQty());
                                    foodCart.add(foodItems);
//      For future reference,
//      total.addAndGet(foodItems.getQty() * foodItems.getPrice());
                                }
                            }
                    );
                }
        );

        foods.forEach(
                it -> {
                    foods.forEach(
                            foodItems -> {
                                if(it.getUid().equals(foodItems.getUid())){
                                    foodItems.setQty(it.getQty());
                                }
                            }
                    );
                }
        );

        for (FoodItems data: foodCart){
            total += data.getPrice() * data.getQty() ;
        }
    System.out.println(foodCart);
    System.out.println(total);

        model.addAttribute("foodList", foods);
        model.addAttribute("mtotal", total);
        model.addAttribute("cartList", foodCart);
        model.addAttribute("id", tableid);
        return "tableDetail";
    }

    @GetMapping({"/homepage","/"})
    String homePage(Model model){
        model.addAttribute("foodList", tableOrderService.findAllTableData());
        model.addAttribute("tables", tableOrderService.getOrderedTableId());
        return "homepage";
    }

    @RequestMapping("/reset/{table}")
    String reset(@PathVariable("table") String tableId, Model model){
        tableOrderService.resetTableById(tableId);
        return "redirect:/homepage";
    }

    @PostMapping("/additem/{table}")
    String addItemToCart(@PathVariable("table") String tableId, @ModelAttribute FoodModel data, Model model){
        tableOrderService.resetTableById(tableId);
        System.out.println(data.getData());
        System.out.println("TableId : " + tableId);
        String[] unParsed = data.getData().split(",");

        try {
            for (String i : unParsed) {
                String[] splitted = i.split("//");
                String key = i.split("//")[0];
                System.out.println(key);
                String value = "0";
                if(splitted.length > 1){
                    value = i.split("//")[1];
                }
                int qty = Integer.parseInt(value);
                TableOrder tableOrder = new TableOrder();
                tableOrder.setTableId(tableId);
                tableOrder.setQty(qty);
                tableOrder.setUid(key);
                tableOrderService.saveData(tableOrder);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/products/" + tableId;
    }

    private Date getDateTime(){
        return Calendar.getInstance().getTime();
    }

}
