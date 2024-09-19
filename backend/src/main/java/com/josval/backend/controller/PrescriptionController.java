package com.josval.backend.controller;

import com.josval.backend.controller.mapper.AppointmentMapper;
import com.josval.backend.controller.mapper.PrescriptionMapper;
import com.josval.backend.model.dto.AppointmentDTO;
import com.josval.backend.model.dto.PrescriptionDTO;
import com.josval.backend.model.entity.Appointment;
import com.josval.backend.model.entity.MedicalHistory;
import com.josval.backend.model.entity.Prescription;
import com.josval.backend.model.payload.MessageResponse;
import com.josval.backend.service.IAppointmentService;
import com.josval.backend.service.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PrescriptionController {
  @Autowired
  private PrescriptionMapper prescriptionMapper;

  @Autowired
  private IPrescriptionService prescriptionService;

  @GetMapping("prescriptions")
  public ResponseEntity<?> showAll() {
    List<Prescription> getPrescriptions = prescriptionService.listAll();
    if (getPrescriptions == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getPrescriptions)
        .build(),
        HttpStatus.OK
    );
  }

  @GetMapping("prescriptions/medical_history/{id}")
  public ResponseEntity<?> showAllByMedicalHistoryId(@PathVariable Integer id) {
    List<Prescription> getPrescriptions = prescriptionService.listAllByMedicalHistoryId(id);
    if (getPrescriptions == null) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message("No records found")
          .object(null)
          .build(),
          HttpStatus.OK
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(getPrescriptions)
        .build(),
        HttpStatus.OK
    );
  }

  @PostMapping("prescription")
  public ResponseEntity<?> create(@RequestBody PrescriptionDTO prescriptionDTO){
    try {
      Prescription prescriptionSave = prescriptionService.save(prescriptionDTO);
      return new ResponseEntity<>(MessageResponse.builder()
          .message("Save successfully")
          .object(prescriptionMapper.toPrescriptionDto(prescriptionSave))
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

  @PatchMapping("prescription")
  public ResponseEntity<?> update(@RequestBody PrescriptionDTO prescriptionDTO){
    try {
      if(!(prescriptionService.existsById(prescriptionDTO.getId()))){
        return new ResponseEntity<>(MessageResponse.builder()
            .message("This user was not found")
            .object(null)
            .build(),
            HttpStatus.NOT_FOUND
        );
      }
      Prescription prescriptionUpdate = prescriptionService.save(prescriptionDTO);
      return new ResponseEntity<>(MessageResponse.builder()
          .message("Update successfully")
          .object(prescriptionMapper.toPrescriptionDto(prescriptionUpdate))
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

  @DeleteMapping("prescription/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    try {
      Prescription prescriptionDelete = prescriptionService.findById(id);
      prescriptionService.delete(prescriptionDelete);
      return new ResponseEntity<>(prescriptionDelete, HttpStatus.NO_CONTENT);
    } catch (DataAccessException e) {
      return new ResponseEntity<>(MessageResponse.builder()
          .message(e.getMessage())
          .object(null)
          .build(),
          HttpStatus.METHOD_NOT_ALLOWED
      );
    }
  }

  @GetMapping("prescription/{id}")
  public ResponseEntity<?> showById(@PathVariable Integer id){
    Prescription prescription = prescriptionService.findById(id);
    if(prescription == null){
      return new ResponseEntity<>(MessageResponse.builder()
          .message("This user was not found")
          .object(null)
          .build(),
          HttpStatus.NOT_FOUND
      );
    }
    return new ResponseEntity<>(MessageResponse.builder()
        .message("Success")
        .object(prescriptionMapper.toPrescriptionDto(prescription))
        .build(),
        HttpStatus.OK
    );
  }
}
