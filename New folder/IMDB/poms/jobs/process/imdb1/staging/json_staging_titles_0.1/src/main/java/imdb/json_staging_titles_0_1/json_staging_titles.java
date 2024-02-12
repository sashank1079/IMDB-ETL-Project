
package imdb.json_staging_titles_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: json_staging_titles Purpose: <br>
 * Description: <br>
 * 
 * @author machiraju.s@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class json_staging_titles implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "json_staging_titles.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(json_staging_titles.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (title_basics_FilePath != null) {

				this.setProperty("title_basics_FilePath", title_basics_FilePath.toString());

			}

			if (title_basics_Encoding != null) {

				this.setProperty("title_basics_Encoding", title_basics_Encoding.toString());

			}

			if (title_basics_XPathQuery != null) {

				this.setProperty("title_basics_XPathQuery", title_basics_XPathQuery.toString());

			}

			if (mysql_imdb_AdditionalParams != null) {

				this.setProperty("mysql_imdb_AdditionalParams", mysql_imdb_AdditionalParams.toString());

			}

			if (mysql_imdb_Server != null) {

				this.setProperty("mysql_imdb_Server", mysql_imdb_Server.toString());

			}

			if (mysql_imdb_Password != null) {

				this.setProperty("mysql_imdb_Password", mysql_imdb_Password.toString());

			}

			if (mysql_imdb_Database != null) {

				this.setProperty("mysql_imdb_Database", mysql_imdb_Database.toString());

			}

			if (mysql_imdb_Login != null) {

				this.setProperty("mysql_imdb_Login", mysql_imdb_Login.toString());

			}

			if (mysql_imdb_Port != null) {

				this.setProperty("mysql_imdb_Port", mysql_imdb_Port.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String title_basics_FilePath;

		public String getTitle_basics_FilePath() {
			return this.title_basics_FilePath;
		}

		public String title_basics_Encoding;

		public String getTitle_basics_Encoding() {
			return this.title_basics_Encoding;
		}

		public String title_basics_XPathQuery;

		public String getTitle_basics_XPathQuery() {
			return this.title_basics_XPathQuery;
		}

		public String mysql_imdb_AdditionalParams;

		public String getMysql_imdb_AdditionalParams() {
			return this.mysql_imdb_AdditionalParams;
		}

		public String mysql_imdb_Server;

		public String getMysql_imdb_Server() {
			return this.mysql_imdb_Server;
		}

		public java.lang.String mysql_imdb_Password;

		public java.lang.String getMysql_imdb_Password() {
			return this.mysql_imdb_Password;
		}

		public String mysql_imdb_Database;

		public String getMysql_imdb_Database() {
			return this.mysql_imdb_Database;
		}

		public String mysql_imdb_Login;

		public String getMysql_imdb_Login() {
			return this.mysql_imdb_Login;
		}

		public String mysql_imdb_Port;

		public String getMysql_imdb_Port() {
			return this.mysql_imdb_Port;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "json_staging_titles";
	private final String projectName = "IMDB";
	public Integer errorCode = null;
	private String currentComponent = "";

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_dVBQUIkvEe6oGe_xSVodTw", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					json_staging_titles.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(json_staging_titles.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputJSON_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tNormalize_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputJSON_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_IMDB_json_staging_titles = new byte[0];
		static byte[] commonByteArray_IMDB_json_staging_titles = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 122;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "dd-MM-yyyy";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		public Boolean genresIsNullable() {
			return true;
		}

		public Boolean genresIsKey() {
			return false;
		}

		public Integer genresLength() {
			return 242;
		}

		public Integer genresPrecision() {
			return 0;
		}

		public String genresDefault() {

			return null;

		}

		public String genresComment() {

			return "";

		}

		public String genresPattern() {

			return "dd-MM-yyyy";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",genres=" + genres);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (genres == null) {
				sb.append("<null>");
			} else {
				sb.append(genres);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_IMDB_json_staging_titles = new byte[0];
		static byte[] commonByteArray_IMDB_json_staging_titles = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 122;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "dd-MM-yyyy";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String titleType;

		public String getTitleType() {
			return this.titleType;
		}

		public Boolean titleTypeIsNullable() {
			return true;
		}

		public Boolean titleTypeIsKey() {
			return false;
		}

		public Integer titleTypeLength() {
			return 255;
		}

		public Integer titleTypePrecision() {
			return 0;
		}

		public String titleTypeDefault() {

			return null;

		}

		public String titleTypeComment() {

			return "";

		}

		public String titleTypePattern() {

			return "dd-MM-yyyy";

		}

		public String titleTypeOriginalDbColumnName() {

			return "titleType";

		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public Boolean primaryTitleIsNullable() {
			return true;
		}

		public Boolean primaryTitleIsKey() {
			return false;
		}

		public Integer primaryTitleLength() {
			return 1024;
		}

		public Integer primaryTitlePrecision() {
			return 0;
		}

		public String primaryTitleDefault() {

			return null;

		}

		public String primaryTitleComment() {

			return "";

		}

		public String primaryTitlePattern() {

			return "dd-MM-yyyy";

		}

		public String primaryTitleOriginalDbColumnName() {

			return "primaryTitle";

		}

		public String originalTitle;

		public String getOriginalTitle() {
			return this.originalTitle;
		}

		public Boolean originalTitleIsNullable() {
			return true;
		}

		public Boolean originalTitleIsKey() {
			return false;
		}

		public Integer originalTitleLength() {
			return 1024;
		}

		public Integer originalTitlePrecision() {
			return 0;
		}

		public String originalTitleDefault() {

			return null;

		}

		public String originalTitleComment() {

			return "";

		}

		public String originalTitlePattern() {

			return "dd-MM-yyyy";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Integer isAdult;

		public Integer getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 1;
		}

		public Integer isAdultPrecision() {
			return 0;
		}

		public String isAdultDefault() {

			return null;

		}

		public String isAdultComment() {

			return "";

		}

		public String isAdultPattern() {

			return "dd-MM-yyyy";

		}

		public String isAdultOriginalDbColumnName() {

			return "isAdult";

		}

		public String startYear;

		public String getStartYear() {
			return this.startYear;
		}

		public Boolean startYearIsNullable() {
			return true;
		}

		public Boolean startYearIsKey() {
			return false;
		}

		public Integer startYearLength() {
			return 4;
		}

		public Integer startYearPrecision() {
			return 0;
		}

		public String startYearDefault() {

			return null;

		}

		public String startYearComment() {

			return "";

		}

		public String startYearPattern() {

			return "dd-MM-yyyy";

		}

		public String startYearOriginalDbColumnName() {

			return "startYear";

		}

		public String endYear;

		public String getEndYear() {
			return this.endYear;
		}

		public Boolean endYearIsNullable() {
			return true;
		}

		public Boolean endYearIsKey() {
			return false;
		}

		public Integer endYearLength() {
			return 4;
		}

		public Integer endYearPrecision() {
			return 0;
		}

		public String endYearDefault() {

			return null;

		}

		public String endYearComment() {

			return "";

		}

		public String endYearPattern() {

			return "dd-MM-yyyy";

		}

		public String endYearOriginalDbColumnName() {

			return "endYear";

		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public Boolean runtimeMinutesIsNullable() {
			return true;
		}

		public Boolean runtimeMinutesIsKey() {
			return false;
		}

		public Integer runtimeMinutesLength() {
			return 10;
		}

		public Integer runtimeMinutesPrecision() {
			return 0;
		}

		public String runtimeMinutesDefault() {

			return null;

		}

		public String runtimeMinutesComment() {

			return "";

		}

		public String runtimeMinutesPattern() {

			return "dd-MM-yyyy";

		}

		public String runtimeMinutesOriginalDbColumnName() {

			return "runtimeMinutes";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + startYear);
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (titleType == null) {
				sb.append("<null>");
			} else {
				sb.append(titleType);
			}

			sb.append("|");

			if (primaryTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(primaryTitle);
			}

			sb.append("|");

			if (originalTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(originalTitle);
			}

			sb.append("|");

			if (isAdult == null) {
				sb.append("<null>");
			} else {
				sb.append(isAdult);
			}

			sb.append("|");

			if (startYear == null) {
				sb.append("<null>");
			} else {
				sb.append(startYear);
			}

			sb.append("|");

			if (endYear == null) {
				sb.append("<null>");
			} else {
				sb.append(endYear);
			}

			sb.append("|");

			if (runtimeMinutes == null) {
				sb.append("<null>");
			} else {
				sb.append(runtimeMinutes);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
		final static byte[] commonByteArrayLock_IMDB_json_staging_titles = new byte[0];
		static byte[] commonByteArray_IMDB_json_staging_titles = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 122;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "dd-MM-yyyy";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		public Boolean genresIsNullable() {
			return true;
		}

		public Boolean genresIsKey() {
			return false;
		}

		public Integer genresLength() {
			return 242;
		}

		public Integer genresPrecision() {
			return 0;
		}

		public String genresDefault() {

			return null;

		}

		public String genresComment() {

			return "";

		}

		public String genresPattern() {

			return "dd-MM-yyyy";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",genres=" + genres);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (genres == null) {
				sb.append("<null>");
			} else {
				sb.append(genres);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_IMDB_json_staging_titles = new byte[0];
		static byte[] commonByteArray_IMDB_json_staging_titles = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 122;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "dd-MM-yyyy";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String titleType;

		public String getTitleType() {
			return this.titleType;
		}

		public Boolean titleTypeIsNullable() {
			return true;
		}

		public Boolean titleTypeIsKey() {
			return false;
		}

		public Integer titleTypeLength() {
			return 81;
		}

		public Integer titleTypePrecision() {
			return 0;
		}

		public String titleTypeDefault() {

			return null;

		}

		public String titleTypeComment() {

			return "";

		}

		public String titleTypePattern() {

			return "dd-MM-yyyy";

		}

		public String titleTypeOriginalDbColumnName() {

			return "titleType";

		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public Boolean primaryTitleIsNullable() {
			return true;
		}

		public Boolean primaryTitleIsKey() {
			return false;
		}

		public Integer primaryTitleLength() {
			return 280;
		}

		public Integer primaryTitlePrecision() {
			return 0;
		}

		public String primaryTitleDefault() {

			return null;

		}

		public String primaryTitleComment() {

			return "";

		}

		public String primaryTitlePattern() {

			return "dd-MM-yyyy";

		}

		public String primaryTitleOriginalDbColumnName() {

			return "primaryTitle";

		}

		public String originalTitle;

		public String getOriginalTitle() {
			return this.originalTitle;
		}

		public Boolean originalTitleIsNullable() {
			return true;
		}

		public Boolean originalTitleIsKey() {
			return false;
		}

		public Integer originalTitleLength() {
			return 203;
		}

		public Integer originalTitlePrecision() {
			return 0;
		}

		public String originalTitleDefault() {

			return null;

		}

		public String originalTitleComment() {

			return "";

		}

		public String originalTitlePattern() {

			return "dd-MM-yyyy";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Integer isAdult;

		public Integer getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 1;
		}

		public Integer isAdultPrecision() {
			return 0;
		}

		public String isAdultDefault() {

			return null;

		}

		public String isAdultComment() {

			return "";

		}

		public String isAdultPattern() {

			return "dd-MM-yyyy";

		}

		public String isAdultOriginalDbColumnName() {

			return "isAdult";

		}

		public String startYear;

		public String getStartYear() {
			return this.startYear;
		}

		public Boolean startYearIsNullable() {
			return true;
		}

		public Boolean startYearIsKey() {
			return false;
		}

		public Integer startYearLength() {
			return 6;
		}

		public Integer startYearPrecision() {
			return 0;
		}

		public String startYearDefault() {

			return null;

		}

		public String startYearComment() {

			return "";

		}

		public String startYearPattern() {

			return "dd-MM-yyyy";

		}

		public String startYearOriginalDbColumnName() {

			return "startYear";

		}

		public String endYear;

		public String getEndYear() {
			return this.endYear;
		}

		public Boolean endYearIsNullable() {
			return true;
		}

		public Boolean endYearIsKey() {
			return false;
		}

		public Integer endYearLength() {
			return 61;
		}

		public Integer endYearPrecision() {
			return 0;
		}

		public String endYearDefault() {

			return null;

		}

		public String endYearComment() {

			return "";

		}

		public String endYearPattern() {

			return "dd-MM-yyyy";

		}

		public String endYearOriginalDbColumnName() {

			return "endYear";

		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public Boolean runtimeMinutesIsNullable() {
			return true;
		}

		public Boolean runtimeMinutesIsKey() {
			return false;
		}

		public Integer runtimeMinutesLength() {
			return 6;
		}

		public Integer runtimeMinutesPrecision() {
			return 0;
		}

		public String runtimeMinutesDefault() {

			return null;

		}

		public String runtimeMinutesComment() {

			return "";

		}

		public String runtimeMinutesPattern() {

			return "dd-MM-yyyy";

		}

		public String runtimeMinutesOriginalDbColumnName() {

			return "runtimeMinutes";

		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		public Boolean genresIsNullable() {
			return true;
		}

		public Boolean genresIsKey() {
			return false;
		}

		public Integer genresLength() {
			return 242;
		}

		public Integer genresPrecision() {
			return 0;
		}

		public String genresDefault() {

			return null;

		}

		public String genresComment() {

			return "";

		}

		public String genresPattern() {

			return "dd-MM-yyyy";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_json_staging_titles.length) {
					if (length < 1024 && commonByteArray_IMDB_json_staging_titles.length == 0) {
						commonByteArray_IMDB_json_staging_titles = new byte[1024];
					} else {
						commonByteArray_IMDB_json_staging_titles = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_json_staging_titles, 0, length);
				strReturn = new String(commonByteArray_IMDB_json_staging_titles, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_json_staging_titles) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + startYear);
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append(",genres=" + genres);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (titleType == null) {
				sb.append("<null>");
			} else {
				sb.append(titleType);
			}

			sb.append("|");

			if (primaryTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(primaryTitle);
			}

			sb.append("|");

			if (originalTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(originalTitle);
			}

			sb.append("|");

			if (isAdult == null) {
				sb.append("<null>");
			} else {
				sb.append(isAdult);
			}

			sb.append("|");

			if (startYear == null) {
				sb.append("<null>");
			} else {
				sb.append(startYear);
			}

			sb.append("|");

			if (endYear == null) {
				sb.append("<null>");
			} else {
				sb.append(endYear);
			}

			sb.append("|");

			if (runtimeMinutes == null) {
				sb.append("<null>");
			} else {
				sb.append(runtimeMinutes);
			}

			sb.append("|");

			if (genres == null) {
				sb.append("<null>");
			} else {
				sb.append(genres);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputJSON_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputJSON_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileInputJSON_1");
		org.slf4j.MDC.put("_subJobPid", "q9JjbY_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();
				out2Struct out2 = new out2Struct();
				row2Struct row2 = new row2Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				cLabel = "mysql_imdb";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out1");

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "context.mysql_imdb_Server");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "context.mysql_imdb_Port");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "context.mysql_imdb_Database");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "context.mysql_imdb_Login");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.mysql_imdb_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"title_basics_stg\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("PROPERTIES" + " = " + "context.mysql_imdb_AdditionalParams");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("EXTENDINSERT" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("NB_ROWS_PER_INSERT" + " = " + "100");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_1", "mysql_imdb", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "title_basics_stg";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = context.mysql_imdb_AdditionalParams;
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mysql://" + context.mysql_imdb_Server + ":" + context.mysql_imdb_Port
						+ "/" + context.mysql_imdb_Database + "?" + properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1) + ("."));
				String dbUser_tDBOutput_1 = context.mysql_imdb_Login;

				final String decryptedPassword_tDBOutput_1 = context.mysql_imdb_Password;

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
							+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int count_tDBOutput_1 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(context.mysql_imdb_Database,
						null, null, new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_1 = false;
				while (rsTable_tDBOutput_1.next()) {
					String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
					if (table_tDBOutput_1.equalsIgnoreCase("title_basics_stg")) {
						whetherExist_tDBOutput_1 = true;
						break;
					}
				}
				if (whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_1 - " + ("Dropping") + (" table '") + (tableName_tDBOutput_1) + ("'."));
						stmtDrop_tDBOutput_1.execute("DROP TABLE `" + tableName_tDBOutput_1 + "`");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Drop") + (" table '") + (tableName_tDBOutput_1)
									+ ("' has succeeded."));
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Creating") + (" table '") + (tableName_tDBOutput_1) + ("'."));
					stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1
							+ "`(`tconst` VARCHAR(122)   not null ,`titleType` VARCHAR(255)  ,`primaryTitle` VARCHAR(1024)  ,`originalTitle` VARCHAR(1024)  ,`isAdult` INT(1)  ,`startYear` VARCHAR(4)  ,`endYear` VARCHAR(4)  ,`runtimeMinutes` VARCHAR(10)  )");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Create") + (" table '") + (tableName_tDBOutput_1)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_1 = "INSERT INTO `" + "title_basics_stg"
						+ "` (`tconst`,`titleType`,`primaryTitle`,`originalTitle`,`isAdult`,`startYear`,`endYear`,`runtimeMinutes`) VALUES (?,?,?,?,?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				cLabel = "mysql_imdb";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_2 = new StringBuilder();
							log4jParamters_tDBOutput_2.append("Parameters:");
							log4jParamters_tDBOutput_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("HOST" + " = " + "context.mysql_imdb_Server");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PORT" + " = " + "context.mysql_imdb_Port");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DBNAME" + " = " + "context.mysql_imdb_Database");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USER" + " = " + "context.mysql_imdb_Login");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.mysql_imdb_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"title_basics_normalized\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("PROPERTIES" + " = " + "context.mysql_imdb_AdditionalParams");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("EXTENDINSERT" + " = " + "true");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("NB_ROWS_PER_INSERT" + " = " + "100");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USE_HINT_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_2 - " + (log4jParamters_tDBOutput_2));
						}
					}
					new BytesLimit65535_tDBOutput_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_2", "mysql_imdb", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rowsToCommitCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;

				String tableName_tDBOutput_2 = "title_basics_normalized";
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
				calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				long date_tDBOutput_2;

				java.sql.Connection conn_tDBOutput_2 = null;

				String properties_tDBOutput_2 = context.mysql_imdb_AdditionalParams;
				if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
					properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_2 = "jdbc:mysql://" + context.mysql_imdb_Server + ":" + context.mysql_imdb_Port
						+ "/" + context.mysql_imdb_Database + "?" + properties_tDBOutput_2;

				String driverClass_tDBOutput_2 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_2) + ("."));
				String dbUser_tDBOutput_2 = context.mysql_imdb_Login;

				final String decryptedPassword_tDBOutput_2 = context.mysql_imdb_Password;

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
				java.lang.Class.forName(driverClass_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection attempts to '") + (url_tDBOutput_2)
							+ ("' with the username '") + (dbUser_tDBOutput_2) + ("'."));
				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
						dbPwd_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection to '") + (url_tDBOutput_2) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);

				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_2.getAutoCommit()) + ("'."));

				int count_tDBOutput_2 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_2 = conn_tDBOutput_2.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_2 = dbMetaData_tDBOutput_2.getTables(context.mysql_imdb_Database,
						null, null, new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_2 = false;
				while (rsTable_tDBOutput_2.next()) {
					String table_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_NAME");
					if (table_tDBOutput_2.equalsIgnoreCase("title_basics_normalized")) {
						whetherExist_tDBOutput_2 = true;
						break;
					}
				}
				if (whetherExist_tDBOutput_2) {
					try (java.sql.Statement stmtDrop_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_2 - " + ("Dropping") + (" table '") + (tableName_tDBOutput_2) + ("'."));
						stmtDrop_tDBOutput_2.execute("DROP TABLE `" + tableName_tDBOutput_2 + "`");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("Drop") + (" table '") + (tableName_tDBOutput_2)
									+ ("' has succeeded."));
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
					if (log.isDebugEnabled())
						log.debug("tDBOutput_2 - " + ("Creating") + (" table '") + (tableName_tDBOutput_2) + ("'."));
					stmtCreate_tDBOutput_2.execute("CREATE TABLE `" + tableName_tDBOutput_2
							+ "`(`tconst` VARCHAR(122)  ,`genres` VARCHAR(242)  )");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_2 - " + ("Create") + (" table '") + (tableName_tDBOutput_2)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_2 = "INSERT INTO `" + "title_basics_normalized"
						+ "` (`tconst`,`genres`) VALUES (?,?)";

				int batchSize_tDBOutput_2 = 100;
				int batchSizeCounter_tDBOutput_2 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tNormalize_1 begin ] start
				 */

				ok_Hash.put("tNormalize_1", false);
				start_Hash.put("tNormalize_1", System.currentTimeMillis());

				currentComponent = "tNormalize_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out2");

				int tos_count_tNormalize_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tNormalize_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tNormalize_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tNormalize_1 = new StringBuilder();
							log4jParamters_tNormalize_1.append("Parameters:");
							log4jParamters_tNormalize_1.append("NORMALIZE_COLUMN" + " = " + "genres");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("ITEMSEPARATOR" + " = " + "\",\"");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("DEDUPLICATE" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("DISCARD_TRAILING_EMPTY_STR" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("TRIM" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tNormalize_1 - " + (log4jParamters_tNormalize_1));
						}
					}
					new BytesLimit65535_tNormalize_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tNormalize_1", "tNormalize_1", "tNormalize");
					talendJobLogProcess(globalMap);
				}

				int lastNoEmptyIndex_tNormalize_1 = 0;
				int nb_line_tNormalize_1 = 0;
				String tmp_tNormalize_1 = null;
				StringBuilder currentRecord_tNormalize_1 = null;
				String[] normalizeRecord_tNormalize_1 = null;
				java.util.Set<String> recordSet_tNormalize_1 = new java.util.HashSet<String>();

				if (((String) ",").length() == 0) {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				/**
				 * [tNormalize_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_1 = 0;

				out1Struct out1_tmp = new out1Struct();
				int count_out2_tMap_1 = 0;

				out2Struct out2_tmp = new out2Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tFileInputJSON_1 begin ] start
				 */

				ok_Hash.put("tFileInputJSON_1", false);
				start_Hash.put("tFileInputJSON_1", System.currentTimeMillis());

				currentComponent = "tFileInputJSON_1";

				cLabel = "title_basics";

				int tos_count_tFileInputJSON_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileInputJSON_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileInputJSON_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileInputJSON_1 = new StringBuilder();
							log4jParamters_tFileInputJSON_1.append("Parameters:");
							log4jParamters_tFileInputJSON_1.append("READ_BY" + " = " + "JSONPATH");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("JSON_PATH_VERSION" + " = " + "2_1_0");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("USEURL" + " = " + "false");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("FILENAME" + " = "
									+ "\"C:/Users/Sashank Machiraju/Downloads/newdata_title_basics.json\"");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("JSON_LOOP_QUERY" + " = " + "\"$.[*]\"");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("MAPPING_JSONPATH" + " = " + "[{QUERY="
									+ ("\"tconst\"") + ", SCHEMA_COLUMN=" + ("tconst") + "}, {QUERY="
									+ ("\"titleType\"") + ", SCHEMA_COLUMN=" + ("titleType") + "}, {QUERY="
									+ ("\"primaryTitle\"") + ", SCHEMA_COLUMN=" + ("primaryTitle") + "}, {QUERY="
									+ ("\"originalTitle\"") + ", SCHEMA_COLUMN=" + ("originalTitle") + "}, {QUERY="
									+ ("\"isAdult\"") + ", SCHEMA_COLUMN=" + ("isAdult") + "}, {QUERY="
									+ ("\"startYear\"") + ", SCHEMA_COLUMN=" + ("startYear") + "}, {QUERY="
									+ ("\"endYear\"") + ", SCHEMA_COLUMN=" + ("endYear") + "}, {QUERY="
									+ ("\"runtimeMinutes\"") + ", SCHEMA_COLUMN=" + ("runtimeMinutes") + "}, {QUERY="
									+ ("\"genres\"") + ", SCHEMA_COLUMN=" + ("genres") + "}]");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("ADVANCED_SEPARATOR" + " = " + "false");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("USE_LOOP_AS_ROOT" + " = " + "false");
							log4jParamters_tFileInputJSON_1.append(" | ");
							log4jParamters_tFileInputJSON_1.append("ENCODING" + " = " + "\"UTF-8\"");
							log4jParamters_tFileInputJSON_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileInputJSON_1 - " + (log4jParamters_tFileInputJSON_1));
						}
					}
					new BytesLimit65535_tFileInputJSON_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFileInputJSON_1", "title_basics", "tFileInputJSON");
					talendJobLogProcess(globalMap);
				}

				class JsonPathCache_tFileInputJSON_1 {
					final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();

					public com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {
						if (jsonPathString2compiledJsonPath.containsKey(jsonPath)) {
							return jsonPathString2compiledJsonPath.get(jsonPath);
						} else {
							com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath
									.compile(jsonPath);
							jsonPathString2compiledJsonPath.put(jsonPath, compiledLoopPath);
							return compiledLoopPath;
						}
					}
				}

				int nb_line_tFileInputJSON_1 = 0;

				JsonPathCache_tFileInputJSON_1 jsonPathCache_tFileInputJSON_1 = new JsonPathCache_tFileInputJSON_1();

				String loopPath_tFileInputJSON_1 = "$.[*]";
				java.util.List<Object> resultset_tFileInputJSON_1 = new java.util.ArrayList<Object>();

				java.io.InputStream is_tFileInputJSON_1 = null;
				com.jayway.jsonpath.ParseContext parseContext_tFileInputJSON_1 = com.jayway.jsonpath.JsonPath
						.using(com.jayway.jsonpath.Configuration.defaultConfiguration());
				Object filenameOrStream_tFileInputJSON_1 = null;
				try {
					filenameOrStream_tFileInputJSON_1 = "C:/Users/Sashank Machiraju/Downloads/newdata_title_basics.json";
				} catch (java.lang.Exception e_tFileInputJSON_1) {
					globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());

					log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());

					globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
					System.err.println(e_tFileInputJSON_1.getMessage());
				}

				com.jayway.jsonpath.ReadContext document_tFileInputJSON_1 = null;
				try {
					if (filenameOrStream_tFileInputJSON_1 instanceof java.io.InputStream) {
						is_tFileInputJSON_1 = (java.io.InputStream) filenameOrStream_tFileInputJSON_1;
					} else {

						is_tFileInputJSON_1 = new java.io.FileInputStream((String) filenameOrStream_tFileInputJSON_1);

					}

					document_tFileInputJSON_1 = parseContext_tFileInputJSON_1.parse(is_tFileInputJSON_1, "UTF-8");
					com.jayway.jsonpath.JsonPath compiledLoopPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
							.getCompiledJsonPath(loopPath_tFileInputJSON_1);
					Object result_tFileInputJSON_1 = document_tFileInputJSON_1.read(compiledLoopPath_tFileInputJSON_1,
							net.minidev.json.JSONObject.class);
					if (result_tFileInputJSON_1 instanceof net.minidev.json.JSONArray) {
						resultset_tFileInputJSON_1 = (net.minidev.json.JSONArray) result_tFileInputJSON_1;
					} else {
						resultset_tFileInputJSON_1.add(result_tFileInputJSON_1);
					}
				} catch (java.lang.Exception e_tFileInputJSON_1) {
					globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
					log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());

					globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
					System.err.println(e_tFileInputJSON_1.getMessage());
				} finally {
					if (is_tFileInputJSON_1 != null) {
						is_tFileInputJSON_1.close();
					}
				}

				String jsonPath_tFileInputJSON_1 = null;
				com.jayway.jsonpath.JsonPath compiledJsonPath_tFileInputJSON_1 = null;

				Object value_tFileInputJSON_1 = null;
				log.info("tFileInputJSON_1 - Retrieving records from data.");
				Object root_tFileInputJSON_1 = null;
				for (Object row_tFileInputJSON_1 : resultset_tFileInputJSON_1) {
					nb_line_tFileInputJSON_1++;
					log.debug("tFileInputJSON_1 - Retrieving the record " + (nb_line_tFileInputJSON_1) + ".");

					row1 = null;
					boolean whetherReject_tFileInputJSON_1 = false;
					row1 = new row1Struct();

					try {
						jsonPath_tFileInputJSON_1 = "tconst";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.tconst = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.tconst =

									null;
						}
						jsonPath_tFileInputJSON_1 = "titleType";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.titleType = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.titleType =

									null;
						}
						jsonPath_tFileInputJSON_1 = "primaryTitle";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.primaryTitle = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.primaryTitle =

									null;
						}
						jsonPath_tFileInputJSON_1 = "originalTitle";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.originalTitle = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.originalTitle =

									null;
						}
						jsonPath_tFileInputJSON_1 = "isAdult";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							if (value_tFileInputJSON_1 != null && !value_tFileInputJSON_1.toString().isEmpty()) {
								row1.isAdult = ParserUtils.parseTo_Integer(value_tFileInputJSON_1.toString());
							} else {
								row1.isAdult =

										null;
							}
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.isAdult =

									null;
						}
						jsonPath_tFileInputJSON_1 = "startYear";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.startYear = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.startYear =

									null;
						}
						jsonPath_tFileInputJSON_1 = "endYear";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.endYear = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.endYear =

									null;
						}
						jsonPath_tFileInputJSON_1 = "runtimeMinutes";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.runtimeMinutes = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.runtimeMinutes =

									null;
						}
						jsonPath_tFileInputJSON_1 = "genres";
						compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

						try {

							if (jsonPath_tFileInputJSON_1.startsWith("$")) {
								if (root_tFileInputJSON_1 == null) {
									root_tFileInputJSON_1 = document_tFileInputJSON_1
											.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
								}
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(root_tFileInputJSON_1);
							} else {
								value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
							}
							row1.genres = value_tFileInputJSON_1 == null ?

									null : value_tFileInputJSON_1.toString();
						} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							row1.genres =

									null;
						}
					} catch (java.lang.Exception e_tFileInputJSON_1) {
						globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
						whetherReject_tFileInputJSON_1 = true;
						log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());

						System.err.println(e_tFileInputJSON_1.getMessage());
						row1 = null;
						globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
					}
