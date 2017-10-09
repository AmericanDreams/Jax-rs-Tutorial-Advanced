package mir.project.jaxrs.test;


import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sing")
@Singleton
public class SingletonResource {

	int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		count++;
		return "this method colled " + count + " times";
	}
}
