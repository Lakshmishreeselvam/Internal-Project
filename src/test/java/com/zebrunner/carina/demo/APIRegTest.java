package com.zebrunner.carina.demo;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.GetRegMethod;
import com.zebrunner.carina.demo.api.PatchRegMethod;
import com.zebrunner.carina.demo.api.PostRegMethod;

public class APIRegTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Lakshmi Shree")
    public void testGetUsers() {

        GetRegMethod getRegresMethod = new GetRegMethod();
        getRegresMethod.callAPIExpectSuccess();
        getRegresMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getRegresMethod.validateResponseAgainstSchema("api/users/_get/rs_regres.schema");

    }

    @Test()
    @MethodOwner(owner = "Lakshmi Shree")
    public void testCreateUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");

        //Gets data from .properties
        PostRegMethod api = new PostRegMethod();
        api.setProperties("api/users/regres.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Lakshmi Shree")
    public void testPatchUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");

        //Gets data from .properties
        PatchRegMethod api = new PatchRegMethod();
        api.setProperties("api/users/patch_regres.properties");

       

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }
	
}
