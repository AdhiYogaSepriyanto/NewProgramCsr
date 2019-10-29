package com.example.ProgramCsr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ProgramCsr.Tblprogramcsr;



@Controller
public class AppController {
 
    @Autowired
    private ProgramCsrService service;
     
    // handler methods...    
    @RequestMapping("/")
    public String viewFrontPage(Model model) {         
        return "front";
    }
    
    
    @RequestMapping("/list")
    public String viewHomePage(Model model) {
        List<Tblprogramcsr> listCsr = service.listAll();
        model.addAttribute("listCsrs", listCsr);
         
        return "list";
    }
    
    
    @RequestMapping("/new")
    public String showNewcsrPage(Model model) {
    	Tblprogramcsr tblprogramcsr = new Tblprogramcsr();
        model.addAttribute("tblprogramcsr", tblprogramcsr);
         
        return "add";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCsr(@ModelAttribute("tblprogramcsr") Tblprogramcsr tblprogramcsr) {
        service.save(tblprogramcsr);
         
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savecsr(@ModelAttribute("tblprogramcsr") Tblprogramcsr tblprogramcsr) {
        service.save(tblprogramcsr);
         
        return "redirect:/list";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditfitnessPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Tblprogramcsr tblprogramcsr = service.get(id);
        mav.addObject("tblprogramcsr", tblprogramcsr);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deletecsr(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/list";       
    }
}