//}

					/**
					 * [tFileInputJSON_1 begin ] stop
					 */

					/**
					 * [tFileInputJSON_1 main ] start
					 */

					currentComponent = "tFileInputJSON_1";

					cLabel = "title_basics";

					tos_count_tFileInputJSON_1++;

					/**
					 * [tFileInputJSON_1 main ] stop
					 */

					/**
					 * [tFileInputJSON_1 process_data_begin ] start
					 */

					currentComponent = "tFileInputJSON_1";

					cLabel = "title_basics";

					/**
					 * [tFileInputJSON_1 process_data_begin ] stop
					 */
// Start of branch "row1"
					if (row1 != null) {

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tFileInputJSON_1", "title_basics", "tFileInputJSON", "tMap_1", "tMap_1",
								"tMap"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)

						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;
						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out1 = null;
							out2 = null;

// # Output table : 'out1'
							count_out1_tMap_1++;

							out1_tmp.tconst = row1.tconst;
							out1_tmp.titleType = row1.titleType;
							out1_tmp.primaryTitle = row1.primaryTitle;
							out1_tmp.originalTitle = row1.originalTitle;
							out1_tmp.isAdult = row1.isAdult;
							out1_tmp.startYear = row1.startYear;
							out1_tmp.endYear = row1.endYear;
							out1_tmp.runtimeMinutes = row1.runtimeMinutes;
							out1 = out1_tmp;
							log.debug("tMap_1 - Outputting the record " + count_out1_tMap_1
									+ " of the output table 'out1'.");

