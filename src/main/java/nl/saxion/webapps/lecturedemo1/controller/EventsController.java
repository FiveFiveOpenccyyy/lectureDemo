package nl.saxion.webapps.lecturedemo1.controller;

import nl.saxion.webapps.lecturedemo1.moduls.Event;
import nl.saxion.webapps.lecturedemo1.dataProvider.EventsDataProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class EventsController {

    @GetMapping(path = "/events")
    public String Events(Model model){
        model.addAttribute("events", EventsDataProvider.getEvents());
        return "Events";
    }



    @PostMapping("/addEvent")
    @ResponseBody
    public ResponseEntity<Event> addEvent(Event events) {
        EventsDataProvider.addEvent(events);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/hello/events");
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }



}
