package org.hanbo.jersey.sample;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.management.openmbean.CompositeData;

import oracle.security.am.admin.config.mgmt.model.BooleanSettings;
import oracle.security.am.admin.config.mgmt.model.Settings;
import oracle.security.am.admin.config.mgmt.model.StringSettings;

/**
 * Created by kgurupra on 4/29/2016.
 */
public class MDCWLSTCommandeCollection {
    public static final String OAM_MDC_PROPERTY = "oamMDCProperty";
    private static final String OAM_MBEAN_LOCATOR = "com.oracle.oam:*";
    private static final String WLST_MBEAN_NAME = "OamWLST";
    private static final String WLST_MBEAN_TYPE = "oam.wlst";
    public static final String WEBGATE_ID_OF_MDC = "webgateId";


    /*
 * Disable the MultiDataCentre Mode
 */
    public static String disableMultiDataCentreModeOnline(MBeanServerConnection connection) {
        final String methodName = "disableMultiDataCentreModeOnline";
        String result = "";
        try {
            ObjectName mbeanObject = getFoundationConfigMBean(connection);
            result = (String) connection.invoke(mbeanObject, "changeMultiDataCentreMode",
                    new Object[]{"false", new String[][]{}}, new String[]{String.class.getName(), String[][].class.getName()});
            result = "MultiData Centre Mode disabled Successfully.";
        } catch (Exception e) {
            result = "Unable to execute the command" + e.getMessage();
        }
        return result;
    }

    /**
     * This method will read the prpo
     *
     * @param wlstBean
     * @return
     * @throws IOException
     */
    public static String addPartnerForMultiDataCentre(WLSTBean wlstBean, MBeanServerConnection connection, Properties properties) throws IOException {
        // TODO
        final String methodName = "addPartnerForMultiDataCentre";
        String result = "";

        try {

            String[][] input_params_array = null;
            String propertiesString = null;
            Properties inputParamsProperty = null;
//            String filePath = partnersFileLoc;

/*            Properties inputParamsProperty = new Properties();
            FileInputStream oFIS = new FileInputStream(filePath);
            if (oFIS != null) {
                inputParamsProperty.load(oFIS);
            }*/
            inputParamsProperty = properties;
        /*Check for mandatory values in the input file */
            validateMandatoryFields(inputParamsProperty);

            input_params_array = retriveInputParamsArray(inputParamsProperty);
            Object[] obMDCParams = new Object[]{input_params_array};
            String[] obMDCSign = new String[]{String[][].class.getName()};
            ObjectName mbeanObject = getFoundationConfigMBean(connection);

            result = (String) connection.invoke(mbeanObject,
                    "addPartnerForMDC", obMDCParams, obMDCSign);

            result = "Partner added successfully.";
        } catch (IOException ioe) {
            throw ioe;

        } catch (Exception e) {

            result = "Unable to execute the command" + e.getMessage();
        }

        return result;
    }

    /*
     * Set MultiData Centre cluster name.
     */
    public static String setMultiDataCentreClusterNameOnline(MBeanServerConnection connection, Object value) {
        final String methodName = "setMultiDataCentreClusterNameOnline";

        String result = "";
        try {
            ObjectName mbeanObject = getFoundationConfigMBean(connection);
            result = (String) connection.invoke(mbeanObject, "setMultiDataCentreClusterName",
                    new String[]{value.toString()}, new String[]{String.class.getName()});
            result = "Successfully added MultiData Centre Cluster Name.";
        } catch (Exception e) {
            e.printStackTrace();
            result = "Unable to execute the command" + e.getMessage();
        }

        return result;
    }

