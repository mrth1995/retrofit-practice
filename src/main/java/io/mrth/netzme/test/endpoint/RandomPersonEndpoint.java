package io.mrth.netzme.test.endpoint;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RandomPersonEndpoint {

	@GET("/api")
	Single<RandomPersonResponse<RandomPerson>> getPerson();
}
