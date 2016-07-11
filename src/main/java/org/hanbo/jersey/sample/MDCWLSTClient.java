package org.hanbo.jersey.sample;

/**
 * Created by kgurupra on 4/29/2016.
 */

import org.json.JSONObject;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

//@Path("/enableMDC")
public class MDCWLSTClient {
    private String mdcClusterName = null;
    private String remoteDataCentreClusterId = null;
    private String adminServerHost = null;
    private String adminServerPort = null;
    private String oamServerMode = null;
    private String oamPrimaryServerHost = null;
    private String oamPrimaryServerPort = null;
    private String accessClientPasswd = null;
    private String wlsUserName = null;
    private String wlsUserPassword = null;
    private String mdcCombination = null;
    private static Properties properties = null;
    private static Properties mdcProperties = null;
    private static MDCWLSTBean mdcWlstBean = null;
    private static JMXConnector jmxCon = null;
    private static MBeanServerConnection con = null;


    public MDCWLSTClient() {
    }

    public MDCWLSTClient(String adminServerHost, String adminServerPort, String partnerId) {
        this.remoteDataCentreClusterId = remoteDataCentreClusterId;
        this.adminServerHost = adminServerHost;
        this.adminServerPort = adminServerPort;

        mdcWlstBean = new MDCWLSTBean();
        mdcWlstBean.setAdminServerHost(adminServerHost);
        mdcWlstBean.setAdminServerPort(adminServerPort);
        mdcWlstBean.setRemoteDataCentreClusterId(remoteDataCentreClusterId);
    }

    public MDCWLSTClient(String remoteDataCentreClusterId, String mdcClusterName, String adminServerHost, String adminServerPort, String oamServerMode, String oamPrimaryServerHost, String oamPrimaryServerPort, String accessClientPasswd, String wlsUserName, String wlsUserPassword) {

        this.mdcClusterName = mdcClusterName;
        this.adminServerHost = adminServerHost;
        this.adminServerPort = adminServerPort;
        this.oamServerMode = oamServerMode;
        this.oamPrimaryServerHost = oamPrimaryServerHost;
        this.oamPrimaryServerPort = oamPrimaryServerPort;
        this.accessClientPasswd = accessClientPasswd;
        this.wlsUserName = wlsUserName;
        this.wlsUserPassword = wlsUserPassword;
        this.mdcCombination = mdcCombination;
        this.remoteDataCentreClusterId = remoteDataCentreClusterId;

        System.out.println("adminServerHost>>" + remoteDataCentreClusterId);
        System.out.println("adminServerHost>>" + mdcClusterName);
        System.out.println("adminServerHost>>" + adminServerHost);
        System.out.println("adminServerPort>>" + adminServerPort);
        System.out.println("oamServerMode>>" + oamServerMode);
        System.out.println("oamPrimaryServerHost>>" + oamPrimaryServerHost);
        System.out.println("oamPrimaryServerPort>>" + oamPrimaryServerPort);
        System.out.println("accessClientPasswd>>" + accessClientPasswd);
        System.out.println("wlsUserName>>" + wlsUserName);
        System.out.println("wlsUserPassword>>" + wlsUserPassword);
        System.out.println("mdcCombination>>" + mdcCombination);


        //Populate all the values to MDCWLSTBean
        mdcWlstBean = new MDCWLSTBean();
        mdcWlstBean.setMdcClusterName(mdcClusterName);
        mdcWlstBean.setAdminServerHost(adminServerHost);
        mdcWlstBean.setAdminServerPort(adminServerPort);
        mdcWlstBean.setOamServerMode(oamServerMode);
        mdcWlstBean.setOamPrimaryServerHost(oamPrimaryServerHost);
        mdcWlstBean.setOamPrimaryServerPort(oamPrimaryServerPort);
        mdcWlstBean.setAccessClientPasswd(accessClientPasswd);
        mdcWlstBean.setWlsUserName(wlsUserName);
        mdcWlstBean.setWlsUserPassword(wlsUserPassword);
        mdcWlstBean.setMdcCombination(mdcCombination);
        mdcWlstBean.setRemoteDataCentreClusterId(remoteDataCentreClusterId);

        System.out.println("AFTER adminServerHost>>" + mdcWlstBean.getMdcClusterName());
        System.out.println("AFTER adminServerHost>>" + mdcWlstBean.getMdcClusterName());
        System.out.println("AFTER adminServerHost>>" + mdcWlstBean.getAdminServerHost());
        System.out.println("AFTER adminServerPort>>" + mdcWlstBean.getAdminServerPort());
        System.out.println("AFTER oamServerMode>>" + mdcWlstBean.getOamServerMode());
        System.out.println("AFTER oamPrimaryServerHost>>" + mdcWlstBean.getOamPrimaryServerHost());
        System.out.println("AFTER oamPrimaryServerPort>>" + mdcWlstBean.getOamPrimaryServerPort());
        System.out.println("AFTER accessClientPasswd>>" + mdcWlstBean.getAccessClientPasswd());
        System.out.println("AFTER wlsUserName>>" + mdcWlstBean.getWlsUserName());
        System.out.println("AFTER wlsUserPassword>>" + mdcWlstBean.getWlsUserPassword());
        System.out.println("AFTER mdcCombination>>" + mdcWlstBean.getMdcCombination());

    }

