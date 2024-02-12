
package imdb.sql_scripts_staging_0_1;

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
 * Job: sql_scripts_staging Purpose: <br>
 * Description: <br>
 * 
 * @author machiraju.s@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class sql_scripts_staging implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "sql_scripts_staging.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(sql_scripts_staging.class);

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
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "sql_scripts_staging";
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
			"_BODO4JDgEe6jSKGRzHGoWQ", "0.1");
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
					sql_scripts_staging.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(sql_scripts_staging.this, new Object[] { e, currentComponent, globalMap });
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

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class out4Struct implements routines.system.IPersistableRow<out4Struct> {
		final static byte[] commonByteArrayLock_IMDB_sql_scripts_staging = new byte[0];
		static byte[] commonByteArray_IMDB_sql_scripts_staging = new byte[0];
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
			return false;
		}

		public Boolean tconstIsKey() {
			return true;
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

		public Integer runtimeMinutes;

		public Integer getRuntimeMinutes() {
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

			return "0";

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

		public java.util.Date DI_CreatedDate;

		public java.util.Date getDI_CreatedDate() {
			return this.DI_CreatedDate;
		}

		public Boolean DI_CreatedDateIsNullable() {
			return false;
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
			return false;
		}

		public Boolean DI_JobIDIsKey() {
			return false;
		}

		public Integer DI_JobIDLength() {
			return 8;
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
			final out4Struct other = (out4Struct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(out4Struct other) {

			other.tconst = this.tconst;
			other.titleType = this.titleType;
			other.primaryTitle = this.primaryTitle;
			other.originalTitle = this.originalTitle;
			other.isAdult = this.isAdult;
			other.startYear = this.startYear;
			other.endYear = this.endYear;
			other.runtimeMinutes = this.runtimeMinutes;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_JobID = this.DI_JobID;

		}

		public void copyKeysDataTo(out4Struct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_sql_scripts_staging.length) {
					if (length < 1024 && commonByteArray_IMDB_sql_scripts_staging.length == 0) {
						commonByteArray_IMDB_sql_scripts_staging = new byte[1024];
					} else {
						commonByteArray_IMDB_sql_scripts_staging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_sql_scripts_staging, 0, length);
				strReturn = new String(commonByteArray_IMDB_sql_scripts_staging, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_sql_scripts_staging.length) {
					if (length < 1024 && commonByteArray_IMDB_sql_scripts_staging.length == 0) {
						commonByteArray_IMDB_sql_scripts_staging = new byte[1024];
					} else {
						commonByteArray_IMDB_sql_scripts_staging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_sql_scripts_staging, 0, length);
				strReturn = new String(commonByteArray_IMDB_sql_scripts_staging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_sql_scripts_staging) {

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

					this.runtimeMinutes = readInteger(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_sql_scripts_staging) {

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

					this.runtimeMinutes = readInteger(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

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

				// Integer

				writeInteger(this.runtimeMinutes, dos);

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

				// Integer

				writeInteger(this.runtimeMinutes, dos);

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
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + startYear);
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + String.valueOf(runtimeMinutes));
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_JobID=" + DI_JobID);
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
		public int compareTo(out4Struct other) {

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

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_IMDB_sql_scripts_staging = new byte[0];
		static byte[] commonByteArray_IMDB_sql_scripts_staging = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return true;
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

		public java.util.Date DI_Create_DT;

		public java.util.Date getDI_Create_DT() {
			return this.DI_Create_DT;
		}

		public Boolean DI_Create_DTIsNullable() {
			return false;
		}

		public Boolean DI_Create_DTIsKey() {
			return false;
		}

		public Integer DI_Create_DTLength() {
			return 19;
		}

		public Integer DI_Create_DTPrecision() {
			return 0;
		}

		public String DI_Create_DTDefault() {

			return "CURRENT_TIMESTAMP";

		}

		public String DI_Create_DTComment() {

			return "";

		}

		public String DI_Create_DTPattern() {

			return "dd-MM-yyyy";

		}

		public String DI_Create_DTOriginalDbColumnName() {

			return "DI_Create_DT";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_sql_scripts_staging.length) {
					if (length < 1024 && commonByteArray_IMDB_sql_scripts_staging.length == 0) {
						commonByteArray_IMDB_sql_scripts_staging = new byte[1024];
					} else {
						commonByteArray_IMDB_sql_scripts_staging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_sql_scripts_staging, 0, length);
				strReturn = new String(commonByteArray_IMDB_sql_scripts_staging, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_sql_scripts_staging.length) {
					if (length < 1024 && commonByteArray_IMDB_sql_scripts_staging.length == 0) {
						commonByteArray_IMDB_sql_scripts_staging = new byte[1024];
					} else {
						commonByteArray_IMDB_sql_scripts_staging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_sql_scripts_staging, 0, length);
				strReturn = new String(commonByteArray_IMDB_sql_scripts_staging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_sql_scripts_staging) {

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

					this.DI_Create_DT = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_sql_scripts_staging) {

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

					this.DI_Create_DT = readDate(dis);

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

				// java.util.Date

				writeDate(this.DI_Create_DT, dos);

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

				// java.util.Date

				writeDate(this.DI_Create_DT, dos);

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
			sb.append(",DI_Create_DT=" + String.valueOf(DI_Create_DT));
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

			if (DI_Create_DT == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_Create_DT);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

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

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_3");
		org.slf4j.MDC.put("_subJobPid", "ZYEesd_" + subJobPidCounter.getAndIncrement());

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

				row3Struct row3 = new row3Struct();
				out4Struct out4 = new out4Struct();

				/**
				 * [tDBOutput_4 begin ] start
				 */

				ok_Hash.put("tDBOutput_4", false);
				start_Hash.put("tDBOutput_4", System.currentTimeMillis());

				currentComponent = "tDBOutput_4";

				cLabel = "mysql_imdb";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out4");

				int tos_count_tDBOutput_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_4 = new StringBuilder();
							log4jParamters_tDBOutput_4.append("Parameters:");
							log4jParamters_tDBOutput_4.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("HOST" + " = " + "context.mysql_imdb_Server");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("PORT" + " = " + "context.mysql_imdb_Port");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("DBNAME" + " = " + "\"imdb\"");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("USER" + " = " + "context.mysql_imdb_Login");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.mysql_imdb_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("TABLE" + " = " + "\"stg_title_basics\"");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4
									.append("PROPERTIES" + " = " + "context.mysql_imdb_AdditionalParams");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("EXTENDINSERT" + " = " + "true");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("NB_ROWS_PER_INSERT" + " = " + "100");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("USE_HINT_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
							log4jParamters_tDBOutput_4.append(" | ");
							log4jParamters_tDBOutput_4.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_4 - " + (log4jParamters_tDBOutput_4));
						}
					}
					new BytesLimit65535_tDBOutput_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_4", "mysql_imdb", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tDBOutput_4 = 0;
				int nb_line_update_tDBOutput_4 = 0;
				int nb_line_inserted_tDBOutput_4 = 0;
				int nb_line_deleted_tDBOutput_4 = 0;
				int nb_line_rejected_tDBOutput_4 = 0;

				int deletedCount_tDBOutput_4 = 0;
				int updatedCount_tDBOutput_4 = 0;
				int insertedCount_tDBOutput_4 = 0;
				int rowsToCommitCount_tDBOutput_4 = 0;
				int rejectedCount_tDBOutput_4 = 0;

				String tableName_tDBOutput_4 = "stg_title_basics";
				boolean whetherReject_tDBOutput_4 = false;

				java.util.Calendar calendar_tDBOutput_4 = java.util.Calendar.getInstance();
				calendar_tDBOutput_4.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
				calendar_tDBOutput_4.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
				long date_tDBOutput_4;

				java.sql.Connection conn_tDBOutput_4 = null;

				String properties_tDBOutput_4 = context.mysql_imdb_AdditionalParams;
				if (properties_tDBOutput_4 == null || properties_tDBOutput_4.trim().length() == 0) {
					properties_tDBOutput_4 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_4.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_4 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_4.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_4 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_4 = "jdbc:mysql://" + context.mysql_imdb_Server + ":" + context.mysql_imdb_Port
						+ "/" + "imdb" + "?" + properties_tDBOutput_4;

				String driverClass_tDBOutput_4 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_4) + ("."));
				String dbUser_tDBOutput_4 = context.mysql_imdb_Login;

				final String decryptedPassword_tDBOutput_4 = context.mysql_imdb_Password;

				String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;
				java.lang.Class.forName(driverClass_tDBOutput_4);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Connection attempts to '") + (url_tDBOutput_4)
							+ ("' with the username '") + (dbUser_tDBOutput_4) + ("'."));
				conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4, dbUser_tDBOutput_4,
						dbPwd_tDBOutput_4);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Connection to '") + (url_tDBOutput_4) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);

				conn_tDBOutput_4.setAutoCommit(false);
				int commitEvery_tDBOutput_4 = 10000;
				int commitCounter_tDBOutput_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_4.getAutoCommit()) + ("'."));

				int count_tDBOutput_4 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_4 = conn_tDBOutput_4.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_4 = dbMetaData_tDBOutput_4.getTables("imdb", null, null,
						new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_4 = false;
				while (rsTable_tDBOutput_4.next()) {
					String table_tDBOutput_4 = rsTable_tDBOutput_4.getString("TABLE_NAME");
					if (table_tDBOutput_4.equalsIgnoreCase("stg_title_basics")) {
						whetherExist_tDBOutput_4 = true;
						break;
					}
				}
				if (whetherExist_tDBOutput_4) {
					try (java.sql.Statement stmtDrop_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_4 - " + ("Dropping") + (" table '") + (tableName_tDBOutput_4) + ("'."));
						stmtDrop_tDBOutput_4.execute("DROP TABLE `" + tableName_tDBOutput_4 + "`");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_4 - " + ("Drop") + (" table '") + (tableName_tDBOutput_4)
									+ ("' has succeeded."));
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
					if (log.isDebugEnabled())
						log.debug("tDBOutput_4 - " + ("Creating") + (" table '") + (tableName_tDBOutput_4) + ("'."));
					stmtCreate_tDBOutput_4.execute("CREATE TABLE `" + tableName_tDBOutput_4
							+ "`(`tconst` VARCHAR(10)   not null ,`titleType` VARCHAR(255)  ,`primaryTitle` VARCHAR(1024)  ,`originalTitle` VARCHAR(1024)  ,`isAdult` TINYINT(3)  ,`startYear` VARCHAR(4)  ,`endYear` VARCHAR(4)  ,`runtimeMinutes` INT(10)  default 0 ,`DI_CreatedDate` DATETIME  not null ,`DI_JobID` VARCHAR(8)   not null ,primary key(`tconst`))");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_4 - " + ("Create") + (" table '") + (tableName_tDBOutput_4)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_4 = "INSERT INTO `" + "stg_title_basics"
						+ "` (`tconst`,`titleType`,`primaryTitle`,`originalTitle`,`isAdult`,`startYear`,`endYear`,`runtimeMinutes`,`DI_CreatedDate`,`DI_JobID`) VALUES (?,?,?,?,?,?,?,?,?,?)";

				int batchSize_tDBOutput_4 = 100;
				int batchSizeCounter_tDBOutput_4 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
				resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);

				/**
				 * [tDBOutput_4 begin ] stop
				 */

				/**
				 * [tMap_4 begin ] start
				 */

				ok_Hash.put("tMap_4", false);
				start_Hash.put("tMap_4", System.currentTimeMillis());

				currentComponent = "tMap_4";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row3");

				int tos_count_tMap_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_4 = new StringBuilder();
							log4jParamters_tMap_4.append("Parameters:");
							log4jParamters_tMap_4.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_4 - " + (log4jParamters_tMap_4));
						}
					}
					new BytesLimit65535_tMap_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_4", "tMap_4", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row3_tMap_4 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_4__Struct {
					java.util.Date DI_CreatedDate;
					String DI_JobID;
				}
				Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out4_tMap_4 = 0;

				out4Struct out4_tmp = new out4Struct();
// ###############################

				/**
				 * [tMap_4 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				cLabel = "\"imdb_title_basics\"";

				int tos_count_tDBInput_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_3 = new StringBuilder();
							log4jParamters_tDBInput_3.append("Parameters:");
							log4jParamters_tDBInput_3.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("HOST" + " = " + "context.mysql_imdb_Server");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PORT" + " = " + "context.mysql_imdb_Port");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("DBNAME" + " = " + "context.mysql_imdb_Database");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USER" + " = " + "context.mysql_imdb_Login");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.mysql_imdb_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"imdb_title_basics\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERY" + " = "
									+ "\"SELECT    `imdb_title_basics`.`tconst`,    `imdb_title_basics`.`titleType`,    `imdb_title_basics`.`primaryTitle`,    `imdb_title_basics`.`originalTitle`,    `imdb_title_basics`.`isAdult`,    `imdb_title_basics`.`startYear`,    `imdb_title_basics`.`endYear`,    `imdb_title_basics`.`runtimeMinutes`,    `imdb_title_basics`.`genres`,    `imdb_title_basics`.`DI_Create_DT` FROM `imdb_title_basics`\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("PROPERTIES" + " = " + "context.mysql_imdb_AdditionalParams");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("tconst") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("titleType") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("primaryTitle")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("originalTitle") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("isAdult") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("startYear") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("endYear") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("runtimeMinutes")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("genres") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("DI_Create_DT") + "}]");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_3 - " + (log4jParamters_tDBInput_3));
						}
					}
					new BytesLimit65535_tDBInput_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_3", "\"imdb_title_basics\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_3 = java.util.Calendar.getInstance();
				calendar_tDBInput_3.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_3 = calendar_tDBInput_3.getTime();
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = context.mysql_imdb_Login;

				final String decryptedPassword_tDBInput_3 = context.mysql_imdb_Password;

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String properties_tDBInput_3 = context.mysql_imdb_AdditionalParams;
				if (properties_tDBInput_3 == null || properties_tDBInput_3.trim().length() == 0) {
					properties_tDBInput_3 = "";
				}
				String url_tDBInput_3 = "jdbc:mysql://" + context.mysql_imdb_Server + ":" + context.mysql_imdb_Port
						+ "/" + context.mysql_imdb_Database + "?" + properties_tDBInput_3;

				log.debug("tDBInput_3 - Driver ClassName: " + driverClass_tDBInput_3 + ".");

				log.debug("tDBInput_3 - Connection attempt to '" + url_tDBInput_3 + "' with the username '"
						+ dbUser_tDBInput_3 + "'.");

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);
				log.debug("tDBInput_3 - Connection to '" + url_tDBInput_3 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT \n  `imdb_title_basics`.`tconst`, \n  `imdb_title_basics`.`titleType`, \n  `imdb_title_basics`.`primaryTitle`, \n  `"
						+ "imdb_title_basics`.`originalTitle`, \n  `imdb_title_basics`.`isAdult`, \n  `imdb_title_basics`.`startYear`, \n  `imdb_title"
						+ "_basics`.`endYear`, \n  `imdb_title_basics`.`runtimeMinutes`, \n  `imdb_title_basics`.`genres`, \n  `imdb_title_basics`.`DI"
						+ "_Create_DT`\nFROM `imdb_title_basics`";

				log.debug("tDBInput_3 - Executing the query: '" + dbquery_tDBInput_3 + "'.");

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);

				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					log.debug("tDBInput_3 - Retrieving records from the database.");

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row3.tconst = null;
						} else {

							row3.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row3.titleType = null;
						} else {

							row3.titleType = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row3.primaryTitle = null;
						} else {

							row3.primaryTitle = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row3.originalTitle = null;
						} else {

							row3.originalTitle = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row3.isAdult = null;
						} else {

							row3.isAdult = rs_tDBInput_3.getByte(5);
							if (rs_tDBInput_3.wasNull()) {
								row3.isAdult = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row3.startYear = null;
						} else {

							row3.startYear = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row3.endYear = null;
						} else {

							row3.endYear = routines.system.JDBCUtil.getString(rs_tDBInput_3, 7, false);
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							row3.runtimeMinutes = null;
						} else {

							row3.runtimeMinutes = routines.system.JDBCUtil.getString(rs_tDBInput_3, 8, false);
						}
						if (colQtyInRs_tDBInput_3 < 9) {
							row3.genres = null;
						} else {

							row3.genres = routines.system.JDBCUtil.getString(rs_tDBInput_3, 9, false);
						}
						if (colQtyInRs_tDBInput_3 < 10) {
							row3.DI_Create_DT = null;
						} else {

							if (rs_tDBInput_3.getString(10) != null) {
								String dateString_tDBInput_3 = rs_tDBInput_3.getString(10);
								if (!("0000-00-00").equals(dateString_tDBInput_3)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_3)) {
									row3.DI_Create_DT = rs_tDBInput_3.getTimestamp(10);
								} else {
									row3.DI_Create_DT = (java.util.Date) year0_tDBInput_3.clone();
								}
							} else {
								row3.DI_Create_DT = null;
							}
						}

						log.debug("tDBInput_3 - Retrieving the record " + nb_line_tDBInput_3 + ".");

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"imdb_title_basics\"";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"imdb_title_basics\"";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tMap_4 main ] start
						 */

						currentComponent = "tMap_4";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row3", "tDBInput_3", "\"imdb_title_basics\"", "tMysqlInput", "tMap_4", "tMap_4",
								"tMap"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

						// ###############################
						// # Input tables (lookups)

						boolean rejectedInnerJoin_tMap_4 = false;
						boolean mainRowRejected_tMap_4 = false;
						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_4__Struct Var = Var__tMap_4;
							Var.DI_CreatedDate = TalendDate.getCurrentDate();
							Var.DI_JobID = pid;// ###############################
							// ###############################
							// # Output tables

							out4 = null;

// # Output table : 'out4'
							count_out4_tMap_4++;

							out4_tmp.tconst = row3.tconst;
							out4_tmp.titleType = row3.titleType;
							out4_tmp.primaryTitle = row3.primaryTitle;
							out4_tmp.originalTitle = row3.originalTitle;
							out4_tmp.isAdult = row3.isAdult;
							out4_tmp.startYear = row3.startYear.replace("\\N", "");
							out4_tmp.endYear = row3.endYear;
							out4_tmp.runtimeMinutes = row3.runtimeMinutes.equals("\\N") ? null
									: Integer.parseInt(row3.runtimeMinutes);
							out4_tmp.DI_CreatedDate = Var.DI_CreatedDate;
							out4_tmp.DI_JobID = Var.DI_JobID;
							out4 = out4_tmp;
							log.debug("tMap_4 - Outputting the record " + count_out4_tMap_4
									+ " of the output table 'out4'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_4 = false;

						tos_count_tMap_4++;

						/**
						 * [tMap_4 main ] stop
						 */

						/**
						 * [tMap_4 process_data_begin ] start
						 */

						currentComponent = "tMap_4";

						/**
						 * [tMap_4 process_data_begin ] stop
						 */
// Start of branch "out4"
						if (out4 != null) {

							/**
							 * [tDBOutput_4 main ] start
							 */

							currentComponent = "tDBOutput_4";

							cLabel = "mysql_imdb";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out4", "tMap_4", "tMap_4", "tMap", "tDBOutput_4", "mysql_imdb", "tMysqlOutput"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out4 - " + (out4 == null ? "" : out4.toLogString()));
							}

							whetherReject_tDBOutput_4 = false;
							if (out4.tconst == null) {
								pstmt_tDBOutput_4.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(1, out4.tconst);
							}

							if (out4.titleType == null) {
								pstmt_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(2, out4.titleType);
							}

							if (out4.primaryTitle == null) {
								pstmt_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(3, out4.primaryTitle);
							}

							if (out4.originalTitle == null) {
								pstmt_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(4, out4.originalTitle);
							}

							if (out4.isAdult == null) {
								pstmt_tDBOutput_4.setNull(5, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_4.setByte(5, out4.isAdult);
							}

							if (out4.startYear == null) {
								pstmt_tDBOutput_4.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(6, out4.startYear);
							}

							if (out4.endYear == null) {
								pstmt_tDBOutput_4.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(7, out4.endYear);
							}

							if (out4.runtimeMinutes == null) {
								pstmt_tDBOutput_4.setNull(8, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_4.setInt(8, out4.runtimeMinutes);
							}

							if (out4.DI_CreatedDate != null) {
								date_tDBOutput_4 = out4.DI_CreatedDate.getTime();
								if (date_tDBOutput_4 < year1_tDBOutput_4 || date_tDBOutput_4 >= year10000_tDBOutput_4) {
									pstmt_tDBOutput_4.setString(9, "0000-00-00 00:00:00");
								} else {
									pstmt_tDBOutput_4.setTimestamp(9, new java.sql.Timestamp(date_tDBOutput_4));
								}
							} else {
								pstmt_tDBOutput_4.setNull(9, java.sql.Types.DATE);
							}

							if (out4.DI_JobID == null) {
								pstmt_tDBOutput_4.setNull(10, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(10, out4.DI_JobID);
							}

							pstmt_tDBOutput_4.addBatch();
							nb_line_tDBOutput_4++;

							if (log.isDebugEnabled())
								log.debug("tDBOutput_4 - " + ("Adding the record ") + (nb_line_tDBOutput_4)
										+ (" to the ") + ("INSERT") + (" batch."));
							batchSizeCounter_tDBOutput_4++;
							if (batchSize_tDBOutput_4 <= batchSizeCounter_tDBOutput_4) {
								try {
									int countSum_tDBOutput_4 = 0;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_4 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
										countSum_tDBOutput_4 += (countEach_tDBOutput_4 == java.sql.Statement.EXECUTE_FAILED
												? 0
												: 1);
									}
									rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_4 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_4 = 0;
									for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
										countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
									}
									rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
									insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
									System.err.println(e.getMessage());
									log.error("tDBOutput_4 - " + (e.getMessage()));
								}

								batchSizeCounter_tDBOutput_4 = 0;
							}
							commitCounter_tDBOutput_4++;

							if (commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {

								try {
									int countSum_tDBOutput_4 = 0;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_4 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
										countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : 1);
									}
									rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_4 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_4 = 0;
									for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
										countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
									}
									rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
									insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
									System.err.println(e.getMessage());
									log.error("tDBOutput_4 - " + (e.getMessage()));

								}
								if (rowsToCommitCount_tDBOutput_4 != 0) {
									if (log.isDebugEnabled())
										log.debug("tDBOutput_4 - " + ("Connection starting to commit ")
												+ (rowsToCommitCount_tDBOutput_4) + (" record(s)."));
								}
								conn_tDBOutput_4.commit();
								if (rowsToCommitCount_tDBOutput_4 != 0) {
									if (log.isDebugEnabled())
										log.debug("tDBOutput_4 - " + ("Connection commit has succeeded."));
									rowsToCommitCount_tDBOutput_4 = 0;
								}
								commitCounter_tDBOutput_4 = 0;
							}

							tos_count_tDBOutput_4++;

							/**
							 * [tDBOutput_4 main ] stop
							 */

							/**
							 * [tDBOutput_4 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_4";

							cLabel = "mysql_imdb";

							/**
							 * [tDBOutput_4 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_4 process_data_end ] start
							 */

							currentComponent = "tDBOutput_4";

							cLabel = "mysql_imdb";

							/**
							 * [tDBOutput_4 process_data_end ] stop
							 */

						} // End of branch "out4"

						/**
						 * [tMap_4 process_data_end ] start
						 */

						currentComponent = "tMap_4";

						/**
						 * [tMap_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"imdb_title_basics\"";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"imdb_title_basics\"";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						log.debug("tDBInput_3 - Closing the connection to the database.");

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_3 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);
				log.debug("tDBInput_3 - Retrieved records count: " + nb_line_tDBInput_3 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Done."));

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tMap_4 end ] start
				 */

				currentComponent = "tMap_4";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_4 - Written records count in the table 'out4': " + count_out4_tMap_4 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row3", 2, 0,
						"tDBInput_3", "\"imdb_title_basics\"", "tMysqlInput", "tMap_4", "tMap_4", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Done."));

				ok_Hash.put("tMap_4", true);
				end_Hash.put("tMap_4", System.currentTimeMillis());

				/**
				 * [tMap_4 end ] stop
				 */

				/**
				 * [tDBOutput_4 end ] start
				 */

				currentComponent = "tDBOutput_4";

				cLabel = "mysql_imdb";

				try {
					if (batchSizeCounter_tDBOutput_4 != 0) {
						int countSum_tDBOutput_4 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_4 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
							countSum_tDBOutput_4 += (countEach_tDBOutput_4 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_4 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_4 = 0;
					for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
						countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
					}
					rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

					insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

					log.error("tDBOutput_4 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_4 = 0;

				if (pstmt_tDBOutput_4 != null) {

					pstmt_tDBOutput_4.close();
					resourceMap.remove("pstmt_tDBOutput_4");

				}

				resourceMap.put("statementClosed_tDBOutput_4", true);

				if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_4 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_4) + (" record(s)."));
				}
				conn_tDBOutput_4.commit();
				if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_4 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_4 = 0;
				}
				commitCounter_tDBOutput_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Closing the connection to the database."));
				conn_tDBOutput_4.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_4", true);

				nb_line_deleted_tDBOutput_4 = nb_line_deleted_tDBOutput_4 + deletedCount_tDBOutput_4;
				nb_line_update_tDBOutput_4 = nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
				nb_line_inserted_tDBOutput_4 = nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
				nb_line_rejected_tDBOutput_4 = nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;

				globalMap.put("tDBOutput_4_NB_LINE", nb_line_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_UPDATED", nb_line_update_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_DELETED", nb_line_deleted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_4)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out4", 2, 0, "tMap_4",
						"tMap_4", "tMap", "tDBOutput_4", "mysql_imdb", "tMysqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_4 - " + ("Done."));

				ok_Hash.put("tDBOutput_4", true);
				end_Hash.put("tDBOutput_4", System.currentTimeMillis());

				/**
				 * [tDBOutput_4 end ] stop
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
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				cLabel = "\"imdb_title_basics\"";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tMap_4 finally ] start
				 */

				currentComponent = "tMap_4";

				/**
				 * [tMap_4 finally ] stop
				 */

				/**
				 * [tDBOutput_4 finally ] start
				 */

				currentComponent = "tDBOutput_4";

				cLabel = "mysql_imdb";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
						if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_4")) != null) {
							pstmtToClose_tDBOutput_4.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_4") == null) {
						java.sql.Connection ctn_tDBOutput_4 = null;
						if ((ctn_tDBOutput_4 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_4")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_4 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_4.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_4 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_4) {
								String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :"
										+ sqlEx_tDBOutput_4.getMessage();
								log.error("tDBOutput_4 - " + (errorMessage_tDBOutput_4));
								System.err.println(errorMessage_tDBOutput_4);
							}
						}
					}
				}

				/**
				 * [tDBOutput_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "OIAbzb_" + subJobPidCounter.getAndIncrement());

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
		final sql_scripts_staging sql_scripts_stagingClass = new sql_scripts_staging();

		int exitCode = sql_scripts_stagingClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'sql_scripts_staging' - Done.");
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
		log.info("TalendJob: 'sql_scripts_staging' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_BODO4JDgEe6jSKGRzHGoWQ");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-04T02:00:49.146266600Z");

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
			java.io.InputStream inContext = sql_scripts_staging.class.getClassLoader()
					.getResourceAsStream("imdb/sql_scripts_staging_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = sql_scripts_staging.class.getClassLoader()
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
		log.info("TalendJob: 'sql_scripts_staging' - Started.");
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
			tDBInput_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_3) {
			globalMap.put("tDBInput_3_SUBPROCESS_STATE", -1);

			e_tDBInput_3.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : sql_scripts_staging");
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
		log.info("TalendJob: 'sql_scripts_staging' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 130231 characters generated by Talend Cloud Data Fabric on the 3 December
 * 2023 at 9:00:49 PM GMT-05:00
 ************************************************************************************************/