package io.github.aizya;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.zipsoft.clicklabel.ClickLabelEvent;
import com.zipsoft.clicklabel.ClickLabelExtension;
import com.zipsoft.clicklabel.ClickLabelListener;
import org.asi.ui.customtextfield.CustomTextField;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		final TextArea textArea = new TextArea("Click event details");
		textArea.setSizeFull();

		final Label demoLabel = new Label("Click on label");

		final ClickLabelExtension extension = new ClickLabelExtension(demoLabel);
		extension.addClickLabelListener(new ClickLabelListener() {

			@Override
			public void onLabelClick(ClickLabelEvent event) {
				final StringBuilder s = new StringBuilder();
				s.append("Clicked Element Details \n");
				s.append(event.getClickedElementDetails().getTagName() + "\n");
				s.append(event.getClickedElementDetails().getId() + "\n");
				s.append(event.getClickedElementDetails().getClassName() + "\n");
				s.append(event.getClickedElementDetails().getHtml() + "\n");
				s.append(event.getClickedElementDetails().getInnerHtml() + "\n");
				s.append(event.getClickedElementDetails().getInnerText() + "\n");
				s.append("-----------\n");
				s.append("MouseEventDetails\n");
				s.append(event.getMouseDetails().toString());
				textArea.setValue(s.toString());
			}
		});

		PopupView popupView = new PopupView();


		layout.addComponents(demoLabel, textArea);
		layout.setMargin(true);
		layout.setSpacing(true);

		setContent(layout);
	}


	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
