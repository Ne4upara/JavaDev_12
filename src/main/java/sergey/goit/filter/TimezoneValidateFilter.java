package sergey.goit.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/time")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String timezoneParam = req.getParameter("timezone");
        if (timezoneParam.isEmpty()) {
            chain.doFilter(req, res);
        } else if (!timezoneParam.matches("-?\\d+") && !timezoneParam.matches("\\+\\d+")) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Timezone needs to be a digit");
        } else {
            int timezone = Integer.parseInt(timezoneParam);
            if (-12 <= timezone && timezone <= 14) {
                chain.doFilter(req, res);
            } else {
                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid timezone");
            }
        }
    }
}