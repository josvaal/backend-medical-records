import { useEffect } from "preact/hooks";
import { useFetch } from "../hooks/useFetch";
import { useAuthStore } from "../hooks/useAuthStore";

const apiUrl =
  "http://ec2-18-117-137-113.us-east-2.compute.amazonaws.com:9777/api/v1/";

export function Profile() {
  const token = localStorage.getItem("token");
  const { data, isLoading, error, fetchData } = useFetch();
  const { isAuthenticated, setAuthenticated } = useAuthStore();

  useEffect(async () => {
    await fetchData("get", apiUrl + "auth/profile", null, {
      Authorization: `Bearer ${token}`,
    });
  }, [token]);

  return (
    <>
      <h1 className="text-xl">Profile Page</h1>
      {isLoading && <p>Loading...</p>}
      {error && <p>Error: {error.message}</p>}
      {data && (
        <div>
          <p>
            <b>Nombre: </b>
            {data.object.firstname}
          </p>
          <p>
            <b>Apellido: </b>
            {data.object.lastname}
          </p>
          <p>
            <b>Correo: </b>
            {data.object.email}
          </p>
          <p>
            <b>Rol: </b>
            {data.object.userRole}
          </p>
          <p>
            <b>Nro. Celular: </b>
            {data.object.phone}
          </p>
          <p>
            <b>Dirección: </b>
            {data.object.address}
          </p>
          <p>
            <b>Nacimiento: </b>
            {new Date(data.object.dateOfBirth).toLocaleDateString("en-ES")}
          </p>
          <button
            className="btn"
            type="button"
            onClick={() => {
              setAuthenticated(false);
              localStorage.removeItem("token");
            }}
          >
            Cerrar Sesión
          </button>
        </div>
      )}
    </>
  );
}
