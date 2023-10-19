package restcontroller;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import service.*;
import control.RequestProcessor;
import dao.customer.CustomerDTO;
import dao.order.OrderDTO;
import dao.product.ProductDto;
import dao.shop.ShopDTO;
import dao.shop.ShopDao;
import dao.shop.ShopDaoImpl;
import dao.shoppingcart.ShoppingCartDAO;
import dao.shoppingcart.ShoppingCartDTO;
import dao.shoppingcartitem.ShoppingCartItemDTO;
import rest.request.LoginRequest;
import rest.request.RegisterRequest;
import rest.response.BasicHttpResponse;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.ShopService;
import service.ShopServiceImpl;
import service.ShoppingCartService;
import service.ShoppingCartServiceImpl;

@Path("/mat")
public class RestController {
	RequestProcessor rp;
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;
	public  RestController() {
		rp=new RequestProcessor();
		
		
	}
	
	//====================Basic Operations (Login , Logout , Lang)===============//
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
 	public BasicHttpResponse login(LoginRequest req ) {
	
		
	BasicHttpResponse resp=null;
	String uname=req.getUsername();
	String upass=req.getPassword();
	
	CustomerService cs=CustomerServiceImpl.getServiceImpl();
	if(cs.checkUser(uname,upass)) {
		
		
		if(cs.checkFlag(uname)) {
			HttpSession session=request.getSession();
		CustomerDTO cdto=cs.findByName(uname);
			session.setAttribute("uname", uname);
			session.setAttribute("customerid", cdto.getCustomerid());
			session.setAttribute("user_profile", cdto);
			cs.updateFlag(1, uname);
			resp=new BasicHttpResponse(200, "success", false);
			return resp;
		}
		else {
			resp=new BasicHttpResponse(200, "failure", false);
			return resp;
		}
	}
	else {
		resp=new BasicHttpResponse(200, "register", false);
		return resp;
	}

	
	}

	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse logout() {
		request.setAttribute("formid","logout");
		HttpSession session=request.getSession();
		/*String uname=session.getAttribute("uname").toString();
		CustomerService cs=CustomerServiceImpl.getServiceImpl();
		cs.updateFlag(0, uname);*/	
		BasicHttpResponse resp=new BasicHttpResponse(200, "success", false);
		return resp;

	}
	@POST
	@Path("/lang/{language}")
	public String language(@PathParam("language") String language) {
		
		ResourceBundle rb=ResourceBundle.getBundle("dictionary",new Locale(language));
		ServletContext application=request.getServletContext();
		application.setAttribute("rb", rb);
		
		return "lang.success";
	}
	
	
	
	//====================Customer Operations ( Register , Edit Profile)==========//
	
	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
 	public BasicHttpResponse register(RegisterRequest req) {
		
		BasicHttpResponse resp=null;
		CustomerService cs=CustomerServiceImpl.getServiceImpl();
		String uname=req.getUname();
		String upass=req.getuPass();
		String mobileNo=req.getMobileNo();
		String email=req.getEmail();
		CustomerDTO dto=new CustomerDTO();
		if(cs.findByName(uname)!=null)
		{
			dto.setCustomername(uname);
			dto.setPassword(upass);
			dto.setMobileno(mobileNo);
			dto.setEmailId(email);
			dto.setActiveFlag(1);
			cs.insertCustomer(dto);
			ResourceBundle rb=ResourceBundle.getBundle("dictionary");
			String result = rb.getString("register.success");
			resp=new BasicHttpResponse(200,result,false);
			
			return resp;
		}
		
		
		return new BasicHttpResponse(200,"user already exists",true);
		
		
	}
	
