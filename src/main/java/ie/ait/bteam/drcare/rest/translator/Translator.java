package ie.ait.bteam.drcare.rest.translator;

import org.springframework.stereotype.Component;

/**
 * @author adheli.tavares
 * @param <T1> Database model
 * @param <T2> REST api model
 */
@Component
public interface Translator<T1, T2> {

	/**
	 * Map the database model to REST api model.
	 * @param original Class from data model.
	 * @return REST api model with all params mapped.
	 */
	T2 translateFrom(T1 original);

	/**
	 * Map the REST api model to database model.
	 * @param copy Class from REST api model.
	 * @return Data model with all params mapped.
	 */
	T1 translateTo(T2 copy);
}
