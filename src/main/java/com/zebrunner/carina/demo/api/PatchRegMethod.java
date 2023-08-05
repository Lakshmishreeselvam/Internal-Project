package com.zebrunner.carina.demo.api;

import com.azure.core.util.Configuration;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;

@Endpoint(url = "${base_url}/users/2", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/users/_post/rq_regres.json")
@ResponseTemplatePath(path = "api/users/_post/rs_regres.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)

public class PatchRegMethod {

	public PatchRegMethod() {

        super("api/users/_post/rq_patch_reg.json", "api/users/_post/rs_patch_reg.json", "api/users/reg.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
	
}
