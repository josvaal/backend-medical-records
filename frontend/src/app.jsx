import Router from "preact-router";
import { Home } from "./pages/home";
import { Patients } from "./pages/patients";
import { Patient } from "./pages/patient";
import { MedicalHistories } from "./pages/medical_histories";
import { MedicalHistory } from "./pages/medical_history";
import { MedicalPatientHistories } from "./pages/medical_patient_histories";
import { MedicalDoctorHistories } from "./pages/medical_doctor_histories";
import { Prescriptions } from "./pages/prescriptions";
import { Prescription } from "./pages/prescription";
import { PrescriptionsMedicalHistory } from "./pages/prescriptions_medical_history";
import { Appointments } from "./pages/appointments";
import { AppointmentsPatient } from "./pages/appointments_patient";
import { Appointment } from "./pages/appointment";
import { AppointmentsDoctor } from "./pages/appointments_doctor";
import { Login } from "./pages/login";
import { Register } from "./pages/register";
import { Profile } from "./pages/profile";

export function App() {
  return (
    <Router>
      {/* Home route */}
      <Home path="/" />
      {/* Auth routes */}
      <Login path="/login" />
      <Register path="/register" />
      <Profile path="/profile" />
      {/* Patient routes */}
      <Patients path="/patients" />
      <Patient path="/patient/:id" />
      {/* Medical Histories routes */}
      <MedicalHistories path="/medical_histories" />
      <MedicalPatientHistories path="/medical_histories/patient" />
      <MedicalDoctorHistories path="/medical_histories/doctor" />
      <MedicalHistory path="/medical_history/:id" />
      {/* Prescriptions routes */}
      <Prescriptions path="/prescriptions" />
      <Prescription path="/prescription/:id" />
      <PrescriptionsMedicalHistory path="/prescriptions/medical_history/:id" />
      {/* Appointments routes */}
      <Appointments path="/appointments" />
      <AppointmentsPatient path="/appointments/patient" />
      <AppointmentsDoctor path="/appointments/doctor" />
      <Appointment path="/appointment/:id" />
    </Router>
  );
}
