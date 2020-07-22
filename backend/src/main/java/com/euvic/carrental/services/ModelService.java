package com.euvic.carrental.services;

import com.euvic.carrental.model.Mark;
import com.euvic.carrental.model.Model;
import com.euvic.carrental.repositories.ModelRepository;
import com.euvic.carrental.responses.MarkDTO;
import com.euvic.carrental.responses.ModelDTO;
import com.euvic.carrental.services.interfaces.ModelServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService implements ModelServiceInterface {

    final ModelRepository modelRepository;
    final MarkService markService;

    public ModelService(ModelRepository modelRepository, MarkService markService) {
        this.modelRepository = modelRepository;
        this.markService = markService;
    }

    @Override
    public Model mapRestModel(ModelDTO modelDTO) {
        return new Model(null, modelDTO.getName(), markService.getEntityByName(modelDTO.getMarkDTO().getName()));
    }

    @Override
    public Model getEntityByName(String name) {
        return modelRepository.findByName(name);
    }

    @Override
    public ModelDTO getDTOByName(String name) {
        final Model model = modelRepository.findByName(name);
        Mark modelMark = model.getMark();
        return new ModelDTO(model.getName(), markService.getDTOByName(modelMark.getName()));
    }

    @Override
    public List<ModelDTO> getAll() {
        final ArrayList<Model> modelList = new ArrayList<>();
        modelRepository.findAll().forEach(modelList::add);

        final ArrayList<ModelDTO> modelDTOList = new ArrayList<>();
        modelList.stream().forEach((model) ->{
            ModelDTO modelDTO = new ModelDTO(model.getName(), new MarkDTO(model.getMark().getName()));
            modelDTOList.add(modelDTO);
        });

        return modelDTOList;
    }

    @Override
    public void addModelToDatabase(ModelDTO modelDTO) {
        modelRepository.save(mapRestModel(modelDTO));
    }
}
