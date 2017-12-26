package oxyzo.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;
import oxyzo.utils.Context;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by nitika on 25/11/17.
 */

public class VelocityTemplateFactory {

    private static final VelocityTemplateFactory instance = new VelocityTemplateFactory();
    private final VelocityEngine velocityEngine;


    private VelocityTemplateFactory() {

        velocityEngine = new VelocityEngine();
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE, IncludeRelativePath.class.getName());
        velocityEngine.init();
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public static String convertTemplateToString(String path) {
        VelocityContext context = new VelocityContext();
        context.put("context", Context.getInstance());
        return convertTemplateToString(context, path);
    }


    public static String convertTemplateToString(VelocityContext context, String path) {
        try {
            Template template = instance.getVelocityEngine().getTemplate(path);
            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
