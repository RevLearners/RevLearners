package io.revlearners.controller.routing;

import org.springframework.beans.factory.annotation.Autowired;

import io.revlearners.util.commons.ServiceFacade;

public abstract class WebServicesController {
	
	@Autowired
	protected ServiceFacade serviceFacade;
	
	// Surprisingly, DispatcherServlet does not support the behavior of 
	// subclassing requests from an abstract controller...
}