// # Output table : 'out2'
							count_out2_tMap_1++;

							out2_tmp.tconst = row1.tconst;
							out2_tmp.genres = row1.genres;
							out2 = out2_tmp;
							log.debug("tMap_1 - Outputting the record " + count_out2_tMap_1
									+ " of the output table 'out2'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							cLabel = "mysql_imdb";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out1", "tMap_1", "tMap_1", "tMap", "tDBOutput_1", "mysql_imdb", "tMysqlOutput"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out1 - " + (out1 == null ? "" : out1.toLogString()));
							}

							whetherReject_tDBOutput_1 = false;
							if (out1.tconst == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(1, out1.tconst);
							}

							if (out1.titleType == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(2, out1.titleType);
							}

							if (out1.primaryTitle == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, out1.primaryTitle);
							}

							if (out1.originalTitle == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, out1.originalTitle);
							}

							if (out1.isAdult == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(5, out1.isAdult);
							}

							if (out1.startYear == null) {
								pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(6, out1.startYear);
							}

							if (out1.endYear == null) {
								pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(7, out1.endYear);
							}

							if (out1.runtimeMinutes == null) {
								pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(8, out1.runtimeMinutes);
							}

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1)
										+ (" to the ") + ("INSERT") + (" batch."));
							batchSizeCounter_tDBOutput_1++;
							if (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
								try {
									int countSum_tDBOutput_1 = 0;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED
												? 0
												: 1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_1 = 0;
									for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									System.err.println(e.getMessage());
									log.error("tDBOutput_1 - " + (e.getMessage()));
								}

								batchSizeCounter_tDBOutput_1 = 0;
							}
							commitCounter_tDBOutput_1++;

							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

								try {
									int countSum_tDBOutput_1 = 0;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_1 = 0;
									for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									System.err.println(e.getMessage());
									log.error("tDBOutput_1 - " + (e.getMessage()));

								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
												+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_1";

							cLabel = "mysql_imdb";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							currentComponent = "tDBOutput_1";

							cLabel = "mysql_imdb";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "out1"

// Start of branch "out2"
						if (out2 != null) {

							/**
							 * [tNormalize_1 main ] start
							 */

							currentComponent = "tNormalize_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out2", "tMap_1", "tMap_1", "tMap", "tNormalize_1", "tNormalize_1", "tNormalize"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out2 - " + (out2 == null ? "" : out2.toLogString()));
							}

							normalizeRecord_tNormalize_1 = new String[1];
							if (out2.genres != null) {
								if ("".equals(out2.genres)) {
									normalizeRecord_tNormalize_1[0] = "";
								} else {

									normalizeRecord_tNormalize_1 = out2.genres.split(",", -1);

								}
							}
							lastNoEmptyIndex_tNormalize_1 = normalizeRecord_tNormalize_1.length;

							for (int i_tNormalize_1 = 0; i_tNormalize_1 < lastNoEmptyIndex_tNormalize_1; i_tNormalize_1++) {

								currentRecord_tNormalize_1 = new StringBuilder();
								nb_line_tNormalize_1++;

								row2.tconst = out2.tconst;

								row2.genres = normalizeRecord_tNormalize_1[i_tNormalize_1];

								tos_count_tNormalize_1++;

								/**
								 * [tNormalize_1 main ] stop
								 */

								/**
								 * [tNormalize_1 process_data_begin ] start
								 */

								currentComponent = "tNormalize_1";

								/**
								 * [tNormalize_1 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_2 main ] start
								 */

								currentComponent = "tDBOutput_2";

								cLabel = "mysql_imdb";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "row2", "tNormalize_1", "tNormalize_1", "tNormalize", "tDBOutput_2",
										"mysql_imdb", "tMysqlOutput"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
								}

								whetherReject_tDBOutput_2 = false;
								if (row2.tconst == null) {
									pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_2.setString(1, row2.tconst);
								}

								if (row2.genres == null) {
									pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_2.setString(2, row2.genres);
								}

								pstmt_tDBOutput_2.addBatch();
								nb_line_tDBOutput_2++;

								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - " + ("Adding the record ") + (nb_line_tDBOutput_2)
											+ (" to the ") + ("INSERT") + (" batch."));
								batchSizeCounter_tDBOutput_2++;
								if (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2) {
									try {
										int countSum_tDBOutput_2 = 0;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_2 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_2 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
													: countEach_tDBOutput_2);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
										System.err.println(e.getMessage());
										log.error("tDBOutput_2 - " + (e.getMessage()));
									}

									batchSizeCounter_tDBOutput_2 = 0;
								}
								commitCounter_tDBOutput_2++;

								if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

									try {
										int countSum_tDBOutput_2 = 0;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_2 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_2 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
													: countEach_tDBOutput_2);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
										System.err.println(e.getMessage());
										log.error("tDBOutput_2 - " + (e.getMessage()));

									}
									if (rowsToCommitCount_tDBOutput_2 != 0) {
										if (log.isDebugEnabled())
											log.debug("tDBOutput_2 - " + ("Connection starting to commit ")
													+ (rowsToCommitCount_tDBOutput_2) + (" record(s)."));
									}
									conn_tDBOutput_2.commit();
									if (rowsToCommitCount_tDBOutput_2 != 0) {
										if (log.isDebugEnabled())
											log.debug("tDBOutput_2 - " + ("Connection commit has succeeded."));
										rowsToCommitCount_tDBOutput_2 = 0;
									}
									commitCounter_tDBOutput_2 = 0;
								}

								tos_count_tDBOutput_2++;

								/**
								 * [tDBOutput_2 main ] stop
								 */

								/**
								 * [tDBOutput_2 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_2";

								cLabel = "mysql_imdb";

								/**
								 * [tDBOutput_2 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_2 process_data_end ] start
								 */

								currentComponent = "tDBOutput_2";

								cLabel = "mysql_imdb";

								/**
								 * [tDBOutput_2 process_data_end ] stop
								 */
								// end for
							}

							/**
							 * [tNormalize_1 process_data_end ] start
							 */

							currentComponent = "tNormalize_1";

							/**
							 * [tNormalize_1 process_data_end ] stop
							 */

						} // End of branch "out2"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

					} // End of branch "row1"

					/**
					 * [tFileInputJSON_1 process_data_end ] start
					 */

					currentComponent = "tFileInputJSON_1";

					cLabel = "title_basics";

					/**
					 * [tFileInputJSON_1 process_data_end ] stop
					 */

					/**
					 * [tFileInputJSON_1 end ] start
					 */

					currentComponent = "tFileInputJSON_1";

					cLabel = "title_basics";

				}
				globalMap.put("tFileInputJSON_1_NB_LINE", nb_line_tFileInputJSON_1);
				log.debug("tFileInputJSON_1 - Retrieved records count: " + nb_line_tFileInputJSON_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tFileInputJSON_1 - " + ("Done."));

				ok_Hash.put("tFileInputJSON_1", true);
				end_Hash.put("tFileInputJSON_1", System.currentTimeMillis());

				/**
				 * [tFileInputJSON_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");
				log.debug("tMap_1 - Written records count in the table 'out2': " + count_out2_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tFileInputJSON_1", "title_basics", "tFileInputJSON", "tMap_1", "tMap_1", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "mysql_imdb";

				try {
					if (batchSizeCounter_tDBOutput_1 != 0) {
						int countSum_tDBOutput_1 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_1 = 0;

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}

				resourceMap.put("statementClosed_tDBOutput_1", true);

				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out1", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tDBOutput_1", "mysql_imdb", "tMysqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

				/**
				 * [tNormalize_1 end ] start
				 */

				currentComponent = "tNormalize_1";

				globalMap.put("tNormalize_1_NB_LINE", nb_line_tNormalize_1);
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out2", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tNormalize_1", "tNormalize_1", "tNormalize", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tNormalize_1 - " + ("Done."));

				ok_Hash.put("tNormalize_1", true);
				end_Hash.put("tNormalize_1", System.currentTimeMillis());

				/**
				 * [tNormalize_1 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "mysql_imdb";

				try {
					if (batchSizeCounter_tDBOutput_2 != 0) {
						int countSum_tDBOutput_2 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

					log.error("tDBOutput_2 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_2 = 0;

				if (pstmt_tDBOutput_2 != null) {

					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");

				}

				resourceMap.put("statementClosed_tDBOutput_2", true);

				if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_2 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_2) + (" record(s)."));
				}
				conn_tDBOutput_2.commit();
				if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_2 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_2 = 0;
				}
				commitCounter_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Closing the connection to the database."));
				conn_tDBOutput_2.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_2)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tNormalize_1", "tNormalize_1", "tNormalize", "tDBOutput_2", "mysql_imdb", "tMysqlOutput",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Done."));

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				/**
				 * [tDBOutput_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputJSON_1 finally ] start
				 */

				currentComponent = "tFileInputJSON_1";

				cLabel = "title_basics";

				/**
				 * [tFileInputJSON_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "mysql_imdb";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

				/**
				 * [tNormalize_1 finally ] start
				 */

				currentComponent = "tNormalize_1";

				/**
				 * [tNormalize_1 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "mysql_imdb";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_2.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								log.error("tDBOutput_2 - " + (errorMessage_tDBOutput_2));
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputJSON_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "MNntrB_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final json_staging_titles json_staging_titlesClass = new json_staging_titles();

		int exitCode = json_staging_titlesClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'json_staging_titles' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20230913_0925-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'json_staging_titles' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_dVBQUIkvEe6oGe_xSVodTw");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-04T02:12:25.925345600Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = json_staging_titles.class.getClassLoader()
					.getResourceAsStream("imdb/json_staging_titles_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = json_staging_titles.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("title_basics_FilePath", "id_File");
					if (context.getStringValue("title_basics_FilePath") == null) {
						context.title_basics_FilePath = null;
					} else {
						context.title_basics_FilePath = (String) context.getProperty("title_basics_FilePath");
					}
					context.setContextType("title_basics_Encoding", "id_String");
					if (context.getStringValue("title_basics_Encoding") == null) {
						context.title_basics_Encoding = null;
					} else {
						context.title_basics_Encoding = (String) context.getProperty("title_basics_Encoding");
					}
					context.setContextType("title_basics_XPathQuery", "id_String");
					if (context.getStringValue("title_basics_XPathQuery") == null) {
						context.title_basics_XPathQuery = null;
					} else {
						context.title_basics_XPathQuery = (String) context.getProperty("title_basics_XPathQuery");
					}
					context.setContextType("mysql_imdb_AdditionalParams", "id_String");
					if (context.getStringValue("mysql_imdb_AdditionalParams") == null) {
						context.mysql_imdb_AdditionalParams = null;
					} else {
						context.mysql_imdb_AdditionalParams = (String) context
								.getProperty("mysql_imdb_AdditionalParams");
					}
					context.setContextType("mysql_imdb_Server", "id_String");
					if (context.getStringValue("mysql_imdb_Server") == null) {
						context.mysql_imdb_Server = null;
					} else {
						context.mysql_imdb_Server = (String) context.getProperty("mysql_imdb_Server");
					}
					context.setContextType("mysql_imdb_Password", "id_Password");
					if (context.getStringValue("mysql_imdb_Password") == null) {
						context.mysql_imdb_Password = null;
					} else {
						String pwd_mysql_imdb_Password_value = context.getProperty("mysql_imdb_Password");
						context.mysql_imdb_Password = null;
						if (pwd_mysql_imdb_Password_value != null) {
							if (context_param.containsKey("mysql_imdb_Password")) {// no need to decrypt if it come from
																					// program argument or parent job
																					// runtime
								context.mysql_imdb_Password = pwd_mysql_imdb_Password_value;
							} else if (!pwd_mysql_imdb_Password_value.isEmpty()) {
								try {
									context.mysql_imdb_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_mysql_imdb_Password_value);
									context.put("mysql_imdb_Password", context.mysql_imdb_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("mysql_imdb_Database", "id_String");
					if (context.getStringValue("mysql_imdb_Database") == null) {
						context.mysql_imdb_Database = null;
					} else {
						context.mysql_imdb_Database = (String) context.getProperty("mysql_imdb_Database");
					}
					context.setContextType("mysql_imdb_Login", "id_String");
					if (context.getStringValue("mysql_imdb_Login") == null) {
						context.mysql_imdb_Login = null;
					} else {
						context.mysql_imdb_Login = (String) context.getProperty("mysql_imdb_Login");
					}
					context.setContextType("mysql_imdb_Port", "id_String");
					if (context.getStringValue("mysql_imdb_Port") == null) {
						context.mysql_imdb_Port = null;
					} else {
						context.mysql_imdb_Port = (String) context.getProperty("mysql_imdb_Port");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("title_basics_FilePath")) {
				context.title_basics_FilePath = (String) parentContextMap.get("title_basics_FilePath");
			}
			if (parentContextMap.containsKey("title_basics_Encoding")) {
				context.title_basics_Encoding = (String) parentContextMap.get("title_basics_Encoding");
			}
			if (parentContextMap.containsKey("title_basics_XPathQuery")) {
				context.title_basics_XPathQuery = (String) parentContextMap.get("title_basics_XPathQuery");
			}
			if (parentContextMap.containsKey("mysql_imdb_AdditionalParams")) {
				context.mysql_imdb_AdditionalParams = (String) parentContextMap.get("mysql_imdb_AdditionalParams");
			}
			if (parentContextMap.containsKey("mysql_imdb_Server")) {
				context.mysql_imdb_Server = (String) parentContextMap.get("mysql_imdb_Server");
			}
			if (parentContextMap.containsKey("mysql_imdb_Password")) {
				context.mysql_imdb_Password = (java.lang.String) parentContextMap.get("mysql_imdb_Password");
			}
			if (parentContextMap.containsKey("mysql_imdb_Database")) {
				context.mysql_imdb_Database = (String) parentContextMap.get("mysql_imdb_Database");
			}
			if (parentContextMap.containsKey("mysql_imdb_Login")) {
				context.mysql_imdb_Login = (String) parentContextMap.get("mysql_imdb_Login");
			}
			if (parentContextMap.containsKey("mysql_imdb_Port")) {
				context.mysql_imdb_Port = (String) parentContextMap.get("mysql_imdb_Port");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("mysql_imdb_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'json_staging_titles' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputJSON_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputJSON_1) {
			globalMap.put("tFileInputJSON_1_SUBPROCESS_STATE", -1);

			e_tFileInputJSON_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : json_staging_titles");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'json_staging_titles' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 172368 characters generated by Talend Cloud Data Fabric on the 3 December
 * 2023 at 9:12:25 PM GMT-05:00
 ************************************************************************************************/