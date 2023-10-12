package sergey.goit.servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sergey.goit.util.ThymeleafController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ThymeleafController.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        TemplateEngine engine = ThymeleafController.getTemplateEngine();
        Context context = new Context();
        String html = engine.process("hello", context);
        resp.getWriter().write(html);
    }
}