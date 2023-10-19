import { Outlet } from "react-router-dom";
import { Box, Toolbar } from "@mui/material";
import colorConfigs from "../../configs/colorConfigs";
import sizeConfigs from "../../configs/sizeConfigs";
import Sidebar from "../common/Sidebar";
import Topbar from "../common/Topbar";
import { Navigate } from "react-router-dom";

import { useEffect, useState } from "react";

const MainLayout = () => {
  const [authenticated, setauthenticated] = useState<any | null>(null);
  const loggedInUser = localStorage.getItem("authenticated")|| "false";
  useEffect(() => {
    
    console.log("loggedinuser",loggedInUser);
    if (loggedInUser === "true") {
      setauthenticated(loggedInUser);
    }
  }, []);

  if (!(loggedInUser==="true")) {
    console.log(loggedInUser);
    return <Navigate replace to="/login" />;
  } else {
    return (


    <Box sx={{ display: "flex" }}>
      <Topbar />
      <Box
        component="nav"
        sx={{
          width: sizeConfigs.sidebar.width,
          flexShrink: 0
        }}
      >
        <Sidebar />
      </Box>
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          p: 3,
          width: `calc(100% - ${sizeConfigs.sidebar.width})`,
          minHeight: "100vh",
          backgroundColor: colorConfigs.mainBg
        }}
      >
        <Toolbar />
        <Outlet />
      </Box>
    </Box>
  );
      }
};

export default MainLayout;