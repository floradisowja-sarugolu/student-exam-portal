import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8087" 
});

export default API;