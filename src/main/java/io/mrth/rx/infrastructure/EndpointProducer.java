package io.mrth.rx.infrastructure;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.mrth.rx.endpoint.RandomPersonEndpoint;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class EndpointProducer {

	private RandomPersonEndpoint endpoint;

	@PostConstruct
	public void init() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://randomuser.me")
				.addConverterFactory(JacksonConverterFactory.create(objectMapper))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
		endpoint = retrofit.create(RandomPersonEndpoint.class);
	}

	@Produces
	@Dependent
	public RandomPersonEndpoint getEndpoint() {
		return endpoint;
	}
}
