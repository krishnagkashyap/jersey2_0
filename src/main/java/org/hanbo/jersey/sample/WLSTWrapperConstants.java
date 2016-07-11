/* $Header: ngam/src/wlst/src/main/java/oracle/security/am/wlst/util/WLSTWrapperConstants.java /ngam_11.1.2.3.0oambp/7 2016/03/01 04:48:34 vkoottay Exp $ */

/* Copyright (c) 2009, 2016, Oracle and/or its affiliates. 
All rights reserved.*/

/*
 DESCRIPTION
 <short description of component this file declares/defines>

 PRIVATE CLASSES
 <list of private classes defined - with one-line descriptions>

 NOTES
 <other useful comments, qualifications, etc.>

 MODIFIED    (MM/DD/YY)
 vkoottay    02/22/16 - Backport vkoottay_fa_drop2_bp_combined1 from
                        ngam_11.1.2.3.0oambp
 rohtiwar    02/04/16 - Backport rohtiwar_fa_agent_password_reset_bug_19884230
                        from main
 gowrshan    12/16/15 - Backport
                        gowrshan_bug-20880000_regenerate_simple_mode_artifacts_upgrade
                        from main
 dknab       05/12/15 - Backport dknab_bug-20232113 from main
 ramyasub    03/25/15 - Add WLST to generate simple mode keystores
 dknab       12/22/14 - Bug 20232113: Add constants for manage audit events
 dknab       08/21/14 - Add constants setMaxSsoSessionTime WLST command
 rnikam      07/29/14 - Added constant for NATIVE
 rnikam      04/18/14 - Bug 18602812 - Add WLST command support for Idle
                        Timeout and Session Life Time
 dknab       04/16/14 - Bug 18507172: adding constants for manageAuditEvents
 samadanw    04/07/14 - Policy Responses config
 ababtiwa    03/14/14 - Adding constant for configureDefaultPasswordPolicy
                        command.
 kac         03/09/14 - WLST support for Cipher Key export/import/reset.
 ababtiwa    10/03/13 - Adding OAM_CHALLENGE_URL
 shubhagu    09/24/13 - Added constants for updateCustomPagesConfig.
 abbhatod    08/22/13 - bug 16745287
 ababtiwa    08/01/13 - Adding constants for SIM mode support
 rnikam      07/30/13 - Bug 17157277 - Added constant for 
                        configureIdentityDomainHeaders command
 rnikam      07/19/13 - Added new commands
                        configOAMOIFSaaS,configureFedSSO,updateSchemeForPolicy
 rnikam      07/04/13 - Bug 16955699 - Added schemeName parameter to
                        updatePolicyWithResources command
 avashah     04/04/13 - Bug 16299382 - saas: method required to register
                        oif/idp authn url to be protected by oam
 uwaghode    02/01/13 - Bug 15894308
 kerwin      01/22/13 - Add Oauth components to copy command
 sshirshe    01/11/13 - Fix for Bug 16073432 : Adding constants for
                        copyMbeanXmlFiles
 stemathe    01/01/13 - MDC read only impl
 sjoharap    11/03/12 - Adding constants related to patch upgrade 11gR2 to
                        11gR2PS1
 swjajain    10/21/12 - Adding WAS T2P Constants
 sjoharap    09/28/12 - Changes related to OAM WLST WAS Porting
 pkray       04/17/12 - WLST command for setting 10g co-existence mode
 ramyasub    03/13/12 - Prompt for password during migration
 ramyasub    10/28/11 - Add WLST commands for upgrade
 stemathe    10/04/11 - Adding the OAM Migrate command group and constants
 parashah    03/14/11 - Bug 11061040 - BACK COMPAT: CREATEUSERIDENTITYSTORE ARG
                        ROLESECADMIN
 parashah    03/11/11 - Bug 10046822 - add wlst for idstore user attribute list
 rturlapa    06/09/10 - UIDP config extensions
 ramyasub    06/02/10 - Add ConfigureOIM method
 rmanchik    04/22/10 - adding GITO parameters
 ramyasub    04/22/10 - Bug 9507567 - MIGRATEPARTNERSTOPROD SHOULD SUPPORT
 CREATION OF A INTERMEDIARY FILE
 nagakula    04/14/10 - Fix for bug 9555328
 rmanchik    03/19/10 - bug_9460560_9468589_9471956
 vaselvar    01/04/09 - Adding Coexist constants
 rmanchik    01/11/10 - adding topology
 nagakula    01/10/10 - Adding webgate 11g agents constants
 ramyasub    01/06/10 - Add constants for T2P WLST commands
 nagakula    12/16/09 - Adding OSSO and 10g Webgate constants
 rmanchik    12/15/09 - adding Server constants
 rmanchik    12/14/09 - refactoring 
 nagakula    12/07/09 - Adding displayUserIdentityStore constant
 rmanchik    12/06/09 - constants class
 rmanchik    12/06/09 - Creation
 */

/**
 *  @version $Header: ngam/src/wlst/src/main/java/oracle/security/am/wlst/util/WLSTWrapperConstants.java /ngam_11.1.2.3.0oambp/7 2016/03/01 04:48:34 vkoottay Exp $
 *  @author  rmanchik
 *  @since   release specific (what release of product did this appear in)
 */

package org.hanbo.jersey.sample;

import java.io.File;
public class WLSTWrapperConstants {
	// Domain home related constants
	public static final String FILE_SEPARATOR = "file.separator";
	public static final String OAM_CONFIG_FILE = "OAM_CONFIG_FILE";
	public static final String CONFIG = "config";
	public static final String FMW_CONFIG = "fmwconfig";
	public static final String OAM_CONFIG = "oam-config.xml";
	public static final String JPS_CONFIG = "jps-config-jse.xml";
	public static final String NAME = "Name";
	public static final String NAME_OF_ID_STORE = "nameOfIdStore";
	public static final String CONTAINER_TYPE = "CONTAINER_TYPE";
	
	// WLST bean related constants
	public static final String WLST_COMMAND = "COMMAND";
	public static final String DOMAIN_HOME = "DOMAIN_HOME";
	public static final String JMX_CONNECTION = "JMX_CONNECTION";
        public static final String CLASS_NAME = "CLASS_NAME";

