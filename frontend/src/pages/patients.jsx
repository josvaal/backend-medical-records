import { useEffect } from "preact/hooks";
import { useLocalStorage } from "../hooks/useLocalStorage";
import { route } from "preact-router";

export function Patients() {
  const [token, setToken] = useLocalStorage("token", "");

  useEffect(async () => {
    if (token == "") {
      route("/login");
      return;
    }

    // const response = await fetchData("get", apiUrl + "auth/profile", null, {
    //   Authorization: `Bearer ${token}`,
    // });
    // if (response.status == 401 && response.data.message == "Invalid Token") {
    //   setToken("");
    // }
  }, [token]);

  return (
    <>
      <h1 className="text-xl">Patients Page</h1>
    </>
  );
}
