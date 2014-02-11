//
//  ========================================================================
//  Copyright (c) 1995-2013 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.mortbay.jetty.tests.webapp;

/**
 * WebApp specific Exception.
 * <p>
 * Here to make sure that the centralized logging doesn't have
 * a classpath / classloader choke on this kind of log.
 */
@SuppressWarnings("serial")
public class AppException extends RuntimeException
{
    public AppException(String msg)
    {
        super(msg);
    }
}