	// command groups
	public static final String WLST_COMMAND_GRP = "COMMAND_GRP";
	public static final String SERVER_COMMAND_GRP = "SERVER_COMMAND_GRP";
	public static final String SSO_SERVER_COMMAND_GRP = "SSO_SERVER_COMMAND_GRP";
	public static final String LDAP_COMMAND_GRP = "LDAP_COMMAND_GRP";
	public static final String OSSO_AGENT_COMMAND_GRP = "OSSO_AGENT_COMMAND_GRP";
	public static final String WEBGATE_AGENT_COMMAND_GRP = "WEBGATE_AGENT_COMMAND_GRP";
	public static final String WLST_TOPOLOGY_COMMAND_GRP = "DISPLAY_TOPOLOGY_COMMAND_GRP";
	public static final String WEBGATE11G_AGENT_COMMAND_GRP = "WEBGATE11G_AGENT_COMMAND_GRP";
	public static final String T2P_COMMAND_GRP = "T2P_COMMAND_GRP";
	public static final String SSO_COEXIST_COMMAND_GRP = "SSO_COEXIST_COMMAND_GRP";
	public static final String OAAM_COMMAND_GRP = "OAAM_COMMAND_GRP";
	public static final String DAP_COMMAND_GRP = "DAP_COMMAND_GRP";
	public static final String GITO_COMMAND_GRP = "GITO_COMMAND_GRP";
	public static final String OIM_COMMAND_GRP = "OIM_COMMAND_GRP";
	public static final String OSSO_PROXY_COMMAND_GRP = "OSSO_PROXY_COMMAND_GRP";
	public static final String DIAGNOSTIC_COOKIE_CONFIG_COMMAND_GRP = "DIAGNOSTIC_COOKIE_CONFIG_GRP";
	public static final String OAM_MIGRATE_COMMAND_GRP = "OAM_MIGRATE_COMMAND_GRP";
	public static final String OAM_UPGRADE_COMMAND_GRP = "OAM_UPGRADE_COMMAND_GRP";
	public static final String OAM_MULTI_DATA_CENTRE_GRP = "OAM_MULTI_DATA_CENTRE_GRP";
	public static final String OAM_URLWHITELIST_GRP = "OAM_URLWHITELIST_GRP";
	public static final String OAM_USER_PROFILE_GRP = "OAM_USER_PROFILE_GRP";
	public static final String OAM_OPENSSO_PROXY ="OAM_OPENSSO_PROXY"; 
	public static final String OAM_FED_CERT_GRP ="OAM_FED_CERT_GRP"; 
	public static final String OAM_CSRFVALIDATION_GRP ="OAM_CSRFVALIDATION_GRP";
	public static final String ESSO_COMMAND_GRP = "ESSO_COMMAND_GRP";
	public static final String ARTIFACTS_COMMAND_GRP = "ARTIFACTS_COMMAND_GRP";

	// LDAP user identity store related commands
	public static final String CREATE_USER_IDENTITY_STORE = "createUserIdentityStore";
	public static final String EDIT_USER_IDENTITY_STORE = "editUserIdentityStore";
	public static final String DELETE_USER_IDENTITY_STORE = "deleteUserIdentityStore";
	public static final String DISPLAY_USER_IDENTITY_STORE = "displayUserIdentityStore";
	public static final String OIM_CONFIG_AND_CREATE = "oimConfigAndCreate";
	public static final String CONFIG_AND_CREATE_USING_PROP_FILE = "oimConfigAndCreateUsingPropertyFile";
	public static final String MIGRATE_ARTIFACTS_COMMAND = "migrateArtifacts";

	// LDAP bean related constants
	public static final String LDAP_NAME = "Name";
	public static final String LDAP_PRINCIPAL = "SECURITY_PRINCIPAL";
	public static final String LDAP_CREDENTIAL = "SECURITY_CREDENTIAL";
	public static final String LDAP_SUBSCRIBER_NAME = "SUBSCRIBER_NAME";
	public static final String LDAP_USER_ATTR = "USER_NAME_ATTRIBUTE";
	public static final String LDAP_TYPE = "Type";
	public static final String LDAP_PROVIDER = "LDAP_PROVIDER";
	public static final String LDAP_ROLE_SEC_ADMIN = "Role Security Admin";
	public static final String LDAP_ROLE_SEC_ADMIN_GROUPS = "Groups";
	public static final String LDAP_ROLE_SEC_ADMIN_USERS = "Users";
	public static final String LDAP_ROLE_SYS_MONITOR = "Role System Monitor";
	public static final String LDAP_ROLE_APP_ADMIN = "Role Application Administrator";
	public static final String LDAP_ROLE_SYS_MANAGER = "Role System Manager";
	public static final String LDAP_USR_SYS_ADMIN = "LDAP_USR_SYS_ADMIN";
	public static final String LDAP_USER_SEARCH_BASE = "USER_SEARCH_BASE";
	public static final String LDAP_URL = "LDAP_URL";
	public static final String LDAP_IS_PRIMARY = "IsPrimary";
	public static final String LDAP_USER_ID_PROVIDER = "UserIdentityProviderType";
	public static final String LDAP_GROUP_SEARCH_BASE = "GROUP_SEARCH_BASE";
	public static final String LDAP_ROLE_MAPPINGS = "RoleMappings";
    public static final String LDAP_USER_FILTER_OBJECTCLASSES = "USER_FILTER_OBJECT_CLASSES";
    public static final String LDAP_GROUP_FILTER_OBJECTCLASSES = "GROUP_FILTER_OBJECT_CLASSES";
    public static final String LDAP_REFERRAL_POLICY = "ReferralPolicy";
    public static final String LDAP_REFERRAL_POLICY_FOLLOW = "follow";
    public static final String LDAP_REFERRAL_POLICY_IGNORE = "ignore";
    public static final String LDAP_REFERRAL_POLICY_THROW = "throw";
    public static final String LDAP_POLICY_BASE = "POLICY_BASE";
    
    public static final String LDAP_SEARCH_TIME_LIMIT = "SearchTimeLimit";
    public static final String LDAP_MIN_CONNECTIONS = "MIN_CONNECTIONS";
    public static final String LDAP_MAX_CONNECTIONS = "MAX_CONNECTIONS";
    public static final String LDAP_CONN_WAIT_TIMEOUT = "ConnectionWaitTimeout";
    public static final String LDAP_CONN_RETRY_COUNT = "ConnectionRetryCount";
    public static final String LDAP_GROUP_NAME_ATTR = "GROUP_NAME_ATTR";
    public static final String LDAP_GROUP_CACHE_ENABLE = "GroupCacheEnabled";
    public static final String LDAP_GROUP_CACHE_SIZE = "GroupCacheSize";
    public static final String LDAP_GROUP_CACHE_TTL = "GroupCacheTTL";
    public static final String LDAP_IS_SYSTEM = "IsSystem";
	public static final String LDAP_ENABLE_PASSWORD_POLICY ="ENABLE_PASSWORD_POLICY";
	public static final String LDAP_SUPPLEMENTARY_RETURN_ATTRIBUTES = "SUPPLEMENTARY_RETURN_ATTRIBUTES";
	public static final String LDAP_IS_NATIVE = "NATIVE";
  
