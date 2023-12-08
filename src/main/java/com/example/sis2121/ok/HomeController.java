package com.example.sis2121.ok;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @PostMapping(value = "gradeResult")
    public String calculateGrade(@RequestParam("midterm") double midterm,
                                 @RequestParam("endterm") double endterm, Model model) {
        double totalGrade = (((((midterm + endterm)/2)*0.6)-70)/0.4)*-1;

        if(totalGrade>100){
            totalGrade=0;
        } else if (totalGrade<50) {
            totalGrade=50;
        }
        model.addAttribute("totalGrade", totalGrade);

        return "gradeResult";

    }
}