    /*
    *  Enable the MultiDataCentre Mode
    */
    public static String enableMultiDataCentreModeOnline(WLSTBean wlstBean, MBeanServerConnection connection, Properties mdcProperties) throws IOException {
        final String methodName = "enableMultiDataCentreModeOnline";
        String result = "";
        try {
            Object[] obMDCParams = null;
            String[][] input_params_array = null;
            String propertiesString = null;
            String[] obMDCSign = null;
//            String filePath = fileLoc;

            Properties inputParamsProperty = mdcProperties;
//            FileInputStream oFIS = new FileInputStream(filePath);
//            if (oFIS != null) {
//                inputParamsProperty.load(oFIS);
//            }
//            propertiesString = WLSTWrapperConstants.OAM_MDC_PROPERTY;
//

            System.out.println("SessionMustBeAnchoredToDataCenterServicingUser" + inputParamsProperty.get("SessionMustBeAnchoredToDataCenterServicingUser"));
            System.out.println("SessionDataRetrievalOnDemand" + inputParamsProperty.get("SessionDataRetrievalOnDemand"));

            input_params_array = retriveInputParamsArray(inputParamsProperty);
            System.out.println("AFTER input_params_array");

/*
            * Validate the integer elements in the properties file
*/
            validateIntValuesForEnbaleMDC(inputParamsProperty);

            System.out.println("AFTER validateIntValuesForEnbaleMDC");

            ObjectName mbeanObject = getFoundationConfigMBean(connection);


            obMDCParams = new Object[]{"true", input_params_array};
            obMDCSign = new String[]{String.class.getName(),
                    String[][].class.getName()};
            result = (String) connection.invoke(mbeanObject, "changeMultiDataCentreMode",
                    obMDCParams, obMDCSign);
            result = "MultiData Centre Mode enabled Successfully.";

        } catch (IOException ioe) {
            if (ioe.getMessage().startsWith("Property Value NULL for") || ioe.getMessage().startsWith("Enter valid security Mode"))
                throw ioe;
        } catch (NumberFormatException nfe) {
            if (nfe.getMessage().startsWith("Provide valid number for"))
                throw nfe;
        } catch (Exception e) {
            result = "Unable to execute the command" + e.getMessage();
        }
        return result;
    }


    /**
     * This method will iterate the properties and generates a new String[][]
     *
     * @param inputParamsProperty
     * @return
     * @throws IOException
     */
    public static String[][] retriveInputParamsArray(Properties inputParamsProperty) throws IOException {
        final String methodName = "retriveInputParamsArray";
        String[][] inputParamsArray;
        inputParamsArray = new String[inputParamsProperty.size()][2];
        Iterator iter = inputParamsProperty.keySet().iterator();
        for (int i = 0; i < inputParamsProperty.size(); i++) {
            String iterArg = (String) iter.next();
            inputParamsArray[i][0] = iterArg;
            if (inputParamsProperty.get(iterArg) != null && !(inputParamsProperty.get(iterArg).equals(""))) {
                inputParamsArray[i][1] = (String) inputParamsProperty.get(iterArg);

            }
        }
        return inputParamsArray;
    }

    /**
     * This method validates the input values for integer fields while enabling MDC
     *
     * @param inputParamsProperty
     */
    public static void validateIntValuesForEnbaleMDC(Properties inputParamsProperty) throws IOException, NumberFormatException {

        final String methodName = "validateIntValuesForEnbaleMDC";

        if (null != inputParamsProperty) {

            if (inputParamsProperty.containsKey(WLSTWrapperConstants.KEY_SESSION_RETRIEVAL_MAX_RETRY_ATTEMPTS)) {
                String maxAttempts = inputParamsProperty.getProperty(WLSTWrapperConstants.KEY_SESSION_RETRIEVAL_MAX_RETRY_ATTEMPTS);

                try {
                    if (null != maxAttempts && !"".equals(maxAttempts)) {
                        Integer attempts = new Integer(maxAttempts);
                    }
                } catch (NumberFormatException nfe) {
                    // TODO: Add catch code
                    throw new NumberFormatException("Provide valid number for :" + WLSTWrapperConstants.KEY_SESSION_RETRIEVAL_MAX_RETRY_ATTEMPTS);
                }
            }
            if (inputParamsProperty.containsKey(WLSTWrapperConstants.KEY_SESSION_RETRIEVAL_MAX_CONN_WAIT_TIME)) {
                String waitTime = inputParamsProperty.getProperty(WLSTWrapperConstants.KEY_SESSION_RETRIEVAL_MAX_CONN_WAIT_TIME);

                try {
                    if (null != waitTime && !"".equals(waitTime)) {
                        Integer time = new Integer(waitTime);
                    }
                } catch (NumberFormatException nfe) {
                    // TODO: Add catch code
                    throw new NumberFormatException("Provide valid number for :" + WLSTWrapperConstants.KEY_SESSION_RETRIEVAL_MAX_CONN_WAIT_TIME);
                }
            }
      /*if(inputParamsProperty.get(WLSTWrapperConstants.MDC_GITO_COOKIE_DOMAIN) == null
              ||  (inputParamsProperty.get(WLSTWrapperConstants.MDC_GITO_COOKIE_DOMAIN).equals(""))){
                 throw new IOException("Property Value NULL for :"+WLSTWrapperConstants.MDC_GITO_COOKIE_DOMAIN);
          }*/
        }

    }

