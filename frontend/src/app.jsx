import Router, { route } from "preact-router";
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

//const apiUrl = "http://ec2-18-117-137-113.us-east-2.compute.amazonaws.com:9777/api/v1/";
const apiUrl = import.meta.env.VITE_API_URL

export function App() {
  const token = localStorage.getItem("token");
  const { data, isLoading, error, fetchData } = useFetch();
  const { isAuthenticated, setAuthenticated } = useAuthStore();

  const checkAuthentication = async () => {
    if (!token || token == "") {
      const path = window.location.pathname;
      const includePaths = ["/login", "/register"];
      if (!includePaths.includes(path)) {
        setAuthenticated(false);
        route("/login");
        return;
      }
      return;
    }

    if (token != "" && isAuthenticated) {
      const path = window.location.pathname;
      const excludePaths = ["/login", "/register"];
      if (excludePaths.includes(path)) {
        route("/profile");
        return;
      }
      return;
    }

    try {
      const response = await fetchData(
        "post",
        apiUrl + "auth/verifyLogin",
        null,
        {
          Authorization: `Bearer ${token}`,
        }
      );
      if (response.status === 200) {
        setAuthenticated(true);
      } else {
        setAuthenticated(false);
      }
    } catch (err) {
      setAuthenticated(false);
    }
  };

  useEffect(() => {
    checkAuthentication();
  }, [isAuthenticated]);

  return (
    <>
      {isLoading ? (
        <div className="h-screen w-full flex justify-center items-center">
          <span className="loading loading-dots loading-lg"></span>
        </div>
      ) : !isAuthenticated ? (
        <Router>
          <Login path="/login" />
          <Register path="/register" />
        </Router>
      ) : (
        <div className="drawer lg:drawer-open">
          <input id="my-drawer-2" type="checkbox" className="drawer-toggle" />
          <div className="drawer-content flex flex-col items-center justify-center">
            {/* Page content here */}
            <Router>
              {/* Home route */}
              <Home path="/" />
              {/* Auth routes */}
              <Redirect path="/login" to="/profile" />
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
                svg={<IconComponent iconName="home" />}
              />
              <SidebarDropdownItem
                title="Historial Médico"
                svg={<IconComponent iconName="medic-clipboard" />}
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
                svg={<IconComponent iconName="person" />}
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
                svg={<IconComponent iconName="medical-bag" />}
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
                svg={<IconComponent iconName="coffee" />}
              />
            </ul>
          </div>
        </div>
      )}
    </>
  );
}
