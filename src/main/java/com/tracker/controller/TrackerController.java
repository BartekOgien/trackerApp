package com.tracker.controller;

import com.tracker.facade.TrackerFacade;
import com.tracker.repository.TicketDao;
import com.tracker.repository.UserDao;
import com.tracker.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackerController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TrackerFacade trackerFacade;

    @RequestMapping("/")
    public String runIndex(){
        return trackerFacade.runHomePage();
    }

    @RequestMapping(value = "/comment")
    public String addComment(){
        return trackerFacade.addNewComment();
    }

    @RequestMapping(value = "/ticket")
    public String editTicket(){
        return trackerFacade.editTicket();
    }

    @RequestMapping(value = "/validation")
    public String validateUser(Model model, @RequestParam String username,String userPassword){
        return trackerFacade.validateUsernameAndPassword(model, username, userPassword);
    }

    @RequestMapping(value = "/ticketList")
    public String getTicketList(Model model){
        return trackerFacade.getListOfTickets(model);
    }

    @RequestMapping(value = "/ticketListAddTicket")
    public String getTicketListAddTicket(Model model, @RequestParam String status, String title, String description){
        return trackerFacade.getListOfTicketsAndNewTicket(model, status, title, description);
    }

    @RequestMapping(value = "/newTicket")
    public String addTicket(){
        return trackerFacade.addNewTicket();
    }
}