package com.uep.wap.service;

import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.dto.InteractionDTO;
import com.uep.wap.model.Category;
import com.uep.wap.model.Interaction;
import com.uep.wap.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InteractionService {
    @Autowired
    private InteractionRepository interactionRepository;

    public InteractionService(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    public void addInteraction(InteractionDTO interactionDTO) {
        Interaction interaction = convertDTOToInteraction(interactionDTO);
        interactionRepository.save(interaction);
    }

    public void editInteraction(int interaction_id, InteractionDTO interactionDTO) {
        Interaction interaction = interactionRepository.findById(interaction_id).get();
        interactionRepository.save(interaction);
    }

    private Interaction convertDTOToInteraction(InteractionDTO dto) {
        Interaction interaction = new Interaction();
        interaction.setTargetID(dto.getTargetID());
        interaction.setType(dto.getType());
        interaction.setTimestamp(dto.getTimestamp());
        return interaction;
    }

    public Iterable<Interaction> getAllInteractions() {return interactionRepository.findAll();}
    public Optional<Interaction> getInteractionById(int id) {return interactionRepository.findById(id);}
    public void deleteInteractionById(int id) {interactionRepository.deleteById(id);}
    public Iterable<Interaction> findInteractionsByType(String type) {return interactionRepository.findByType(type);}
    public Iterable<Interaction> findInteractionsByTargetID(int targetID) {return interactionRepository.findByTargetID(targetID);}
}