  public static final String PROFILE_TYPE = "PROFILE_TYPE";

	public static final String SECURITY_CREDENTIAL = "idStoreSecurityCredential";
	public static final String USER_NAME_ATTRIBUTE = "userNameAttr";
	public static final String USER_SEARCH_BASE = "userSearchBase";
	public static final String _LDAP_URL = "ldapUrl";
	public static final String GROUP_SEARCH_BASE = "groupSearchBase";
	public static final String SECURITY_PRINCIPAL = "securityPrincipal";
	public static final String ID_STORE_TYPE = "idStoreType";
	public static final String _LDAP_PROVIDER = "storeType";
	public static final String USER_ID_PROVIDER = "userIDProvider";
	public static final String PATH_OF_FILE = "PATH_OF_FILE";
	public static final String TYPE = "TYPE";
	
	// Bug 11061040 - BACK COMPAT: CREATEUSERIDENTITYSTORE ARG ROLESECADMIN
	public static final String IS_SYSTEM = "IsSystem";
	public static final String AUTHH_MODULE_NAME = "LDAP";
	public final static String NAME_OF_ZIP_FILE = "artifacts.zip";
	public final static String NAME_OF_GZ_FILE = "artifacts.zip.gz";
	public final static String ARTIFACTS_FOLDER_NAME = "artifacts"; 
	public final static String PASSWORD = "PASSWORD";
	public final static String OAM_POLICY_FILE = "oam-policy.xml";
	public final static String OAM_SYS_CONFIG_FILE = "oam-config.xml";
	public final static String OAM_KEY_STORE_FILE = ".oamkeystore";
	/** Name of JCKES file where password is stored **/
	public final static String PASSWORD_FILE_NAME = "password";
	/** Alias used to store password in PASSWORD_FILE **/
	public final static String PASSWORD_ALIAS = "PASSWORD";
	/** Value to specify whether the upgrade is incremental or not*/
	public final static String IS_INCREMENTAL = "IS_INCREMENTAL";
	
	// OAMserver related commands
	public static final String CREATE_OAM_SERVER = "createOAMServer";
	public static final String EDIT_OAM_SERVER = "editOAMServer";
	public static final String DELETE_OAM_SERVER = "deleteOAMServer";
	public static final String DISPLAY_OAM_SERVERS = "displayOAMServer";

	// OAMserver related constants
	public static final String CONFIGURATION_PROFILE = "configProfile";
	public static final String HOST = "host";
	public static final String PORT = "port";
	public static final String SITE_NAME = "siteName";
	public static final String OAM_PROXY_ID = "OAMProxyServerID";
	public static final String OAM_SHARED_SECRET = "sharedSecret";
	public static final String OAM_WEBLOGIC_PORT = "oamWeblogicPort";
	public static final String OAM_PROXY_PORT = "oamProxyPort";
	public static final String OAM_SERVER_NAME = "oamServerName";

	// SSOServer related constants
	public static final String SSO_CONFIG_REQUEST_CACHE_TYPE = "configRequestCacheType";
	public static final String SSO_DISPLAY_REQUEST_CACHE_TYPE = "displayRequestCacheType";
	public static final String SSO_CONFIG_SSO_SESSION_TYPE = "configSsoSessionType";
	public static final String SSO_DISPLAY_SSO_SESSION_TYPE = "displaySsoSessionType";
	public static final String SSO_REQUEST_CACHE_TYPE = "requestCacheType";
	public static final String SSO_REQUEST_CACHE_TYPE_BASIC = "BASIC";
	public static final String SSO_REQUEST_CACHE_TYPE_COOKIE = "COOKIE";
	public static final String SSO_SSO_SESSION_TYPE = "ssoSessionType";
	public static final String SSO_SSO_SESSION_DOMAIN = "cookieDomain";
	public static final String SSO_REQUEST_CACHE_TYPE_FORM = "FORM";
	public static final String CONFIG_OAM_LOGIN_PAGE_PREF = "configOAMLoginPagePref";
	public static final String CONFIG_OAM_UPDATE_CUSTOM_PAGE = "updateCustomPagesConfig";
	public static final String CONFIG_OAM_CUSTOM_PAGE_CONTEXT = "customPageContext";
	public static final String CONFIG_OAM_CUSTOM_PAGE_EXTENSION = "customPageExtension";
        public static final String CONFIG_OAM_LOGIN_PAGE_SERVER_OVERRIDE_LANGUAGE = "serverOverrideLanguage";
        public static final String CONFIG_OAM_LOGIN_PAGE_PERSISTENT_COOKIE = "persistentCookie";
        public static final String CONFIG_OAM_LOGIN_PAGE_PERSISTENT_COOKIE_LIFETIME = "persistentCookieLifetime";
        public static final String CONFIG_OAM_LOGIN_PAGE_PERSISTENT_COOKIE_DOMAIN = "langPrefCookieDomain";
        public static final String CONFIG_OAM_LOGIN_PAGE_LANG_PREF_ORDER = "langPrefOrder";
	public static final String CONFIG_OAM_LOGIN_PAGE_DEFAULT_LANGUAGE="defaultLanguage";
        public static final String CONFIG_OAM_LOGIN_PAGE_APPLICATION_LOCALES="applicationSupportedLocales";
    public static final String CONFIG_PERSISTENT_LOGIN = "configurePersistentLogin";

    // SSOServer related commands
    public static final String SSO_CHANGE_CIPHER_KEY = "changeCipherKey";
    public static final String SSO_EXPORT_CIPHER_KEY = "exportCipherKey";
    public static final String MODE = "mode";
    public static final String REGENERATE = "autoGenerate";
    public static final String IMPORT = "import";
    public static final String DISPLAY = "display";
    public static final String EXPORT = "export";
    public static final String KEYSTORE_LOC = "keyStoreLocation";
    public static final String KEYSTORE_PWD =  "keyStorePassword";

	// OSSO Agent related commands
	public static final String EDIT_OSSO_AGENT = "editOssoAgent";
	public static final String DELETE_OSSO_AGENT = "deleteOssoAgent";
	public static final String DISPLAY_OSSO_AGENT = "displayOssoAgent";

