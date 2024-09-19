package com.josval.backend.controller.mapper;

import com.josval.backend.model.dto.PrescriptionDTO;
import com.josval.backend.model.entity.Prescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {
    PrescriptionDTO toPrescriptionDto(Prescription prescription);
    Prescription toPrescription(PrescriptionDTO prescriptionDTO);

    //@Mapping(target = "id", ignore = true)
    //UserDTO createUserDTOWithoutId(User user);
}
