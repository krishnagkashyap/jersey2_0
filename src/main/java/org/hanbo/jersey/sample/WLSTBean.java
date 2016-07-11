/* $Header: ngam/src/wlst/src/main/java/oracle/security/am/wlst/beans/WLSTBean.java /main/3 2010/03/23 23:04:23 rmanchik Exp $ */

/* Copyright (c) 2009, 2010, Oracle and/or its affiliates. 
All rights reserved. */

/*
   DESCRIPTION
    <short description of component this file declares/defines>

   PRIVATE CLASSES
    <list of private classes defined - with one-line descriptions>

   NOTES
    <other useful comments, qualifications, etc.>

   MODIFIED    (MM/DD/YY)
    rmanchik    03/19/10 - bug-9460560-9468589-9471956
    rmanchik    12/14/09 - adding logging
    nagakula    12/07/09 - Changing Map
    rmanchik    12/06/09 - main abstract level bean
    rmanchik    12/06/09 - Creation
 */

/**
 *  @version $Header: ngam/src/wlst/src/main/java/oracle/security/am/wlst/beans/WLSTBean.java /main/3 2010/03/23 23:04:23 rmanchik Exp $
 *  @author  rmanchik
 *  @since   release specific (what release of product did this appear in)
 */
package org.hanbo.jersey.sample;

import java.util.Iterator;
import java.util.Map;
import javax.management.MBeanServerConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

//import oracle.security.am.common.utilities.constant.Component;
//import oracle.security.am.common.utilities.log.OAMLogger;
//import oracle.security.am.wlst.resource.LoggingMessageKeys;
//
//import oracle.security.am.wlst.util.WLSTWrapperConstants;

public class WLSTBean
{

	/** The Constant s_logger. */
//	private static final Logger LOGGER = OAMLogger.getLogger(Component.WLST);

	/** The Constant CLASS_NAME. */
	private static final String CLASS_NAME = WLSTBean.class.getName();

	//LOGGER.entering(CLASS_NAME);

	// map fetched from script
	private Map<String, Object> argMap = null;

	// to check if the command is online/offline based.
	private boolean isOnline = false;

	public Map<String,Object> getArgMap(){
		return argMap;
	}

	public boolean isOnline()
	{
		return isOnline;
	}

	public void setOnline(boolean isOnline)
	{
		this.isOnline = isOnline;
	}

	public WLSTBean(Map<String, Object> attributesMap)
	{
		this.argMap = attributesMap;
	}

	public String getCommandGroup()
	{
		return (String) argMap.get(WLSTWrapperConstants.WLST_COMMAND_GRP);
	}

	public String getCommand()
	{
		return (String) argMap.get(WLSTWrapperConstants.WLST_COMMAND);
	}

	public String getDomainHome()
	{
		return (String) argMap.get(WLSTWrapperConstants.DOMAIN_HOME);
	}

	public MBeanServerConnection getJMXConnection()
	{
		return (MBeanServerConnection) argMap
		    .get(WLSTWrapperConstants.JMX_CONNECTION);
	}

	public Object getArgValue(Object arg)
	{
		return argMap.get(arg);
	}

	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		Iterator<String> argsItr = argMap.keySet().iterator();

		while (argsItr.hasNext())
		{
			String key = argsItr.next();
			builder.append(key).append("=").append(argMap.get(key)).append(":");
		}

		return builder.toString();
	}
}
