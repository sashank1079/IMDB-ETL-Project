
package imdb.genre_dim_0_1;

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
 * Job: genre_dim Purpose: <br>
 * Description: <br>
 * 
 * @author machiraju.s@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class genre_dim implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "genre_dim.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(genre_dim.class);

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

			if (mysql_imdb_Port != null) {

				this.setProperty("mysql_imdb_Port", mysql_imdb_Port.toString());

			}

			if (mysql_imdb_Login != null) {

				this.setProperty("mysql_imdb_Login", mysql_imdb_Login.toString());

			}

			if (mysql_imdb_Password != null) {

				this.setProperty("mysql_imdb_Password", mysql_imdb_Password.toString());

			}

			if (mysql_imdb_Database != null) {

				this.setProperty("mysql_imdb_Database", mysql_imdb_Database.toString());

			}

			if (mysql_imdb_Server != null) {

				this.setProperty("mysql_imdb_Server", mysql_imdb_Server.toString());

			}

			if (mysql_imdb_AdditionalParams != null) {

				this.setProperty("mysql_imdb_AdditionalParams", mysql_imdb_AdditionalParams.toString());

			}

			if (imdb_db_Login != null) {

				this.setProperty("imdb_db_Login", imdb_db_Login.toString());

			}

			if (imdb_db_AdditionalParams != null) {

				this.setProperty("imdb_db_AdditionalParams", imdb_db_AdditionalParams.toString());

			}

			if (imdb_db_Password != null) {

				this.setProperty("imdb_db_Password", imdb_db_Password.toString());

			}

			if (imdb_db_Database != null) {

				this.setProperty("imdb_db_Database", imdb_db_Database.toString());

			}

			if (imdb_db_Server != null) {

				this.setProperty("imdb_db_Server", imdb_db_Server.toString());

			}

			if (imdb_db_Port != null) {

				this.setProperty("imdb_db_Port", imdb_db_Port.toString());

			}

			if (imdb2_dbconn_Port != null) {

				this.setProperty("imdb2_dbconn_Port", imdb2_dbconn_Port.toString());

			}

			if (imdb2_dbconn_Database != null) {

				this.setProperty("imdb2_dbconn_Database", imdb2_dbconn_Database.toString());

			}

			if (imdb2_dbconn_Login != null) {

				this.setProperty("imdb2_dbconn_Login", imdb2_dbconn_Login.toString());

			}

			if (imdb2_dbconn_AdditionalParams != null) {

				this.setProperty("imdb2_dbconn_AdditionalParams", imdb2_dbconn_AdditionalParams.toString());

			}

			if (imdb2_dbconn_Password != null) {

				this.setProperty("imdb2_dbconn_Password", imdb2_dbconn_Password.toString());

			}

			if (imdb2_dbconn_Server != null) {

				this.setProperty("imdb2_dbconn_Server", imdb2_dbconn_Server.toString());

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

		public String mysql_imdb_Port;

		public String getMysql_imdb_Port() {
			return this.mysql_imdb_Port;
		}

		public String mysql_imdb_Login;

		public String getMysql_imdb_Login() {
			return this.mysql_imdb_Login;
		}

		public java.lang.String mysql_imdb_Password;

		public java.lang.String getMysql_imdb_Password() {
			return this.mysql_imdb_Password;
		}

		public String mysql_imdb_Database;

		public String getMysql_imdb_Database() {
			return this.mysql_imdb_Database;
		}

		public String mysql_imdb_Server;

		public String getMysql_imdb_Server() {
			return this.mysql_imdb_Server;
		}

		public String mysql_imdb_AdditionalParams;

		public String getMysql_imdb_AdditionalParams() {
			return this.mysql_imdb_AdditionalParams;
		}

		public String imdb_db_Login;

		public String getImdb_db_Login() {
			return this.imdb_db_Login;
		}

		public String imdb_db_AdditionalParams;

		public String getImdb_db_AdditionalParams() {
			return this.imdb_db_AdditionalParams;
		}

		public java.lang.String imdb_db_Password;

		public java.lang.String getImdb_db_Password() {
			return this.imdb_db_Password;
		}

		public String imdb_db_Database;

		public String getImdb_db_Database() {
			return this.imdb_db_Database;
		}

		public String imdb_db_Server;

		public String getImdb_db_Server() {
			return this.imdb_db_Server;
		}

		public String imdb_db_Port;

		public String getImdb_db_Port() {
			return this.imdb_db_Port;
		}

		public String imdb2_dbconn_Port;

		public String getImdb2_dbconn_Port() {
			return this.imdb2_dbconn_Port;
		}

		public String imdb2_dbconn_Database;

		public String getImdb2_dbconn_Database() {
			return this.imdb2_dbconn_Database;
		}

		public String imdb2_dbconn_Login;

		public String getImdb2_dbconn_Login() {
			return this.imdb2_dbconn_Login;
		}

		public String imdb2_dbconn_AdditionalParams;

		public String getImdb2_dbconn_AdditionalParams() {
			return this.imdb2_dbconn_AdditionalParams;
		}

		public java.lang.String imdb2_dbconn_Password;

		public java.lang.String getImdb2_dbconn_Password() {
			return this.imdb2_dbconn_Password;
		}

		public String imdb2_dbconn_Server;

		public String getImdb2_dbconn_Server() {
			return this.imdb2_dbconn_Server;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "genre_dim";
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
			"_i8bd0JJ8Ee6_WIiIWRIzPA", "0.1");
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
					genre_dim.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(genre_dim.this, new Object[] { e, currentComponent, globalMap });
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

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUnite_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAggregateRow_1_AGGOUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tAggregateRow_1_AGGIN_error(exception, errorComponent, globalMap);

	}

	public void tAggregateRow_1_AGGIN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer genre_sk;

		public Integer getGenre_sk() {
			return this.genre_sk;
		}

		public Boolean genre_skIsNullable() {
			return true;
		}

		public Boolean genre_skIsKey() {
			return true;
		}

		public Integer genre_skLength() {
			return null;
		}

		public Integer genre_skPrecision() {
			return null;
		}

		public String genre_skDefault() {

			return null;

		}

		public String genre_skComment() {

			return "";

		}

		public String genre_skPattern() {

			return "";

		}

		public String genre_skOriginalDbColumnName() {

			return "genre_sk";

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
			return 255;
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

			return "";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		public java.util.Date DI_CreatedDate;

		public java.util.Date getDI_CreatedDate() {
			return this.DI_CreatedDate;
		}

		public Boolean DI_CreatedDateIsNullable() {
			return true;
		}

		public Boolean DI_CreatedDateIsKey() {
			return false;
		}

		public Integer DI_CreatedDateLength() {
			return 15;
		}

		public Integer DI_CreatedDatePrecision() {
			return null;
		}

		public String DI_CreatedDateDefault() {

			return null;

		}

		public String DI_CreatedDateComment() {

			return "";

		}

		public String DI_CreatedDatePattern() {

			return "dd-MM-yyyy";

		}

		public String DI_CreatedDateOriginalDbColumnName() {

			return "DI_CreatedDate";

		}

		public String DI_JobID;

		public String getDI_JobID() {
			return this.DI_JobID;
		}

		public Boolean DI_JobIDIsNullable() {
			return true;
		}

		public Boolean DI_JobIDIsKey() {
			return false;
		}

		public Integer DI_JobIDLength() {
			return 15;
		}

		public Integer DI_JobIDPrecision() {
			return null;
		}

		public String DI_JobIDDefault() {

			return null;

		}

		public String DI_JobIDComment() {

			return "";

		}

		public String DI_JobIDPattern() {

			return "";

		}

		public String DI_JobIDOriginalDbColumnName() {

			return "DI_JobID";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.genre_sk == null) ? 0 : this.genre_sk.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out1Struct other = (out1Struct) obj;

			if (this.genre_sk == null) {
				if (other.genre_sk != null)
					return false;

			} else if (!this.genre_sk.equals(other.genre_sk))

				return false;

			return true;
		}

		public void copyDataTo(out1Struct other) {

			other.genre_sk = this.genre_sk;
			other.genres = this.genres;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_JobID = this.DI_JobID;

		}

		public void copyKeysDataTo(out1Struct other) {

			other.genre_sk = this.genre_sk;

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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.genre_sk = readInteger(dis);

					this.genres = readString(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.genre_sk = readInteger(dis);

					this.genres = readString(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.genre_sk, dos);

				// String

				writeString(this.genres, dos);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_JobID, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.genre_sk, dos);

				// String

				writeString(this.genres, dos);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_JobID, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("genre_sk=" + String.valueOf(genre_sk));
			sb.append(",genres=" + genres);
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_JobID=" + DI_JobID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (genre_sk == null) {
				sb.append("<null>");
			} else {
				sb.append(genre_sk);
			}

			sb.append("|");

			if (genres == null) {
				sb.append("<null>");
			} else {
				sb.append(genres);
			}

			sb.append("|");

			if (DI_CreatedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_CreatedDate);
			}

			sb.append("|");

			if (DI_JobID == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_JobID);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.genre_sk, other.genre_sk);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];

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
			return 10;
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

			return "";

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

			return "";

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

			return "";

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

			return "";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Byte isAdult;

		public Byte getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 3;
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

			return "";

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

			return "";

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

			return "";

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

			return "";

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
			return 255;
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

			return "";

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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

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

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

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

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

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

	public static class OnRowsEndStructtAggregateRow_1
			implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];

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
			return 10;
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

			return "";

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

			return "";

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

			return "";

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

			return "";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Byte isAdult;

		public Byte getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 3;
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

			return "";

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

			return "";

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

			return "";

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

			return "";

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
			return 255;
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

			return "";

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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

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

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

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

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

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
		public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

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

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return true;
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

			return "";

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

			return "";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.tconst = this.tconst;
			other.genres = this.genres;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

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
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.tconst, other.tconst);
			if (returnValue != 0) {
				return returnValue;
			}

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
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return true;
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

			return "";

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

			return "";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out2Struct other = (out2Struct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(out2Struct other) {

			other.tconst = this.tconst;
			other.genres = this.genres;

		}

		public void copyKeysDataTo(out2Struct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

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

			returnValue = checkNullsAndCompare(this.tconst, other.tconst);
			if (returnValue != 0) {
				return returnValue;
			}

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
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];

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
			return 10;
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

			return "";

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

			return "";

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

			return "";

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

			return "";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Byte isAdult;

		public Byte getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 3;
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

			return "";

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

			return "";

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

			return "";

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

			return "";

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
			return 255;
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

			return "";

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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

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

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

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

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

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

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_IMDB_genre_dim = new byte[0];
		static byte[] commonByteArray_IMDB_genre_dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return true;
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

			return "";

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

			return "";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row3Struct other = (row3Struct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.tconst = this.tconst;
			other.genres = this.genres;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_genre_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_genre_dim.length == 0) {
						commonByteArray_IMDB_genre_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_genre_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_genre_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_genre_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

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

			synchronized (commonByteArrayLock_IMDB_genre_dim) {

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
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.tconst, other.tconst);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_1");
		org.slf4j.MDC.put("_subJobPid", "AcwLeb_" + subJobPidCounter.getAndIncrement());

		String currentVirtualComponent = null;

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
				out2Struct out2 = new out2Struct();

				row3Struct row3 = new row3Struct();

				row4Struct row4 = new row4Struct();
				row2Struct row2 = new row2Struct();
				out1Struct out1 = new out1Struct();

				/**
				 * [tAggregateRow_1_AGGOUT begin ] start
				 */

				ok_Hash.put("tAggregateRow_1_AGGOUT", false);
				start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row4");

				int tos_count_tAggregateRow_1_AGGOUT = 0;

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGOUT - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tAggregateRow_1_AGGOUT {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tAggregateRow_1_AGGOUT = new StringBuilder();
							log4jParamters_tAggregateRow_1_AGGOUT.append("Parameters:");
							log4jParamters_tAggregateRow_1_AGGOUT.append("DESTINATION" + " = " + "tAggregateRow_1");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT.append("GROUPBYS" + " = " + "[{OUTPUT_COLUMN="
									+ ("genres") + ", INPUT_COLUMN=" + ("genres") + "}]");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT.append("OPERATIONS" + " = " + "[]");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT.append("LIST_DELIMITER" + " = " + "\",\"");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT.append("USE_FINANCIAL_PRECISION" + " = " + "true");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT.append("CHECK_TYPE_OVERFLOW" + " = " + "false");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT.append("CHECK_ULP" + " = " + "false");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tAggregateRow_1_AGGOUT - " + (log4jParamters_tAggregateRow_1_AGGOUT));
						}
					}
					new BytesLimit65535_tAggregateRow_1_AGGOUT().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tAggregateRow_1_AGGOUT", "tAggregateRow_1_AGGOUT", "tAggregateOut");
					talendJobLogProcess(globalMap);
				}

