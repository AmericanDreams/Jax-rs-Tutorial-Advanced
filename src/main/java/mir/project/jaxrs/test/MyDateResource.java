package mir.project.jaxrs.test;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/date")
public class MyDateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{date}")
	public String test(@PathParam("date") MyDate date) {
		return "Date is " + date;
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getDate() {
		return Calendar.getInstance().getTime();
	}
	
	
}
