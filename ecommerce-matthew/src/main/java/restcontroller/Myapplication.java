package restcontroller;

import java.util.HashSet;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class Myapplication extends Application {

	public Myapplication() {
		
	}	
	
	@Override
	public Set<Object> getSingletons() {
	
		HashSet<Object> set=new HashSet<Object>();
		return set;
	}
}
