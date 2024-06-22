package com.uep.wap.controller;

import com.uep.wap.dto.BoardDTO;
import com.uep.wap.dto.InteractionDTO;
import com.uep.wap.model.Interaction;
import com.uep.wap.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class InteractionController {
    private final InteractionService interactionService;

    @Autowired
    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }
    @PostMapping(path = "/interactions")
    public String addInteraction(@RequestBody InteractionDTO interactionDTO) {
        interactionService.addInteraction(interactionDTO);
        return "Interaction added successfully";
    }

    @PutMapping(path = "/interactions/{interaction_id}")
    public String editInteraction(@PathVariable int interaction_id, @RequestBody InteractionDTO interactionDTO) {
        interactionService.editInteraction(interaction_id, interactionDTO);
        return "interaction edited yipieee!";
    }
    @GetMapping(path = "/interactions")
    public Iterable<Interaction> getAllInteractions() {
        return interactionService.getAllInteractions();
    }

    @GetMapping(path="/interactions/{id}")
    public Optional<Interaction> getInteractionById(@PathVariable int id) {
        return interactionService.getInteractionById(id);
    }

    @DeleteMapping(path = "/interactions/{id}")
    public String deleteInteractionById(@PathVariable int id) {
        interactionService.deleteInteractionById(id);
        return "Interaction deleted successfully";
    }

    @GetMapping(path="/interactions/type/{type}")
    public Iterable<Interaction> findInteractionsByType(@PathVariable String type) {
        return interactionService.findInteractionsByType(type);
    }

    @GetMapping(path="/interactions/target/{targetID}")
    public Iterable<Interaction> findInteractionsByTargetID(@PathVariable int targetID) {
        return interactionService.findInteractionsByTargetID(targetID);
    }

}