    public static String updateService(String path, Boolean flag) throws Exception {
        String output = null;
        try {

            System.out.println("ADMIN SERVER HOST >>>> " + mdcWlstBean.getAdminServerHost());
            System.out.println("ADMIN SERVER PORT >>>> " + mdcWlstBean.getAdminServerPort());

            JMXServiceURL serviceUrl =
                    new JMXServiceURL(
                            "service:jmx:t3://" + mdcWlstBean.getAdminServerHost() + ":" + mdcWlstBean.getAdminServerPort() + "/jndi/weblogic.management.mbeanservers.domainruntime");

            System.out.println("Connecting to: " + serviceUrl);

            Hashtable env = new Hashtable();
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            System.out.println("WLST USER NAME >>>> " + mdcWlstBean.getWlsUserName());
            System.out.println("WLST USER PASSWORD >>>> " + mdcWlstBean.getWlsUserPassword());
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, mdcWlstBean.getWlsUserName());
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, mdcWlstBean.getWlsUserPassword());

            System.out.println(">>>>>>>>Obtaining JMX Connection...");
            jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);
            System.out.println(">>>>>>>>Making JMX Connection...");
            jmxCon.connect();
            con = jmxCon.getMBeanServerConnection();


            output = MDCWLSTCommandeCollection.updateService(null, con, path, flag);

            System.out.println("CLUSTER NAME COMMAND >>>>>>>>>>" + output);

        } finally {
            if (jmxCon != null)
                jmxCon.close();
        }
        return output;
    }


    public static String setMultiDataCentreClusterNameOnline(String clusterName) throws Exception {
        String output = null;
        try {

            System.out.println("ADMIN SERVER HOST >>>> " + mdcWlstBean.getAdminServerHost());
            System.out.println("ADMIN SERVER PORT >>>> " + mdcWlstBean.getAdminServerPort());

            JMXServiceURL serviceUrl =
                    new JMXServiceURL(
                            "service:jmx:iiop://" + mdcWlstBean.getAdminServerHost() + ":" + mdcWlstBean.getAdminServerPort() + "/jndi/weblogic.management.mbeanservers.runtime");

            System.out.println("Connecting to: " + serviceUrl);

            Hashtable env = new Hashtable();
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, mdcWlstBean.getWlsUserName());
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, mdcWlstBean.getWlsUserPassword());

            jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);
            jmxCon.connect();
            con = jmxCon.getMBeanServerConnection();
            output = MDCWLSTCommandeCollection.setMultiDataCentreClusterNameOnline(con, clusterName);
            System.out.println("CLUSTER NAME COMMAND >>>>>>>>>>" + output);

        } finally {
            if (jmxCon != null)
                jmxCon.close();
        }
        return output;
    }


    public static String disableMultiDataCentreModeOnline() throws Exception {
        String output = null;
        try {

            System.out.println("ADMIN SERVER HOST >>>> " + mdcWlstBean.getAdminServerHost());
            System.out.println("ADMIN SERVER PORT >>>> " + mdcWlstBean.getAdminServerPort());

            JMXServiceURL serviceUrl =
                    new JMXServiceURL(
                            "service:jmx:iiop://" + mdcWlstBean.getAdminServerHost() + ":" + mdcWlstBean.getAdminServerPort() + "/jndi/weblogic.management.mbeanservers.runtime");

            System.out.println("Connecting to: " + serviceUrl);

            Hashtable env = new Hashtable();
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, mdcWlstBean.getWlsUserName());
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, mdcWlstBean.getWlsUserPassword());

            jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);
            jmxCon.connect();
            con = jmxCon.getMBeanServerConnection();
            output = MDCWLSTCommandeCollection.disableMultiDataCentreModeOnline(con);
            System.out.println("CLUSTER NAME COMMAND >>>>>>>>>>" + output);

        } finally {
            if (jmxCon != null)
                jmxCon.close();
        }
        return output;
    }


    public static String enableMultiDataCentreModeOnline(Properties mdcComb) throws Exception {
        String output = null;
        try {

            System.out.println("ADMIN SERVER HOST >>>> " + mdcWlstBean.getAdminServerHost());
            System.out.println("ADMIN SERVER PORT >>>> " + mdcWlstBean.getAdminServerPort());

            JMXServiceURL serviceUrl =
                    new JMXServiceURL(
                            "service:jmx:iiop://" + mdcWlstBean.getAdminServerHost() + ":" + mdcWlstBean.getAdminServerPort() + "/jndi/weblogic.management.mbeanservers.runtime");

            System.out.println("Connecting to: " + serviceUrl);

            Hashtable env = new Hashtable();
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, mdcWlstBean.getWlsUserName());
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, mdcWlstBean.getWlsUserPassword());

            jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);
            jmxCon.connect();
            con = jmxCon.getMBeanServerConnection();

