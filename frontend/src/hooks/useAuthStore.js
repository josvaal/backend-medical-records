import { create } from "zustand";

export const useAuthStore = create((set) => ({
    isAuthenticated: false,
    setAuthenticated: (state) => set({ isAuthenticated: state }),
}));
