package spring4core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ImportResource("file:property-config.xml")//creates a different bean
public class Pointconfig {


	int x;
	int y;

	@Autowired
	@Qualifier(value = "messageSource")
	MessageSource msg;

	
	
	/*@Bean(name = "Point_bean")// duplicaTE OF component, so single bean in singleton scope
	@Scope("Singleton")
	Point getPoint() {
		Point p = new Point();
		// p.init(); valid, in case, not using @PostConstruct or init Method declaration in @Bean annotation,which is equivalent to init method parameter of bean tag
		return p;
	}*/

}