	// Coexist Settings related commands
	public static final String ENABLE_COEXIST_MODE = "enableCoexistMode";
	public static final String DISABLE_COEXIST_MODE = "disableCoexistMode";
	public static final String ENABLE_OAM_AGENT_COEXIST = "enableOamAgentCoexist";
	public static final String DISABLE_OAM_AGENT_COEXIST = "disableOamAgentCoexist";
	public static final String ENABLE_OAM_AGENT_COEXIST_WITH_10G = "enableOamAgentCoexistWith10G";
	public static final String DISABLE_OAM_AGENT_COEXIST_WITH_10G = "disableOamAgentCoexistWith10G";
	public static final String OAM_AGENT_COEXIST_WITH_10G_LDAP_CONFIG = "setCoexistenceConfigWith10G";
	public static final String LDAP_CONFIG_BASE = "CONFIG_BASE";
	public static final String COEX_COOKIE_DOMAIN = "COOKIE_DOMAIN";
	
	
  // Multiple data centre related commands
  public static final String ENABLE_MULTI_DATA_CENTRE_MODE = "enableMultiDataCentreMode";
  public static final String DISABLE_MULTI_DATA_CENTRE_MODE = "disableMultiDataCentreMode";
  public static final String VALIDATE_MDC_CONFIG = "validateMDCConfig";
  public static final String SET_MULTI_DATA_CENTRE_CLUSTER_NAME = "setMultiDataCentreClusterName";
  public static final String SET_MULTI_DATA_CENTRE_LOGOUT_URLS = "OAM_MDC_PROPERTYsetMultiDataCentreLogoutURLs";
  public static final String UPDATE_MULTI_DATA_CENTRE_LOGOUT_URLS = "updateMultiDataCentreLogoutURLs";
  public static final String OAM_MDC_PROPERTIES_FILE = "pathMDCPropertiesFile";
  public static final String OAM_MDC_PROPERTY = "oamMDCProperty";
  public static final String OAM_MDC_INT_PROPERTY = "oamMDCIntProperty";
  public static final String ADD_PARTNER_FOR_MDC_MODE = "addPartnerForMultiDataCentre";
  public static final String PARTNER_MDC_PROPERTIES_FILE = "partnerMDCPropertiesFilePath";
  public static final String PARTNER_MDC_PROPERTY = "oamPartnerMDCProperty";
  public static final String REMOVE_PARTNER_FOR_MDC_MODE = "removePartnerForMultiDataCentre";
  public static final String WEBGATE_ID_OF_MDC = "webgateId";
   
  
  public static final String KEY_SESSION_RETRIEVAL_MAX_RETRY_ATTEMPTS = "SessionDataRetrievalOnDemandMax_retry_attempts";
  public static final String KEY_SESSION_RETRIEVAL_MAX_CONN_WAIT_TIME = "SessionDataRetrievalOnDemandMax_conn_wait_time";
  
  
  
    

	// OSSO Agent related constants
	public static final String OSSO_AGENT_NAME = "agentName";
	public static final String OSSO_PARTNER_ID = "partnerId";
	public static final String OSSO_SITE_TOKEN = "siteToken";
	public static final String OSSO_SITE_NAME = "siteName";
	public static final String OSSO_SUCCESS_URL = "successUrl";
	public static final String OSSO_FAILURE_URL = "failureUrl";
	public static final String OSSO_HOME_URL = "homeUrl";
	public static final String OSSO_LOGOUT_URL = "logoutUrl";
	public static final String OSSO_START_DATE = "startDate";
	public static final String OSSO_END_DATE = "endDate";
	public static final String OSSO_ADMIN_ID_URL = "adminId";
	public static final String OSSO_ADMIN_INFO_URL = "adminInfo";

	// Webgate Agent related commands
	public static final String EDIT_WEBGATE_AGENT = "editWebgateAgent";
	public static final String DELETE_WEBGATE_AGENT = "deleteWebgateAgent";
	public static final String DISPLAY_WEBGATE_AGENT = "displayWebgateAgent";

	// Webgate agent related constants
	public static final String WEBGATE_AGENT_NAME = "agentName";
	public static final String WEBGATE_ACCESS_CLIENT_PASSWORD = "accessClientPasswd";
	public static final String WEBGATE_STATE = "state";
	public static final String WEBGATE_PREFERRED_HOST = "preferredHost";
	public static final String WEBGATE_AAA_TIMEOUT_THRESHOLD = "aaaTimeoutThreshold";
	public static final String WEBGATE_SECURITY = "security";
	public static final String WEBGATE_PRIMARY_COOKIE_DOMAIN = "primaryCookieDomain";
	public static final String WEBGATE_MAX_CONNECTIONS = "maxConnections";
	public static final String WEBGATE_MAX_CACHE_ELEMENTS = "maxCacheElems";
	public static final String WEBGATE_CACHE_TIME_OUT = "cacheTimeout";
	public static final String WEBGATE_COOKIE_SESSION_TIME = "cookieSessionTime";
	public static final String WEBGATE_MAX_SESSION_TIME = "maxSessionTime";
	public static final String WEBGATE_IDLE_SESSION_TIMEOUT = "idleSessionTimeout";
	public static final String WEBGATE_FAILOVER_THRESHOLD = "failoverThreshold";
  
  // Webgate agent and Webgate 11g agent related commands
  public static final String DISPLAY_SIMPLEMODE_GLOBALPASSPHRASE = "displaySimpleModeGlobalPassphrase";
  public static final String UPGRADE_SERVER_KEYSTORE_CERTIFICATE = "upgradeServerKeystoreCertificate";

	// Topology related constants
	public static final String WLST_TOPOLOGY_DISPLAY = "displayTopology";

	// Webgate11g Agent related commands
	public static final String EDIT_WEBGATE11G_AGENT = "editWebgate11gAgent";
	public static final String DELETE_WEBGATE11G_AGENT = "deleteWebgate11gAgent";
	public static final String DISPLAY_WEBGATE11G_AGENT = "displayWebgate11gAgent";

