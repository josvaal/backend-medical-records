import { useForm } from "react-hook-form";
import { useFetch } from "../hooks/useFetch";
import { useEffect, useState } from "preact/hooks";
import { useLocalStorage } from "../hooks/useLocalStorage";
import { route } from "preact-router";

const apiUrl = import.meta.env.VITE_API_URL;
// console.log(apiUrl);

export function Login() {
  const [token, setToken] = useLocalStorage("token", "");
  const { register, handleSubmit } = useForm();
  const { data, isLoading, error, fetchData } = useFetch();
  // console.log(token);

  const onSubmit = async (formData) => {
    const response = await fetchData(
      "post",
      apiUrl + "auth/login",
      formData,
      {}
    );
    // console.log(response);
    setToken(response.object.token);
  };

  useEffect(() => {
    if (token != "") {
      route("/profile");
    }
  }, [token]);

  return (
    <>
      <h1 className="text-xl">Login Page</h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <label>
          Email:
          <input type="email" {...register("email")} required />
        </label>
        <label>
          Password:
          <input type="password" {...register("password")} required />
        </label>
        <button type="submit">Login</button>
      </form>

      {isLoading && <p>Loading...</p>}
      {error && <p>Error: {error.message}</p>}
      {data && <p>{JSON.stringify(data)}</p>}
    </>
  );
}
