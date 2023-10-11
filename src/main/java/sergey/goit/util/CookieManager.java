package sergey.goit.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieManager {
    public static Cookie getCookieZone(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static Cookie nameCookie(String name, String value) {
        Cookie timeCookie = new Cookie(name, value);
        timeCookie.setMaxAge(60);
        timeCookie.setSecure(true);
        return timeCookie;
    }
}