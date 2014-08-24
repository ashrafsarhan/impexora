package com.impexora.commons;

public class CommonConstants {

	public static final String DELIMITER = "_";
	public static final String BANG_DELIMITER = "!";
	public static final String COMMA_DELIMITER = ",";
	public static final String PIPE_DELIMITER = "|";
	public static final String UNDERSCORE_DELIMITER = "_";
	public static final String PERIOD_DELIMITER = ".";

	public static final String OPEN_PARENTHESIS = "(";
	public static final String CLOSE_PARENTHESIS = ")";
	public static final String ADD_DELIMITER = "+";

	public static final String URL_EQUALS = "=";
	public static final String URL_AND = "&";
	public static final String URL_DELIMITER = "/";
	public static final String URL_QUERY = "?";
	public static final String URL_PORT_DELIMITER = ":";
	public static final String URL_HTTP_HEADER = "http://";
	public static final String URL_SECURE_HTTP_HEADER = "https://";
	public static final String URL_ENCODE = "UTF-8";

	// debug post params
	public static final String POST_DEBUG = "debug";
	public static final String POST_ENV = "env";

	// language
	public static final String URL_CONTEXT_LANG_EN = "en";

	// response servlet
	public static final String FORMAT_TYPE_JSON = "json";
	public static final String FORMAT_TYPE_XML = "xml";

	public static final String XML_HEADER_STANDARD = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	public static final String CONTENT_TYPE_JSONP = "text/javascript; chartset=UTF-8";
	public static final String CONTENT_TYPE_JSON = "application/json; charset=UTF-8";
	public static final String CONTENT_TYPE_XML = "text/xml; charset=UTF-8";

	public static final String X_RATELIMIT_LIMIT = "X-RateLimit-Limit";
	public static final String X_RATELIMIT_REMAINING = "X-RateLimit-Remaining";

	public static final String TAG_RESPONSE_STATUS = "response";
	public static final String ATTR_RESPONSE_STATUS_SUCCESS = "success";
	public static final String TAG_SERVICE_META_DATA = "serviceMetaData";
	public static final String TAG_TRANSACTION_AREA = "transactionArea";

	// fmt and callback
	public static final String PARAM_FORMAT = "fmt";
	public static final String PARAM_CALLBACKFN = "callbackfn";

	public static final String REQUEST_ERROR_STATUS = "errorstatusmsg";

	// used to standarize on environment passed as System.property
	public static final String ENVIRONMENT_KEY = "environment";
	public static final String ENVIRONMENT_DEVELOPMENT = "dev";
	public static final String ENVIRONMENT_QUALITY = "qa";
	public static final String ENVIRONMENT_PRODUCTION = "prod";

	// optional parameters
	public static final String GET_PARAM_ENC_REQUEST = "req";

	// Colon Delimiter
	public final static String COLON_DELIMITER = ":";

	public static final int API_VERSION_SUPPORT = 2;
	public static final String CURRENT_VERSION = "2.0.0";

	public static final String FORMAT_PARAM = "wt";

	public static final String XML_FORMAT = "xml";

	public static final String JSON_FORMAT = "json";
	
	public static final String SOLR_CONTEXT = "solr";
	
	public static final String DATA_IMPORT = "dataimport?command=";
	
	public static final String FULL_IMPORT = "full-import";
	public static final String DELTA_IMPORT = "delta-import";
	public static final String STATUS = "status";
	public static final String RELOAD_CONFIG = "reload-config";
	public static final String ABORT = "abort";
	
	public static final String [] ACTIONS = { FULL_IMPORT, DELTA_IMPORT, STATUS, RELOAD_CONFIG, ABORT };

	private CommonConstants() {
		throw new AssertionError();
	}

}
