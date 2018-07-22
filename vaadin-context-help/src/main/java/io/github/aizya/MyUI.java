package io.github.aizya;

import javax.servlet.annotation.WebServlet;

import com.polelink.utils.vaadin.contexthelp.ContextHelp;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	private static final String nameHelp = "Fill the <i>name</i> field with your name or the name of the contact person for your company.";

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final ContextHelp contextHelp = new ContextHelp();
		contextHelp.extend(this);
		// 这个必须开启，否则无法启动提示功能
		contextHelp.setFollowFocus(true);
		final VerticalLayout layout = new VerticalLayout();

		TextField textField = new TextField("Test Context Help");

		contextHelp.addHelpForComponent(textField, nameHelp);

		layout.addComponents(textField);
		layout.setMargin(true);
		layout.setSpacing(true);

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