// ------------ Seems it is not used

				java.util.Map hashAggreg_tAggregateRow_1 = new java.util.HashMap();

// ------------
				class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					String genres;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.genres == null) ? 0 : this.genres.hashCode());

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final AggOperationStruct_tAggregateRow_1 other = (AggOperationStruct_tAggregateRow_1) obj;

						if (this.genres == null) {
							if (other.genres != null)
								return false;
						} else if (!this.genres.equals(other.genres))
							return false;

						return true;
					}

				} // G_OutBegin_AggR_100

				AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
				AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
				java.util.Map<AggOperationStruct_tAggregateRow_1, AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1, AggOperationStruct_tAggregateRow_1>();

				/**
				 * [tAggregateRow_1_AGGOUT begin ] stop
				 */

				/**
				 * [tUnite_1 begin ] start
				 */

				ok_Hash.put("tUnite_1", false);
				start_Hash.put("tUnite_1", System.currentTimeMillis());

				currentComponent = "tUnite_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out2", "row3");

				int tos_count_tUnite_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tUnite_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tUnite_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tUnite_1 = new StringBuilder();
							log4jParamters_tUnite_1.append("Parameters:");
							if (log.isDebugEnabled())
								log.debug("tUnite_1 - " + (log4jParamters_tUnite_1));
						}
					}
					new BytesLimit65535_tUnite_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tUnite_1", "tUnite_1", "tUnite");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tUnite_1 = 0;

				/**
				 * [tUnite_1 begin ] stop
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
				int count_out2_tMap_1 = 0;

				out2Struct out2_tmp = new out2Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				cLabel = "\"merged_title_basics\"";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = " + "context.mysql_imdb_Server");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = " + "context.mysql_imdb_Port");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = " + "context.mysql_imdb_Database");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = " + "context.mysql_imdb_Login");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.mysql_imdb_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"merged_title_basics\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"SELECT    `merged_title_basics`.`tconst`,    `merged_title_basics`.`titleType`,    `merged_title_basics`.`primaryTitle`,    `merged_title_basics`.`originalTitle`,    `merged_title_basics`.`isAdult`,    `merged_title_basics`.`startYear`,    `merged_title_basics`.`endYear`,    `merged_title_basics`.`runtimeMinutes`,    `merged_title_basics`.`genres` FROM `merged_title_basics`\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("PROPERTIES" + " = " + "context.mysql_imdb_AdditionalParams");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("tconst") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("titleType") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("primaryTitle")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("originalTitle") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("isAdult") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("startYear") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("endYear") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("runtimeMinutes")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("genres") + "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - " + (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_1", "\"merged_title_basics\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.mysql_imdb_Login;

				final String decryptedPassword_tDBInput_1 = context.mysql_imdb_Password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = context.mysql_imdb_AdditionalParams;
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mysql://" + context.mysql_imdb_Server + ":" + context.mysql_imdb_Port
						+ "/" + context.mysql_imdb_Database + "?" + properties_tDBInput_1;

				log.debug("tDBInput_1 - Driver ClassName: " + driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '"
						+ dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  `merged_title_basics`.`tconst`, \n  `merged_title_basics`.`titleType`, \n  `merged_title_basics`.`primaryTitle`"
						+ ", \n  `merged_title_basics`.`originalTitle`, \n  `merged_title_basics`.`isAdult`, \n  `merged_title_basics`.`startYear`, \n "
						+ " `merged_title_basics`.`endYear`, \n  `merged_title_basics`.`runtimeMinutes`, \n  `merged_title_basics`.`genres`\nFROM `mer"
						+ "ged_title_basics`";

				log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);

				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.tconst = null;
						} else {

							row1.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.titleType = null;
						} else {

							row1.titleType = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.primaryTitle = null;
						} else {

							row1.primaryTitle = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.originalTitle = null;
						} else {

							row1.originalTitle = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.isAdult = null;
						} else {

							row1.isAdult = rs_tDBInput_1.getByte(5);
							if (rs_tDBInput_1.wasNull()) {
								row1.isAdult = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.startYear = null;
						} else {

							row1.startYear = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row1.endYear = null;
						} else {

							row1.endYear = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row1.runtimeMinutes = null;
						} else {

							row1.runtimeMinutes = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row1.genres = null;
						} else {

							row1.genres = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"merged_title_basics\"";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"merged_title_basics\"";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tDBInput_1", "\"merged_title_basics\"", "tMysqlInput", "tMap_1", "tMap_1",
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

							out2 = null;

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
// Start of branch "out2"
						if (out2 != null) {

							/**
							 * [tUnite_1 main ] start
							 */

							currentComponent = "tUnite_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out2", "tMap_1", "tMap_1", "tMap", "tUnite_1", "tUnite_1", "tUnite"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out2 - " + (out2 == null ? "" : out2.toLogString()));
							}

							if (log.isTraceEnabled()) {
								log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
							}

