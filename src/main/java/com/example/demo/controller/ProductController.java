package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BranchService;
import com.example.demo.service.TableOrderService;
import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    @Autowired
    TableOrderService tableOrderService;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    BranchService branchService;

    @RequestMapping("/signup")
    String singUp(){
        return "redirect:/api/foodorder/signup";
    }

    @GetMapping("/table/{branch}")
    String branchTable(@PathVariable("branch") String branch, Model model) {
        model.addAttribute("foodList", tableOrderService.findAllTableData());
        model.addAttribute("tables", tableOrderService.getOrderedTableId(branch));
        model.addAttribute("branch",branch);
        User user =  userDetailService.getUserData();
        model.addAttribute("role",user.getRole());
        if(user.getRole().equals("manager")){
            int i,j=0;
            ArrayList<Branch> b;
            String[] getBranch = user.getBranch().split(",");

            model.addAttribute("branch1",getBranch[0]);
            model.addAttribute("branch2",getBranch[1]);
            String[] name = new String[getBranch.length];
            for(i=0;i<getBranch.length;i++){
                b = branchService.findBranchData(getBranch[i]);
                for (Branch data: b){
                    name[j] = data.getBranchName();
                    System.out.println(name[j]);
                    j++;
                }
            }
            model.addAttribute("branchA", name[0]);
            model.addAttribute("branchB", name[1]);
        }
        return "homepage";
    }

    @GetMapping("/branch/{branch}")
    String branch(@PathVariable("branch") String branch, Model model) {
        ArrayList<Branch> b,b1;
        b = branchService.findBranchData(branch);
        model.addAttribute("branchDetails",b );

        int i,j=0;
        User user =  userDetailService.getUserData();
        String[] userBranch = user.getBranch().split(",");
        String[] name = new String[userBranch.length];
        for(i=0;i<userBranch.length;i++){
            b = branchService.findBranchData(userBranch[i]);
            for (Branch data: b){
                name[j] = data.getBranchName();
                System.out.println(name[j]);
                j++;
            }
        }
        b1 = branchService.findBranchData(branch);
        model.addAttribute("branchData",b1);
        model.addAttribute("branch1",userBranch[0]);
        model.addAttribute("branch2",userBranch[1]);

        model.addAttribute("branchA", name[0]);
        model.addAttribute("branchB", name[1]);

        model.addAttribute("userData",userDetailService.getUserData(branch));
        return "managerhomepage";
    }

    @GetMapping("/products/{branch}/{table}")
    String products(@PathVariable("table") String tableid, @PathVariable("branch") String branch, Model model){
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
        model.addAttribute("branch",branch);

        User user =  userDetailService.getUserData();
        model.addAttribute("role",user.getRole());
        if(user.getRole().equals("manager")){
            int i,j=0;
            ArrayList<Branch> b;
            String[] getBranch = user.getBranch().split(",");
            model.addAttribute("branch1",getBranch[0]);
            model.addAttribute("branch2",getBranch[1]);
            String[] name = new String[getBranch.length];
            for(i=0;i<getBranch.length;i++){
                b = branchService.findBranchData(getBranch[i]);
                for (Branch data: b){
                    name[j] = data.getBranchName();
                    System.out.println(name[j]);
                    j++;
                }
            }
            model.addAttribute("branchA", name[0]);
            model.addAttribute("branchB", name[1]);
        }
        return "tableDetail";
    }

    @GetMapping({"/homepage","/"})
    String homePage(Model model){
        User user =  userDetailService.getUserData();
        System.out.println(user.getBranch());
        System.out.println(user.getRole());
        String role = user.getRole();

        model.addAttribute("foodList", tableOrderService.findAllTableData());
        model.addAttribute("tables", tableOrderService.getOrderedTableId(user.getBranch()));
        model.addAttribute("branch",user.getBranch());
        model.addAttribute("role",user.getRole());
        if(role.equals("manager")){
            int i,j=0;
            String[] branch = user.getBranch().split(",");

            model.addAttribute("branch1",branch[0]);
            model.addAttribute("branch2",branch[1]);
            ArrayList<Branch> b = null,b1;
            String[] name = new String[branch.length];
            for(i=0;i<branch.length;i++){
                b = branchService.findBranchData(branch[i]);
                for (Branch data: b){
                     name[j] = data.getBranchName();
                     System.out.println(name[j]);
                     j++;
                }
            }
            b1 = branchService.findBranchData(branch[0]);
            model.addAttribute("branchData",b1);
            model.addAttribute("branchA", name[0]);
            model.addAttribute("branchB", name[1]);
            model.addAttribute("userData",userDetailService.getUserData(branch[0]));
            return "managerhomepage";
        }

        return "homepage";
    }

    @RequestMapping("/reset/{table}")
    String reset(@PathVariable("table") String tableId, Model model){
        tableOrderService.resetTableById(tableId);
        return "redirect:/homepage";
    }

    @PostMapping("/additem/{branch}/{table}")
    String addItemToCart(@PathVariable("table") String tableId, @PathVariable("branch") String branch, @ModelAttribute FoodModel data, Model model){
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
//                User user = userDetailService.getUserData();
                tableOrder.setBranch(branch);
                tableOrderService.saveData(tableOrder);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/products/"+branch+"/"+ tableId;
    }

    private Date getDateTime(){
        return Calendar.getInstance().getTime();
    }

}
