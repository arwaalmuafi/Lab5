package com.example.lab5q3.Controller;

import com.example.lab5q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/lab5/vi/event")
public class EventController {
    ArrayList<Event> eventsList = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getEventsList() {
        return eventsList;
    }

    @PostMapping("/add")
    public ArrayList<Event> addEvent(@RequestBody Event event) {
        eventsList.add(event);
        return eventsList;
    }

    @PutMapping("/update/{index}")
    public String updateEvent(@PathVariable int index, @RequestBody Event event) {
        eventsList.set(index, event);

        return "event updated";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteEvent(@PathVariable int index) {
        eventsList.remove(index);
        return "event deleted";
    }

    @PutMapping("/change/{ID}/{Cap}")
    public ArrayList<Event> changeCap(@PathVariable String ID, @PathVariable int Cap) {
        for (Event event : eventsList) {
            if (event.getID().equals(ID)) {
                event.setCapacity(Cap);
            }
        }
        return eventsList;
    }

    @GetMapping("search/{ID}")
    public ArrayList<Event> search(@PathVariable String ID) {
        for (Event event : eventsList) {
            if (event.getID().equalsIgnoreCase(ID)) {
                return eventsList;
            }
        }
        return eventsList;
    }


}
