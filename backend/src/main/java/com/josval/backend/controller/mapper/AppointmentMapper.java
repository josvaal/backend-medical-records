package com.josval.backend.controller.mapper;

import com.josval.backend.model.dto.AppointmentDTO;
import com.josval.backend.model.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentDTO toAppointmentDTO(Appointment appointment);
    Appointment toAppointment(AppointmentDTO appointmentDTO);

    //@Mapping(target = "id", ignore = true)
    //UserDTO createUserDTOWithoutId(User user);
}
