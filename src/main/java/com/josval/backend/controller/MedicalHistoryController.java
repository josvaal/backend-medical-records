package com.josval.backend.controller;

import com.josval.backend.controller.mapper.AppointmentMapper;
import com.josval.backend.controller.mapper.MedicalHistoryMapper;
import com.josval.backend.model.dto.AppointmentDTO;
import com.josval.backend.model.dto.MedicalHistoryDTO;
import com.josval.backend.model.entity.Appointment;
import com.josval.backend.model.entity.MedicalHistory;
import com.josval.backend.model.payload.MessageResponse;
import com.josval.backend.service.IAppointmentService;
import com.josval.backend.service.IMedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MedicalHistoryController {
  @Autowired
  private MedicalHistoryMapper medicalHistoryMapper;

  @Autowired
  private IMedicalHistoryService medicalHistoryService;

  @GetMapping("medical_histories")
  public ResponseEntity<?> showAll() {
    List<MedicalHistory> getMedicalHistories = medicalHistoryService.listAll();
    if (getMedicalHistories == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getMedicalHistories)
        .build(),
        HttpStatus.OK
    );
  }

  @GetMapping("medical_histories/doctor/{id}")
  public ResponseEntity<?> showAllByDoctorId(@PathVariable Integer id) {
    List<MedicalHistory> getMedicalHistories = medicalHistoryService.listAllByDoctorId(id);
    if (getMedicalHistories == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getMedicalHistories)
        .build(),
        HttpStatus.OK
    );
  }

  @GetMapping("medical_histories/patient/{id}")
  public ResponseEntity<?> showAllByPatientId(@PathVariable Integer id) {
    List<MedicalHistory> getMedicalHistories = medicalHistoryService.listAllByPatientId(id);
    if (getMedicalHistories == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getMedicalHistories)
        .build(),
        HttpStatus.OK
    );
  }

  @PostMapping("medical_history")
  public ResponseEntity<?> create(@RequestBody MedicalHistoryDTO medicalHistoryDTO){
    try {
      MedicalHistory medicalHistorySave = medicalHistoryService.save(medicalHistoryDTO);
      return new ResponseEntity<>(MessageResponse.builder()
          .message("Save successfully")
          .object(medicalHistoryMapper.toMedicalHistoryDto(medicalHistorySave))
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

  @PatchMapping("medical_history")
  public ResponseEntity<?> update(@RequestBody MedicalHistoryDTO medicalHistoryDTO){
    try {
      if(!(medicalHistoryService.existsById(medicalHistoryDTO.getId()))){
        return new ResponseEntity<>(MessageResponse.builder()
            .message("This user was not found")
            .object(null)
            .build(),
            HttpStatus.NOT_FOUND
        );
      }
      MedicalHistory medicalHistoryUpdate = medicalHistoryService.save(medicalHistoryDTO);
      return new ResponseEntity<>(MessageResponse.builder()
          .message("Update successfully")
          .object(medicalHistoryMapper.toMedicalHistoryDto(medicalHistoryUpdate))
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

  @DeleteMapping("medical_history/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    try {
      MedicalHistory medicalHistoryDelete = medicalHistoryService.findById(id);
      medicalHistoryService.delete(medicalHistoryDelete);
      return new ResponseEntity<>(medicalHistoryDelete, HttpStatus.NO_CONTENT);
    } catch (DataAccessException e) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message(e.getMessage())
          .object(null)
          .build(),
          HttpStatus.METHOD_NOT_ALLOWED
      );
    }
  }

  @GetMapping("medical_history/{id}")
  public ResponseEntity<?> showById(@PathVariable Integer id){
    MedicalHistory medicalHistory = medicalHistoryService.findById(id);
    if(medicalHistory == null){
      return new ResponseEntity<>(MessageResponse.builder()
          .message("This user was not found")
          .object(null)
          .build(),
          HttpStatus.NOT_FOUND
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(medicalHistoryMapper.toMedicalHistoryDto(medicalHistory))
        .build(),
        HttpStatus.OK
    );
  }
}
