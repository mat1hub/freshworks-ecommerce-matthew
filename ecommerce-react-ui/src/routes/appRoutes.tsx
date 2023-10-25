
import HomePage from "../pages/home/HomePage";
import { RouteType } from "./config";


import DashboardOutlinedIcon from '@mui/icons-material/DashboardOutlined';
import AppsOutlinedIcon from '@mui/icons-material/AppsOutlined';
import ArticleOutlinedIcon from '@mui/icons-material/ArticleOutlined';
import FormatListBulletedOutlinedIcon from '@mui/icons-material/FormatListBulletedOutlined';
import FileDownloadOutlinedIcon from '@mui/icons-material/FileDownloadOutlined';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import Profile from "../pages/profile/Profile";
import Orders from "../pages/orders/Orders";
import Logout from "../pages/logout/Logout";
import MainLayout from "../components/layout/MainLayout";
import AddShop from "../pages/shop/AddShop";
import ViewShop from "../pages/shop/ViewShop";
import ShopPageLayout from "../pages/shop/ShopPageLayout";
import ProductPageLayout from "../pages/products/ProductPageLayout";
import AddProduct from "../pages/products/AddProduct";
import ViewProduct from "../pages/products/ViewProduct";
import ShoppingCart from "../pages/ShoppingCart/ShoppingCart";

const appRoutes: RouteType[] = [
 
  {
    index: true,
    element: <HomePage />,
    state: "home"
  },
 
  {
    path: "/shop",
    element: <ShopPageLayout/>,
    state: "shop",
    sidebarProps: {
      displayText: "Shop",
      icon: <DashboardOutlinedIcon />
    },
    child: [
      {
        index: true,
        element: <AddShop />,
        state: "shop.add"
      },
      {
        path: "/shop/add",
        element: <AddShop />,
        state: "shop.add",
        sidebarProps: {
          displayText: "Add Shop"
        },
      },
      {
        path: "/shop/view",
        element: <ViewShop />,
        state: "shop.add",
        sidebarProps: {
          displayText: "View Shop"
        },
      }
     
    ]
  },
  {
    path: "/product",
    element: <ProductPageLayout />,
    state: "product",
    sidebarProps: {
      displayText: "Products",
      icon: <AppsOutlinedIcon />
    },
    child: [
      {
        path: "/product/add",
        element: <AddProduct />,
        state: "product.add",
        sidebarProps: {
          displayText: "Add Product"
        },
      },
      {
        path: "/product/view",
        element: <ViewProduct />,
        state: "product.view",
        sidebarProps: {
          displayText: "View Product"
        }
      }
    ]
  },
  {
    path: "/profile",
    element: <Profile />,
    state: "profile",
    sidebarProps: {
      displayText: "Profile",
      icon: <ArticleOutlinedIcon />
    }
  },
  {
    path: "/shoppingCart",
    element: <ShoppingCart />,
    state: "shoppingcart",
    sidebarProps: {
      displayText: "ShoppingCart",
      icon: <ShoppingCartIcon />
    }
  },
  {
    path: "/Orders",
    element: <Orders />,
    state: "orders",
    sidebarProps: {
      displayText: "Orders",
      icon: <FormatListBulletedOutlinedIcon />
    }
  },
  {
    path: "/logout",
    element: <Logout />,
    state: "logout",
    sidebarProps: {
      displayText: "Logout",
      icon: <FileDownloadOutlinedIcon />
    }
  }
];

export default appRoutes;