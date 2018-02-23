package com.tracker.controller;

import com.tracker.facade.TrackerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TrackerController {

    @Autowired
    private TrackerFacade trackerFacade;

    @RequestMapping("/")
    public String runIndex(){
        return trackerFacade.runHomePage();
    }

    @RequestMapping(value = "/comment")
    public String addComment(Model model, HttpServletRequest request){
        return trackerFacade.addNewComment(model, request);
    }

    @RequestMapping(value = "/ticket")
    public String editTicket(){
        return trackerFacade.editTicket();
    }

    @RequestMapping(value = "/registerUser")
    public String showRegisterTemplate(){
        return trackerFacade.showRegisterTemplate();
    }

    @RequestMapping(value = "/addUser")
    public String registerUser(HttpServletRequest request, @RequestParam String newUsername,String newPassword){
        return trackerFacade.addNewUser(request, newUsername, newPassword);
    }

    @RequestMapping(value = "/validation")
    public String validateUser(HttpServletRequest request, Model model, @RequestParam String username, String userPassword){
        return trackerFacade.validateUsernameAndPassword(request, model, username, userPassword);
    }

    @RequestMapping(value = "/ticketList")
    public String getTicketList(Model model){
        return trackerFacade.getListOfTickets(model);
    }

    @RequestMapping(value = "/ticketListAddTicket")
    public String getTicketListAddTicket(HttpServletRequest request, Model model, @RequestParam String status, String title, String description){
        return trackerFacade.getListOfTicketsAndNewTicket(request, model, status, title, description);
    }

    @RequestMapping(value = "/newTicket")
    public String addTicket(){
        return trackerFacade.addNewTicket();
    }
}
