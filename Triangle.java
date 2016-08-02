package spring4core;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements DisposableBean, InitializingBean {
	
	@Autowired
	List<Point> p;

	public List<Point> getP() {
		return p;
	}

	public void setP(List<Point> p) {
		this.p = p;
	}
	
	public void draw()
	{
		System.out.println("Points Size==> " + p.size());
		System.out.println("Points==> " + p);
		for(Point po:p)
		{
			System.out.println("x "+po.getX()+" y "+ Integer.parseInt(po.getMsg().getMessage("y",null,"-1",null)));
			
		}
	}

	@Override
	public String toString() {
		return "Triangle [p=" + p + "]";
	}

	@Override
	public void destroy() throws Exception {

		System.out.println("triangle distroyed");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("triangle initialised");
		
	}
	
	

}
