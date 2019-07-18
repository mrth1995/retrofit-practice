package io.mrth.netzme.test.endpoint;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface RandomPersonEndpoint {

	@GET("/api")
	Observable<RandomPersonResponse<RandomPerson>> getPerson();
}