//////////

// for output
							row4 = new row4Struct();

							row4.tconst = out2.tconst;
							row4.genres = out2.genres;

							nb_line_tUnite_1++;

//////////

							tos_count_tUnite_1++;

							/**
							 * [tUnite_1 main ] stop
							 */

							/**
							 * [tUnite_1 process_data_begin ] start
							 */

							currentComponent = "tUnite_1";

							/**
							 * [tUnite_1 process_data_begin ] stop
							 */

							/**
							 * [tAggregateRow_1_AGGOUT main ] start
							 */

							currentVirtualComponent = "tAggregateRow_1";

							currentComponent = "tAggregateRow_1_AGGOUT";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "row4", "tUnite_1", "tUnite_1", "tUnite", "tAggregateRow_1_AGGOUT",
									"tAggregateRow_1_AGGOUT", "tAggregateOut"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
							}

							operation_finder_tAggregateRow_1.genres = row4.genres;

							operation_finder_tAggregateRow_1.hashCodeDirty = true;

							operation_result_tAggregateRow_1 = hash_tAggregateRow_1
									.get(operation_finder_tAggregateRow_1);

							if (operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

								operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

								operation_result_tAggregateRow_1.genres = operation_finder_tAggregateRow_1.genres;

								hash_tAggregateRow_1.put(operation_result_tAggregateRow_1,
										operation_result_tAggregateRow_1);

							} // G_OutMain_AggR_001

							tos_count_tAggregateRow_1_AGGOUT++;

							/**
							 * [tAggregateRow_1_AGGOUT main ] stop
							 */

							/**
							 * [tAggregateRow_1_AGGOUT process_data_begin ] start
							 */

							currentVirtualComponent = "tAggregateRow_1";

							currentComponent = "tAggregateRow_1_AGGOUT";

							/**
							 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
							 */

							/**
							 * [tAggregateRow_1_AGGOUT process_data_end ] start
							 */

							currentVirtualComponent = "tAggregateRow_1";

							currentComponent = "tAggregateRow_1_AGGOUT";

							/**
							 * [tAggregateRow_1_AGGOUT process_data_end ] stop
							 */

							/**
							 * [tUnite_1 process_data_end ] start
							 */

							currentComponent = "tUnite_1";

							/**
							 * [tUnite_1 process_data_end ] stop
							 */

						} // End of branch "out2"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"merged_title_basics\"";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"merged_title_basics\"";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_1 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: " + nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out2': " + count_out2_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tDBInput_1", "\"merged_title_basics\"", "tMysqlInput", "tMap_1", "tMap_1", "tMap", "output")) {
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
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				cLabel = "\"title_basics_normalized\"";

				int tos_count_tDBInput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
							log4jParamters_tDBInput_2.append("Parameters:");
							log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("HOST" + " = " + "context.mysql_imdb_Server");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PORT" + " = " + "context.mysql_imdb_Port");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("DBNAME" + " = " + "context.mysql_imdb_Database");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USER" + " = " + "context.mysql_imdb_Login");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.mysql_imdb_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"title_basics_normalized\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERY" + " = "
									+ "\"SELECT    `title_basics_normalized`.`tconst`,    `title_basics_normalized`.`genres` FROM `title_basics_normalized`\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("PROPERTIES" + " = " + "context.mysql_imdb_AdditionalParams");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("tconst")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("genres") + "}]");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_2 - " + (log4jParamters_tDBInput_2));
						}
					}
					new BytesLimit65535_tDBInput_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_2", "\"title_basics_normalized\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.mysql_imdb_Login;

				final String decryptedPassword_tDBInput_2 = context.mysql_imdb_Password;

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = context.mysql_imdb_AdditionalParams;
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mysql://" + context.mysql_imdb_Server + ":" + context.mysql_imdb_Port
						+ "/" + context.mysql_imdb_Database + "?" + properties_tDBInput_2;

				log.debug("tDBInput_2 - Driver ClassName: " + driverClass_tDBInput_2 + ".");

				log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '"
						+ dbUser_tDBInput_2 + "'.");

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);
				log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n  `title_basics_normalized`.`tconst`, \n  `title_basics_normalized`.`genres`\nFROM `title_basics_normalized`";

				log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);

				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					log.debug("tDBInput_2 - Retrieving records from the database.");

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row3.tconst = null;
						} else {

							row3.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row3.genres = null;
						} else {

							row3.genres = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}

						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"title_basics_normalized\"";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"title_basics_normalized\"";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tUnite_1 main ] start
						 */

						currentComponent = "tUnite_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row3", "tDBInput_2", "\"title_basics_normalized\"", "tMysqlInput", "tUnite_1",
								"tUnite_1", "tUnite"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("out2 - " + (out2 == null ? "" : out2.toLogString()));
						}

						if (log.isTraceEnabled()) {
							log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
						}

