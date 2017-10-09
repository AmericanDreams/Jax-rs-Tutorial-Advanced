package mir.project.jaxrs.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{path}/test")
public class InstanceAnnotationResource {

	@PathParam("path") private String path;
	@QueryParam("query") private String queryParam;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Path is " + path + " and query param is " + queryParam + " .";
	}
}
