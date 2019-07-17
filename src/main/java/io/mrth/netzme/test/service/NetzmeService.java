package io.mrth.netzme.test.service;

import io.mrth.netzme.test.endpoint.NetzmeEndpoint;
import io.mrth.netzme.test.endpoint.NetzmePerson;
import io.mrth.netzme.test.endpoint.NetzmeResponse;
import io.mrth.netzme.test.model.Person;
import io.reactivex.Single;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

@Dependent
public class NetzmeService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private NetzmeEndpoint endpoint;

	public Person getPerson() {
		Single<NetzmeResponse<NetzmePerson>> single =  endpoint.getPerson();
		AtomicReference<Person> reference = new AtomicReference<>();
		single.subscribe(response -> {
			NetzmePerson netzmePerson = response.getResults().get(0);
			Person p = new Person(netzmePerson);
			reference.set(p);
		});
		return reference.get();
	}

}
