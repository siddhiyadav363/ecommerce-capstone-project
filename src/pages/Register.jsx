import { useContext, useState } from "react";
import { AuthContext } from "../auth/AuthContext";
import { useNavigate } from "react-router-dom";

export default function Register() {
  const { register } = useContext(AuthContext);
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const submit = async (e) => {
    e.preventDefault();
    try {
      await register(username, email, password);
      alert("Registration successful");
      navigate("/");
    } catch {
      alert("Registration failed");
    }
  };

  return (
    <div style={styles.container}>
      <form style={styles.card} onSubmit={submit}>
        <h2>Register</h2>

        <input style={styles.input} placeholder="Username"
          value={username} onChange={e => setUsername(e.target.value)} />

        <input style={styles.input} placeholder="Email"
          value={email} onChange={e => setEmail(e.target.value)} />

        <input style={styles.input} type="password" placeholder="Password"
          value={password} onChange={e => setPassword(e.target.value)} />

        <button style={styles.button}>Register</button>
      </form>
    </div>
  );
}

const styles = {
  container: { display: "flex", height: "100vh", justifyContent: "center", alignItems: "center" },
  card: { padding: 30, width: 300, boxShadow: "0 0 10px #ccc" },
  input: { width: "100%", padding: 10, marginBottom: 10 },
  button: { width: "100%", padding: 10 }
};
