package io.mrth.rx.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RandomPersonResponse<T> {

	private List<T> results;

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RandomPersonResponse<?> that = (RandomPersonResponse<?>) o;
		return Objects.equals(results, that.results);
	}

	@Override
	public int hashCode() {
		return Objects.hash(results);
	}
}
