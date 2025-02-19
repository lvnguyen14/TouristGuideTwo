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

    @GetMapping("/")
    public String getAllTouristAttractions(Model model) {
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractions();
        model.addAttribute("touristAttractions", touristAttractions);
        return "index";
    }

    @GetMapping("/{name}")
    public String getTouristAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction touristAttraction = touristService.findTouristAttractionByName(name);
        if (touristAttraction != null) {
            model.addAttribute("touristAttraction", touristAttraction);
            return "touristAttractionDetail";
        } else {
            model.addAttribute("error", "Attraction not found");
            return "error";
        }
    }

    @GetMapping("/attractions/{name}/tags")
    public String getTouristAttractionByNameAndTags(@RequestParam String name, @RequestParam List<Tags> tags, Model model) {
        List<TouristAttraction> touristAttractions = touristService.findTouristAttractionByNameAndTags(name, tags);
        if (!touristAttractions.isEmpty()) {
            model.addAttribute("touristAttractions", touristAttractions);
            return "index";
        } else {
            model.addAttribute("error", "No attractions found with the specified tags");
            return "error";
        }
    }

    @GetMapping("/attractions/add")
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
    public String showEditForm(@PathVariable String name, Model model) {
        TouristAttraction touristAttraction = touristService.findTouristAttractionByName(name);
        if (touristAttraction != null) {
            model.addAttribute("touristAttraction", touristAttraction);
            return "editAttraction";
        } else {
            model.addAttribute("error", "Attraction not found");
            return "error";
        }
    }

    @PostMapping("/{name}/edit")
    public String editTouristAttraction(@PathVariable String name, @ModelAttribute TouristAttraction touristAttraction) {
        TouristAttraction updatedAttraction = touristService.updateTouristAttraction(touristAttraction);
        if (updatedAttraction != null) {
            return "redirect:/attractions/";
        } else {
            return "error";
        }
    }

    @PostMapping("/{name}/delete")
    public String deleteTouristAttraction(@PathVariable String name) {
        TouristAttraction deletedAttraction = touristService.deleteTouristAttraction(name);
        if (deletedAttraction != null) {
            return "redirect:/attractions/";
        } else {
            return "error";
        }
    }
}