//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            URL is = classLoader.getResource("mdc/oamMDCProperty_comb14.properties");
//
//            File file = new File(is.toURI());
//            System.out.println("MDC Properties FILE PATH >>>>>>>>>> " + file.getAbsolutePath());


            output = MDCWLSTCommandeCollection.enableMultiDataCentreModeOnline(null, con, mdcComb);
            System.out.println("CLUSTER NAME COMMAND >>>>>>>>>>" + output);

        } finally {
            if (jmxCon != null)
                jmxCon.close();
        }
        return output;
    }

    public static String removePartnerForMultiDataCentre(String partnerId) throws Exception {
        String output = null;
        try {

            System.out.println("ADMIN SERVER HOST >>>> " + mdcWlstBean.getAdminServerHost());
            System.out.println("ADMIN SERVER PORT >>>> " + mdcWlstBean.getAdminServerPort());

            JMXServiceURL serviceUrl =
                    new JMXServiceURL(
                            "service:jmx:iiop://" + mdcWlstBean.getAdminServerHost() + ":" + mdcWlstBean.getAdminServerPort() + "/jndi/weblogic.management.mbeanservers.runtime");

            System.out.println("Connecting to: " + serviceUrl);

            Hashtable env = new Hashtable();
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, mdcWlstBean.getWlsUserName());
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, mdcWlstBean.getWlsUserPassword());

            jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);
            jmxCon.connect();
            con = jmxCon.getMBeanServerConnection();

/*            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL is = classLoader.getResource("mdc/oamMDCProperty_comb14.properties");

            File file = new File(is.toURI());
            System.out.println("MDC Properties FILE PATH >>>>>>>>>> " + file.getAbsolutePath());*/


            output = MDCWLSTCommandeCollection.removePartnerForMultiDataCentre(null, con, partnerId);
            System.out.println("CLUSTER NAME COMMAND >>>>>>>>>>" + output);

        } finally {
            if (jmxCon != null)
                jmxCon.close();
        }
        return output;
    }

    public static String addPartnerForMultiDataCentre(Properties properties) throws Exception {
        String output = null;
        try {

            System.out.println("ADMIN SERVER HOST >>>> " + mdcWlstBean.getAdminServerHost());
            System.out.println("ADMIN SERVER PORT >>>> " + mdcWlstBean.getAdminServerPort());

            JMXServiceURL serviceUrl =
                    new JMXServiceURL(
                            "service:jmx:iiop://" + mdcWlstBean.getAdminServerHost() + ":" + mdcWlstBean.getAdminServerPort() + "/jndi/weblogic.management.mbeanservers.runtime");

            System.out.println("Connecting to: " + serviceUrl);

            Hashtable env = new Hashtable();
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                    "weblogic.management.remote");
            System.out.println("WLST USER NAME >>>> " + mdcWlstBean.getWlsUserName());
            System.out.println("WLST USER PASSWORD >>>> " + mdcWlstBean.getWlsUserPassword());
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, mdcWlstBean.getWlsUserName());
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, mdcWlstBean.getWlsUserPassword());

            System.out.println(">>>>>>>>Obtaining JMX Connection...");
            jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);
            System.out.println(">>>>>>>>Making JMX Connection...");
            jmxCon.connect();
            con = jmxCon.getMBeanServerConnection();

//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            URL partners = classLoader.getResource("mdc/partner2Info.properties");
//
//            File partnersFile = new File(partners.toURI());
//            System.out.println("Partners FILE PATH >>>>>>>>>> " + partnersFile.getAbsolutePath());


            output = MDCWLSTCommandeCollection.addPartnerForMultiDataCentre(null, con, properties);
            System.out.println("CLUSTER NAME COMMAND >>>>>>>>>>" + output);

        } finally {
            if (jmxCon != null)
                jmxCon.close();
        }
        return output;
    }

    public static void main(String[] args) throws Exception {

        MDCWLSTClient mdcwlstClient = new MDCWLSTClient("DC22", "DC1", "slc01hjo.us.oracle.com", "16801", "OPEN", "slc02jqf.us.oracle.com", "15796", "Welcome1", "weblogic", "welcome1");
//        MDCWLSTClient.setMultiDataCentreClusterNameOnline("DC1");

//        MDCWLSTClient.disableMultiDataCentreModeOnline();

//        MDCWLSTClient.enableMultiDataCentreModeOnline();


        MDCWLSTClient.removePartnerForMultiDataCentre("DC22");

//        MDCWLSTClient.addPartnerForMultiDataCentre();
    }
}