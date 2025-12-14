import { createContext, useState } from "react";
import api from "../api/axios";

export const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [token, setToken] = useState(localStorage.getItem("token"));

  const login = async (username, password) => {
    const res = await api.post("/api/auth/login", {
      username,
      password,
      passwordHash: password
    });

    const jwt = typeof res.data === "string" ? res.data : res.data.token;

    localStorage.setItem("token", jwt);
    setToken(jwt);
  };

  const register = async (username, email, password) => {
    await api.post("/api/auth/register", {
      username,
      email,
      password,
      passwordHash: password
    });
  };

  return (
    <AuthContext.Provider value={{ token, login, register }}>
      {children}
    </AuthContext.Provider>
  );
}
