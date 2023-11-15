// ========================================================================
// Copyright (c) Webtide LLC
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
//
// The Eclipse Public License is available at 
// http://www.eclipse.org/legal/epl-v10.html
//
// The Apache License v2.0 is available at
// http://www.apache.org/licenses/LICENSE-2.0.txt
//
// You may elect to redistribute this code under either of these licenses. 
// ========================================================================

package org.mortbay.jetty.tests.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * Servlet that tweaks the existing configuration.
 */
public class LoggingConfigServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LogManager.getLogger(LoggingConfigServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        // Attempt to reconfigure the level of the root logger
        Logger root = LogManager.getRootLogger();

        org.apache.logging.log4j.core.Logger coreRoot = (org.apache.logging.log4j.core.Logger)root;
        coreRoot.setLevel(Level.WARN);
        LOG.info("Set level to WARN");
        LOG.warn("Set level to WARN");
        
        // Attempt to add a new console appender
        PatternLayout layout = PatternLayout.newBuilder().withPattern("#CONFIGURED# %r [%t] %p %c %x - %m%n").build();
        ConsoleAppender appender = ConsoleAppender.newBuilder().setLayout(layout).build();
        coreRoot.addAppender(appender);

        LOG.info("Added ConsoleAppender");
        LOG.warn("Added ConsoleAppender");
    }
}