	// Webgate 11g Agent related constants
	public static final String WEBGATE11G_AGENT_NAME = "agentName";
	public static final String WEBGATE11G_PREFERRED_HOST = "preferredHost";
	public static final String WEBGATE11G_ACCESS_CLIENT_PASSWORD = "accessClientPasswd";
	public static final String WEBGATE11G_STATE = "state";
	public static final String WEBGATE11G_MAX_CONNECTIONS = "maxConnections";
	public static final String WEBGATE11G_AAA_TIMEOUT_THRESHOLD = "aaaTimeoutThreshold";
	public static final String WEBGATE11G_SECURITY = "security";
	public static final String WEBGATE11G_TOKEN_VALIDITY_PERIOD = "tokenValidityPeriod";
	public static final String WEBGATE11G_MAX_CACHE_ELEMS = "maxCacheElems";
	public static final String WEBGATE11G_CACHE_TIME_OUT = "cacheTimeout";
	public static final String WEBGATE11G_LOGOUT_CALLBACK_URL = "logoutCallbackUrl";
	public static final String WEBGATE11G_MAX_SESSION_TIME = "maxSessionTime";
	public static final String WEBGATE11G_LOGOUT_REDIRECT_URL = "logoutRedirectUrl";
	public static final String WEBGATE11G_LOGOUT_TARGET_URL_PARAMNAME = "logoutTargetUrlParamName";
	public static final String WEBGATE11G_FAILOVER_THRESHOLD = "failoverThreshold";
	public static final String WEBGATE11G_LOGOUT_URLS = "logOutUrls";
	public static final String T2P_EXPORT_POLICY = "exportPolicy";
	public static final String T2P_EXPORT_ACCESS_STORE = "exportAccessStore";
	public static final String T2P_IMPORT_ACCESS_STORE = "importAccessStore";
	public static final String T2P_IMPORT_POLICY = "importPolicy";
	public static final String T2P_EXPORT_PARTNERS = "exportPartners";
	public static final String T2P_EXPORT_SELECTED_PARTNERS = "exportSelectedPartners";
	public static final String T2P_IMPORT_PARTNERS = "importPartners";
	public static final String T2P_IMPORT_POLICY_DELTA = "importPolicyDelta";
	public static final String CONFIGURE_POLICY_RESPONSES = "configurePolicyResponses";
	public static final String RESPONSE_SEPARATOR = "ResponseSeparator";
	public static final String RESPONSE_ESCAPE_CHAR = "ResponseEscapeChar";
	public static final String T2P_MIGRATE_PARTNERS_TO_PROD = "migratePartnersToProd";
	public static final String T2P_ACCESS_DATA_TO_FILE = "toFile";
  public static final String T2P_ACCESS_DATA_FROM_FILE = "fromFile";
  public static final String T2P_ACCESS_DATA_NAME_PATH = "namePath";
	public static final String T2P_TEMP_OAM_POLICY_FILE = "pathTempOAMPolicyFile";
	public static final String T2P_IS_APP_DOMAIN_UPDATE = "isAppDomainUpdate";
  public static final String T2P_MODE = "mode";
	public static final String T2P_AGENT_NAME_CHAR_SEQUENCE = "sequence";
	public static final String T2P_SERVERLIST_UPDATE_REQUIRED = "serverUpdateReq";
	public static final String T2P_TEMP_OAM_PARTNER_FILE = "pathTempOAMPartnerFile";
	public static final String T2P_PARTNERS_NAME_LIST = "partnersNameList";
	public static final String T2P_PROD_SERVER_HOST = "prodServerHost";
	public static final String T2P_PROD_SERVER_PORT = "prodServerPort";
	public static final String T2P_PROD_SERVER_ADMIN_USER = "prodServerAdminUser";
	public static final String T2P_PROD_SERVER_ADMIN_PWD = "prodServerAdminPwd";	
	public static final String WEBGATE11G_ALLOW_MANAGEMENT_OPERATIONS = "AllowManagementOperations";
	public static final String WEBGATE11G_ALLOW_TOKEN_SCOPE_OPERATIONS = "AllowTokenScopeOperations";
	public static final String WEBGATE11G_ALLOW_MASTER_TOKEN_RETRIEVAL = "AllowMasterTokenRetrieval";
	public static final String WEBGATE11G_ALLOW_CRED_COLLECTOR_OPERATIONS = "AllowCredentialCollectorOperations";

	// OAAM/ TAP related commands
	public static final String CONFIGURE_OAAM = "configureOAAM";
        public static final String CONFIGURE_OAAM_PARTNER = "configureOAAMPartner";
	public static final String REGISTER_OIF_DAP_PARTNER = "registerOIFDAPPartner";
        public static final String REGISTER_OIF_DAP_PARTNER_IDP_MODE = "registerOIFDAPPartnerIDPMode";
	public static final String REGISTER_THIRD_PARTY_TAP_PARTNER = "registerThirdPartyTAPPartner";
	public static final String KEYSTORE_LOCATION = "KeyStoreLocation";
	public static final String DAP_LOGOUT_URL = "LogoutURL";
	public static final String ROLLOVER_TIME = "RolloverTime";
	public static final String TAP_PARTNER_NAME = "PartnerName";
//	public static final String PASSWORD = "Password";
	public static final String TAP_TOKEN_VERSION = "TAPTokenVersion";
	public static final String TAP_SCHEME = "TAPScheme";
	public static final String TAP_REDIRECT_URL = "TAPRedirectUrl";

	// GITO related commands
	public static final String GITO_EDIT_VALUES = "editGITOValues";

	// LDAP bean related constants
	public static final String GITO_ENABLED = "GITOEnabled";
	public static final String GITO_COOKIE_DOMAIN = "GITOCookieDomain";
	public static final String GITO_COOKIE_NAME = "GITOCookieName";
	public static final String GITO_VERSION = "GITOVersion";
	public static final String GITO_KEY = "GITOKey";
	public static final String GITO_TIMEOUT = "GITOTimeout";
	public static final String GITO_SECURE_COOKIE_ENABLED = "GITOSecureCookieEnabled";
	//Diagnostic Cookie related
	public static final String DIAG_COOKIE_ENABLED = "DiagnosticCookieEnabled";
    public static final String DIAG_COOKIE_NAME = "CookieName";
    public static final String DIAG_COOKIE_VERSION = "DIAGCookieVersion";
    public static final String DIAG_COOKIE_KEY = "DIAGCookieKey";
    public static final String DIAG_COOKIE_PASSWORD = "DIAGCookiePassword";
    public static final String DIAG_COOKIE_SALT = "DIAGCookieSalt";
    public static final String DIAG_COOKIE_ITERATION_COUNT = "DIAGCookieIterationCount";
    public static final String RETRIEVE_DIAGNOSTIC_COOKIE_KEY="retreiveDiagnosticCookieKey";
    public static final String MANAGE_DIAGNOSTIC_COOKIE="manageDiagnosticCookie";
    public static final String REGENERATE_DIAGNOSTIC_COOKIE_KEY="regenerateDiagnosticCookieKey";
	
	public static final String DES_ALGO = "DES";
	public static final String AES_ALGO = "AES";
	public static final int DES_KEY_SIZE = 56;
	public static final int AES_128_KEY_SIZE = 128;
	
	//OIM related commands
	public static final String UPDATE_OIM_HOST_PORT = "updateOIMHostPort";
	public static final String OIM_HOST_NAME = "hostName";
	public static final String OIM_PORT = "port";
	public static final String OIM_SECURE_PROTOCOL = "secureProtocol";
	public static final String CONFIGURE_OIM = "configureOIM";
	public static final Object OIM_HOST = "oimHost";
	public static final Object OIM_PORT_PARAM = "oimPort";
	public static final Object OIM_SECURE = "oimSecureProtocolEnabled";
	public static final Object OIM_ACCESS_GATE_PWD = "oimAccessGatePwd";
	public static final Object OIM_COOKIE_DOMAIN = "oimCookieDomain";
	public static final Object OIM_WG_ID = "oimWgId";
	public static final Object OIM_WG_VERSION = "oimWgVersion";

	
	// OSSOProxy related commands
	public static final String OSSOPROXY_UPDATE_RESPONSE_COOKIE_CONFIG = "updateOSSOResponseCookieConfig";
	public static final String OSSOPROXY_DELETE_RESPONSE_COOKIE_CONFIG = "deleteOSSOResponseCookieConfig";
	public static final String OSSOPROXY_COOKIE_NAME = "CookieName";
	
