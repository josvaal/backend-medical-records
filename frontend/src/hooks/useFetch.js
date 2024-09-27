import axios from "axios";
import { useState } from "react";

export const useFetch = () => {
  const [data, setData] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchData = async (method, endpoint, body, customHeaders = {}) => {
    setIsLoading(true);
    setError(null);

    const headers = {
      'Content-Type': 'application/json',
      ...customHeaders
    };

    let response;

    try {
      switch (method.toLowerCase()) {
        case 'post':
          response = await axios.post(endpoint, body, { headers });
          break;
        case 'patch':
          response = await axios.patch(endpoint, body, { headers });
          break;
        case 'delete':
          response = await axios.delete(endpoint, { headers, data: body });
          break;
        case 'get':
        default:
          response = await axios.get(endpoint, { headers, data: body });
      }

      setData(response.data);
      return response.data;
    } catch (err) {
      setError(err);
      return err.response
    } finally {
      setIsLoading(false);
    }
  };

  return { data, isLoading, error, fetchData };
};
