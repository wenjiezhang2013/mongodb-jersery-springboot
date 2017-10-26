package jz.mongodb.demo.controller;

import java.util.Objects;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import jz.mongodb.demo.model.Customer;
import jz.mongodb.demo.service.CustomerService;

@Component
@Path("/user")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@POST
    @Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response save(@QueryParam("firstName") String firstName, @QueryParam("lastName")String lastName) {
		Customer customer = customerService.save(new Customer(firstName, lastName));
		return Response.status(200).entity(customer).build();
	}
	
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response get(@PathParam("id") String id) {
		Customer customer = customerService.get(id);
		return Objects.isNull(customer) ? Response.status(404).build(): Response.status(200).entity(customer).build();
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getAll() {
		return Response.status(200).entity(customerService.getAll()).build();
	}

}