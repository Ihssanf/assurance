package com.gestion.assurance.contrôleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;

import com.gestion.assurance.entities.Client;
import com.gestion.assurance.entities.Contrat;
import com.gestion.assurance.entities.Assurance;
import com.gestion.assurance.services.ClientService;
import com.gestion.assurance.services.ContratService;
import com.gestion.assurance.services.AssuranceService;

import java.util.List;

@Controller
public class ContractController {

    @Autowired
    private ContratService contratService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping("/add-contract")
    public String showAddContractForm(Model model) {
        model.addAttribute("contract", new Contrat());
        List<Client> clients = clientService.findAll();
        List<Assurance> assurances = assuranceService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("assurances", assurances);
        return "add-contract";
    }

    @PostMapping("/add-contract")
    public String addContract(@Validated @ModelAttribute Contrat contrat, Model model) {


        // Assuming you have a client ID and an assurance ID in the form data
        Long clientId = contrat.getClient().getId();
        Long assuranceId = contrat.getAssurance().getId();

        // Get the client and assurance objects
        Client client = clientService.findById(clientId);
        Assurance assurance = assuranceService.findById(assuranceId);

        // Set the client and assurance objects in the Contrat object
        contrat.setClient(client);
        contrat.setAssurance(assurance);

        contratService.save(contrat);
        return "redirect:/contracts";
    }

    @GetMapping("/contracts")
    public String viewContracts(Model model) {
        List<Contrat> contrats = contratService.findAll();
        model.addAttribute("contrats", contrats);
        return "contracts";
    }

    @GetMapping("/edit-contract/{id}")
    public String showEditContractForm(@PathVariable Long id, Model model) {
        Contrat contrat = contratService.findById(id);
        if (contrat != null) {
            model.addAttribute("contract", contrat);
            List<Client> clients = clientService.findAll();
            List<Assurance> assurances = assuranceService.findAll();
            model.addAttribute("clients", clients);
            model.addAttribute("assurances", assurances);
            return "edit-contract";
        } else {
            return "redirect:/contracts";
        }
    }

    @PostMapping("/edit-contract/{id}")
    public String editContract(@PathVariable Long id, @Validated @ModelAttribute Contrat contrat,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Get all clients and assurances for the dropdown menus
            List<Client> clients = clientService.findAll();
            List<Assurance> assurances = assuranceService.findAll();
            model.addAttribute("clients", clients);
            model.addAttribute("assurances", assurances);
            return "edit-contract"; // Return the edit-contract view with validation errors
        }

        // Assuming you have a client ID and an assurance ID in the form data
        Long clientId = contrat.getClient().getId();
        Long assuranceId = contrat.getAssurance().getId();

        // Get the client and assurance objects
        Client client = clientService.findById(clientId);
        Assurance assurance = assuranceService.findById(assuranceId);

        // Set the client and assurance objects in the Contrat object
        contrat.setClient(client);
        contrat.setAssurance(assurance);

        contratService.update(contrat);
        return "redirect:/contracts";
    }

    @GetMapping("/delete-contract/{id}")
    public String deleteContract(@PathVariable Long id) {
        contratService.delete(id);
        return "redirect:/contracts";
    }


}