    /**
     * Method to get mbean object by making connection to mbean server
     *
     * @param mbeanServerConnection
     * @return MBean
     */
    public static ObjectName getFoundationConfigMBean(
            MBeanServerConnection mbeanServerConnection) {

        final String methodName = "getFoundationConfigMBean";
        ObjectName mbeanObject = null;
        try {
            Set<ObjectName> deploymentMBeans = mbeanServerConnection.queryNames(
                    new ObjectName(OAM_MBEAN_LOCATOR), null);
            if (deploymentMBeans == null || deploymentMBeans.size() == 0) {

                throw new Exception("No foundation mbeans found");
            } else {
                for (ObjectName mbean : deploymentMBeans) {
                    // m_logger.log(ODLLevel.INFO,"CNAME="+upMBean.getCanonicalName());
                    String name = mbean.getKeyProperty("name");
                    String type = mbean.getKeyProperty("type");
                    if (WLST_MBEAN_NAME.equalsIgnoreCase(name)
                            && WLST_MBEAN_TYPE.equalsIgnoreCase(type)) {
                        mbeanObject = new ObjectName(mbean.toString());
                        System.out.printf("MBEAN OBJECT>>>>>>>>");
                        break;
                    }
                    System.out.printf("FOR MBEAN OBJECT>>>>>>>>");

                }
            }
        } catch (Exception e) {
        }
        return mbeanObject;
    }


