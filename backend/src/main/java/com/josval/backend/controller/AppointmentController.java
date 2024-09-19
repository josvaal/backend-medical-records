package com.josval.backend.controller;

import com.josval.backend.controller.mapper.AppointmentMapper;
import com.josval.backend.model.dto.AppointmentDTO;
import com.josval.backend.model.entity.Appointment;
import com.josval.backend.model.payload.MessageResponse;
import com.josval.backend.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
  @Autowired
  private AppointmentMapper appointmentMapper;

  @Autowired
  private IAppointmentService appointmentService;

  @GetMapping("appointments")
  public ResponseEntity<?> showAll() {
    List<Appointment> getAppointments = appointmentService.listAll();
    if (getAppointments == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getAppointments)
        .build(),
        HttpStatus.OK
    );
  }

  @GetMapping("appointments/patient/{id}")
  public ResponseEntity<?> showAllByPatientId(@PathVariable Integer id) {
    List<Appointment> getAppointments = appointmentService.listAllByPatientId(id);
    if (getAppointments == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getAppointments)
        .build(),
        HttpStatus.OK
    );
  }

  @GetMapping("appointments/doctor/{id}")
  public ResponseEntity<?> showAllByDoctorId(@PathVariable Integer id) {
    List<Appointment> getAppointments = appointmentService.listAllByDoctorId(id);
    if (getAppointments == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getAppointments)
        .build(),
        HttpStatus.OK
    );
  }

  @PostMapping("appointment")
  public ResponseEntity<?> create(@RequestBody AppointmentDTO appointmentDTO){
    try {
      Appointment appointmentSave = appointmentService.save(appointmentDTO);
      return new ResponseEntity<>(MessageResponse.builder()
          .message("Save successfully")
          .object(appointmentMapper.toAppointmentDTO(appointmentSave))
          .build(),
          HttpStatus.CREATED
      );
    }catch (DataAccessException e){
      return new ResponseEntity<>(MessageResponse.builder()
          .message(e.getMessage())
          .object(null)
          .build(),
          HttpStatus.METHOD_NOT_ALLOWED
      );
    }
  }

  @PatchMapping("appointment")
  public ResponseEntity<?> update(@RequestBody AppointmentDTO appointmentDTO){
    try {
      if(!(appointmentService.existsById(appointmentDTO.getId()))){
        return new ResponseEntity<>(MessageResponse.builder()
            .message("This user was not found")
            .object(null)
            .build(),
            HttpStatus.NOT_FOUND
        );
      }
      Appointment appointmentUpdate = appointmentService.save(appointmentDTO);
      return new ResponseEntity<>(MessageResponse.builder()
          .message("Update successfully")
          .object(appointmentMapper.toAppointmentDTO(appointmentUpdate))
          .build(),
          HttpStatus.CREATED
      );
    } catch (DataAccessException e) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message(e.getMessage())
          .object(null)
          .build(),
          HttpStatus.METHOD_NOT_ALLOWED
      );
    }
  }

  @DeleteMapping("appointment/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    try {
      Appointment appointmentDelete = appointmentService.findById(id);
      appointmentService.delete(appointmentDelete);
      return new ResponseEntity<>(appointmentDelete, HttpStatus.NO_CONTENT);
    } catch (DataAccessException e) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message(e.getMessage())
          .object(null)
          .build(),
          HttpStatus.METHOD_NOT_ALLOWED
      );
    }
  }

  @GetMapping("appointment/{id}")
  public ResponseEntity<?> showById(@PathVariable Integer id){
    Appointment appointment = appointmentService.findById(id);
    if(appointment == null){
      return new ResponseEntity<>(MessageResponse.builder()
          .message("This user was not found")
          .object(null)
          .build(),
          HttpStatus.NOT_FOUND
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(appointmentMapper.toAppointmentDTO(appointment))
        .build(),
        HttpStatus.OK
    );
  }
}
