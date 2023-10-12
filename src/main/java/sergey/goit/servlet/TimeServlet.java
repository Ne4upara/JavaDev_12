package sergey.goit.servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sergey.goit.util.CookieManager;
import sergey.goit.util.ThymeleafController;
import sergey.goit.util.TimeFormatter;
import sergey.goit.util.UserName;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private String formattedTime;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ThymeleafController.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setIntHeader("Refresh", 1); //auto-update page
        resp.setContentType("text/html;charset=UTF-8");
        String timezoneParam = req.getParameter("timezone");
        String name = UserName.userName(req.getParameter("name"));
        Cookie timeCookie = CookieManager.getCookieZone(req, "timezone");

        if (timezoneParam.isEmpty()) {
            if (timeCookie != null) {
                resp.addCookie(timeCookie);
                formattedTime = TimeFormatter.formatTime(new Date(), timeCookie.getValue());
            } else {
                resp.addCookie(CookieManager.nameCookie("timezone", timezoneParam));
                formattedTime = TimeFormatter.formatTime(new Date(), timezoneParam);
            }
        } else {
            resp.addCookie(CookieManager.nameCookie("timezone", timezoneParam));
            formattedTime = TimeFormatter.formatTime(new Date(), timezoneParam);
        }

        TemplateEngine engine = ThymeleafController.getTemplateEngine();
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("gmt", TimeFormatter.getTimezone());
        context.setVariable("formattedTime", formattedTime);
        if (timeCookie != null) {
            context.setVariable("timeCookie", timeCookie.getValue());
        }
        String html = engine.process("time", context);
        resp.getWriter().write(html);
    }
}