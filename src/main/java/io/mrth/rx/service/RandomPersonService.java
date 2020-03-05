package io.mrth.rx.service;

import io.mrth.rx.endpoint.RandomPerson;
import io.mrth.rx.endpoint.RandomPersonEndpoint;
import io.mrth.rx.endpoint.RandomPersonResponse;
import io.mrth.rx.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;

@Dependent
public class RandomPersonService implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomPersonService.class);

	@Inject
	private RandomPersonEndpoint endpoint;

	public Observable<Person> getPerson() {
		Observable<RandomPersonResponse<RandomPerson>> single =  endpoint.getPerson();
		return single.flatMap(res -> Observable.fromIterable(res.getResults()))
				.map(Person::new)
				.doOnError(err -> LOGGER.info(err.getMessage()));
	}
}
