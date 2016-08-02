package spring4core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*package spring4core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainApp
{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ctx.scan("spring4core");// scans mentioned package, can scan for both, @Configuration, and @Component classes
		ctx.register(Config.class);// registers configuration class, which it finds, after scanning
		ctx.refresh();// refreshes applicationContext
		ctx.getBean("trngl", Triangle.class).draw();
	}	 
}
*/


public class MainApp extends AnnotationConfigApplicationContext 
//AnnotationConfigApplicationContext is stand alone application context ,accepts @Configuration and @component classes
{

	public static void main(String[] args) {
		
      /* ApplicationContext ctx=new ClassPathXmlApplicationContext("practice.xml");
       ctx.getBean("trngl",Triangle.class).draw();
      */
	   
      MainApp ma=new MainApp(); // object of subclass to AnnotationConfigApplicationContext
      ma.scan("spring4core");//scans mentioned package, can scan for both, @Configuration, and @Component classes
      ma.register(Config.class);//registers configuration class, which it finds, after scanning
      ma.refresh();// refreshes applicationContext
      ma.getBean( Triangle.class).draw();
      ma.close();
	}
	
	/*above code is replacement to this xml file, which requires config bean to be created in xml file, annotation- config to be declared.
	 * <bean class="spring4core.Config"/>
	<context:annotation-config/>
	*/

}