import { useState, useEffect } from 'preact/hooks';

export const useLocalStorage = (key, initialValue) => {
  const [storedValue, setStoredValue] = useState(() => {
    try {
      const item = localStorage.getItem(key);
      return item ? isJSON(item) ? JSON.parse(item) : item : initialValue;
    } catch (error) {
      console.error("Error leyendo desde localStorage:", error);
      return initialValue;
    }
  });

  useEffect(() => {
    try {
      const valueToStore = typeof storedValue === 'object' ? JSON.stringify(storedValue) : storedValue;
      localStorage.setItem(key, valueToStore);
    } catch (error) {
      console.error("Error guardando en localStorage:", error);
    }
  }, [key, storedValue]);

  return [storedValue, setStoredValue];
};

const isJSON = (str) => {
  try {
    JSON.parse(str);
    return true;
  } catch (error) {
    return false;
  }
};
