import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function Register() {
  const [form, setForm] = useState({
    name: "",
    roll: "",
    email: "",
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await API.post("/register", form);

      localStorage.setItem("student", JSON.stringify(form));

      alert("Registered Successfully ✅");

      navigate("/exam");
    } catch (error) {
      console.error(error);
      alert("Error connecting to backend ❌");
    }
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h2>Student Registration</h2>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" onChange={handleChange} required /><br />
        <input name="roll" placeholder="Roll Number" onChange={handleChange} required /><br />
        <input name="email" placeholder="Email" onChange={handleChange} required /><br />
        <button type="submit">Start Exam</button>
      </form>
    </div>
  );
}

export default Register;