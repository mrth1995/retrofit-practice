package io.mrth.rx.endpoint;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import java.util.ArrayList;
import java.util.List;

public class RandomPersonEndpointTest {
	private static final Logger LOG = LoggerFactory.getLogger(RandomPersonEndpointTest.class);

	private RandomPersonEndpoint endpoint;
	private final NetworkBehavior networkBehavior = NetworkBehavior.create();

	@Before
	public void prepare() {
		LOG.info("prepare");
		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.baseUrl("http://localhost")
				.build();
		MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
				.networkBehavior(networkBehavior)
				.build();
		final BehaviorDelegate<RandomPersonEndpoint> behaviorDelegate = mockRetrofit.create(RandomPersonEndpoint.class);
		endpoint = new RandomPersonEndpointMock(behaviorDelegate);
	}

	@Test
	public void getPerson() {
		LOG.info("getPerson");
		RandomPersonResponse<RandomPerson> response = new RandomPersonResponse<>();
		List<RandomPerson> list = new ArrayList<>();
		list.add(new RandomPerson("male", "kwon@mail.com", new RandomPerson.Name("mr", "kwon", "banner"),
				new RandomPerson.Location(new RandomPerson.Location.Street(282, "Saradan"), "cimahi", "40532", "Jawa barat"),
				new RandomPerson.Picture("http://localhost")));
		response.setResults(list);
		endpoint.getPerson().test().assertValue(response);
		endpoint.getPerson().test().assertNoErrors();
	}

	@Test
	public void getPerson_error() {
		LOG.info("getPerson_error");
		networkBehavior.setErrorPercent(100);

		endpoint.getPerson().test().assertNoValues();
		endpoint.getPerson().test().assertError(HttpException.class);
	}
}