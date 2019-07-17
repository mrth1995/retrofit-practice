package io.mrth.netzme.test.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NetzmeResponse<T> {

	private List<T> results;

	public List<T> getResults() {
		return results;
	}
}
