package oxyzo.methods;

import com.jayway.restassured.RestAssured;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import oxyzo.utils.Context;

/**
 * Created by nitika on 05/12/17.
 */
public class BaseUtils {

    //Before Suite
    @BeforeSuite
    public void turnOffTestNgListeners() {

        TestNG myTestNG = new TestNG();
        myTestNG.setUseDefaultListeners(true);
    }

    @BeforeSuite
    public void turnOffTestNgListener() {

        TestNG myTestNG = new TestNG();
        myTestNG.setUseDefaultListeners(true);
        System.out.println("which option to select: \n 1. loan application with no sales assignee \n 2. loan "
            + "application with sales assignee \n 3. loan application status - processing \n 4. loan application"
            + "status - underwriting \n 5. loan application status - sent_to_nbfc \n 6. loan application status - "
            + "offered status \n 7.loan application in accepted status i.e loan with loan-id and with status - "
            + "waiting_for_docs");

    }
    private static final Context context = Context.getInstance();

    @BeforeSuite(groups = {"sanity"})
    public void setURL() {
        // Setup data
      //  setupData();
        //RestAssured.baseURI = context.getBaseURI();
    }

    public void setupData() {
        try {
            // Setup Data
            Resource resource = new ClassPathResource("staging/environment.properties");
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            context.setBaseURI(properties.getProperty("baseURI"));
            context.setApiURI(properties.getProperty("apiURI"));
            System.out.println(properties.getProperty("baseURI"));
        }
        catch (Exception e)
        {
            throw new IllegalStateException("exception", e);
        }
    }
}
