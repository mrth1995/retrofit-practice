package io.mrth.netzme.test.controller;

import io.mrth.netzme.test.model.Person;
import io.mrth.netzme.test.service.NetzmeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RequestScoped
@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {
	private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

	@Inject
	private NetzmeService service;

	@GET
	public Person getPerson() throws IOException {
		LOG.info("getPerson");
		return service.getPerson();
	}
}
