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
import "./index.css";
import SidebarItem from "./components/SidebarItem";
import SidebarDropdownItem from "./components/SidebarDropdownItem";
import IconComponent from "./components/IconComponent";
import { useEffect, useState } from "preact/hooks";
import { useFetch } from "./hooks/useFetch";
import { useAuthStore } from "./hooks/useAuthStore";
import Redirect from "./components/Redirect";

const apiUrl = import.meta.env.VITE_API_URL

export function App() {
    return (
        <>
            <div className="drawer lg:drawer-open">
                <input id="my-drawer-2" type="checkbox" className="drawer-toggle" />
                <div className="drawer-content flex flex-col items-center justify-center">
                    {/* Page content here */}
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
                    <label
                        htmlFor="my-drawer-2"
                        className="btn btn-primary drawer-button lg:hidden"
                    >
                        Open drawer
                    </label>
                </div>
                <div className="drawer-side">
                    <label
                        htmlFor="my-drawer-2"
                        aria-label="close sidebar"
                        className="drawer-overlay"
                    ></label>
                    <ul className="menu bg-base-200 text-base-content min-h-full w-80 p-4">
                        {/* Sidebar content here */}
                        <SidebarItem
                            title="Inicio"
                            url="/"
                            svg={
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="1em"
                                    height="1em"
                                    viewBox="0 0 24 24"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M4 21V9l8-6l8 6v12h-6v-7h-4v7z"
                                    />
                                </svg>
                            }
                        />
                        <SidebarDropdownItem
                            title="Historial Médico"
                            svg={
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="1.25em"
                                    height="1em"
                                    viewBox="0 0 640 512"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M64 96c0-35.3 28.7-64 64-64h384c35.3 0 64 28.7 64 64v256h-64V96H128v256H64zM0 403.2C0 392.6 8.6 384 19.2 384h601.6c10.6 0 19.2 8.6 19.2 19.2c0 42.4-34.4 76.8-76.8 76.8H76.8C34.4 480 0 445.6 0 403.2M288 160c0-8.8 7.2-16 16-16h32c8.8 0 16 7.2 16 16v48h48c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16h-48v48c0 8.8-7.2 16-16 16h-32c-8.8 0-16-7.2-16-16v-48h-48c-8.8 0-16-7.2-16-16v-32c0-8.8 7.2-16 16-16h48z"
                                    />
                                </svg>
                            }
                            items={[
                                {
                                    url: "/",
                                    title: "View All",
                                },
                                {
                                    url: "/",
                                    title: "Search",
                                },
                                {
                                    url: "/",
                                    title: "Add",
                                },
                                {
                                    url: "/",
                                    title: "Modify",
                                },
                            ]}
                        />
                        <SidebarDropdownItem
                            title="Paciente"
                            svg={
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="1em"
                                    height="1em"
                                    viewBox="0 0 24 24"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M8 6c0-2.21 1.79-4 4-4s4 1.79 4 4s-1.79 4-4 4s-4-1.79-4-4m9 16h1c1.1 0 2-.9 2-2v-4.78c0-1.12-.61-2.15-1.61-2.66c-.43-.22-.89-.43-1.39-.62zm-4.66-5L15 11.33c-.93-.21-1.93-.33-3-.33c-2.53 0-4.71.7-6.39 1.56A2.97 2.97 0 0 0 4 15.22V22h2.34c-.22-.45-.34-.96-.34-1.5C6 18.57 7.57 17 9.5 17zM10 22l1.41-3H9.5c-.83 0-1.5.67-1.5 1.5S8.67 22 9.5 22z"
                                    />
                                </svg>
                            }
                            items={[
                                {
                                    url: "/",
                                    title: "View All",
                                },
                                {
                                    url: "/",
                                    title: "Search",
                                },
                                {
                                    url: "/",
                                    title: "Add",
                                },
                                {
                                    url: "/",
                                    title: "Modify",
                                },
                            ]}
                        />
                        <SidebarDropdownItem
                            title="Cita Médica"
                            svg={
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="1em"
                                    height="1em"
                                    viewBox="0 0 14 14"
                                >
                                    <path
                                        fill="currentColor"
                                        fill-rule="evenodd"
                                        d="M4.5 1a1 1 0 0 0-2 0v1h-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h11a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 12.5 2h-1V1a1 1 0 1 0-2 0v1h-5zm1.47 4.428c0-.217.176-.392.393-.392h1.275c.216 0 .392.175.392.392v1.56h1.56c.217 0 .392.176.392.392v1.275a.39.39 0 0 1-.392.393H8.03v1.56a.39.39 0 0 1-.392.392H6.362a.39.39 0 0 1-.392-.392v-1.56H4.41a.39.39 0 0 1-.392-.393V7.38c0-.216.175-.392.392-.392h1.56z"
                                        clip-rule="evenodd"
                                    />
                                </svg>
                            }
                            items={[
                                {
                                    url: "/",
                                    title: "View All",
                                },
                                {
                                    url: "/",
                                    title: "Search",
                                },
                                {
                                    url: "/",
                                    title: "Add",
                                },
                                {
                                    url: "/",
                                    title: "Modify",
                                },
                            ]}
                        />
                        <div className="flex-1"></div>
                        <SidebarItem
                            title="Perfil"
                            url="/profile"
                            svg={
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="1em"
                                    height="1em"
                                    viewBox="0 0 24 24"
                                >
                                    <g fill="none" stroke="currentColor" stroke-width="2">
                                        <path
                                            stroke-linejoin="round"
                                            d="M4 18a4 4 0 0 1 4-4h8a4 4 0 0 1 4 4a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2Z"
                                        />
                                        <circle cx="12" cy="7" r="3" />
                                    </g>
                                </svg>
                            }
                        />
                    </ul>
                </div>
            </div>
        </>
    );
}