//////////

// for output
						row4 = new row4Struct();

						row4.tconst = row3.tconst;
						row4.genres = row3.genres;

						nb_line_tUnite_1++;

//////////

						tos_count_tUnite_1++;

						/**
						 * [tUnite_1 main ] stop
						 */

						/**
						 * [tUnite_1 process_data_begin ] start
						 */

						currentComponent = "tUnite_1";

						/**
						 * [tUnite_1 process_data_begin ] stop
						 */

						/**
						 * [tAggregateRow_1_AGGOUT main ] start
						 */

						currentVirtualComponent = "tAggregateRow_1";

						currentComponent = "tAggregateRow_1_AGGOUT";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row4", "tUnite_1", "tUnite_1", "tUnite", "tAggregateRow_1_AGGOUT",
								"tAggregateRow_1_AGGOUT", "tAggregateOut"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
						}

						operation_finder_tAggregateRow_1.genres = row4.genres;

						operation_finder_tAggregateRow_1.hashCodeDirty = true;

						operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

						if (operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

							operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

							operation_result_tAggregateRow_1.genres = operation_finder_tAggregateRow_1.genres;

							hash_tAggregateRow_1.put(operation_result_tAggregateRow_1,
									operation_result_tAggregateRow_1);

						} // G_OutMain_AggR_001

						tos_count_tAggregateRow_1_AGGOUT++;

						/**
						 * [tAggregateRow_1_AGGOUT main ] stop
						 */

						/**
						 * [tAggregateRow_1_AGGOUT process_data_begin ] start
						 */

						currentVirtualComponent = "tAggregateRow_1";

						currentComponent = "tAggregateRow_1_AGGOUT";

						/**
						 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
						 */

						/**
						 * [tAggregateRow_1_AGGOUT process_data_end ] start
						 */

						currentVirtualComponent = "tAggregateRow_1";

						currentComponent = "tAggregateRow_1_AGGOUT";

						/**
						 * [tAggregateRow_1_AGGOUT process_data_end ] stop
						 */

						/**
						 * [tUnite_1 process_data_end ] start
						 */

						currentComponent = "tUnite_1";

						/**
						 * [tUnite_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"title_basics_normalized\"";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"title_basics_normalized\"";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						log.debug("tDBInput_2 - Closing the connection to the database.");

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_2 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);
				log.debug("tDBInput_2 - Retrieved records count: " + nb_line_tDBInput_2 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Done."));

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tUnite_1 end ] start
				 */

				currentComponent = "tUnite_1";

				globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out2", "row3");
				}

				if (enableLogStash) {

					if (runStat.log(resourceMap, iterateId, "out2", 2, 0, "tMap_1", "tMap_1", "tMap", "tUnite_1",
							"tUnite_1", "tUnite", "output")) {
						talendJobLogProcess(globalMap);
					}

					if (runStat.log(resourceMap, iterateId, "row3", 2, 0, "tDBInput_2", "\"title_basics_normalized\"",
							"tMysqlInput", "tUnite_1", "tUnite_1", "tUnite", "output")) {
						talendJobLogProcess(globalMap);
					}

				}

				if (log.isDebugEnabled())
					log.debug("tUnite_1 - " + ("Done."));

				ok_Hash.put("tUnite_1", true);
				end_Hash.put("tUnite_1", System.currentTimeMillis());

				/**
				 * [tUnite_1 end ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGOUT end ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row4", 2, 0, "tUnite_1",
						"tUnite_1", "tUnite", "tAggregateRow_1_AGGOUT", "tAggregateRow_1_AGGOUT", "tAggregateOut",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGOUT - " + ("Done."));

				ok_Hash.put("tAggregateRow_1_AGGOUT", true);
				end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());

				/**
				 * [tAggregateRow_1_AGGOUT end ] stop
				 */

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				cLabel = "imdb_db";

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
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "context.imdb2_dbconn_Server");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "context.imdb2_dbconn_Port");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "context.imdb2_dbconn_Database");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "context.imdb2_dbconn_Login");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.imdb2_dbconn_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"genre_dim\"");
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
									.append("PROPERTIES" + " = " + "context.imdb2_dbconn_AdditionalParams");
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
					talendJobLog.addCM("tDBOutput_1", "imdb_db", "tMysqlOutput");
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

				String tableName_tDBOutput_1 = "genre_dim";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = context.imdb2_dbconn_AdditionalParams;
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

				String url_tDBOutput_1 = "jdbc:mysql://" + context.imdb2_dbconn_Server + ":" + context.imdb2_dbconn_Port
						+ "/" + context.imdb2_dbconn_Database + "?" + properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1) + ("."));
				String dbUser_tDBOutput_1 = context.imdb2_dbconn_Login;

				final String decryptedPassword_tDBOutput_1 = context.imdb2_dbconn_Password;

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
				java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(context.imdb2_dbconn_Database,
						null, null, new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_1 = false;
				while (rsTable_tDBOutput_1.next()) {
					String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
					if (table_tDBOutput_1.equalsIgnoreCase("genre_dim")) {
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
							+ "`(`genre_sk` INT(0)  ,`genres` VARCHAR(255)  ,`DI_CreatedDate` DATETIME ,`DI_JobID` VARCHAR(15)  ,primary key(`genre_sk`))");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Create") + (" table '") + (tableName_tDBOutput_1)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_1 = "INSERT INTO `" + "genre_dim"
						+ "` (`genre_sk`,`genres`,`DI_CreatedDate`,`DI_JobID`) VALUES (?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tMap_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_2 = new StringBuilder();
							log4jParamters_tMap_2.append("Parameters:");
							log4jParamters_tMap_2.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_2 - " + (log4jParamters_tMap_2));
						}
					}
					new BytesLimit65535_tMap_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_2", "tMap_2", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row2_tMap_2 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_2 = 0;

				out1Struct out1_tmp = new out1Struct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGIN begin ] start
				 */

				ok_Hash.put("tAggregateRow_1_AGGIN", false);
				start_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGIN";

				int tos_count_tAggregateRow_1_AGGIN = 0;

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGIN - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tAggregateRow_1_AGGIN {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tAggregateRow_1_AGGIN = new StringBuilder();
							log4jParamters_tAggregateRow_1_AGGIN.append("Parameters:");
							log4jParamters_tAggregateRow_1_AGGIN.append("ORIGIN" + " = " + "tAggregateRow_1");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN.append("GROUPBYS" + " = " + "[{OUTPUT_COLUMN="
									+ ("genres") + ", INPUT_COLUMN=" + ("genres") + "}]");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN.append("OPERATIONS" + " = " + "[]");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN.append("LIST_DELIMITER" + " = " + "\",\"");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN.append("USE_FINANCIAL_PRECISION" + " = " + "true");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN.append("CHECK_TYPE_OVERFLOW" + " = " + "false");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN.append("CHECK_ULP" + " = " + "false");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tAggregateRow_1_AGGIN - " + (log4jParamters_tAggregateRow_1_AGGIN));
						}
					}
					new BytesLimit65535_tAggregateRow_1_AGGIN().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tAggregateRow_1_AGGIN", "tAggregateRow_1_AGGIN", "tAggregateIn");
					talendJobLogProcess(globalMap);
				}

				java.util.Collection<AggOperationStruct_tAggregateRow_1> values_tAggregateRow_1 = hash_tAggregateRow_1
						.values();

				globalMap.put("tAggregateRow_1_NB_LINE", values_tAggregateRow_1.size());

				if (log.isInfoEnabled())
					log.info("tAggregateRow_1_AGGIN - " + ("Retrieving the aggregation results."));
				for (AggOperationStruct_tAggregateRow_1 aggregated_row_tAggregateRow_1 : values_tAggregateRow_1) { // G_AggR_600

					/**
					 * [tAggregateRow_1_AGGIN begin ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN main ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					row2.genres = aggregated_row_tAggregateRow_1.genres;

					tos_count_tAggregateRow_1_AGGIN++;

					/**
					 * [tAggregateRow_1_AGGIN main ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN process_data_begin ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					/**
					 * [tAggregateRow_1_AGGIN process_data_begin ] stop
					 */

					/**
					 * [tMap_2 main ] start
					 */

					currentComponent = "tMap_2";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row2", "tAggregateRow_1_AGGIN", "tAggregateRow_1_AGGIN", "tAggregateIn", "tMap_2",
							"tMap_2", "tMap"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
					}

					boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

					// ###############################
					// # Input tables (lookups)

					boolean rejectedInnerJoin_tMap_2 = false;
					boolean mainRowRejected_tMap_2 = false;
					// ###############################
					{ // start of Var scope

						// ###############################
						// # Vars tables

						Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
						// ###############################
						// # Output tables

						out1 = null;

// # Output table : 'out1'
						count_out1_tMap_2++;

						out1_tmp.genre_sk = Numeric.sequence("s1", 1, 1);
						out1_tmp.genres = row2.genres;
						out1_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
						out1_tmp.DI_JobID = pid;
						out1 = out1_tmp;
						log.debug(
								"tMap_2 - Outputting the record " + count_out1_tMap_2 + " of the output table 'out1'.");

// ###############################

					} // end of Var scope

					rejectedInnerJoin_tMap_2 = false;

					tos_count_tMap_2++;

					/**
					 * [tMap_2 main ] stop
					 */

					/**
					 * [tMap_2 process_data_begin ] start
					 */

					currentComponent = "tMap_2";

					/**
					 * [tMap_2 process_data_begin ] stop
					 */
