import { BrowserRouter, Route, Routes } from "react-router-dom";
import MainLayout from "./components/layout/MainLayout";
import Login from "./components/login/Login";
import Register from "./components/register/Register";
import { routes } from "./routes";

function App() {
  return (
    <BrowserRouter>
      <Routes>   
     
        <Route path="/" element={<MainLayout/>}>
          {routes}
        </Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/register" element={<Register/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
