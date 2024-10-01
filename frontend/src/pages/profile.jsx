import { useEffect } from "preact/hooks";
import { useLocalStorage } from "../hooks/useLocalStorage";
import { route } from "preact-router";
import { useFetch } from "../hooks/useFetch";

const apiUrl = import.meta.env.VITE_API_URL;

export function Profile() {
  const [token, setToken] = useLocalStorage("token", "");
  const { data, isLoading, error, fetchData } = useFetch();

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
        </div>
      )}
    </>
  );
}
