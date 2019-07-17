package io.mrth.netzme.test.endpoint;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetzmeEndpoint {

	@GET("/api")
	Call<NetzmeResponse<NetzmePerson>> getPerson();
}
