package sergey.goit.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

public class ThymeleafController {
    private static TemplateEngine engine;

    public static void init() {
        engine = new TemplateEngine();
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\my\\WEB-INF\\templates\\");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);
    }

    public static TemplateEngine getTemplateEngine() {
        return engine;
    }
}