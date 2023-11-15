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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoggingServlet
 */
public class LoggingServlet extends HttpServlet
{
    private static final Logger LOG = LoggerFactory.getLogger(LoggingServlet.class);

    /**
     * Default constructor.
     */
    public LoggingServlet()
    {
        LOG.debug("initialized");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LOG.info("GET requested");

        LOG.warn("Slightly warn, with a chance of log events");

        LOG.error("Nothing is (intentionally) being output by this Servlet");

        Throwable severe = new AppException("App Exception (logback)");

        LOG.error("Whoops (intentionally) causing a Throwable", severe);
    }
}
