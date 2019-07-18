package io.mrth.netzme.test.endpoint;

import io.reactivex.Single;
import retrofit2.mock.BehaviorDelegate;

import java.util.ArrayList;
import java.util.List;

public class RandomPersonEndpointMock implements RandomPersonEndpoint {
	private BehaviorDelegate<RandomPersonEndpoint> delegate;

	public RandomPersonEndpointMock(BehaviorDelegate<RandomPersonEndpoint> delegate) {
		this.delegate = delegate;
	}

	@Override
	public Single<RandomPersonResponse<RandomPerson>> getPerson() {
		RandomPersonResponse<RandomPerson> response = new RandomPersonResponse<>();
		List<RandomPerson> list = new ArrayList<>();
		list.add(new RandomPerson("male", "kwon@mail.com", new RandomPerson.Name("mr", "kwon", "banner"),
				new RandomPerson.Location("sadarmanah", "cimahi", "40532", "Jawa barat"),
				new RandomPerson.Picture("http://localhost")));
		response.setResults(list);
		return delegate.returningResponse(response).getPerson();
	}
}
