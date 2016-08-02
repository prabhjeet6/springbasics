package spring4core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Import(value = { spring4core.Messageconfig.class,
		spring4core.Pointconfig.class })
// we can also import from xml files, mentioning their name with .xml extention,
// in '@ImportResource' annotation
@Configuration
@Profile("test")
// there can be multiple profiles viz. test/dev/production, we mention the
// active profile environment variable in properties file, in our case, it is
// messages.properties.
/*
 * Spring Profiles provide a way to segregate parts of your application
 * configuration and make it only available in certain environments. Any
 * @Component or @Configuration can be marked with @Profile to limit when it is
 * loaded: You can programmatically set active profiles by calling
 * SpringApplication.setAdditionalProfiles(…​) before your application runs
 */
@EnableAspectJAutoProxy
// equivalent to <aop:aspectj-autoproxy/> in xml.
@ComponentScan(basePackages = { "spring4core" })
// @AnnotationDrivenConfig ????
public class Config {

	@Autowired
	@Qualifier(value = "Point_bean")
	List<Point> ps;

	// Qualifier value is the value of name attribute in bean annotation for the
	// class concerned.

	/*@Bean
	Triangle getTriangle() {
		return new Triangle();
	}*/

	/*
	 * name attribute in @Bean annotation is equivalent to id attribute in bean
	 * tag, return type in the method is interface type, and we return
	 * implementer object(IOC)
	 * 
	 * @Bean public static PropertySourcesPlaceholderConfigurer
	 * propertyPlaceholderConfigurer() { return new
	 * PropertySourcesPlaceholderConfigurer(); }
	 * 
	 * 
	 * In order for @Value annotations to work
	 * PropertySourcesPlaceholderConfigurer should be registered. It is done
	 * automatically when using <context:property-placeholder> in XML, but
	 * should be registered as a static @Bean when using @Configuration
	 * 
	 * 
	 * if we use @ImportResource("classpath:property-config.xml"), instead of
	 * using @Value, we do not need to register
	 * PropertySourcesPlaceholderConfigurer.
	 */
}
