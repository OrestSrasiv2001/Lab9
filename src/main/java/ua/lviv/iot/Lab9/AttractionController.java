package ua.lviv.iot.Lab9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.Lab9.Attraction;

import java.util.List;

@RestController
 class AttractionController {
    @Autowired
    private AttractionRepocitoriy attractionRepocitoriy;

    @RequestMapping(value = "/attraction", method = RequestMethod.GET)
    public List<Attraction> getAttractionVisitors() {
        return (List<Attraction>) attractionRepocitoriy.findAll();
    }

    @RequestMapping(value = "/attraction/{id}", method = RequestMethod.GET)
    public Attraction getAttractionVisitors(@PathVariable Integer id) {
        return attractionRepocitoriy.findById(id).get();
    }

    @RequestMapping(value = "/attraction/{id}", method = RequestMethod.PUT)
    public Attraction replaceAttraction(@RequestBody Attraction newAttraction, @PathVariable Integer id) {
        return attractionRepocitoriy.findById(id)
                .map( attraction-> {
                    attraction.setPriceOfTicket(newAttraction.getPriceOfTicket());
                    attraction.setMaxNumberOfVisitors(newAttraction.getMaxNumberOfVisitors());
                    attraction.setDangerLevel(newAttraction.getDangerLevel());
                    return attractionRepocitoriy.save(attraction);
                }).orElseGet(() -> {
                    newAttraction.setId(id);
                    return attractionRepocitoriy.save(newAttraction);
                });
    }

    @RequestMapping(value = "/attraction", method = RequestMethod.POST)
    public Attraction postAttractionVisitors(@RequestBody Attraction attraction) {
        return attractionRepocitoriy.save(attraction);
    }

    @RequestMapping(value = "/stationary/{id}", method = RequestMethod.DELETE)
    public Attraction deleteEquity(@PathVariable Integer id) {
        Attraction temp = getAttractionVisitors(id);
        attractionRepocitoriy.deleteById(id);
        return temp;
    }
}