	@POST
	@Path("/editProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
 	public BasicHttpResponse editProfile(RegisterRequest req) {
		
		BasicHttpResponse resp=null;
		CustomerService cs=CustomerServiceImpl.getServiceImpl();
		String uname=req.getUname();
		String upass=req.getuPass();
		String mobileNo=req.getMobileNo();
		String email=req.getEmail();
		CustomerDTO dto=new CustomerDTO();
		if(cs.findByName(uname)!=null)
		{
			dto.setCustomername(uname);
			dto.setPassword(upass);
			dto.setMobileno(mobileNo);
			dto.setEmailId(email);
			dto.setActiveFlag(1);
			cs.editCustomer(dto);
			ResourceBundle rb=ResourceBundle.getBundle("dictionary");
			String result = rb.getString("register.success");
			resp=new BasicHttpResponse(200,result,false);
			
			return resp;
		}
		
		
		return new BasicHttpResponse(200,"user already exists",true);
		
		
	}
	
	
	
	// ==================== Shop Operations (Add Shop , Edit Shop , List Shop,  Delete  Shop ======//
	
	
	@Path("/addShop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse  addShop(ShopDTO shop){
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		ShopService ss =ShopServiceImpl.getServiceImpl();
		int response=ss.insertShop(shop);
		
		bhttpResp.setMsg(response==1?"Shop Added Successfully":"Failed to add the shop");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	@Path("/deleteShop/{shopid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse  deleteShop(@PathParam("shopid") int shopid){
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		ShopService ss =ShopServiceImpl.getServiceImpl();
		int response=ss.deleteShop(shopid);
		
		bhttpResp.setMsg(response==1?"Shop deleted Successfully":"Failed to delete the shop");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	@Path("/editShop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse  editShop(ShopDTO shop){
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		ShopService ss =ShopServiceImpl.getServiceImpl();
		int response=ss.editShop(shop);
		
		bhttpResp.setMsg(response==1?"Shop Updated Successfully":"Failed to add the shop");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	

	@Path("/shop/{shopid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ShopDTO  findShopById(@PathParam("shopid") int shopid){
		
		ShopService ss =ShopServiceImpl.getServiceImpl();
		return ss.findbyShopid(shopid);
		
				
	}
	
	@Path("/shop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShopDTO>  listShop(){
		
		ShopService ss =ShopServiceImpl.getServiceImpl();
		return ss.findAll();
		
				
	}
	
	
	
	// ==================== Product Operations (Add Products , Find Products , Edit product, Delete Product ======//
	
	
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse  addProduct(ProductDto productDto){
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		
		int response=ps.insertProduct(productDto);
		
		bhttpResp.setMsg(response==1?"Product Added Successfully":"Failed to add the product");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	@Path("/editProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse  editProduct(ProductDto productDto){
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		
		int response=ps.updateProduct(productDto);
		
		bhttpResp.setMsg(response==1?"Product Added Successfully":"Failed to add the product");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	
	@GET
	@Path("/showproduct")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDto> showProducts(){
		
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		List<ProductDto> list=ps.getProducts();
		return list;
	}
	

	@GET
	@Path("/showproduct/{shopid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDto> showProductsByShopId(@PathParam("shopid")int shopid){
		System.out.println(shopid);
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		List<ProductDto> list=ps.showProductByShopId(shopid);
		return list;
	}
	
	@GET
	@Path("/showproductByName/{productName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDto findByproductName(@PathParam("productName")String  productName){
		
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		ProductDto dto=ps.findByproductName(productName);
		return dto;
	}
	
	@GET
	@Path("/showproductByCode/{productCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDto findByproductCode(@PathParam("productCode")String  productCode){
		
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		ProductDto dto=ps.findByProductCode(productCode);
		return dto;
	}
	
	
	@Path("/deleteProduct/{productid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse  deleteProduct(@PathParam("productid") int productid){
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		ProductService  ps =ProductServiceImpl.getServiceImpl();
		int response=ps.deleteProduct(null);
		
		bhttpResp.setMsg(response==1?"product deleted Successfully":"Failed to delete the product");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	
	// ==================== Shopping Cart Operations (Add ItemToCart , Remove Item from Cart , list items in the cart) ======//

	@GET
	@Path("/additemtocart/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse addItemToCart(@PathParam("productID") String productID,
			@QueryParam("id") int id ,@QueryParam("name") String name) {
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		
		
		int customerid =(int)request.getSession().getAttribute("customerid");
		System.out.println(customerid);
		ShoppingCartDTO sdto =new ShoppingCartDTO();
		ShoppingCartService scs =ShoppingCartServiceImpl.getServiceImpl();		
		sdto.setCustomerid(customerid);
		sdto.setShoppingcartid(scs.getActiveShoppingcart(customerid).getShoppingcartid());
		sdto.setIsactive(1);
		
		
		int response=scs.insertProduct(sdto);
		
		bhttpResp.setMsg(response==1?"Item added to cart Successfully":"Item failed to add to the cart");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	@GET
	@Path("/removeItemFromCart/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse removeItemFromCart(@PathParam("productID") String productID,
			@QueryParam("id") int id ,@QueryParam("name") String name) {
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		ShoppingCartService scs =ShoppingCartServiceImpl.getServiceImpl();
		System.out.println("productid :"+productID);
		int customerid =(int)request.getSession().getAttribute("customerid");
		System.out.println(customerid);
		ShoppingCartItemDTO sdto =new ShoppingCartItemDTO();
		sdto.setProductcode(productID);		
		sdto.setShoppingcartid(scs.getActiveShoppingcart(customerid).getShoppingcartid());
		ShoppingCartItemService scis =ShoppingCartItemServiceImpl.getServiceImpl();
		
		sdto.setIsactive(1);
		
		
		int response=scis.removeItem(sdto);
		
		bhttpResp.setMsg(response==1?"Item removed from cart Successfully":"Item failed to remove from the cart");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	
	@GET
	@Path("/listItemsInCart")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShoppingCartItemDTO> listItemsInCart() {
		
		ShoppingCartService scs =ShoppingCartServiceImpl.getServiceImpl();
		ShoppingCartItemService scis =ShoppingCartItemServiceImpl.getServiceImpl();
		int customerid =(int)request.getSession().getAttribute("customerid");
		
		
		List<ShoppingCartItemDTO> list=scis.getItemsinCart(customerid);
		
		return list;
		
		
		
	}
	
	
	// ==================== Order Operations (Place Order , list orders of the user) ======//
	
	
	@GET
	@Path("/placeOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public BasicHttpResponse placeOrder() {
		BasicHttpResponse bhttpResp=new  BasicHttpResponse();
		ShoppingCartService scs =ShoppingCartServiceImpl.getServiceImpl();
		
		int customerid =(int)request.getSession().getAttribute("customerid");
		System.out.println(customerid);
		int shoppingcartId=scs.getActiveShoppingcart(customerid).getShoppingcartid();
		OrderService os =OrderServiceImp.getOrderImp();
		
		int response=os.placeOrder(shoppingcartId);
		
		bhttpResp.setMsg(response==1?"Item removed from cart Successfully":"Item failed to remove from the cart");
		bhttpResp.setHasError(response==0);
		
		return bhttpResp;
		
	}
	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDTO> orders() {
		
		OrderService os =OrderServiceImp.getOrderImp();
	
		int customerid =(int)request.getSession().getAttribute("customerid");
		
		
		List<OrderDTO> list=os.getOrders(customerid);
		
		return list;
		
		
		
	}
	
}
	
	