	// OAM Migrate related commands
	public static final String OAM_INVOKE_MIGRATE = "oamMigrate";
	public static final String OAM_MIGRATE_PROPERTIES_FILE = "pathMigrationPropertiesFile";
	public static final String OAM_MIGRATE_TYPE = "oamMigrateType";
	public static final String OAM_MIGRATE_PROPERTY = "oamMigrateProperty";

	// OAM Upgrade  related commands
	public static final String OAM_PRE_SCHEMA_UPGRADE = "preSchemeUpgrade";
	public static final String OAM_POST_SCHEMA_UPGRADE = "postSchemeUpgrade";
	public static final String RCU_SCHEMA_UPGRADE = "schemeUpgrade";
	public static final String OAM_UPGRADE_PROPERTIES_FILE = "pathUpgradePropertiesFile";
	
	//OAM White list URL related commands
	public static final String OAM_SET_WHITELISTMODE = "oamSetWhiteListMode";
	public static final String OAM_WHITELIST_MODE = "oamWhiteListMode";
	public static final String OAM_CONFIG_WHITELISTURL = "oamWhiteListURLConfig";
	public static final String OAM_WHITELISTURL_KEY = "oamWhiteListURLkey";
	public static final String OAM_WHITELISTURL_VALUE = "oamWhiteListURLvalue";
	public static final String OAM_WHITELISTURL_OP = "oamWhiteListURLop";
	
	public static final String OAM_ENABLE_PASSWD_POLICY_PROFILE = "enablePasswordPolicyProfile";
	public static final String OAM_ADD_PASSWD_POLICY_PROFILE = "addPasswordPolicyProfile";
	public static final String OAM_EDIT_PASSWD_POLICY_PROFILE = "editPasswordPolicyProfile";
	public static final String OAM_DELETE_PASSWD_POLICY_PROFILE = "deletePasswordPolicyProfile";
	
	public static final String PROFILE_NAME = "profileName";
	public static final String PASSWORD_POLICY_ATTRIBUTES = "passwordPolicyAttributes";
	public static final String OVERWRITE_FLAG = "overwriteProfile";
	
   public static final String CONFIG_MDC_PARTNER_ID = "oamMdcAgentId";
   
   public static final String CONFIG_MDC_REMOTE_DC_CLUSTERID = "remoteDataCentreClusterId";
   public static final String PROP_KEY_HOSTNAME = "HostName";
   public static final String PROP_KEY_PORT = "Port";
   public static final String PROP_KEY_PRIMARY_HOSTPORT = "PrimaryHostPort";
   public static final String PROP_KEY_SECONDARY_HOSTPORT = "SecondaryHostPort";
   public static final String PROP_KEY_ACCESS_CLIENT_PWD = "AccessClientPasswd";
   public static final String PROP_KEY_CERT_PATH = "trustStorePath";
   public static final String CONFIG_MDC_PARTNER_SECURITY = "oamMdcSecurityMode";
   
   public static final String CONFIG_MDC_PARTNER_GLOBAL_PASS = "globalPassPhrase";
   public static final String CONFIG_MDC_PARTNER_KEYSTOREPATH = "keyStorePath";
   public static final String CONFIG_MDC_PARTNER_KEYSTOREPWD = "keystorePassword";
   public static final String CONFIG_MDC_PARTNER_AGENT_VERSION= "agentVersion";
   public static final String CONFIG_MDC_11g_WEBGATE_AGENT="11g";
   public static final String CONFIG_MDC_SERVER_CONN_TIMEOUT = "serverConnTimeout";
   public static final String MDC_SERVER_CONN_TIMEOUT = "3600";
   public static final String CONFIG_MDC_PERIOD_FOR_WATCHER = "periodForWatcher";
   public static final String MDC_PERIOD_FOR_WATCHER = "2000";
   public static final String CONFIG_MDC_INITIAL_DELAY_FOR_WATCHER = "delayForWatcher";
   public static final String MDC_INITIAL_DELAY_FOR_WATCHER = "1000";
   public static final String CONFIG_MDC_MIN_CONN_INPOOL = "minConnPool";
   public static final String MDC_MIN_CONN_INPOOL = "1";
   public static final String CONFIG_MDC_MAX_CONN_INPOOL = "maxConnPool";
   public static final String MDC_MAX_CONN_INPOOL = "10";
   public static final String SSO_COOKIE_DOMAIN = "SSOCookieDomain";
   public static final String MDC_GITO_COOKIE_DOMAIN = "MDCGitoCookieDomain";
   
   public static final String CERT_MODE_SIMPLE = "SIMPLE";
   public static final String CERT_MODE_CERT = "CERT";
   public static final String CERT_MODE_OPEN = "OPEN";
   
   // artifact backup related commands
   public static final String SAVE_ACCESS_ARTIFACTS = "saveAccessArtifacts";
   
   public static final String DOWNLOAD_ACCESS_ARTIFACTS = "downloadAccessArtifacts";
   
   // Patch upgrade related command
   public static final String PATCH_UPGRADE = "patchUpgrade";
   public static final String UPGRADE_CONFIG = "upgradeConfig";

   // Patch upgrade related constants
   public static final String ORACLE_HOME = "ORACLE_HOME";
   public static final String PSFE_COMMAND = "PSFE_COMMAND";
   public static final String SYSDBA_USER = "SYSDBA_USER";
   public static final String SYSDBA_PWD = "SYSDBA_PWD";
   public static final String OAM_SCHEMA_OWNER = "OAM_SCHEMA_OWNER";
   public static final String OAM_DB_JDBC_URL = "OAM_DB_JDBC_URL";
   public static final String CONFIG_PATH = "oam" + File.separator + "server" + File.separator + "config";
   public static final String PATCH_UPGRADE_PATH = "/patchUpgrade";
   public static final int DEFAULT_PATH_LENGTH = 200;

   // copyMbeanXmlFiles related constants
   public static final String COPY_MBEAN_XML_FILES = "copyMbeanXmlFiles";

   public static final String OAM_MBEAN_XML_PATH = "oam" + File.separator + "server" + File.separator + "config" + File.separator + "mbeans";
   
