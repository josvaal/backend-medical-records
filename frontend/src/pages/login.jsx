import { useForm } from "react-hook-form";
import { useFetch } from "../hooks/useFetch";
import { useAuthStore } from "../hooks/useAuthStore";

 const apiUrl = import.meta.env.VITE_API_URL;
//const apiUrl = "http://ec2-18-117-137-113.us-east-2.compute.amazonaws.com:9777/api/v1/";

export function Login() {
  const { register, handleSubmit } = useForm();
  const { data, isLoading, error, fetchData } = useFetch();
  const { isAuthenticated, setAuthenticated } = useAuthStore();

  const onSubmit = async (formData) => {
    const response = await fetchData(
      "post",
      apiUrl + "auth/login",
      formData,
      {}
    );
    localStorage.setItem("token", response.data.object.token);
    setAuthenticated(true);
  };

  return (
    <>
      <h1 className="text-xl">Login Page</h1>
      <div className="card bg-neutral text-neutral-content w-96">
        <div className="card-body items-center text-center">
          <form
            onSubmit={handleSubmit(onSubmit)}
            className="w-full flex flex-col gap-5"
          >
            <input
              type="email"
              {...register("email")}
              required
              placeholder="Email"
              className="input input-bordered"
            />
            <input
              placeholder="password"
              type="password"
              {...register("password")}
              required
              className="input input-bordered"
            />
            <button type="submit" className="btn btn-primary w-full">
              Login
            </button>
          </form>
        </div>
      </div>

      {isLoading && <p>Loading...</p>}
      {error && <p>Error: {error.message}</p>}
      {data && <p>{JSON.stringify(data)}</p>}
    </>
  );
}
