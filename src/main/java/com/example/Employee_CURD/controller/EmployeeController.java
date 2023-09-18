package com.example.Employee_CURD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Employee_CURD.domain.Employee;
import com.example.Employee_CURD.service.EmployeeService;

@Controller
public class EmployeeController {
    
     @Autowired
        private EmployeeService service;
     
        @GetMapping("/index")
        public String viewHomePage(Model model) {
            List<Employee> employeelist = service.listAll();
            model.addAttribute("employeelist", employeelist);
            System.out.print("Get / ");    
            return "index";
        }

        @GetMapping("/new")
        public String add(Model model) {
            model.addAttribute("employee", new Employee());
            return "new";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveEmployee(@ModelAttribute("employee") Employee std) {
            service.save(std);
            return "redirect:/";
        }

        @RequestMapping("/edit/{id}")
        public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("new");
            Employee std = service.get(id);
            mav.addObject("employee", std);
            return mav;
            
        }
        
        @RequestMapping("/delete/{id}")
        public String deleteemployee(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/";
        }
        
}