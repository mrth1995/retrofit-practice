package io.mrth.netzme.test.service;

import io.mrth.netzme.test.endpoint.RandomPersonEndpoint;
import io.mrth.netzme.test.endpoint.RandomPerson;
import io.mrth.netzme.test.endpoint.RandomPersonResponse;
import io.mrth.netzme.test.model.Person;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

@Dependent
public class RandomPersonService implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomPersonService.class);

	@Inject
	private RandomPersonEndpoint endpoint;

	public Person getPerson() {
		Single<RandomPersonResponse<RandomPerson>> single =  endpoint.getPerson();
		AtomicReference<Person> reference = new AtomicReference<>();
		single.subscribe(response -> {
			RandomPerson randomPerson = response.getResults().get(0);
			Person p = new Person(randomPerson);
			reference.set(p);
			}, error -> {
			LOGGER.error(error.getMessage(), error);
		});
		return reference.get();
	}

}
