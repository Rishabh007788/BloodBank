package blood.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Diapatcher_Servlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	} 

	@Override
	protected Class[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] arr= {Myconfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] arr = {"/"};
		return arr;
	}

}

