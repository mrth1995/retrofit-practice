package io.mrth.netzme.test.service;

import io.mrth.netzme.test.endpoint.NetzmeEndpoint;
import io.mrth.netzme.test.endpoint.NetzmePerson;
import io.mrth.netzme.test.endpoint.NetzmeResponse;
import retrofit2.Call;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;

@Dependent
public class NetzmeService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private NetzmeEndpoint endpoint;

	public NetzmeResponse<NetzmePerson> getPerson() throws IOException {
		Call<NetzmeResponse<NetzmePerson>> callable =  endpoint.getPerson();
		NetzmeResponse<NetzmePerson> person = callable.execute().body();
		return person;
	}

}
