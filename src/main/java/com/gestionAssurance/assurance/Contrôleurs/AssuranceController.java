package com.gestionAssurance.assurance.Contrôleurs;

import com.gestionAssurance.assurance.entities.Assurance;
import com.gestionAssurance.assurance.services.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AssuranceController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping("/add-insurance")
    public String showAddInsuranceForm(Model model) {
        model.addAttribute("insurance", new Assurance());
        return "add-insurance";
    }

    @PostMapping("/add-insurance")
    public String addInsurance(@ModelAttribute Assurance assurance) {
        assuranceService.save(assurance);
        return "redirect:/assurances";
    }

    @GetMapping("/assurances")
    public String viewAssurances(Model model) {
        List<Assurance> assurances = assuranceService.findAll();
        model.addAttribute("assurances", assurances);
        return "assurances";
    }

    @GetMapping("/edit-insurance/{id}")
    public String showEditInsuranceForm(@PathVariable Long id, Model model) {
        Assurance assurance = assuranceService.findById(id);
        if (assurance != null) {
            model.addAttribute("insurance", assurance);
            return "edit-insurance";
        } else {
            return "redirect:/assurances";
        }
    }

    @PostMapping("/edit-insurance/{id}")
    public String editInsurance(@PathVariable Long id, @ModelAttribute Assurance assurance) {
        assuranceService.update(assurance);
        return "redirect:/assurances";
    }

    @GetMapping("/delete-insurance/{id}")
    public String deleteInsurance(@PathVariable Long id) {
        assuranceService.delete(id);
        return "redirect:/assurances";
    }
}