package com.josval.backend.controller.mapper;

import com.josval.backend.model.dto.MedicalHistoryDTO;
import com.josval.backend.model.entity.MedicalHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {
    MedicalHistoryDTO toMedicalHistoryDto(MedicalHistory medicalHistory);
    MedicalHistory toMedicalHistory(MedicalHistoryDTO medicalHistoryDTO);

    //@Mapping(target = "id", ignore = true)
    //UserDTO createUserDTOWithoutId(User user);
}
