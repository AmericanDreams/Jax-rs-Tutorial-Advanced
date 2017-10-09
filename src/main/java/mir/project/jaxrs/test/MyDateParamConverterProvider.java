package mir.project.jaxrs.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateParamConverterProvider implements ParamConverterProvider {

	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		
		if(rawType.getName().equals(MyDate.class.getName())) {
			
			return new ParamConverter<T>() {

				public T fromString(String value) {
					
					Calendar c = Calendar.getInstance();
					
					if(value.equalsIgnoreCase("today")) {
						//nothing
						
					}else if(value.equalsIgnoreCase("tomorrow")) {
						
						c.add(Calendar.DATE, 1);
						
					}else if(value.equalsIgnoreCase("yesterday")) {
						
						c.add(Calendar.DATE, -1);
						
					}else {
						return null;
					}
					
					MyDate myDate = new MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DATE));
					return rawType.cast(myDate);
				}

				public String toString(T value) {
					return value.toString();
				}
				
				
			};
			
		}
		
		return null;
	}

}
