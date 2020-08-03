package com.euvic.carrental.services.interfaces;

import com.euvic.carrental.model.Model;
import com.euvic.carrental.model.Parking;
import com.euvic.carrental.responses.ModelDTO;
import com.euvic.carrental.responses.ParkingDTO;

import java.util.List;

public interface ModelServiceInterface {
    Model mapRestModel(Long id, ModelDTO modelDTO);

    Model getEntityByName(String name);

    Model getEntityById(Long id);

    ModelDTO getDTOByName(String name);

    Long addEntityToDB(Model model);

    List<ModelDTO> getAllDTOs();

    void updateModelInDb(Long oldModelId, ModelDTO newModelDTO);
}