   public static final String OIC_MBEAN_XML_PATH = "oic" + File.separator + "config" + File.separator + "mbeans";
   public static final String OIC_OAUTH_XML_PATH = "oic" + File.separator + "config";
   public static final String XML_DOMAINHOME_PATH = "config" + File.separator + "fmwconfig";

   public static final String MBEAN_DOMAINHOME_PATH = "config" + File.separator + "fmwconfig" + File.separator + "mbeans";
   
   public static final String IDS_DOMAINHOME_PATH = "config" + File.separator + "fmwconfig" + File.separator + "ovd" + File.separator + "ids";
   public static final String IDS_TEMPLATES_PATH = File.separator + "modules" + File.separator + "oracle.ovd_11.1.1" + File.separator + "domain_config" + File.separator + "ovd" + File.separator + "ids";
   public static final String IDS_MBEAN_XML_PATH = File.separator + "modules" + File.separator + "oracle.ovd_11.1.1" + File.separator + "domain_config" + File.separator + "mbeans";
 
   //Websphere T2P Related Commands
   public static final String T2P_WAS_EXPORT_OAM_CONFIG = "exportOAMConfiguration";
   public static final String T2P_WAS_IMPORT_OAM_CONFIG = "importOAMConfiguration";
   public static final String T2P_WAS_UPDATE_OAM_CONFIG = "updateOAMConfiguration";
   
   //Websphere T2P Related Constants
   public static final String T2P_SRC_ZIP_FILE_LOC = "srczipfileloc";
   public static final String T2P_TRGT_ZIP_FILE_LOC = "trgtzipfileloc";
   
   // Websphere T2P MBean Name and Type
   public static final String WAS_T2P_MBEAN_NAME ="oracle.oam";
   public static final String WAS_T2P_MBEAN_TYPE ="Test2Prod";
   
   // Set Opensso Proxy LBR data to oam config related commands
   public static final String SET_OPENSSO_PROXY_LBR ="setOpenssoProxyLBR"; 
   public static final String SET_OPENSSO_PROXY_COOKIE_DOMAIN ="setOpenssoProxyCookieDomain";
   
   
   public static final String SET_MULTIDATACENTER_TYPE = "setMultiDataCenterType";
   public static final String SET_MULTIDATACENTER_WRITE = "setMultiDataCenterWrite";
   public static final String CONFIG_MDC_ENABLED_PATH = "DataCenterConfiguration/MultiDataCenterEnabled";
   public static final String CONFIG_MDC_TYPE_PATH = "DataCenterConfiguration/Cluster/DataCenterType";
   public static final String CONFIG_MDC_WRITE_PATH = "DataCenterConfiguration/Cluster/WriteEnabledFlag";
   public static final String MDC_TYPE_MASTER = "Master";
   public static final String MDC_TYPE_CLONE = "Clone";

   //upgradePolicyWithResources related constants
   public static final String UPDATE_POLICY_WITH_RESOURCES = "updatePolicyWithResources";

   public static final String OAM_HOST_ID = "hostId";
   public static final String OAM_APP_DOMAIN_NAME = "appDomain";
   public static final String OAM_AUTHN_POLICY_NAME = "authnPolicy";
   public static final String OAM_RESOURCE_URI = "resURIs";
   public static final String OAM_SCHEME_NAME = "schemeName";
 	
      
   
	// OAM OIF intg support commands
	public static final String ENABLE_FEDSSO_CMD = "enableFedSSO";
	public static final String CONFIG_OAMOIF_SAAS = "configOAMOIFSaaS";
	public static final String UPDATE_COMPOSITE_AUTHN_MODULE = "updateCompositeAuthnModule";
	public static final String CONFIGURE_FEDSSO_CMD = "configureFedSSO";
	public static final String UPDATE_AUTHN_SCHEME_CP_CMD = "updateAuthSchemeChallengeParams";
	public static final String UPDATE_SCHEME_FOR_POLICY_CMD = "updateSchemeForPolicy";
  public static final String CONFIGURE_IDENTITY_DOMAIN_HEADERS = "configureIdentityDomainHeaders";
	
	// OAM OIF intg support constants
	public static final String OAM_FED_AUNTHN_SCHEME_NAMES = "authnSchemeNames";
        public static final String OAM_FED_ENABLED = "fedEnabled";
	public static final String OAM_FED_SSO_ENABLED = "fedSSOEnabled";
	public static final String OAM_FED_MOBILE_SSO_ENABLED = "fedMobileSSOEnabled";
	public static final String OAM_FED_SSO_CHOOSER_ENABLED = "ssoChooserEnabled";
	public static final String CONFIG_OAMOIF_SAAS_MODE = "fedMode";
	public static final String PLUGIN_NAME = "pluginName";
	public static final String PLUGIN_PARAM_KEYS = "pluginParamKeys";
	public static final String PLUGIN_PARAM_VALUES = "pluginParamValues";
	public static final String OAM_FED_BASIC_SP_HOST = "fedBasicSPHost";
        public static final String OAM_CHALLENGE_URL = "challengeURL";

	public static final String OAM_FED_AUNTHN_SCHEME_NAME = "authnSchemeName";
	public static final String OAM_FED_AUNTHN_SCHEME_TOBEREPLACED = "authnSchemeNameTobeReplaced";
	public static final String OAM_FED_AUNTHN_SCHEME_REPLACEWITH = "authnSchemeNameReplaceWith";
	public static final String OAM_FED_LIST_CHALLENGE_PARAMS = "listOfChallengeParams";
  public static final String IDENTITY_DOMAIN_HEADER_NAMES = "headerNames"; 
  public static final String IDENTITY_DOMAIN_AUTHN_MODULE_NAME = "authnModuleName";
        public static final String OAM_MT = "oam_mt";
        
        
     public static final String ALLOW_EMPTY_HOST_IDENTIFIER = "setAllowEmptyHostIdentifier";
     public static final String ENABLE_ALLOW_EMPTY_HOST_IDENTIFIER = "ENABLE" ;
     
     //ESSO Config in OAM update related command
     public static final String ESSO_GLOBAL_CONFIG_UPDATE_COMMAND = "essoGlobalConfigUpdate";
     public static final String ESSO_GLOBAL_CONFIG_PROPERTIES_FILE = "pathConfigPropertiesFile";
     //ESSO global oam auth key rollover
     public static final String ROLLOVER_ESSO_MASTERKEY = "rollOverESSOMasterKey";
     public static final String OPERATION = "operation";
     public static final String DATA = "data";
     public static final String ESSO_REMOVE_DEPENDENCY_ON_USER_UUID = "essoRemoveDependencyOnUserUUID";
     
     public static final String REST_ENDPOINT_CONFIG_PARAM = "RESTEndpoint";
     
