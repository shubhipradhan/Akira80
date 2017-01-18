package com.diamond.AkiraFRONTEND.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;




public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class , WebflowConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[] { "/" };
	}

	
}
