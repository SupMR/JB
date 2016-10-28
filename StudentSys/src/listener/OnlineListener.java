package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

		ServletContext context=arg0.getSession().getServletContext();
		Integer onlineNum=(Integer)context.getAttribute("onlineNum");
		if(onlineNum==null)
			context.setAttribute("onlineNum", 1);
		else{
			onlineNum++;
			context.setAttribute("onlineNum", onlineNum);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

		ServletContext context=arg0.getSession().getServletContext();
		Integer onlineNum=(Integer)context.getAttribute("onlineNum");
		onlineNum--;
		context.setAttribute("onlineNum", onlineNum);

	}

}