     // Password constants 
     
     public static final String USER_SCHEMA = "USER_SCHEMA";
     public static final String LAST_NAME_ATTRIBUTE = "LAST_NAME_ATTRIBUTE";
     public static final String FIRST_NAME_ATTRIBUTE = "FIRST_NAME_ATTRIBUTE";
     public static final String GLOBAL_UNIQUE_USER_ID_ATTRIBUTE ="commonid";
     public static final String CHALLENGE_ANSWERS_ATTRIBUTE = "CHALLENGE_ANSWERS_ATTRIBUTE";
     public static final String CHALLENGE_QUESTIONS_ATTRIBUTE ="CHALLENGE_QUESTIONS_ATTRIBUTE";
     public static final String EMAIL_ADDRESS_ATTRIBUTE="EMAIL_ADDRESS_ATTRIBUTE";
     
     public static final String CONFIGURE_DEFAULT_PASSWORD_POLICY = "configureDefaultPasswordPolicy";
     
     // Manage Event Audit constants
    public static final String MANAGE_AUDIT_EVENTS = "manageAuditEvents";
    public static final String AUDIT_CONFIG_XPATH = "/DeployedComponent/Server/NGAMServer/Profile/Audit/AuditConfig";
    public static final String CONFIG_AUDIT_EVENT_TYPE_FILTERS_MAP = "EventTypeFilters";
    public static final String CONFIG_AUDIT_EVENT_FILTER_TYPE = "EventType" ; 
    public static final String CONFIG_AUDIT_EVENT_FILTER_TYPE_ENABLED = "AuditEnabled";
    public static final String CONFIG_AUDIT_EVENT_FILTER_TYPE_EVENT_STATUS = "EventStatus";
    public static final String CONFIG_AUDIT_EVENT_FILTER_TYPE_PRESET_FILTER = "PresetFilter";
    
     //CSRF validation constants
     
     public static final String ENABLE_CSRF_VALIDATION = "enableCSRFValidation";
     public static final String DISABLE_CSRF_VALIDATION = "disableCSRFValidation";
     public static final String LOGOUT_CONSENT_URL = "LogoutConsentURL";
     public static final String LOGOUT_CONSENT_CANCEL_URL = "LogoutConsentCancelURL";
     
     public static final String CONFIGURE_SERVER_SESSION_PARAMETERS = "configureServerSessionParameters";   
     public static final String CONFIG_SME_SESSION_PATH = "/DeployedComponent/Server/NGAMServer/Profile/Sme/SessionConfigurations";
     public static final String SESSION_LIFETIME_PARAM = "Expiry";
     public static final String IDLE_TIMEOUT_PARAM = "Timeout";

    // Max OSSO session lifetime constants
    public static final String SET_MAX_OSSO_SESSION_LIFETIME = "setMaxOssoSessionLifetime";
    public static final String SET_MAX_OSSO_SESSION_LIFETIME_PARAM = "TIME";
    
    //AuthZ Call Back URL HashKey constants
    public static final String DISPLAY_AUTHZ_CALLBACK_KEY = "displayAuthZCallBackKey";
    public static final String AUTHZ_CALLBACK_ENABLED = "AuthZCallBackEnabled";
    public static final String AUTHZ_HASH_KEY = "AuthZHashKey";
    		

     // enable HeartBeat additional checks command
     public static final String ENABLE_ADDITIONAL_HEART_BEAT_CHECKS = "enableAdditionalHeartBeatChecks";
     public static final String ADDITIONAL_CHECKS_LIST = "additionalChecks";
     public static final String DISABLE_ADDITIONAL_HEART_BEAT_CHECKS = "disableAdditionalHeartBeatChecks";
    
    
    
    public static final String DISPLAY_TRUSTED_INPUT_CONFIG = "displayTrustedInputConfig";
    
    public static final String CONFIG_TRUSTED_INPUTS = "configTrustedInputs";
	public static final String CONFIG_TRUSTED_INPUTS_PARAM_NAME = "Name";
	public static final String CONFIG_TRUSTED_INPUTS_PARAM_MAX_SIZE = "MaxSize";
	public static final String CONFIG_TRUSTED_INPUTS_PARAM_REGEXP = "RegExp";
 
	public static final String GENERATE_KEYSTORES = "generateSimpleModeKeyStores";
    public static final String SSLGLOBALPASSPHRASE = "sslGlobalPassPhrase";
    public static final Object REGENERATE_ALL_ARTIFACTS = "regenerateAllArtifacts";
    public static final String PROFILE_X_PATH = "DeployedComponent/Server/NGAMServer/Profile/";
    public static final String OAM_PROXY_PROFILE_X_PATH = PROFILE_X_PATH  + "oamproxy";
    public static final String SIMPLE_MODE_CONFIGURATION = "sslSimpleModeConfig";
    public static final String SIMPLE_MODE_PASS_PHRASE = "sslGlobalPassphrase";
    
	public static final String UPDATE_AGENT_PASSWORD = "updateAgentPassword";
	public static final String NEW_AGENT_PASSWORD = "newPassword";
	public static final String PASSWORD_EXPIRY_TIME= "expiryTime";
	public static final String PASSWORD_UPDATE_TIME = "passwordUpdateTime";
	public static final String FORCE_UPDATE_PASSWORD= "forceUpdate";
	
	
	public static final String AGENT_OLD_PASSWORD = "oldAccessClientPasswd";
	public static final String AGENT_OLD_PASSWORD_SET_TIME = "oldPasswordSetTimeInMili";
	public static final String AGENT_OLD_PASSWORD_EXPIRY_TIME="oldPasswordExpiryTimeInMinute";
    
	// Global Responses Constants
	public static final String CONFIGURE_GLOBAL_RESPONSE = "configureGlobalResponse";
    public static final String DELETE_GLOBAL_RESPONSE = "deleteGlobalResponse";
    public static final String RESPONSE_NAME = "responseName";
    public static final String RESPONSE_TYPE = "responseType";
    public static final String RESPONSE_VALUE = "responseValue";
    public static final String GLOBAL_RESPONSES = "GlobalResponses";
    public static final String SSOENGINE_X_PATH = "/DeployedComponent/Server/NGAMServer/Profile/ssoengine";
    
    //constants for extractConfigToFile 
    public static final String EXTRACTCONFIGTOFILE_ONLINE = "extractConfigToFileOnline";
    public static final String EXTRACTCONFIGTOFILE_OFFLINE = "extractConfigToFileOffline";
    public static final String SCHEMA_USER = "oam.entityStore.schemaUser";
    public static final String SCHEMA_PASSWORD = "oam.entityStore.schemaPassword";
    public static final String DBCONNECT_STRING	 = "oam.entityStore.ConnectString";
    
}
