package com.zebrunner.carina.demo.api;

import com.azure.core.util.Configuration;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/_post/rq_post_regress.json")
@ResponseTemplatePath(path = "api/users/_post/rs_post_regress.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostRegMethod {
	
	 public void PostRegMethod() {
	        super("api/users/_post/rq_regres.json", "api/users/_post/rs_regres.json", "api/users/regres.properties");
	        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
	    }

}
