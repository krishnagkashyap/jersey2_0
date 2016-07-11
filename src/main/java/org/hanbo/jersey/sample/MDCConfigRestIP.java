package org.hanbo.jersey.sample;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

/**
 * Servlet implementation class MDCConfigServlet
 */

@Path("/enableMDCIP")
public class MDCConfigRestIP {
    private static final long serialVersionUID = 1L;
    private static HashMap<String, String> inputParamMap;
    private Properties properties = new Properties();


    public MDCConfigRestIP() {
        super();
        // TODO Auto-generated constructor stub
        inputParamMap = new HashMap<String, String>();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/updateService")
    public Response updateService(String mdcComb) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;

        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + mdcComb);

        MDCData mdcDataFromJson = parseJsonToObj(mdcComb);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();
        properties.load(MDCConfigRestIP.class.getClassLoader().getResourceAsStream("properties/mdc/oamMDCProperty_comb" + mdcCombination + ".properties"));

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);
        System.out.println(">>>>> mdcCombination = " + mdcCombination);


        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {

            output2 = MDCWLSTClient.updateService("\"DeployedComponent/Descriptors/OAMSEntityDescriptor/FederationServicesDescriptor/IdProviderServiceDescriptor/ServiceStatus", Boolean.TRUE);
            System.out.println(">>>>>> updateService out = " + output2);

        } catch (Exception e) {
            e.printStackTrace();
        }


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mdcfeature", properties.toString());
        String result = "Output: \n\nMDC enablement Complete: \n\n" + jsonObject;

        Gson mdccom = new GsonBuilder().setPrettyPrinting().create();

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(mdccom.toJson(jsonObject));
        return responseBuilder.build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/getMDCCombination")
    public Response getMDCCombination(String mdcComb) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;

        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + mdcComb);

        MDCData mdcDataFromJson = parseJsonToObj(mdcComb);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();
        properties.load(MDCConfigRestIP.class.getClassLoader().getResourceAsStream("properties/mdc/oamMDCProperty_comb" + mdcCombination + ".properties"));

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);
        System.out.println(">>>>> mdcCombination = " + mdcCombination);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mdcfeature", properties.toString());
        String result = "Output: \n\nMDC enablement Complete: \n\n" + jsonObject;

        Gson mdccom = new GsonBuilder().setPrettyPrinting().create();

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(mdccom.toJson(jsonObject));
        return responseBuilder.build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/setMDCClusterName")
    public Response setMDCClusterName(String mdcClusterNm) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;

        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + mdcClusterNm);

        MDCData mdcDataFromJson = parseJsonToObj(mdcClusterNm);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();
        properties.load(MDCConfigRestIP.class.getClassLoader().getResourceAsStream("properties/mdc/oamMDCProperty_comb" + mdcCombination + ".properties"));

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);
        System.out.println(">>>>> mdcCombination = " + mdcCombination);

        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {

            output2 = MDCWLSTClient.setMultiDataCentreClusterNameOnline(mdcClusterName);
            System.out.println(">>>>>> enableMDCMode out = " + output2);

        } catch (Exception e) {

        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mdcfeature", output2);
        String result = "Output: \n\nMDC enablement Complete: \n\n" + jsonObject;

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(jsonObject));
        return responseBuilder.build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/setMDCCombination")
    public Response enableMDCCombination(String mdcComb) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;

        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + mdcComb);

        MDCData mdcDataFromJson = parseJsonToObj(mdcComb);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();
        properties.load(MDCConfigRestIP.class.getClassLoader().getResourceAsStream("properties/mdc/oamMDCProperty_comb" + mdcCombination + ".properties"));

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);
        System.out.println(">>>>> mdcCombination = " + mdcCombination);

        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {

            output2 = MDCWLSTClient.enableMultiDataCentreModeOnline(properties);
            System.out.println(">>>>>> enableMDCMode out = " + output2);

        } catch (Exception e) {

        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mdcfeature", output2);
        String result = "Output: \n\nMDC enablement Complete: \n\n" + jsonObject;

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(jsonObject));
        return responseBuilder.build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/enableMDC")
    public Response enableMDC(String mdcData) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;
        Properties remotePartnerProperties = new Properties();
        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + mdcData);

        MDCData mdcDataFromJson = parseJsonToObj(mdcData);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();
        properties.load(MDCConfigRestIP.class.getClassLoader().getResourceAsStream("properties/mdc/oamMDCProperty_comb" + mdcCombination + ".properties"));


        remotePartnerProperties.put("remoteDataCentreClusterId", remoteDataCentreClusterId);
        remotePartnerProperties.put("oamMdcAgentId", "partner2");
        remotePartnerProperties.put("PrimaryHostPort", oamPrimaryServerPort + ":" + oamPrimaryServerPort);
        remotePartnerProperties.put("AccessClientPasswd", accessClientPasswd);
        remotePartnerProperties.put("oamMdcSecurityMode", oamServerMode);
        remotePartnerProperties.put("trustStorePath", "");
        remotePartnerProperties.put("keyStorePath", "");
        remotePartnerProperties.put("globalPassPhrase", "");
        remotePartnerProperties.put("keystorePassword", "");
        remotePartnerProperties.put("agentVersion", "");
        remotePartnerProperties.put("RESTEndpoint", "http://" + adminServerHost + ":" + adminServerPort);

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);

        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {
            output1 = MDCWLSTClient.setMultiDataCentreClusterNameOnline(mdcClusterName);
            System.out.println(">>>>>> setMDCClusterName out = " + output1);
            output2 = MDCWLSTClient.enableMultiDataCentreModeOnline(properties);
            System.out.println(">>>>>> enableMDCMode out = " + output2);
            output3 = MDCWLSTClient.addPartnerForMultiDataCentre(remotePartnerProperties);
            System.out.println(">>>>> addPartnerForMDC out = " + output3);
        } catch (Exception e) {

        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("clustername", output1);
        jsonObject.addProperty("mdcfeature", output2);
        jsonObject.addProperty("addpartner", output3);
        String result = "Output: \n\nMDC enablement Complete: \n\n" + jsonObject;

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(jsonObject));
        return responseBuilder.build();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/disableMDC")
    public Response disableMDC(String mdcData) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;

        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + mdcData);

        MDCData mdcDataFromJson = parseJsonToObj(mdcData);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);

        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {
            output1 = MDCWLSTClient.disableMultiDataCentreModeOnline();
            System.out.println(">>>>>> Disable MDC out = " + output1);
        } catch (Exception e) {

        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mdcfeature", output1);

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(jsonObject));
        return responseBuilder.build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/addPartnerForMultiDataCentre")
    public Response addPartner(String partnerId) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;
        Properties properties = new Properties();
        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + partnerId);

        MDCData mdcDataFromJson = parseJsonToObj(partnerId);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();

        properties.put("remoteDataCentreClusterId", remoteDataCentreClusterId);
        properties.put("oamMdcAgentId", "partner2");
        properties.put("PrimaryHostPort", oamPrimaryServerPort + ":" + oamPrimaryServerPort);
        properties.put("AccessClientPasswd", accessClientPasswd);
        properties.put("oamMdcSecurityMode", oamServerMode);
        properties.put("trustStorePath", "");
        properties.put("keyStorePath", "");
        properties.put("globalPassPhrase", "");
        properties.put("keystorePassword", "");
        properties.put("agentVersion", "");
        properties.put("RESTEndpoint", "http://" + adminServerHost + ":" + adminServerPort);

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);

        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {
            output1 = MDCWLSTClient.addPartnerForMultiDataCentre(properties);
            System.out.println(">>>>>> setMDCClusterName out = " + output1);

        } catch (Exception e) {

        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("removePartner", output1);
        String result = "Output: \n\npartnerId: \n\n" + jsonObject;

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(jsonObject));
        return responseBuilder.build();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/removePartnerForMultiDataCentre")
    public Response removePartnerForMultiDataCentre(String partnerId) throws IOException, JSONException {
        String output1 = null;
        String output2 = null;
        String output3 = null;

        System.out.println("MDC DATA mdcData >>>>>>>>>>>>>>>>>>>>" + partnerId);

        MDCData mdcDataFromJson = parseJsonToObj(partnerId);

        System.out.println("MDC DATA " + mdcDataFromJson);

        String mdcClusterName = mdcDataFromJson.getMdcClusterName();
        String remoteDataCentreClusterId = mdcDataFromJson.getRemoteDataCentreClusterId();
        String adminServerHost = mdcDataFromJson.getAdminServerHost();
        String adminServerPort = mdcDataFromJson.getAdminServerPort();
        String oamServerMode = mdcDataFromJson.getOamServerMode();
        String oamPrimaryServerHost = mdcDataFromJson.getOamPrimaryServerHost();
        String oamPrimaryServerPort = mdcDataFromJson.getOamPrimaryServerPort();
        String accessClientPasswd = mdcDataFromJson.getAccessClientPasswd();
        String wlsUserName = mdcDataFromJson.getWlsUserName();
        String wlsUserPassword = mdcDataFromJson.getWlsUserPassword();
        String mdcCombination = mdcDataFromJson.getMdcCombination();

        System.out.println(">>>>> remoteDataCentreClusterId = " + remoteDataCentreClusterId);
        System.out.println(">>>>> mdcClusterName = " + mdcClusterName);
        System.out.println(">>>>> adminServerHost = " + adminServerHost);
        System.out.println(">>>>> adminServerPort = " + adminServerPort);
        System.out.println(">>>>> oamServerMode = " + oamServerMode);
        System.out.println(">>>>> oamPrimaryServerHost = " + oamPrimaryServerHost);
        System.out.println(">>>>> oamPrimaryServerPort = " + oamPrimaryServerPort);
        System.out.println(">>>>> accessClientPasswd = " + accessClientPasswd);
        System.out.println(">>>>> wlsUserName = " + wlsUserName);
        System.out.println(">>>>> wlsUserPassword = " + wlsUserPassword);

        MDCWLSTClient mdcWlstClient = new MDCWLSTClient(remoteDataCentreClusterId, mdcClusterName, adminServerHost, adminServerPort, oamServerMode,
                oamPrimaryServerHost, oamPrimaryServerPort, accessClientPasswd, wlsUserName, wlsUserPassword);

        try {
            output1 = MDCWLSTClient.removePartnerForMultiDataCentre(remoteDataCentreClusterId);
            System.out.println(">>>>>> setMDCClusterName out = " + output1);

        } catch (Exception e) {

        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("removePartner", output1);
        String result = "Output: \n\npartnerId: \n\n" + jsonObject;

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(jsonObject));
        return responseBuilder.build();
    }

    private MDCData parseJsonToObj(String jsonStr) {
        final ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        final JsonFactory factory = mapper.getFactory();
        MDCData mdcData = new MDCData();

        try {
            System.out.println("BEFORE" + factory);
            System.out.println("STRING " + jsonStr);

            JsonParser jp = factory.createParser(jsonStr);

            String str = jp.readValueAsTree().toString();

            System.out.println("STRRRRRRR" + str);

            mdcData = mapper.readValue(str, MDCData.class);

        } catch (JsonParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return mdcData;
    }


    // public static void main(String[] args) {
    // String client =
    // "{\"adminServerHost\":\"slc01hto.us.oracle.com\",\"adminServerPort\":\"17346\",\"oamServerMode\":\"OPEN\",\"oamPrimaryServerHost\":\"slc01hto.us.oracle.com\",\"oamPrimaryServerPort\":\"6766\",\"accessClientPasswd\":\"Welcome1\",\"wlsUserName\":\"weblogic\",\"wlsUserPassword\":\"welcome1\",\"mdcCombination\":\"13\"}";
    //
    // MDCData mdcData = parseJsonToObj(client);
    // System.out.println(mdcData);
    //
    // System.out.println("ADMINSERVER HOST" + mdcData.getAdminServerHost());
    // }

}
