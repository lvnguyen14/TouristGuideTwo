package com.example.touristguidetwo.controller;

import com.example.touristguidetwo.model.Tags;
import com.example.touristguidetwo.model.TouristAttraction;
import com.example.touristguidetwo.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService){

        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAllTouristAttractions(Model model) {
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractions();
        model.addAttribute("touristAttractions", touristAttractions);
        return "attractionList";
    }

    @GetMapping("/{name}")
    public String getTouristAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction touristAttraction = touristService.findTouristAttractionByName(name);
            model.addAttribute("touristAttraction", touristAttraction);
            return "touristAttractionDetail";
    }

    @GetMapping("/{name}/tags")
    public String getTouristAttractionByNameAndTags(@RequestParam String name, @RequestParam List<Tags> tags, Model model) {
        List<TouristAttraction> touristAttractions = touristService.findTouristAttractionByNameAndTags(name, tags);
            model.addAttribute("touristAttractions", touristAttractions);
            return "attractionList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("touristAttraction", new TouristAttraction());
        return "addAttraction";
    }

    @PostMapping("/add")
    public String addTouristAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.addTouristAttraction(touristAttraction);
        return "redirect:/attractions/";
    }

    @GetMapping("/{name}/edit")
    public String editTouristAttraction(@PathVariable String name, Model model) {
        TouristAttraction touristAttraction = touristService.findTouristAttractionByName(name);
            model.addAttribute("touristAttraction", touristAttraction);
            return "editAttraction";
        }

    @PostMapping("/edit")
    public String updateTouristAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.updateTouristAttraction(touristAttraction);
            return "redirect:/attractions/";
    }

    @PostMapping("/delete/{name}")
    public String deleteTouristAttraction(@PathVariable String name) {
        touristService.deleteTouristAttraction(name);
            return "redirect:/attractions/";
    }
}


