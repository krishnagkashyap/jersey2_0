package org.hanbo.jersey.sample;

import javax.management.MBeanServerConnection;
import java.io.File;

/**
 * Created by kgurupra on 4/29/2016.
 */
public class MDCWLSTBean {

    private MBeanServerConnection con = null;
    private File mdcFile = null;
    private String mdcClusterName = null;
    private String adminServerHost = null;
    private String adminServerPort = null;
    private String oamServerMode = null;
    private String oamPrimaryServerHost = null;
    private String oamPrimaryServerPort = null;
    private String accessClientPasswd = null;
    private String wlsUserName = null;
    private String wlsUserPassword = null;
    private String mdcCombination = null;
    private String remoteDataCentreClusterId = null;

    public String getRemoteDataCentreClusterId() {
        return remoteDataCentreClusterId;
    }

    public void setRemoteDataCentreClusterId(String remoteDataCentreClusterId) {
        this.remoteDataCentreClusterId = remoteDataCentreClusterId;
    }

    public String getMdcClusterName() {
        return mdcClusterName;
    }

    public void setMdcClusterName(String mdcClusterName) {
        this.mdcClusterName = mdcClusterName;
    }


    public MBeanServerConnection getCon() {
        return con;
    }

    public void setCon(MBeanServerConnection con) {
        this.con = con;
    }

    public File getMdcFile() {
        return mdcFile;
    }

    public void setMdcFile(File mdcFile) {
        this.mdcFile = mdcFile;
    }

    public String getAdminServerHost() {
        return adminServerHost;
    }

    public void setAdminServerHost(String adminServerHost) {
        this.adminServerHost = adminServerHost;
    }

    public String getAdminServerPort() {
        return adminServerPort;
    }

    public void setAdminServerPort(String adminServerPort) {
        this.adminServerPort = adminServerPort;
    }

    public String getOamServerMode() {
        return oamServerMode;
    }

    public void setOamServerMode(String oamServerMode) {
        this.oamServerMode = oamServerMode;
    }

    public String getOamPrimaryServerHost() {
        return oamPrimaryServerHost;
    }

    public void setOamPrimaryServerHost(String oamPrimaryServerHost) {
        this.oamPrimaryServerHost = oamPrimaryServerHost;
    }

    public String getOamPrimaryServerPort() {
        return oamPrimaryServerPort;
    }

    public void setOamPrimaryServerPort(String oamPrimaryServerPort) {
        this.oamPrimaryServerPort = oamPrimaryServerPort;
    }

    public String getAccessClientPasswd() {
        return accessClientPasswd;
    }

    public void setAccessClientPasswd(String accessClientPasswd) {
        this.accessClientPasswd = accessClientPasswd;
    }

    public String getWlsUserName() {
        return wlsUserName;
    }

    public void setWlsUserName(String wlsUserName) {
        this.wlsUserName = wlsUserName;
    }

    public String getWlsUserPassword() {
        return wlsUserPassword;
    }

    public void setWlsUserPassword(String wlsUserPassword) {
        this.wlsUserPassword = wlsUserPassword;
    }

    public String getMdcCombination() {
        return mdcCombination;
    }

    public void setMdcCombination(String mdcCombination) {
        this.mdcCombination = mdcCombination;
    }
}