    public static void validateMandatoryFields(Properties inputParamsProperty) throws IOException {

        final String methodName = "validateMandatoryFields";


        if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_REMOTE_DC_CLUSTERID) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_REMOTE_DC_CLUSTERID).equals(""))) {
            throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.CONFIG_MDC_REMOTE_DC_CLUSTERID);
        }

        if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_ID) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_ID).equals(""))) {
            throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.CONFIG_MDC_PARTNER_ID);
        }
       /*if(inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_HOSTNAME) == null
            ||  (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_HOSTNAME).equals(""))){

         throw new IOException("Property Value NULL for :"+WLSTWrapperConstants.PROP_KEY_HOSTNAME);
       }
       if(inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PORT) == null
            ||  (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PORT).equals(""))){


         throw new IOException("Property Value NULL for :"+WLSTWrapperConstants.PROP_KEY_PORT);
       }*/
        if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PRIMARY_HOSTPORT) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PRIMARY_HOSTPORT).equals(""))) {

            if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_HOSTNAME) == null
                    || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_HOSTNAME).equals(""))) {

                throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.PROP_KEY_HOSTNAME);
            }
        }
        if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PRIMARY_HOSTPORT) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PRIMARY_HOSTPORT).equals(""))) {

            if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PORT) == null
                    || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_PORT).equals(""))) {


                throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.PROP_KEY_PORT);
            }
        }
       /* if(inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_SECONDARY_HOSTPORT) == null
               ||  (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_SECONDARY_HOSTPORT).equals(""))){


            throw new IOException("Property Value NULL for :"+WLSTWrapperConstants.PROP_KEY_SECONDARY_HOSTPORT);
          }*/
        if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_ACCESS_CLIENT_PWD) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_ACCESS_CLIENT_PWD).equals(""))) {


            throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.PROP_KEY_ACCESS_CLIENT_PWD);
        }
        if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_ACCESS_CLIENT_PWD) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_ACCESS_CLIENT_PWD).equals(""))) {

            throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.PROP_KEY_ACCESS_CLIENT_PWD);
        }
        if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY) == null
                || (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY).equals(""))) {

            throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY);
        }


        if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY) != null
                && !(inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY).equals(""))) {

            String value = (String) inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY);

            if (!(WLSTWrapperConstants.CERT_MODE_SIMPLE.equalsIgnoreCase(value)
                    || WLSTWrapperConstants.CERT_MODE_CERT.equalsIgnoreCase(value)
                    || WLSTWrapperConstants.CERT_MODE_OPEN.equalsIgnoreCase(value))) {


                throw new IOException("Enter valid security Mode (SIMPLE/CERT/OPEN):" + WLSTWrapperConstants.CONFIG_MDC_PARTNER_SECURITY);
            }

            if (null != value && !"".equals(value) && (!WLSTWrapperConstants.CERT_MODE_OPEN.equalsIgnoreCase(value))
                    && (WLSTWrapperConstants.CERT_MODE_SIMPLE.equalsIgnoreCase(value)
                    || WLSTWrapperConstants.CERT_MODE_CERT.equalsIgnoreCase(value))) {


                if (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_CERT_PATH) == null
                        || (inputParamsProperty.get(WLSTWrapperConstants.PROP_KEY_CERT_PATH).equals(""))) {


                    throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.PROP_KEY_CERT_PATH);
                }
                if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_GLOBAL_PASS) == null
                        || (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_GLOBAL_PASS).equals(""))) {
                    throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.CONFIG_MDC_PARTNER_GLOBAL_PASS);
                }
                if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_KEYSTOREPATH) == null
                        || (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_KEYSTOREPATH).equals(""))) {
                    throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.CONFIG_MDC_PARTNER_KEYSTOREPATH);
                }
                if (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_KEYSTOREPWD) == null
                        || (inputParamsProperty.get(WLSTWrapperConstants.CONFIG_MDC_PARTNER_KEYSTOREPWD).equals(""))) {
                    throw new IOException("Property Value NULL for :" + WLSTWrapperConstants.CONFIG_MDC_PARTNER_KEYSTOREPWD);
                }
            }
        }
    }


    public static String removePartnerForMultiDataCentre(WLSTBean wlstBean, MBeanServerConnection connection, String agentId) {

        final String methodName = "removePartnerForMultiDataCentre";
        String result = "";
        try {
/*            MBeanServerConnection connection;*/
//            connection = wlstBean.getJMXConnection();
//            String agentId = WEBGATE_ID_OF_MDC;
            Object[] obMDCParams = new Object[]{agentId};
            String[] obMDCSign = new String[]{String.class.getName()};
            ObjectName mbeanObject = getFoundationConfigMBean(connection);

            result = (String) connection.invoke(mbeanObject,
                    "removePartnerForMDC", obMDCParams, obMDCSign);

            //result ="Partner removed succesfully";
        } catch (Exception e) {
            result = "Unable to execute the command" + e.getMessage();
        }
        return result;

    }

    public static String updateService(WLSTBean wlstBean, MBeanServerConnection connection, String path, Boolean flag) {

        final String methodName = "removePartnerForMultiDataCentre";
        String result = "";
        try {
/*            MBeanServerConnection connection;*/
//            connection = wlstBean.getJMXConnection();
//            String agentId = WEBGATE_ID_OF_MDC;
            System.out.printf("" +
                    "PATH" + path);
            System.out.printf("FLAGG >>>>"+ flag);
            ObjectName oamConfigObjectName = new ObjectName("oracle.oam:type=Config");

            Object[] obMDCParams = new Object[]{path};
            String[] obMDCSign = new String[]{String.class.getName()};
//            ObjectName mbeanObject = getFoundationConfigMBean(connection);
            System.out.printf("BLABAL >>" + connection.getMBeanCount());
            System.out.printf("BLABAL >>" + connection.getMBeanInfo(oamConfigObjectName));
//
            BooleanSettings ls = new BooleanSettings(path, flag);
            CompositeData cd = ls.toCompositeData(StringSettings.toCompositeType());
            Object[] newParams = new Object[]{path, cd};
            String[] signature = new String[]{"java.lang.String", "javax.management.openmbean.CompositeData"};

            try {
                result = (String) connection.invoke(oamConfigObjectName, "applyBooleanProperty", newParams, signature);
                System.out.printf("Command executed successfully!");
            } catch (Exception e) {
                System.out.println("Command execution failed!");
                e.printStackTrace();
            }

//            result = (String) connection.invoke(mbeanObject,
//                    "removePartnerForMDC", obMDCParams, obMDCSign);

            //result ="Partner removed succesfully";
        } catch (Exception e) {
            result = "Unable to execute the command" + e.getMessage();
        }
        return result;

    }
}