package com.dulal.fizzbuzz_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<String> a1;

    @GetMapping("/")
    public String fizzBuzzForm(Model model) {
        model.addAttribute("nums", new FBNumbers());
        return "form";

    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute("nums") FBNumbers nums, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        model.addAttribute("myres", result(nums.getStart(),nums.getEnd()));
        return "display";
    }


    //This will return an array list
    public static ArrayList<String> result(int start, int end) {

        ArrayList<String> a1 = new ArrayList<>();

        if(start>end){
            int temp=start;
            start=end;
            end=temp;
        }

        for (int i = start; i <= end; i++) {

            if ((i % 3 == 0) && (i % 5 == 0)) {
                a1.add("FizzBuzz");
            } else if (i % 5 == 0) {
                a1.add("Buzz");
            } else if (i % 3 == 0) {
                a1.add("Fizz");
            } else {
                a1.add(String.valueOf(i));
            }
        }
        return a1;

    }
}