package spring4core;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Point implements BeanNameAware {


	/*Setter-based DI is accomplished by the container calling setter methods on your beans after invoking 
	a "no-argument constructor" or no-argument static factory method to instantiate your bean
	
	Constructor-based DI is accomplished by the container invoking a constructor with a number of arguments, each representing a dependency.
	
	@Inject can be called in place of @Autowired*/
	
	int x;
	int y;
	
	public String getBean_name() {
		return bean_name;
	}

	public void setBean_name(String bean_name) {
		this.bean_name = bean_name;
	}

	String bean_name;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		
	}
	@Autowired
	MessageSource msg;
	public MessageSource getMsg() {
		return msg;
	}

	public void setMsg(MessageSource msg) {
		this.msg = msg;
	}
	
	

	@PostConstruct
	void init() {
		System.out.println("initializing point @PostConstruct");
	}

	@Override
	public void setBeanName(String bean_name) {
		this.bean_name = bean_name;

	}

	// All Aware Interfaces are supported, automatically called when required,
	// upon instantiation in config class
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", bean_name=" + bean_name
				+ ", msg=" + msg + "]";
	}

}
