package io.mrth.netzme.test.endpoint;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NetzmeEndpoint {

	@GET("/api")
	Single<NetzmeResponse<NetzmePerson>> getPerson();
}
