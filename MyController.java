package com.underskywoker.spring.mvc.bank_system.controller;

import com.underskywoker.spring.mvc.bank_system.entity.Client;
import com.underskywoker.spring.mvc.bank_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/")
    public String showAllClients(Model model) {

        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);


        return "all-clients";
    }

    @RequestMapping("/addNewClient")
    public String addNewClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "client-info";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {

        clientService.saveClient(client);

        return "redirect:/";
    }

    @RequestMapping("/accountReplenishment")
    public String addMoney(@RequestParam("clientId") int id, Model model) {

        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "add-money";
    }
    @RequestMapping("/saveAddBill")
    public String saveAddBill(@ModelAttribute("client") Client client){
        int id = client.getId();
        int money = client.getBankAccount();
        clientService.accountReplenishment(id,money);

        return "redirect:/";
    }
    @RequestMapping("/withdraw")
    public String minusMoney(@RequestParam("clientId") int id, Model model) {

        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "minus-money";
    }
    @RequestMapping("/saveMinusBill")
    public String saveMinusBill(@ModelAttribute("client") Client client){
        int id = client.getId();
        int money = client.getBankAccount();
        clientService.withdraw(id,money);

        return "redirect:/";
    }

    @RequestMapping("/updateClient")
    public String updateClient(@RequestParam("clientId")int id, Model model) {

        Client client = clientService.getClient(id);
        model.addAttribute(client);
        return "client-info";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id){
        clientService.deleteClient(id);
        return "redirect:/";
    }



}
