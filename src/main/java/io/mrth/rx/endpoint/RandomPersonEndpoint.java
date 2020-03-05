package io.mrth.rx.endpoint;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RandomPersonEndpoint {

	@GET("/api")
	Observable<RandomPersonResponse<RandomPerson>> getPerson();
}
