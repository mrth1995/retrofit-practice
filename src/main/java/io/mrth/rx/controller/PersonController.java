package io.mrth.rx.controller;

import io.mrth.rx.service.RandomPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {
	private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

	@Inject
	private RandomPersonService service;

	@GET
	public void getPerson(@Suspended AsyncResponse response) {
		LOG.info("getPerson");
		service.getPerson().subscribe(response::resume, response::resume);
	}
}
