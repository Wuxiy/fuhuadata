package com.fuhuadata.web.velocity;


import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolboxFactory;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by intanswer on 2017/2/15.
 */
public class VelocityToolbox20View extends VelocityLayoutView {

    @Override
    protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Create a ViewToolContext instance since ChainedContext is deprecated
        // in Velocity Tools 2.0.
        ViewToolContext velocityContext = new ViewToolContext(
                getVelocityEngine(), request, response, getServletContext());
        velocityContext.putAll(model);

        // Load a Configuration and publish toolboxes to the context when
        // necessary
        if (getToolboxConfigLocation() != null) {
            XmlFactoryConfiguration cfg = new XmlFactoryConfiguration();
            cfg.read(new ServletContextResource(getServletContext(),
                    getToolboxConfigLocation()).getURL());
            ToolboxFactory factory = cfg.createFactory();

            velocityContext
                    .addToolbox(factory.createToolbox(Scope.APPLICATION));
            velocityContext.addToolbox(factory.createToolbox(Scope.REQUEST));
            velocityContext.addToolbox(factory.createToolbox(Scope.SESSION));
        }
        return velocityContext;
    }
}
