package org.sprintdragon.opensource.springbootrest;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by wangdi on 17-6-15.
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    //当用户与服务器之间开始session时触发该方法
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        //获取session ID
        String sessionsessionId = session.getId();
        //如果是一次新的会话
        if (session.isNew()) {
            String user = (String) session.getAttribute("user");
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