// Start of branch "out1"
					if (out1 != null) {

						/**
						 * [tDBOutput_1 main ] start
						 */

						currentComponent = "tDBOutput_1";

						cLabel = "imdb_db";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "out1", "tMap_2", "tMap_2", "tMap", "tDBOutput_1", "imdb_db", "tMysqlOutput"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("out1 - " + (out1 == null ? "" : out1.toLogString()));
						}

						whetherReject_tDBOutput_1 = false;
						if (out1.genre_sk == null) {
							pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
						} else {
							pstmt_tDBOutput_1.setInt(1, out1.genre_sk);
						}

						if (out1.genres == null) {
							pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
						} else {
							pstmt_tDBOutput_1.setString(2, out1.genres);
						}

						if (out1.DI_CreatedDate != null) {
							date_tDBOutput_1 = out1.DI_CreatedDate.getTime();
							if (date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
								pstmt_tDBOutput_1.setString(3, "0000-00-00 00:00:00");
							} else {
								pstmt_tDBOutput_1.setTimestamp(3, new java.sql.Timestamp(date_tDBOutput_1));
							}
						} else {
							pstmt_tDBOutput_1.setNull(3, java.sql.Types.DATE);
						}

						if (out1.DI_JobID == null) {
							pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
						} else {
							pstmt_tDBOutput_1.setString(4, out1.DI_JobID);
						}

						pstmt_tDBOutput_1.addBatch();
						nb_line_tDBOutput_1++;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1) + (" to the ")
									+ ("INSERT") + (" batch."));
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

						cLabel = "imdb_db";

						/**
						 * [tDBOutput_1 process_data_begin ] stop
						 */

						/**
						 * [tDBOutput_1 process_data_end ] start
						 */

						currentComponent = "tDBOutput_1";

						cLabel = "imdb_db";

						/**
						 * [tDBOutput_1 process_data_end ] stop
						 */

					} // End of branch "out1"

					/**
					 * [tMap_2 process_data_end ] start
					 */

					currentComponent = "tMap_2";

					/**
					 * [tMap_2 process_data_end ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN process_data_end ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					/**
					 * [tAggregateRow_1_AGGIN process_data_end ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN end ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

				} // G_AggR_600

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGIN - " + ("Done."));

				ok_Hash.put("tAggregateRow_1_AGGIN", true);
				end_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());

				/**
				 * [tAggregateRow_1_AGGIN end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'out1': " + count_out1_tMap_2 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tAggregateRow_1_AGGIN", "tAggregateRow_1_AGGIN", "tAggregateIn", "tMap_2", "tMap_2", "tMap",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Done."));

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "imdb_db";

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

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out1", 2, 0, "tMap_2",
						"tMap_2", "tMap", "tDBOutput_1", "imdb_db", "tMysqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tAggregateRow_1_AGGIN"
			globalMap.remove("tAggregateRow_1");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				cLabel = "\"merged_title_basics\"";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				cLabel = "\"title_basics_normalized\"";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tUnite_1 finally ] start
				 */

				currentComponent = "tUnite_1";

				/**
				 * [tUnite_1 finally ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGOUT finally ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				/**
				 * [tAggregateRow_1_AGGOUT finally ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGIN finally ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGIN";

				/**
				 * [tAggregateRow_1_AGGIN finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "imdb_db";

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

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "Ojrdqh_" + subJobPidCounter.getAndIncrement());

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
		final genre_dim genre_dimClass = new genre_dim();

		int exitCode = genre_dimClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'genre_dim' - Done.");
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
		log.info("TalendJob: 'genre_dim' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_i8bd0JJ8Ee6_WIiIWRIzPA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-04T08:14:05.169191100Z");

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
			java.io.InputStream inContext = genre_dim.class.getClassLoader()
					.getResourceAsStream("imdb/genre_dim_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = genre_dim.class.getClassLoader()
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
					context.setContextType("mysql_imdb_Port", "id_String");
					if (context.getStringValue("mysql_imdb_Port") == null) {
						context.mysql_imdb_Port = null;
					} else {
						context.mysql_imdb_Port = (String) context.getProperty("mysql_imdb_Port");
					}
					context.setContextType("mysql_imdb_Login", "id_String");
					if (context.getStringValue("mysql_imdb_Login") == null) {
						context.mysql_imdb_Login = null;
					} else {
						context.mysql_imdb_Login = (String) context.getProperty("mysql_imdb_Login");
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
					context.setContextType("mysql_imdb_Server", "id_String");
					if (context.getStringValue("mysql_imdb_Server") == null) {
						context.mysql_imdb_Server = null;
					} else {
						context.mysql_imdb_Server = (String) context.getProperty("mysql_imdb_Server");
					}
					context.setContextType("mysql_imdb_AdditionalParams", "id_String");
					if (context.getStringValue("mysql_imdb_AdditionalParams") == null) {
						context.mysql_imdb_AdditionalParams = null;
					} else {
						context.mysql_imdb_AdditionalParams = (String) context
								.getProperty("mysql_imdb_AdditionalParams");
					}
					context.setContextType("imdb_db_Login", "id_String");
					if (context.getStringValue("imdb_db_Login") == null) {
						context.imdb_db_Login = null;
					} else {
						context.imdb_db_Login = (String) context.getProperty("imdb_db_Login");
					}
					context.setContextType("imdb_db_AdditionalParams", "id_String");
					if (context.getStringValue("imdb_db_AdditionalParams") == null) {
						context.imdb_db_AdditionalParams = null;
					} else {
						context.imdb_db_AdditionalParams = (String) context.getProperty("imdb_db_AdditionalParams");
					}
					context.setContextType("imdb_db_Password", "id_Password");
					if (context.getStringValue("imdb_db_Password") == null) {
						context.imdb_db_Password = null;
					} else {
						String pwd_imdb_db_Password_value = context.getProperty("imdb_db_Password");
						context.imdb_db_Password = null;
						if (pwd_imdb_db_Password_value != null) {
							if (context_param.containsKey("imdb_db_Password")) {// no need to decrypt if it come from
																				// program argument or parent job
																				// runtime
								context.imdb_db_Password = pwd_imdb_db_Password_value;
							} else if (!pwd_imdb_db_Password_value.isEmpty()) {
								try {
									context.imdb_db_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_imdb_db_Password_value);
									context.put("imdb_db_Password", context.imdb_db_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("imdb_db_Database", "id_String");
					if (context.getStringValue("imdb_db_Database") == null) {
						context.imdb_db_Database = null;
					} else {
						context.imdb_db_Database = (String) context.getProperty("imdb_db_Database");
					}
					context.setContextType("imdb_db_Server", "id_String");
					if (context.getStringValue("imdb_db_Server") == null) {
						context.imdb_db_Server = null;
					} else {
						context.imdb_db_Server = (String) context.getProperty("imdb_db_Server");
					}
					context.setContextType("imdb_db_Port", "id_String");
					if (context.getStringValue("imdb_db_Port") == null) {
						context.imdb_db_Port = null;
					} else {
						context.imdb_db_Port = (String) context.getProperty("imdb_db_Port");
					}
					context.setContextType("imdb2_dbconn_Port", "id_String");
					if (context.getStringValue("imdb2_dbconn_Port") == null) {
						context.imdb2_dbconn_Port = null;
					} else {
						context.imdb2_dbconn_Port = (String) context.getProperty("imdb2_dbconn_Port");
					}
					context.setContextType("imdb2_dbconn_Database", "id_String");
					if (context.getStringValue("imdb2_dbconn_Database") == null) {
						context.imdb2_dbconn_Database = null;
					} else {
						context.imdb2_dbconn_Database = (String) context.getProperty("imdb2_dbconn_Database");
					}
					context.setContextType("imdb2_dbconn_Login", "id_String");
					if (context.getStringValue("imdb2_dbconn_Login") == null) {
						context.imdb2_dbconn_Login = null;
					} else {
						context.imdb2_dbconn_Login = (String) context.getProperty("imdb2_dbconn_Login");
					}
					context.setContextType("imdb2_dbconn_AdditionalParams", "id_String");
					if (context.getStringValue("imdb2_dbconn_AdditionalParams") == null) {
						context.imdb2_dbconn_AdditionalParams = null;
					} else {
						context.imdb2_dbconn_AdditionalParams = (String) context
								.getProperty("imdb2_dbconn_AdditionalParams");
					}
					context.setContextType("imdb2_dbconn_Password", "id_Password");
					if (context.getStringValue("imdb2_dbconn_Password") == null) {
						context.imdb2_dbconn_Password = null;
					} else {
						String pwd_imdb2_dbconn_Password_value = context.getProperty("imdb2_dbconn_Password");
						context.imdb2_dbconn_Password = null;
						if (pwd_imdb2_dbconn_Password_value != null) {
							if (context_param.containsKey("imdb2_dbconn_Password")) {// no need to decrypt if it come
																						// from program argument or
																						// parent job runtime
								context.imdb2_dbconn_Password = pwd_imdb2_dbconn_Password_value;
							} else if (!pwd_imdb2_dbconn_Password_value.isEmpty()) {
								try {
									context.imdb2_dbconn_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_imdb2_dbconn_Password_value);
									context.put("imdb2_dbconn_Password", context.imdb2_dbconn_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("imdb2_dbconn_Server", "id_String");
					if (context.getStringValue("imdb2_dbconn_Server") == null) {
						context.imdb2_dbconn_Server = null;
					} else {
						context.imdb2_dbconn_Server = (String) context.getProperty("imdb2_dbconn_Server");
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
			if (parentContextMap.containsKey("mysql_imdb_Port")) {
				context.mysql_imdb_Port = (String) parentContextMap.get("mysql_imdb_Port");
			}
			if (parentContextMap.containsKey("mysql_imdb_Login")) {
				context.mysql_imdb_Login = (String) parentContextMap.get("mysql_imdb_Login");
			}
			if (parentContextMap.containsKey("mysql_imdb_Password")) {
				context.mysql_imdb_Password = (java.lang.String) parentContextMap.get("mysql_imdb_Password");
			}
			if (parentContextMap.containsKey("mysql_imdb_Database")) {
				context.mysql_imdb_Database = (String) parentContextMap.get("mysql_imdb_Database");
			}
			if (parentContextMap.containsKey("mysql_imdb_Server")) {
				context.mysql_imdb_Server = (String) parentContextMap.get("mysql_imdb_Server");
			}
			if (parentContextMap.containsKey("mysql_imdb_AdditionalParams")) {
				context.mysql_imdb_AdditionalParams = (String) parentContextMap.get("mysql_imdb_AdditionalParams");
			}
			if (parentContextMap.containsKey("imdb_db_Login")) {
				context.imdb_db_Login = (String) parentContextMap.get("imdb_db_Login");
			}
			if (parentContextMap.containsKey("imdb_db_AdditionalParams")) {
				context.imdb_db_AdditionalParams = (String) parentContextMap.get("imdb_db_AdditionalParams");
			}
			if (parentContextMap.containsKey("imdb_db_Password")) {
				context.imdb_db_Password = (java.lang.String) parentContextMap.get("imdb_db_Password");
			}
			if (parentContextMap.containsKey("imdb_db_Database")) {
				context.imdb_db_Database = (String) parentContextMap.get("imdb_db_Database");
			}
			if (parentContextMap.containsKey("imdb_db_Server")) {
				context.imdb_db_Server = (String) parentContextMap.get("imdb_db_Server");
			}
			if (parentContextMap.containsKey("imdb_db_Port")) {
				context.imdb_db_Port = (String) parentContextMap.get("imdb_db_Port");
			}
			if (parentContextMap.containsKey("imdb2_dbconn_Port")) {
				context.imdb2_dbconn_Port = (String) parentContextMap.get("imdb2_dbconn_Port");
			}
			if (parentContextMap.containsKey("imdb2_dbconn_Database")) {
				context.imdb2_dbconn_Database = (String) parentContextMap.get("imdb2_dbconn_Database");
			}
			if (parentContextMap.containsKey("imdb2_dbconn_Login")) {
				context.imdb2_dbconn_Login = (String) parentContextMap.get("imdb2_dbconn_Login");
			}
			if (parentContextMap.containsKey("imdb2_dbconn_AdditionalParams")) {
				context.imdb2_dbconn_AdditionalParams = (String) parentContextMap.get("imdb2_dbconn_AdditionalParams");
			}
			if (parentContextMap.containsKey("imdb2_dbconn_Password")) {
				context.imdb2_dbconn_Password = (java.lang.String) parentContextMap.get("imdb2_dbconn_Password");
			}
			if (parentContextMap.containsKey("imdb2_dbconn_Server")) {
				context.imdb2_dbconn_Server = (String) parentContextMap.get("imdb2_dbconn_Server");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("mysql_imdb_Password");
		parametersToEncrypt.add("imdb_db_Password");
		parametersToEncrypt.add("imdb2_dbconn_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'genre_dim' - Started.");
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
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : genre_dim");
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
		log.info("TalendJob: 'genre_dim' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 219761 characters generated by Talend Cloud Data Fabric on the 4 December
 * 2023 at 3:14:05 AM GMT-05:00
 ************************************************************************************************/