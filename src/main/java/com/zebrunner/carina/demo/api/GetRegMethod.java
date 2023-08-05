package com.zebrunner.carina.demo.api;

import com.azure.core.util.Configuration;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get/rs_regres.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetRegMethod {
	
	 public GetRegMethod() {
	        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
	    }

}
