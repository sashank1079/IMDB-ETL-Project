
package imdb.fact_movie_revenue_0_1;

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
 * Job: fact_movie_revenue Purpose: <br>
 * Description: <br>
 * 
 * @author machiraju.s@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class fact_movie_revenue implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "fact_movie_revenue.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(fact_movie_revenue.class);

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

			if (imdb_db_Port != null) {

				this.setProperty("imdb_db_Port", imdb_db_Port.toString());

			}

			if (imdb_db_Login != null) {

				this.setProperty("imdb_db_Login", imdb_db_Login.toString());

			}

			if (imdb_db_AdditionalParams != null) {

				this.setProperty("imdb_db_AdditionalParams", imdb_db_AdditionalParams.toString());

			}

			if (imdb_db_Database != null) {

				this.setProperty("imdb_db_Database", imdb_db_Database.toString());

			}

			if (imdb_db_Server != null) {

				this.setProperty("imdb_db_Server", imdb_db_Server.toString());

			}

			if (imdb_db_Password != null) {

				this.setProperty("imdb_db_Password", imdb_db_Password.toString());

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

		public String imdb_db_Port;

		public String getImdb_db_Port() {
			return this.imdb_db_Port;
		}

		public String imdb_db_Login;

		public String getImdb_db_Login() {
			return this.imdb_db_Login;
		}

		public String imdb_db_AdditionalParams;

		public String getImdb_db_AdditionalParams() {
			return this.imdb_db_AdditionalParams;
		}

		public String imdb_db_Database;

		public String getImdb_db_Database() {
			return this.imdb_db_Database;
		}

		public String imdb_db_Server;

		public String getImdb_db_Server() {
			return this.imdb_db_Server;
		}

		public java.lang.String imdb_db_Password;

		public java.lang.String getImdb_db_Password() {
			return this.imdb_db_Password;
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
	private final String jobName = "fact_movie_revenue";
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
			"_Fv0tsJGgEe6-v-KvacN3eg", "0.1");
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
					fact_movie_revenue.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(fact_movie_revenue.this, new Object[] { e, currentComponent, globalMap });
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

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBOutput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
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

	public void tDBOutput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_IMDB_fact_movie_revenue = new byte[0];
		static byte[] commonByteArray_IMDB_fact_movie_revenue = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int datesk;

		public int getDatesk() {
			return this.datesk;
		}

		public Boolean dateskIsNullable() {
			return false;
		}

		public Boolean dateskIsKey() {
			return true;
		}

		public Integer dateskLength() {
			return 10;
		}

		public Integer dateskPrecision() {
			return 0;
		}

		public String dateskDefault() {

			return null;

		}

		public String dateskComment() {

			return "";

		}

		public String dateskPattern() {

			return "";

		}

		public String dateskOriginalDbColumnName() {

			return "datesk";

		}

		public java.util.Date date;

		public java.util.Date getDate() {
			return this.date;
		}

		public Boolean dateIsNullable() {
			return true;
		}

		public Boolean dateIsKey() {
			return false;
		}

		public Integer dateLength() {
			return 10;
		}

		public Integer datePrecision() {
			return 0;
		}

		public String dateDefault() {

			return null;

		}

		public String dateComment() {

			return "";

		}

		public String datePattern() {

			return "dd-MM-yyyy";

		}

		public String dateOriginalDbColumnName() {

			return "date";

		}

		public Integer Day;

		public Integer getDay() {
			return this.Day;
		}

		public Boolean DayIsNullable() {
			return true;
		}

		public Boolean DayIsKey() {
			return false;
		}

		public Integer DayLength() {
			return 10;
		}

		public Integer DayPrecision() {
			return 0;
		}

		public String DayDefault() {

			return null;

		}

		public String DayComment() {

			return "";

		}

		public String DayPattern() {

			return "";

		}

		public String DayOriginalDbColumnName() {

			return "Day";

		}

		public String Day_Str;

		public String getDay_Str() {
			return this.Day_Str;
		}

		public Boolean Day_StrIsNullable() {
			return true;
		}

		public Boolean Day_StrIsKey() {
			return false;
		}

		public Integer Day_StrLength() {
			return 9;
		}

		public Integer Day_StrPrecision() {
			return 0;
		}

		public String Day_StrDefault() {

			return null;

		}

		public String Day_StrComment() {

			return "";

		}

		public String Day_StrPattern() {

			return "";

		}

		public String Day_StrOriginalDbColumnName() {

			return "Day_Str";

		}

		public String Month_Str;

		public String getMonth_Str() {
			return this.Month_Str;
		}

		public Boolean Month_StrIsNullable() {
			return true;
		}

		public Boolean Month_StrIsKey() {
			return false;
		}

		public Integer Month_StrLength() {
			return 9;
		}

		public Integer Month_StrPrecision() {
			return 0;
		}

		public String Month_StrDefault() {

			return null;

		}

		public String Month_StrComment() {

			return "";

		}

		public String Month_StrPattern() {

			return "";

		}

		public String Month_StrOriginalDbColumnName() {

			return "Month_Str";

		}

		public String Season;

		public String getSeason() {
			return this.Season;
		}

		public Boolean SeasonIsNullable() {
			return true;
		}

		public Boolean SeasonIsKey() {
			return false;
		}

		public Integer SeasonLength() {
			return 8;
		}

		public Integer SeasonPrecision() {
			return 0;
		}

		public String SeasonDefault() {

			return null;

		}

		public String SeasonComment() {

			return "";

		}

		public String SeasonPattern() {

			return "";

		}

		public String SeasonOriginalDbColumnName() {

			return "Season";

		}

		public Integer Year;

		public Integer getYear() {
			return this.Year;
		}

		public Boolean YearIsNullable() {
			return true;
		}

		public Boolean YearIsKey() {
			return false;
		}

		public Integer YearLength() {
			return 10;
		}

		public Integer YearPrecision() {
			return 0;
		}

		public String YearDefault() {

			return null;

		}

		public String YearComment() {

			return "";

		}

		public String YearPattern() {

			return "";

		}

		public String YearOriginalDbColumnName() {

			return "Year";

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
			return 19;
		}

		public Integer DI_CreatedDatePrecision() {
			return 0;
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
			return 10;
		}

		public Integer DI_JobIDPrecision() {
			return 0;
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

				result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());

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
			final row2Struct other = (row2Struct) obj;

			if (this.date == null) {
				if (other.date != null)
					return false;

			} else if (!this.date.equals(other.date))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.datesk = this.datesk;
			other.date = this.date;
			other.Day = this.Day;
			other.Day_Str = this.Day_Str;
			other.Month_Str = this.Month_Str;
			other.Season = this.Season;
			other.Year = this.Year;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_JobID = this.DI_JobID;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.date = this.date;

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

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.datesk = dis.readInt();

				this.Day = readInteger(dis, ois);

				this.Day_Str = readString(dis, ois);

				this.Month_Str = readString(dis, ois);

				this.Season = readString(dis, ois);

				this.Year = readInteger(dis, ois);

				this.DI_CreatedDate = readDate(dis, ois);

				this.DI_JobID = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.datesk = objectIn.readInt();

				this.Day = readInteger(dis, objectIn);

				this.Day_Str = readString(dis, objectIn);

				this.Month_Str = readString(dis, objectIn);

				this.Season = readString(dis, objectIn);

				this.Year = readInteger(dis, objectIn);

				this.DI_CreatedDate = readDate(dis, objectIn);

				this.DI_JobID = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.datesk);

				writeInteger(this.Day, dos, oos);

				writeString(this.Day_Str, dos, oos);

				writeString(this.Month_Str, dos, oos);

				writeString(this.Season, dos, oos);

				writeInteger(this.Year, dos, oos);

				writeDate(this.DI_CreatedDate, dos, oos);

				writeString(this.DI_JobID, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.datesk);

				writeInteger(this.Day, dos, objectOut);

				writeString(this.Day_Str, dos, objectOut);

				writeString(this.Month_Str, dos, objectOut);

				writeString(this.Season, dos, objectOut);

				writeInteger(this.Year, dos, objectOut);

				writeDate(this.DI_CreatedDate, dos, objectOut);

				writeString(this.DI_JobID, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("datesk=" + String.valueOf(datesk));
			sb.append(",date=" + String.valueOf(date));
			sb.append(",Day=" + String.valueOf(Day));
			sb.append(",Day_Str=" + Day_Str);
			sb.append(",Month_Str=" + Month_Str);
			sb.append(",Season=" + Season);
			sb.append(",Year=" + String.valueOf(Year));
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_JobID=" + DI_JobID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(datesk);

			sb.append("|");

			if (date == null) {
				sb.append("<null>");
			} else {
				sb.append(date);
			}

			sb.append("|");

			if (Day == null) {
				sb.append("<null>");
			} else {
				sb.append(Day);
			}

			sb.append("|");

			if (Day_Str == null) {
				sb.append("<null>");
			} else {
				sb.append(Day_Str);
			}

			sb.append("|");

			if (Month_Str == null) {
				sb.append("<null>");
			} else {
				sb.append(Month_Str);
			}

			sb.append("|");

			if (Season == null) {
				sb.append("<null>");
			} else {
				sb.append(Season);
			}

			sb.append("|");

			if (Year == null) {
				sb.append("<null>");
			} else {
				sb.append(Year);
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
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.date, other.date);
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
		org.slf4j.MDC.put("_subJobPid", "KnyLGY_" + subJobPidCounter.getAndIncrement());

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

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tAdvancedHash_row2 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row2
				// source node:tDBInput_1 - inputs:(after_tDBInput_3) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row2,row3,out2) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				cLabel = "\"date_dimension\"";

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
							log4jParamters_tDBInput_1.append("HOST" + " = " + "context.imdb_db_Server");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = " + "context.imdb_db_Port");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = " + "context.imdb_db_Database");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = " + "context.imdb_db_Login");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.imdb_db_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"date_dimension\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"SELECT    `date_dimension`.`datesk`,    `date_dimension`.`date`,    `date_dimension`.`Day`,    `date_dimension`.`Day_Str`,    `date_dimension`.`Month_Str`,    `date_dimension`.`Season`,    `date_dimension`.`Year`,    `date_dimension`.`DI_CreatedDate`,    `date_dimension`.`DI_JobID` FROM `date_dimension`\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "context.imdb_db_AdditionalParams");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("datesk") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("date") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Day") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("Day_Str") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Month_Str") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("Season") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Year") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("DI_CreatedDate") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DI_JobID") + "}]");
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
					talendJobLog.addCM("tDBInput_1", "\"date_dimension\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.imdb_db_Login;

				final String decryptedPassword_tDBInput_1 = context.imdb_db_Password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = context.imdb_db_AdditionalParams;
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mysql://" + context.imdb_db_Server + ":" + context.imdb_db_Port + "/"
						+ context.imdb_db_Database + "?" + properties_tDBInput_1;

				log.debug("tDBInput_1 - Driver ClassName: " + driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '"
						+ dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  `date_dimension`.`datesk`, \n  `date_dimension`.`date`, \n  `date_dimension`.`Day`, \n  `date_dimension`.`Day_St"
						+ "r`, \n  `date_dimension`.`Month_Str`, \n  `date_dimension`.`Season`, \n  `date_dimension`.`Year`, \n  `date_dimension`.`DI_C"
						+ "reatedDate`, \n  `date_dimension`.`DI_JobID`\nFROM `date_dimension`";

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
							row2.datesk = 0;
						} else {

							row2.datesk = rs_tDBInput_1.getInt(1);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row2.date = null;
						} else {

							if (rs_tDBInput_1.getString(2) != null) {
								String dateString_tDBInput_1 = rs_tDBInput_1.getString(2);
								if (!("0000-00-00").equals(dateString_tDBInput_1)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
									row2.date = rs_tDBInput_1.getTimestamp(2);
								} else {
									row2.date = (java.util.Date) year0_tDBInput_1.clone();
								}
							} else {
								row2.date = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row2.Day = null;
						} else {

							row2.Day = rs_tDBInput_1.getInt(3);
							if (rs_tDBInput_1.wasNull()) {
								row2.Day = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row2.Day_Str = null;
						} else {

							row2.Day_Str = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row2.Month_Str = null;
						} else {

							row2.Month_Str = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row2.Season = null;
						} else {

							row2.Season = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row2.Year = null;
						} else {

							row2.Year = rs_tDBInput_1.getInt(7);
							if (rs_tDBInput_1.wasNull()) {
								row2.Year = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row2.DI_CreatedDate = null;
						} else {

							if (rs_tDBInput_1.getString(8) != null) {
								String dateString_tDBInput_1 = rs_tDBInput_1.getString(8);
								if (!("0000-00-00").equals(dateString_tDBInput_1)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
									row2.DI_CreatedDate = rs_tDBInput_1.getTimestamp(8);
								} else {
									row2.DI_CreatedDate = (java.util.Date) year0_tDBInput_1.clone();
								}
							} else {
								row2.DI_CreatedDate = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row2.DI_JobID = null;
						} else {

							row2.DI_JobID = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"date_dimension\"";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"date_dimension\"";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row2", "tDBInput_1", "\"date_dimension\"", "tMysqlInput", "tAdvancedHash_row2",
								"tAdvancedHash_row2", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.datesk = row2.datesk;

						row2_HashRow.date = row2.date;

						row2_HashRow.Day = row2.Day;

						row2_HashRow.Day_Str = row2.Day_Str;

						row2_HashRow.Month_Str = row2.Month_Str;

						row2_HashRow.Season = row2.Season;

						row2_HashRow.Year = row2.Year;

						row2_HashRow.DI_CreatedDate = row2.DI_CreatedDate;

						row2_HashRow.DI_JobID = row2.DI_JobID;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"date_dimension\"";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"date_dimension\"";

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
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tDBInput_1", "\"date_dimension\"", "tMysqlInput", "tAdvancedHash_row2", "tAdvancedHash_row2",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
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
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				cLabel = "\"date_dimension\"";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
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

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_IMDB_fact_movie_revenue = new byte[0];
		static byte[] commonByteArray_IMDB_fact_movie_revenue = new byte[0];
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

		public int movie_sk;

		public int getMovie_sk() {
			return this.movie_sk;
		}

		public Boolean movie_skIsNullable() {
			return false;
		}

		public Boolean movie_skIsKey() {
			return true;
		}

		public Integer movie_skLength() {
			return 10;
		}

		public Integer movie_skPrecision() {
			return 0;
		}

		public String movie_skDefault() {

			return null;

		}

		public String movie_skComment() {

			return "";

		}

		public String movie_skPattern() {

			return "";

		}

		public String movie_skOriginalDbColumnName() {

			return "movie_sk";

		}

		public java.util.Date scd_start;

		public java.util.Date getScd_start() {
			return this.scd_start;
		}

		public Boolean scd_startIsNullable() {
			return false;
		}

		public Boolean scd_startIsKey() {
			return false;
		}

		public Integer scd_startLength() {
			return 19;
		}

		public Integer scd_startPrecision() {
			return 0;
		}

		public String scd_startDefault() {

			return null;

		}

		public String scd_startComment() {

			return "";

		}

		public String scd_startPattern() {

			return "dd-MM-yyyy";

		}

		public String scd_startOriginalDbColumnName() {

			return "scd_start";

		}

		public java.util.Date scd_end;

		public java.util.Date getScd_end() {
			return this.scd_end;
		}

		public Boolean scd_endIsNullable() {
			return true;
		}

		public Boolean scd_endIsKey() {
			return false;
		}

		public Integer scd_endLength() {
			return 19;
		}

		public Integer scd_endPrecision() {
			return 0;
		}

		public String scd_endDefault() {

			return null;

		}

		public String scd_endComment() {

			return "";

		}

		public String scd_endPattern() {

			return "dd-MM-yyyy";

		}

		public String scd_endOriginalDbColumnName() {

			return "scd_end";

		}

		public int scd_version;

		public int getScd_version() {
			return this.scd_version;
		}

		public Boolean scd_versionIsNullable() {
			return false;
		}

		public Boolean scd_versionIsKey() {
			return false;
		}

		public Integer scd_versionLength() {
			return 10;
		}

		public Integer scd_versionPrecision() {
			return 0;
		}

		public String scd_versionDefault() {

			return null;

		}

		public String scd_versionComment() {

			return "";

		}

		public String scd_versionPattern() {

			return "";

		}

		public String scd_versionOriginalDbColumnName() {

			return "scd_version";

		}

		public boolean scd_active;

		public boolean getScd_active() {
			return this.scd_active;
		}

		public Boolean scd_activeIsNullable() {
			return false;
		}

		public Boolean scd_activeIsKey() {
			return false;
		}

		public Integer scd_activeLength() {
			return 15;
		}

		public Integer scd_activePrecision() {
			return 0;
		}

		public String scd_activeDefault() {

			return null;

		}

		public String scd_activeComment() {

			return "";

		}

		public String scd_activePattern() {

			return "";

		}

		public String scd_activeOriginalDbColumnName() {

			return "scd_active";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.primaryTitle == null) ? 0 : this.primaryTitle.hashCode());

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

			if (this.primaryTitle == null) {
				if (other.primaryTitle != null)
					return false;

			} else if (!this.primaryTitle.equals(other.primaryTitle))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.tconst = this.tconst;
			other.primaryTitle = this.primaryTitle;
			other.originalTitle = this.originalTitle;
			other.startYear = this.startYear;
			other.endYear = this.endYear;
			other.movie_sk = this.movie_sk;
			other.scd_start = this.scd_start;
			other.scd_end = this.scd_end;
			other.scd_version = this.scd_version;
			other.scd_active = this.scd_active;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.primaryTitle = this.primaryTitle;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.primaryTitle = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.primaryTitle = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.primaryTitle, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.primaryTitle, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.tconst = readString(dis, ois);

				this.originalTitle = readString(dis, ois);

				this.startYear = readString(dis, ois);

				this.endYear = readString(dis, ois);

				this.movie_sk = dis.readInt();

				this.scd_start = readDate(dis, ois);

				this.scd_end = readDate(dis, ois);

				this.scd_version = dis.readInt();

				this.scd_active = dis.readBoolean();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.tconst = readString(dis, objectIn);

				this.originalTitle = readString(dis, objectIn);

				this.startYear = readString(dis, objectIn);

				this.endYear = readString(dis, objectIn);

				this.movie_sk = objectIn.readInt();

				this.scd_start = readDate(dis, objectIn);

				this.scd_end = readDate(dis, objectIn);

				this.scd_version = objectIn.readInt();

				this.scd_active = objectIn.readBoolean();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.tconst, dos, oos);

				writeString(this.originalTitle, dos, oos);

				writeString(this.startYear, dos, oos);

				writeString(this.endYear, dos, oos);

				dos.writeInt(this.movie_sk);

				writeDate(this.scd_start, dos, oos);

				writeDate(this.scd_end, dos, oos);

				dos.writeInt(this.scd_version);

				dos.writeBoolean(this.scd_active);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.tconst, dos, objectOut);

				writeString(this.originalTitle, dos, objectOut);

				writeString(this.startYear, dos, objectOut);

				writeString(this.endYear, dos, objectOut);

				objectOut.writeInt(this.movie_sk);

				writeDate(this.scd_start, dos, objectOut);

				writeDate(this.scd_end, dos, objectOut);

				objectOut.writeInt(this.scd_version);

				objectOut.writeBoolean(this.scd_active);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",startYear=" + startYear);
			sb.append(",endYear=" + endYear);
			sb.append(",movie_sk=" + String.valueOf(movie_sk));
			sb.append(",scd_start=" + String.valueOf(scd_start));
			sb.append(",scd_end=" + String.valueOf(scd_end));
			sb.append(",scd_version=" + String.valueOf(scd_version));
			sb.append(",scd_active=" + String.valueOf(scd_active));
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

			sb.append(movie_sk);

			sb.append("|");

			if (scd_start == null) {
				sb.append("<null>");
			} else {
				sb.append(scd_start);
			}

			sb.append("|");

			if (scd_end == null) {
				sb.append("<null>");
			} else {
				sb.append(scd_end);
			}

			sb.append("|");

			sb.append(scd_version);

			sb.append("|");

			sb.append(scd_active);

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.primaryTitle, other.primaryTitle);
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

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_2");
		org.slf4j.MDC.put("_subJobPid", "f8IifI_" + subJobPidCounter.getAndIncrement());

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

				/**
				 * [tAdvancedHash_row3 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row3", false);
				start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row3";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row3");

				int tos_count_tAdvancedHash_row3 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row3", "tAdvancedHash_row3", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row3
				// source node:tDBInput_2 - inputs:(after_tDBInput_3) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_1 - inputs:(row2,row3,out2) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				cLabel = "\"movie_dim_scd\"";

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
							log4jParamters_tDBInput_2.append("HOST" + " = " + "context.imdb_db_Server");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PORT" + " = " + "context.imdb_db_Port");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("DBNAME" + " = " + "context.imdb_db_Database");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USER" + " = " + "context.imdb_db_Login");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.imdb_db_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"movie_dim_scd\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERY" + " = "
									+ "\"SELECT    `movie_dim_scd`.`tconst`,    `movie_dim_scd`.`primaryTitle`,    `movie_dim_scd`.`originalTitle`,    `movie_dim_scd`.`startYear`,    `movie_dim_scd`.`endYear`,    `movie_dim_scd`.`movie_sk`,    `movie_dim_scd`.`scd_start`,    `movie_dim_scd`.`scd_end`,    `movie_dim_scd`.`scd_version`,    `movie_dim_scd`.`scd_active` FROM `movie_dim_scd`\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PROPERTIES" + " = " + "context.imdb_db_AdditionalParams");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("tconst") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("primaryTitle") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("originalTitle") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("startYear")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("endYear") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("movie_sk") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("scd_start") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("scd_end") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("scd_version")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("scd_active") + "}]");
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
					talendJobLog.addCM("tDBInput_2", "\"movie_dim_scd\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.imdb_db_Login;

				final String decryptedPassword_tDBInput_2 = context.imdb_db_Password;

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = context.imdb_db_AdditionalParams;
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mysql://" + context.imdb_db_Server + ":" + context.imdb_db_Port + "/"
						+ context.imdb_db_Database + "?" + properties_tDBInput_2;

				log.debug("tDBInput_2 - Driver ClassName: " + driverClass_tDBInput_2 + ".");

				log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '"
						+ dbUser_tDBInput_2 + "'.");

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);
				log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n  `movie_dim_scd`.`tconst`, \n  `movie_dim_scd`.`primaryTitle`, \n  `movie_dim_scd`.`originalTitle`, \n  `movie_di"
						+ "m_scd`.`startYear`, \n  `movie_dim_scd`.`endYear`, \n  `movie_dim_scd`.`movie_sk`, \n  `movie_dim_scd`.`scd_start`, \n  `mov"
						+ "ie_dim_scd`.`scd_end`, \n  `movie_dim_scd`.`scd_version`, \n  `movie_dim_scd`.`scd_active`\nFROM `movie_dim_scd`";

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
							row3.primaryTitle = null;
						} else {

							row3.primaryTitle = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row3.originalTitle = null;
						} else {

							row3.originalTitle = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row3.startYear = null;
						} else {

							row3.startYear = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row3.endYear = null;
						} else {

							row3.endYear = routines.system.JDBCUtil.getString(rs_tDBInput_2, 5, false);
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							row3.movie_sk = 0;
						} else {

							row3.movie_sk = rs_tDBInput_2.getInt(6);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							row3.scd_start = null;
						} else {

							if (rs_tDBInput_2.getString(7) != null) {
								String dateString_tDBInput_2 = rs_tDBInput_2.getString(7);
								if (!("0000-00-00").equals(dateString_tDBInput_2)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_2)) {
									row3.scd_start = rs_tDBInput_2.getTimestamp(7);
								} else {
									row3.scd_start = (java.util.Date) year0_tDBInput_2.clone();
								}
							} else {
								row3.scd_start = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 8) {
							row3.scd_end = null;
						} else {

							if (rs_tDBInput_2.getString(8) != null) {
								String dateString_tDBInput_2 = rs_tDBInput_2.getString(8);
								if (!("0000-00-00").equals(dateString_tDBInput_2)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_2)) {
									row3.scd_end = rs_tDBInput_2.getTimestamp(8);
								} else {
									row3.scd_end = (java.util.Date) year0_tDBInput_2.clone();
								}
							} else {
								row3.scd_end = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 9) {
							row3.scd_version = 0;
						} else {

							row3.scd_version = rs_tDBInput_2.getInt(9);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 10) {
							row3.scd_active = false;
						} else {

							row3.scd_active = rs_tDBInput_2.getBoolean(10);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"movie_dim_scd\"";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"movie_dim_scd\"";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 main ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row3", "tDBInput_2", "\"movie_dim_scd\"", "tMysqlInput", "tAdvancedHash_row3",
								"tAdvancedHash_row3", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
						}

						row3Struct row3_HashRow = new row3Struct();

						row3_HashRow.tconst = row3.tconst;

						row3_HashRow.primaryTitle = row3.primaryTitle;

						row3_HashRow.originalTitle = row3.originalTitle;

						row3_HashRow.startYear = row3.startYear;

						row3_HashRow.endYear = row3.endYear;

						row3_HashRow.movie_sk = row3.movie_sk;

						row3_HashRow.scd_start = row3.scd_start;

						row3_HashRow.scd_end = row3.scd_end;

						row3_HashRow.scd_version = row3.scd_version;

						row3_HashRow.scd_active = row3.scd_active;

						tHash_Lookup_row3.put(row3_HashRow);

						tos_count_tAdvancedHash_row3++;

						/**
						 * [tAdvancedHash_row3 main ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"movie_dim_scd\"";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"movie_dim_scd\"";

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
				 * [tAdvancedHash_row3 end ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				tHash_Lookup_row3.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row3", 2, 0,
						"tDBInput_2", "\"movie_dim_scd\"", "tMysqlInput", "tAdvancedHash_row3", "tAdvancedHash_row3",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row3", true);
				end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row3 end ] stop
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
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				cLabel = "\"movie_dim_scd\"";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row3 finally ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				/**
				 * [tAdvancedHash_row3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_IMDB_fact_movie_revenue = new byte[0];
		static byte[] commonByteArray_IMDB_fact_movie_revenue = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int revenue_fact_sk;

		public int getRevenue_fact_sk() {
			return this.revenue_fact_sk;
		}

		public Boolean revenue_fact_skIsNullable() {
			return false;
		}

		public Boolean revenue_fact_skIsKey() {
			return true;
		}

		public Integer revenue_fact_skLength() {
			return null;
		}

		public Integer revenue_fact_skPrecision() {
			return null;
		}

		public String revenue_fact_skDefault() {

			return null;

		}

		public String revenue_fact_skComment() {

			return "";

		}

		public String revenue_fact_skPattern() {

			return "";

		}

		public String revenue_fact_skOriginalDbColumnName() {

			return "revenue_fact_sk";

		}

		public int movie_sk;

		public int getMovie_sk() {
			return this.movie_sk;
		}

		public Boolean movie_skIsNullable() {
			return false;
		}

		public Boolean movie_skIsKey() {
			return false;
		}

		public Integer movie_skLength() {
			return 10;
		}

		public Integer movie_skPrecision() {
			return 0;
		}

		public String movie_skDefault() {

			return null;

		}

		public String movie_skComment() {

			return "";

		}

		public String movie_skPattern() {

			return "";

		}

		public String movie_skOriginalDbColumnName() {

			return "movie_sk";

		}

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

		public java.util.Date date;

		public java.util.Date getDate() {
			return this.date;
		}

		public Boolean dateIsNullable() {
			return true;
		}

		public Boolean dateIsKey() {
			return false;
		}

		public Integer dateLength() {
			return 10;
		}

		public Integer datePrecision() {
			return 0;
		}

		public String dateDefault() {

			return null;

		}

		public String dateComment() {

			return "";

		}

		public String datePattern() {

			return "dd-MM-yyyy";

		}

		public String dateOriginalDbColumnName() {

			return "date";

		}

		public String Rank;

		public String getRank() {
			return this.Rank;
		}

		public Boolean RankIsNullable() {
			return true;
		}

		public Boolean RankIsKey() {
			return false;
		}

		public Integer RankLength() {
			return 100;
		}

		public Integer RankPrecision() {
			return 0;
		}

		public String RankDefault() {

			return null;

		}

		public String RankComment() {

			return "";

		}

		public String RankPattern() {

			return "";

		}

		public String RankOriginalDbColumnName() {

			return "Rank";

		}

		public Integer Gross;

		public Integer getGross() {
			return this.Gross;
		}

		public Boolean GrossIsNullable() {
			return true;
		}

		public Boolean GrossIsKey() {
			return false;
		}

		public Integer GrossLength() {
			return 10;
		}

		public Integer GrossPrecision() {
			return 0;
		}

		public String GrossDefault() {

			return null;

		}

		public String GrossComment() {

			return "";

		}

		public String GrossPattern() {

			return "";

		}

		public String GrossOriginalDbColumnName() {

			return "Gross";

		}

		public Integer Days;

		public Integer getDays() {
			return this.Days;
		}

		public Boolean DaysIsNullable() {
			return true;
		}

		public Boolean DaysIsKey() {
			return false;
		}

		public Integer DaysLength() {
			return 10;
		}

		public Integer DaysPrecision() {
			return 0;
		}

		public String DaysDefault() {

			return null;

		}

		public String DaysComment() {

			return "";

		}

		public String DaysPattern() {

			return "";

		}

		public String DaysOriginalDbColumnName() {

			return "Days";

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
			return 20;
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
			return 10;
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

				result = prime * result + (int) this.revenue_fact_sk;

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

			if (this.revenue_fact_sk != other.revenue_fact_sk)
				return false;

			return true;
		}

		public void copyDataTo(out1Struct other) {

			other.revenue_fact_sk = this.revenue_fact_sk;
			other.movie_sk = this.movie_sk;
			other.tconst = this.tconst;
			other.date = this.date;
			other.Rank = this.Rank;
			other.Gross = this.Gross;
			other.Days = this.Days;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_JobID = this.DI_JobID;

		}

		public void copyKeysDataTo(out1Struct other) {

			other.revenue_fact_sk = this.revenue_fact_sk;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.revenue_fact_sk = dis.readInt();

					this.movie_sk = dis.readInt();

					this.tconst = readString(dis);

					this.date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					this.Days = readInteger(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.revenue_fact_sk = dis.readInt();

					this.movie_sk = dis.readInt();

					this.tconst = readString(dis);

					this.date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					this.Days = readInteger(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.revenue_fact_sk);

				// int

				dos.writeInt(this.movie_sk);

				// String

				writeString(this.tconst, dos);

				// java.util.Date

				writeDate(this.date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

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

				// int

				dos.writeInt(this.revenue_fact_sk);

				// int

				dos.writeInt(this.movie_sk);

				// String

				writeString(this.tconst, dos);

				// java.util.Date

				writeDate(this.date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

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
			sb.append("revenue_fact_sk=" + String.valueOf(revenue_fact_sk));
			sb.append(",movie_sk=" + String.valueOf(movie_sk));
			sb.append(",tconst=" + tconst);
			sb.append(",date=" + String.valueOf(date));
			sb.append(",Rank=" + Rank);
			sb.append(",Gross=" + String.valueOf(Gross));
			sb.append(",Days=" + String.valueOf(Days));
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_JobID=" + DI_JobID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(revenue_fact_sk);

			sb.append("|");

			sb.append(movie_sk);

			sb.append("|");

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (date == null) {
				sb.append("<null>");
			} else {
				sb.append(date);
			}

			sb.append("|");

			if (Rank == null) {
				sb.append("<null>");
			} else {
				sb.append(Rank);
			}

			sb.append("|");

			if (Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Gross);
			}

			sb.append("|");

			if (Days == null) {
				sb.append("<null>");
			} else {
				sb.append(Days);
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

			returnValue = checkNullsAndCompare(this.revenue_fact_sk, other.revenue_fact_sk);
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
		final static byte[] commonByteArrayLock_IMDB_fact_movie_revenue = new byte[0];
		static byte[] commonByteArray_IMDB_fact_movie_revenue = new byte[0];

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
			return 15;
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

		public String title;

		public String getTitle() {
			return this.title;
		}

		public Boolean titleIsNullable() {
			return true;
		}

		public Boolean titleIsKey() {
			return false;
		}

		public Integer titleLength() {
			return 50;
		}

		public Integer titlePrecision() {
			return 0;
		}

		public String titleDefault() {

			return null;

		}

		public String titleComment() {

			return "";

		}

		public String titlePattern() {

			return "";

		}

		public String titleOriginalDbColumnName() {

			return "title";

		}

		public java.util.Date Date;

		public java.util.Date getDate() {
			return this.Date;
		}

		public Boolean DateIsNullable() {
			return true;
		}

		public Boolean DateIsKey() {
			return false;
		}

		public Integer DateLength() {
			return 19;
		}

		public Integer DatePrecision() {
			return 0;
		}

		public String DateDefault() {

			return null;

		}

		public String DateComment() {

			return "";

		}

		public String DatePattern() {

			return "yyyy-MM-dd";

		}

		public String DateOriginalDbColumnName() {

			return "Date";

		}

		public String Rank;

		public String getRank() {
			return this.Rank;
		}

		public Boolean RankIsNullable() {
			return true;
		}

		public Boolean RankIsKey() {
			return false;
		}

		public Integer RankLength() {
			return 100;
		}

		public Integer RankPrecision() {
			return 0;
		}

		public String RankDefault() {

			return null;

		}

		public String RankComment() {

			return "";

		}

		public String RankPattern() {

			return "";

		}

		public String RankOriginalDbColumnName() {

			return "Rank";

		}

		public Integer Gross;

		public Integer getGross() {
			return this.Gross;
		}

		public Boolean GrossIsNullable() {
			return true;
		}

		public Boolean GrossIsKey() {
			return false;
		}

		public Integer GrossLength() {
			return 10;
		}

		public Integer GrossPrecision() {
			return 0;
		}

		public String GrossDefault() {

			return null;

		}

		public String GrossComment() {

			return "";

		}

		public String GrossPattern() {

			return "";

		}

		public String GrossOriginalDbColumnName() {

			return "Gross";

		}

		public Double _YD;

		public Double get_YD() {
			return this._YD;
		}

		public Boolean _YDIsNullable() {
			return true;
		}

		public Boolean _YDIsKey() {
			return false;
		}

		public Integer _YDLength() {
			return 100;
		}

		public Integer _YDPrecision() {
			return 2;
		}

		public String _YDDefault() {

			return null;

		}

		public String _YDComment() {

			return "";

		}

		public String _YDPattern() {

			return "";

		}

		public String _YDOriginalDbColumnName() {

			return "_YD";

		}

		public Double _LW;

		public Double get_LW() {
			return this._LW;
		}

		public Boolean _LWIsNullable() {
			return true;
		}

		public Boolean _LWIsKey() {
			return false;
		}

		public Integer _LWLength() {
			return 100;
		}

		public Integer _LWPrecision() {
			return 2;
		}

		public String _LWDefault() {

			return null;

		}

		public String _LWComment() {

			return "";

		}

		public String _LWPattern() {

			return "";

		}

		public String _LWOriginalDbColumnName() {

			return "_LW";

		}

		public Integer Theaters;

		public Integer getTheaters() {
			return this.Theaters;
		}

		public Boolean TheatersIsNullable() {
			return true;
		}

		public Boolean TheatersIsKey() {
			return false;
		}

		public Integer TheatersLength() {
			return 10;
		}

		public Integer TheatersPrecision() {
			return 0;
		}

		public String TheatersDefault() {

			return null;

		}

		public String TheatersComment() {

			return "";

		}

		public String TheatersPattern() {

			return "";

		}

		public String TheatersOriginalDbColumnName() {

			return "Theaters";

		}

		public Integer Per_Theater;

		public Integer getPer_Theater() {
			return this.Per_Theater;
		}

		public Boolean Per_TheaterIsNullable() {
			return true;
		}

		public Boolean Per_TheaterIsKey() {
			return false;
		}

		public Integer Per_TheaterLength() {
			return 10;
		}

		public Integer Per_TheaterPrecision() {
			return 0;
		}

		public String Per_TheaterDefault() {

			return null;

		}

		public String Per_TheaterComment() {

			return "";

		}

		public String Per_TheaterPattern() {

			return "";

		}

		public String Per_TheaterOriginalDbColumnName() {

			return "Per_Theater";

		}

		public Integer Total_Gross;

		public Integer getTotal_Gross() {
			return this.Total_Gross;
		}

		public Boolean Total_GrossIsNullable() {
			return true;
		}

		public Boolean Total_GrossIsKey() {
			return false;
		}

		public Integer Total_GrossLength() {
			return 10;
		}

		public Integer Total_GrossPrecision() {
			return 0;
		}

		public String Total_GrossDefault() {

			return null;

		}

		public String Total_GrossComment() {

			return "";

		}

		public String Total_GrossPattern() {

			return "";

		}

		public String Total_GrossOriginalDbColumnName() {

			return "Total_Gross";

		}

		public Integer Days;

		public Integer getDays() {
			return this.Days;
		}

		public Boolean DaysIsNullable() {
			return true;
		}

		public Boolean DaysIsKey() {
			return false;
		}

		public Integer DaysLength() {
			return 10;
		}

		public Integer DaysPrecision() {
			return 0;
		}

		public String DaysDefault() {

			return null;

		}

		public String DaysComment() {

			return "";

		}

		public String DaysPattern() {

			return "";

		}

		public String DaysOriginalDbColumnName() {

			return "Days";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this._YD = null;
					} else {
						this._YD = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this._LW = null;
					} else {
						this._LW = dis.readDouble();
					}

					this.Theaters = readInteger(dis);

					this.Per_Theater = readInteger(dis);

					this.Total_Gross = readInteger(dis);

					this.Days = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this._YD = null;
					} else {
						this._YD = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this._LW = null;
					} else {
						this._LW = dis.readDouble();
					}

					this.Theaters = readInteger(dis);

					this.Per_Theater = readInteger(dis);

					this.Total_Gross = readInteger(dis);

					this.Days = readInteger(dis);

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

				writeString(this.title, dos);

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Double

				if (this._YD == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._YD);
				}

				// Double

				if (this._LW == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._LW);
				}

				// Integer

				writeInteger(this.Theaters, dos);

				// Integer

				writeInteger(this.Per_Theater, dos);

				// Integer

				writeInteger(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Double

				if (this._YD == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._YD);
				}

				// Double

				if (this._LW == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._LW);
				}

				// Integer

				writeInteger(this.Theaters, dos);

				// Integer

				writeInteger(this.Per_Theater, dos);

				// Integer

				writeInteger(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",title=" + title);
			sb.append(",Date=" + String.valueOf(Date));
			sb.append(",Rank=" + Rank);
			sb.append(",Gross=" + String.valueOf(Gross));
			sb.append(",_YD=" + String.valueOf(_YD));
			sb.append(",_LW=" + String.valueOf(_LW));
			sb.append(",Theaters=" + String.valueOf(Theaters));
			sb.append(",Per_Theater=" + String.valueOf(Per_Theater));
			sb.append(",Total_Gross=" + String.valueOf(Total_Gross));
			sb.append(",Days=" + String.valueOf(Days));
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

			if (title == null) {
				sb.append("<null>");
			} else {
				sb.append(title);
			}

			sb.append("|");

			if (Date == null) {
				sb.append("<null>");
			} else {
				sb.append(Date);
			}

			sb.append("|");

			if (Rank == null) {
				sb.append("<null>");
			} else {
				sb.append(Rank);
			}

			sb.append("|");

			if (Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Gross);
			}

			sb.append("|");

			if (_YD == null) {
				sb.append("<null>");
			} else {
				sb.append(_YD);
			}

			sb.append("|");

			if (_LW == null) {
				sb.append("<null>");
			} else {
				sb.append(_LW);
			}

			sb.append("|");

			if (Theaters == null) {
				sb.append("<null>");
			} else {
				sb.append(Theaters);
			}

			sb.append("|");

			if (Per_Theater == null) {
				sb.append("<null>");
			} else {
				sb.append(Per_Theater);
			}

			sb.append("|");

			if (Total_Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Total_Gross);
			}

			sb.append("|");

			if (Days == null) {
				sb.append("<null>");
			} else {
				sb.append(Days);
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
		final static byte[] commonByteArrayLock_IMDB_fact_movie_revenue = new byte[0];
		static byte[] commonByteArray_IMDB_fact_movie_revenue = new byte[0];

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
			return 15;
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

		public String title;

		public String getTitle() {
			return this.title;
		}

		public Boolean titleIsNullable() {
			return true;
		}

		public Boolean titleIsKey() {
			return false;
		}

		public Integer titleLength() {
			return 50;
		}

		public Integer titlePrecision() {
			return 0;
		}

		public String titleDefault() {

			return null;

		}

		public String titleComment() {

			return "";

		}

		public String titlePattern() {

			return "";

		}

		public String titleOriginalDbColumnName() {

			return "title";

		}

		public java.util.Date Date;

		public java.util.Date getDate() {
			return this.Date;
		}

		public Boolean DateIsNullable() {
			return true;
		}

		public Boolean DateIsKey() {
			return false;
		}

		public Integer DateLength() {
			return 19;
		}

		public Integer DatePrecision() {
			return 0;
		}

		public String DateDefault() {

			return null;

		}

		public String DateComment() {

			return "";

		}

		public String DatePattern() {

			return "dd-MM-yyyy";

		}

		public String DateOriginalDbColumnName() {

			return "Date";

		}

		public String Rank;

		public String getRank() {
			return this.Rank;
		}

		public Boolean RankIsNullable() {
			return true;
		}

		public Boolean RankIsKey() {
			return false;
		}

		public Integer RankLength() {
			return 100;
		}

		public Integer RankPrecision() {
			return 0;
		}

		public String RankDefault() {

			return null;

		}

		public String RankComment() {

			return "";

		}

		public String RankPattern() {

			return "";

		}

		public String RankOriginalDbColumnName() {

			return "Rank";

		}

		public Integer Gross;

		public Integer getGross() {
			return this.Gross;
		}

		public Boolean GrossIsNullable() {
			return true;
		}

		public Boolean GrossIsKey() {
			return false;
		}

		public Integer GrossLength() {
			return 10;
		}

		public Integer GrossPrecision() {
			return 0;
		}

		public String GrossDefault() {

			return null;

		}

		public String GrossComment() {

			return "";

		}

		public String GrossPattern() {

			return "";

		}

		public String GrossOriginalDbColumnName() {

			return "Gross";

		}

		public Double _YD;

		public Double get_YD() {
			return this._YD;
		}

		public Boolean _YDIsNullable() {
			return true;
		}

		public Boolean _YDIsKey() {
			return false;
		}

		public Integer _YDLength() {
			return 100;
		}

		public Integer _YDPrecision() {
			return 2;
		}

		public String _YDDefault() {

			return null;

		}

		public String _YDComment() {

			return "";

		}

		public String _YDPattern() {

			return "";

		}

		public String _YDOriginalDbColumnName() {

			return "_YD";

		}

		public Double _LW;

		public Double get_LW() {
			return this._LW;
		}

		public Boolean _LWIsNullable() {
			return true;
		}

		public Boolean _LWIsKey() {
			return false;
		}

		public Integer _LWLength() {
			return 100;
		}

		public Integer _LWPrecision() {
			return 2;
		}

		public String _LWDefault() {

			return null;

		}

		public String _LWComment() {

			return "";

		}

		public String _LWPattern() {

			return "";

		}

		public String _LWOriginalDbColumnName() {

			return "_LW";

		}

		public Integer Theaters;

		public Integer getTheaters() {
			return this.Theaters;
		}

		public Boolean TheatersIsNullable() {
			return true;
		}

		public Boolean TheatersIsKey() {
			return false;
		}

		public Integer TheatersLength() {
			return 10;
		}

		public Integer TheatersPrecision() {
			return 0;
		}

		public String TheatersDefault() {

			return null;

		}

		public String TheatersComment() {

			return "";

		}

		public String TheatersPattern() {

			return "";

		}

		public String TheatersOriginalDbColumnName() {

			return "Theaters";

		}

		public Integer Per_Theater;

		public Integer getPer_Theater() {
			return this.Per_Theater;
		}

		public Boolean Per_TheaterIsNullable() {
			return true;
		}

		public Boolean Per_TheaterIsKey() {
			return false;
		}

		public Integer Per_TheaterLength() {
			return 10;
		}

		public Integer Per_TheaterPrecision() {
			return 0;
		}

		public String Per_TheaterDefault() {

			return null;

		}

		public String Per_TheaterComment() {

			return "";

		}

		public String Per_TheaterPattern() {

			return "";

		}

		public String Per_TheaterOriginalDbColumnName() {

			return "Per_Theater";

		}

		public Integer Total_Gross;

		public Integer getTotal_Gross() {
			return this.Total_Gross;
		}

		public Boolean Total_GrossIsNullable() {
			return true;
		}

		public Boolean Total_GrossIsKey() {
			return false;
		}

		public Integer Total_GrossLength() {
			return 10;
		}

		public Integer Total_GrossPrecision() {
			return 0;
		}

		public String Total_GrossDefault() {

			return null;

		}

		public String Total_GrossComment() {

			return "";

		}

		public String Total_GrossPattern() {

			return "";

		}

		public String Total_GrossOriginalDbColumnName() {

			return "Total_Gross";

		}

		public Integer Days;

		public Integer getDays() {
			return this.Days;
		}

		public Boolean DaysIsNullable() {
			return true;
		}

		public Boolean DaysIsKey() {
			return false;
		}

		public Integer DaysLength() {
			return 10;
		}

		public Integer DaysPrecision() {
			return 0;
		}

		public String DaysDefault() {

			return null;

		}

		public String DaysComment() {

			return "";

		}

		public String DaysPattern() {

			return "";

		}

		public String DaysOriginalDbColumnName() {

			return "Days";

		}

		public String DI_Filename;

		public String getDI_Filename() {
			return this.DI_Filename;
		}

		public Boolean DI_FilenameIsNullable() {
			return false;
		}

		public Boolean DI_FilenameIsKey() {
			return false;
		}

		public Integer DI_FilenameLength() {
			return 300;
		}

		public Integer DI_FilenamePrecision() {
			return 0;
		}

		public String DI_FilenameDefault() {

			return null;

		}

		public String DI_FilenameComment() {

			return "";

		}

		public String DI_FilenamePattern() {

			return "";

		}

		public String DI_FilenameOriginalDbColumnName() {

			return "DI_Filename";

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
			return 19;
		}

		public Integer DI_CreatedDatePrecision() {
			return 0;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this._YD = null;
					} else {
						this._YD = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this._LW = null;
					} else {
						this._LW = dis.readDouble();
					}

					this.Theaters = readInteger(dis);

					this.Per_Theater = readInteger(dis);

					this.Total_Gross = readInteger(dis);

					this.Days = readInteger(dis);

					this.DI_Filename = readString(dis);

					this.DI_CreatedDate = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this._YD = null;
					} else {
						this._YD = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this._LW = null;
					} else {
						this._LW = dis.readDouble();
					}

					this.Theaters = readInteger(dis);

					this.Per_Theater = readInteger(dis);

					this.Total_Gross = readInteger(dis);

					this.Days = readInteger(dis);

					this.DI_Filename = readString(dis);

					this.DI_CreatedDate = readDate(dis);

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

				writeString(this.title, dos);

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Double

				if (this._YD == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._YD);
				}

				// Double

				if (this._LW == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._LW);
				}

				// Integer

				writeInteger(this.Theaters, dos);

				// Integer

				writeInteger(this.Per_Theater, dos);

				// Integer

				writeInteger(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

				// String

				writeString(this.DI_Filename, dos);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Double

				if (this._YD == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._YD);
				}

				// Double

				if (this._LW == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._LW);
				}

				// Integer

				writeInteger(this.Theaters, dos);

				// Integer

				writeInteger(this.Per_Theater, dos);

				// Integer

				writeInteger(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

				// String

				writeString(this.DI_Filename, dos);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",title=" + title);
			sb.append(",Date=" + String.valueOf(Date));
			sb.append(",Rank=" + Rank);
			sb.append(",Gross=" + String.valueOf(Gross));
			sb.append(",_YD=" + String.valueOf(_YD));
			sb.append(",_LW=" + String.valueOf(_LW));
			sb.append(",Theaters=" + String.valueOf(Theaters));
			sb.append(",Per_Theater=" + String.valueOf(Per_Theater));
			sb.append(",Total_Gross=" + String.valueOf(Total_Gross));
			sb.append(",Days=" + String.valueOf(Days));
			sb.append(",DI_Filename=" + DI_Filename);
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
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

			if (title == null) {
				sb.append("<null>");
			} else {
				sb.append(title);
			}

			sb.append("|");

			if (Date == null) {
				sb.append("<null>");
			} else {
				sb.append(Date);
			}

			sb.append("|");

			if (Rank == null) {
				sb.append("<null>");
			} else {
				sb.append(Rank);
			}

			sb.append("|");

			if (Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Gross);
			}

			sb.append("|");

			if (_YD == null) {
				sb.append("<null>");
			} else {
				sb.append(_YD);
			}

			sb.append("|");

			if (_LW == null) {
				sb.append("<null>");
			} else {
				sb.append(_LW);
			}

			sb.append("|");

			if (Theaters == null) {
				sb.append("<null>");
			} else {
				sb.append(Theaters);
			}

			sb.append("|");

			if (Per_Theater == null) {
				sb.append("<null>");
			} else {
				sb.append(Per_Theater);
			}

			sb.append("|");

			if (Total_Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Total_Gross);
			}

			sb.append("|");

			if (Days == null) {
				sb.append("<null>");
			} else {
				sb.append(Days);
			}

			sb.append("|");

			if (DI_Filename == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_Filename);
			}

			sb.append("|");

			if (DI_CreatedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_CreatedDate);
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

	public static class after_tDBInput_3Struct implements routines.system.IPersistableRow<after_tDBInput_3Struct> {
		final static byte[] commonByteArrayLock_IMDB_fact_movie_revenue = new byte[0];
		static byte[] commonByteArray_IMDB_fact_movie_revenue = new byte[0];

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
			return 15;
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

		public String title;

		public String getTitle() {
			return this.title;
		}

		public Boolean titleIsNullable() {
			return true;
		}

		public Boolean titleIsKey() {
			return false;
		}

		public Integer titleLength() {
			return 50;
		}

		public Integer titlePrecision() {
			return 0;
		}

		public String titleDefault() {

			return null;

		}

		public String titleComment() {

			return "";

		}

		public String titlePattern() {

			return "";

		}

		public String titleOriginalDbColumnName() {

			return "title";

		}

		public java.util.Date Date;

		public java.util.Date getDate() {
			return this.Date;
		}

		public Boolean DateIsNullable() {
			return true;
		}

		public Boolean DateIsKey() {
			return false;
		}

		public Integer DateLength() {
			return 19;
		}

		public Integer DatePrecision() {
			return 0;
		}

		public String DateDefault() {

			return null;

		}

		public String DateComment() {

			return "";

		}

		public String DatePattern() {

			return "dd-MM-yyyy";

		}

		public String DateOriginalDbColumnName() {

			return "Date";

		}

		public String Rank;

		public String getRank() {
			return this.Rank;
		}

		public Boolean RankIsNullable() {
			return true;
		}

		public Boolean RankIsKey() {
			return false;
		}

		public Integer RankLength() {
			return 100;
		}

		public Integer RankPrecision() {
			return 0;
		}

		public String RankDefault() {

			return null;

		}

		public String RankComment() {

			return "";

		}

		public String RankPattern() {

			return "";

		}

		public String RankOriginalDbColumnName() {

			return "Rank";

		}

		public Integer Gross;

		public Integer getGross() {
			return this.Gross;
		}

		public Boolean GrossIsNullable() {
			return true;
		}

		public Boolean GrossIsKey() {
			return false;
		}

		public Integer GrossLength() {
			return 10;
		}

		public Integer GrossPrecision() {
			return 0;
		}

		public String GrossDefault() {

			return null;

		}

		public String GrossComment() {

			return "";

		}

		public String GrossPattern() {

			return "";

		}

		public String GrossOriginalDbColumnName() {

			return "Gross";

		}

		public Double _YD;

		public Double get_YD() {
			return this._YD;
		}

		public Boolean _YDIsNullable() {
			return true;
		}

		public Boolean _YDIsKey() {
			return false;
		}

		public Integer _YDLength() {
			return 100;
		}

		public Integer _YDPrecision() {
			return 2;
		}

		public String _YDDefault() {

			return null;

		}

		public String _YDComment() {

			return "";

		}

		public String _YDPattern() {

			return "";

		}

		public String _YDOriginalDbColumnName() {

			return "_YD";

		}

		public Double _LW;

		public Double get_LW() {
			return this._LW;
		}

		public Boolean _LWIsNullable() {
			return true;
		}

		public Boolean _LWIsKey() {
			return false;
		}

		public Integer _LWLength() {
			return 100;
		}

		public Integer _LWPrecision() {
			return 2;
		}

		public String _LWDefault() {

			return null;

		}

		public String _LWComment() {

			return "";

		}

		public String _LWPattern() {

			return "";

		}

		public String _LWOriginalDbColumnName() {

			return "_LW";

		}

		public Integer Theaters;

		public Integer getTheaters() {
			return this.Theaters;
		}

		public Boolean TheatersIsNullable() {
			return true;
		}

		public Boolean TheatersIsKey() {
			return false;
		}

		public Integer TheatersLength() {
			return 10;
		}

		public Integer TheatersPrecision() {
			return 0;
		}

		public String TheatersDefault() {

			return null;

		}

		public String TheatersComment() {

			return "";

		}

		public String TheatersPattern() {

			return "";

		}

		public String TheatersOriginalDbColumnName() {

			return "Theaters";

		}

		public Integer Per_Theater;

		public Integer getPer_Theater() {
			return this.Per_Theater;
		}

		public Boolean Per_TheaterIsNullable() {
			return true;
		}

		public Boolean Per_TheaterIsKey() {
			return false;
		}

		public Integer Per_TheaterLength() {
			return 10;
		}

		public Integer Per_TheaterPrecision() {
			return 0;
		}

		public String Per_TheaterDefault() {

			return null;

		}

		public String Per_TheaterComment() {

			return "";

		}

		public String Per_TheaterPattern() {

			return "";

		}

		public String Per_TheaterOriginalDbColumnName() {

			return "Per_Theater";

		}

		public Integer Total_Gross;

		public Integer getTotal_Gross() {
			return this.Total_Gross;
		}

		public Boolean Total_GrossIsNullable() {
			return true;
		}

		public Boolean Total_GrossIsKey() {
			return false;
		}

		public Integer Total_GrossLength() {
			return 10;
		}

		public Integer Total_GrossPrecision() {
			return 0;
		}

		public String Total_GrossDefault() {

			return null;

		}

		public String Total_GrossComment() {

			return "";

		}

		public String Total_GrossPattern() {

			return "";

		}

		public String Total_GrossOriginalDbColumnName() {

			return "Total_Gross";

		}

		public Integer Days;

		public Integer getDays() {
			return this.Days;
		}

		public Boolean DaysIsNullable() {
			return true;
		}

		public Boolean DaysIsKey() {
			return false;
		}

		public Integer DaysLength() {
			return 10;
		}

		public Integer DaysPrecision() {
			return 0;
		}

		public String DaysDefault() {

			return null;

		}

		public String DaysComment() {

			return "";

		}

		public String DaysPattern() {

			return "";

		}

		public String DaysOriginalDbColumnName() {

			return "Days";

		}

		public String DI_Filename;

		public String getDI_Filename() {
			return this.DI_Filename;
		}

		public Boolean DI_FilenameIsNullable() {
			return false;
		}

		public Boolean DI_FilenameIsKey() {
			return false;
		}

		public Integer DI_FilenameLength() {
			return 300;
		}

		public Integer DI_FilenamePrecision() {
			return 0;
		}

		public String DI_FilenameDefault() {

			return null;

		}

		public String DI_FilenameComment() {

			return "";

		}

		public String DI_FilenamePattern() {

			return "";

		}

		public String DI_FilenameOriginalDbColumnName() {

			return "DI_Filename";

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
			return 19;
		}

		public Integer DI_CreatedDatePrecision() {
			return 0;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_fact_movie_revenue.length) {
					if (length < 1024 && commonByteArray_IMDB_fact_movie_revenue.length == 0) {
						commonByteArray_IMDB_fact_movie_revenue = new byte[1024];
					} else {
						commonByteArray_IMDB_fact_movie_revenue = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_fact_movie_revenue, 0, length);
				strReturn = new String(commonByteArray_IMDB_fact_movie_revenue, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this._YD = null;
					} else {
						this._YD = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this._LW = null;
					} else {
						this._LW = dis.readDouble();
					}

					this.Theaters = readInteger(dis);

					this.Per_Theater = readInteger(dis);

					this.Total_Gross = readInteger(dis);

					this.Days = readInteger(dis);

					this.DI_Filename = readString(dis);

					this.DI_CreatedDate = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_fact_movie_revenue) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readDate(dis);

					this.Rank = readString(dis);

					this.Gross = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this._YD = null;
					} else {
						this._YD = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this._LW = null;
					} else {
						this._LW = dis.readDouble();
					}

					this.Theaters = readInteger(dis);

					this.Per_Theater = readInteger(dis);

					this.Total_Gross = readInteger(dis);

					this.Days = readInteger(dis);

					this.DI_Filename = readString(dis);

					this.DI_CreatedDate = readDate(dis);

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

				writeString(this.title, dos);

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Double

				if (this._YD == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._YD);
				}

				// Double

				if (this._LW == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._LW);
				}

				// Integer

				writeInteger(this.Theaters, dos);

				// Integer

				writeInteger(this.Per_Theater, dos);

				// Integer

				writeInteger(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

				// String

				writeString(this.DI_Filename, dos);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// Integer

				writeInteger(this.Gross, dos);

				// Double

				if (this._YD == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._YD);
				}

				// Double

				if (this._LW == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this._LW);
				}

				// Integer

				writeInteger(this.Theaters, dos);

				// Integer

				writeInteger(this.Per_Theater, dos);

				// Integer

				writeInteger(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

				// String

				writeString(this.DI_Filename, dos);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",title=" + title);
			sb.append(",Date=" + String.valueOf(Date));
			sb.append(",Rank=" + Rank);
			sb.append(",Gross=" + String.valueOf(Gross));
			sb.append(",_YD=" + String.valueOf(_YD));
			sb.append(",_LW=" + String.valueOf(_LW));
			sb.append(",Theaters=" + String.valueOf(Theaters));
			sb.append(",Per_Theater=" + String.valueOf(Per_Theater));
			sb.append(",Total_Gross=" + String.valueOf(Total_Gross));
			sb.append(",Days=" + String.valueOf(Days));
			sb.append(",DI_Filename=" + DI_Filename);
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
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

			if (title == null) {
				sb.append("<null>");
			} else {
				sb.append(title);
			}

			sb.append("|");

			if (Date == null) {
				sb.append("<null>");
			} else {
				sb.append(Date);
			}

			sb.append("|");

			if (Rank == null) {
				sb.append("<null>");
			} else {
				sb.append(Rank);
			}

			sb.append("|");

			if (Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Gross);
			}

			sb.append("|");

			if (_YD == null) {
				sb.append("<null>");
			} else {
				sb.append(_YD);
			}

			sb.append("|");

			if (_LW == null) {
				sb.append("<null>");
			} else {
				sb.append(_LW);
			}

			sb.append("|");

			if (Theaters == null) {
				sb.append("<null>");
			} else {
				sb.append(Theaters);
			}

			sb.append("|");

			if (Per_Theater == null) {
				sb.append("<null>");
			} else {
				sb.append(Per_Theater);
			}

			sb.append("|");

			if (Total_Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Total_Gross);
			}

			sb.append("|");

			if (Days == null) {
				sb.append("<null>");
			} else {
				sb.append(Days);
			}

			sb.append("|");

			if (DI_Filename == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_Filename);
			}

			sb.append("|");

			if (DI_CreatedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_CreatedDate);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_3Struct other) {

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
		org.slf4j.MDC.put("_subJobPid", "34Hgle_" + subJobPidCounter.getAndIncrement());

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

				tDBInput_1Process(globalMap);
				tDBInput_2Process(globalMap);

				row1Struct row1 = new row1Struct();
				out2Struct out2 = new out2Struct();
				out1Struct out1 = new out1Struct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out1");

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_UNIQUE_NAME" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_COLNAMES" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("USE_FIXED_LENGTH" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - " + (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
					talendJobLogProcess(globalMap);
				}

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_tLogRow_1 = null;

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out2");

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
				int count_out2_tMap_1 = 0;

				int count_row2_tMap_1 = 0;

				int count_row3_tMap_1 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					java.util.Date DI_CreatedDate;
					String DI_JobID;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_1 = 0;

				out1Struct out1_tmp = new out1Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

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
				int count_row1_tMap_2 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out2_tMap_2 = 0;

				out2Struct out2_tmp = new out2Struct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				cLabel = "\"movie_revenuefinal\"";

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
							log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"movie_revenuefinal\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERY" + " = "
									+ "\"SELECT    `movie_revenuefinal`.`tconst`,    `movie_revenuefinal`.`title`,    `movie_revenuefinal`.`Date`,    `movie_revenuefinal`.`Rank`,    `movie_revenuefinal`.`Gross`,    `movie_revenuefinal`.`_YD`,    `movie_revenuefinal`.`_LW`,    `movie_revenuefinal`.`Theaters`,    `movie_revenuefinal`.`Per_Theater`,    `movie_revenuefinal`.`Total_Gross`,    `movie_revenuefinal`.`Days`,    `movie_revenuefinal`.`DI_Filename`,    `movie_revenuefinal`.`DI_CreatedDate` FROM `movie_revenuefinal`\"");
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
									+ ("title") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Date") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("Rank") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Gross") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("_YD") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("_LW") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("Theaters") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Per_Theater") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Total_Gross") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Days") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("DI_Filename") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("DI_CreatedDate") + "}]");
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
					talendJobLog.addCM("tDBInput_3", "\"movie_revenuefinal\"", "tMysqlInput");
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

				String dbquery_tDBInput_3 = "SELECT \n  `movie_revenuefinal`.`tconst`, \n  `movie_revenuefinal`.`title`, \n  `movie_revenuefinal`.`Date`, \n  `movie_rev"
						+ "enuefinal`.`Rank`, \n  `movie_revenuefinal`.`Gross`, \n  `movie_revenuefinal`.`_YD`, \n  `movie_revenuefinal`.`_LW`, \n  `mo"
						+ "vie_revenuefinal`.`Theaters`, \n  `movie_revenuefinal`.`Per_Theater`, \n  `movie_revenuefinal`.`Total_Gross`, \n  `movie_re"
						+ "venuefinal`.`Days`, \n  `movie_revenuefinal`.`DI_Filename`, \n  `movie_revenuefinal`.`DI_CreatedDate`\nFROM `movie_revenuef"
						+ "inal`";

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
							row1.tconst = null;
						} else {

							row1.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row1.title = null;
						} else {

							row1.title = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row1.Date = null;
						} else {

							if (rs_tDBInput_3.getString(3) != null) {
								String dateString_tDBInput_3 = rs_tDBInput_3.getString(3);
								if (!("0000-00-00").equals(dateString_tDBInput_3)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_3)) {
									row1.Date = rs_tDBInput_3.getTimestamp(3);
								} else {
									row1.Date = (java.util.Date) year0_tDBInput_3.clone();
								}
							} else {
								row1.Date = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row1.Rank = null;
						} else {

							row1.Rank = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row1.Gross = null;
						} else {

							row1.Gross = rs_tDBInput_3.getInt(5);
							if (rs_tDBInput_3.wasNull()) {
								row1.Gross = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row1._YD = null;
						} else {

							row1._YD = rs_tDBInput_3.getDouble(6);
							if (rs_tDBInput_3.wasNull()) {
								row1._YD = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row1._LW = null;
						} else {

							row1._LW = rs_tDBInput_3.getDouble(7);
							if (rs_tDBInput_3.wasNull()) {
								row1._LW = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							row1.Theaters = null;
						} else {

							row1.Theaters = rs_tDBInput_3.getInt(8);
							if (rs_tDBInput_3.wasNull()) {
								row1.Theaters = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 9) {
							row1.Per_Theater = null;
						} else {

							row1.Per_Theater = rs_tDBInput_3.getInt(9);
							if (rs_tDBInput_3.wasNull()) {
								row1.Per_Theater = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 10) {
							row1.Total_Gross = null;
						} else {

							row1.Total_Gross = rs_tDBInput_3.getInt(10);
							if (rs_tDBInput_3.wasNull()) {
								row1.Total_Gross = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 11) {
							row1.Days = null;
						} else {

							row1.Days = rs_tDBInput_3.getInt(11);
							if (rs_tDBInput_3.wasNull()) {
								row1.Days = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 12) {
							row1.DI_Filename = null;
						} else {

							row1.DI_Filename = routines.system.JDBCUtil.getString(rs_tDBInput_3, 12, false);
						}
						if (colQtyInRs_tDBInput_3 < 13) {
							row1.DI_CreatedDate = null;
						} else {

							if (rs_tDBInput_3.getString(13) != null) {
								String dateString_tDBInput_3 = rs_tDBInput_3.getString(13);
								if (!("0000-00-00").equals(dateString_tDBInput_3)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_3)) {
									row1.DI_CreatedDate = rs_tDBInput_3.getTimestamp(13);
								} else {
									row1.DI_CreatedDate = (java.util.Date) year0_tDBInput_3.clone();
								}
							} else {
								row1.DI_CreatedDate = null;
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

						cLabel = "\"movie_revenuefinal\"";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"movie_revenuefinal\"";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tMap_2 main ] start
						 */

						currentComponent = "tMap_2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tDBInput_3", "\"movie_revenuefinal\"", "tMysqlInput", "tMap_2", "tMap_2",
								"tMap"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
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

							out2 = null;

// # Output table : 'out2'
							count_out2_tMap_2++;

							out2_tmp.tconst = row1.tconst;
							out2_tmp.title = row1.title;
							out2_tmp.Date = row1.Date;
							out2_tmp.Rank = row1.Rank;
							out2_tmp.Gross = row1.Gross;
							out2_tmp._YD = row1._YD;
							out2_tmp._LW = row1._LW;
							out2_tmp.Theaters = row1.Theaters;
							out2_tmp.Per_Theater = row1.Per_Theater;
							out2_tmp.Total_Gross = row1.Total_Gross;
							out2_tmp.Days = row1.Days;
							out2 = out2_tmp;
							log.debug("tMap_2 - Outputting the record " + count_out2_tMap_2
									+ " of the output table 'out2'.");

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
// Start of branch "out2"
						if (out2 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out2", "tMap_2", "tMap_2", "tMap", "tMap_1", "tMap_1", "tMap"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out2 - " + (out2 == null ? "" : out2.toLogString()));
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2Struct row2 = null;

							row3Struct row3 = null;

							// ###############################
							// # Input tables (lookups)

							boolean rejectedInnerJoin_tMap_1 = false;
							boolean mainRowRejected_tMap_1 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row2"
							///////////////////////////////////////////////

							boolean forceLooprow2 = false;

							row2Struct row2ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_1 = false;

								row2HashKey.date = out2.Date == null ? null : new java.util.Date((out2.Date).getTime());

								row2HashKey.hashCodeDirty = true;

								tHash_Lookup_row2.lookup(row2HashKey);

								if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_1 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
								// and it contains more one result from keys : row2.date = '" + row2HashKey.date
								// + "'");
							} // G 071

							row2Struct fromLookup_row2 = null;
							row2 = row2Default;

							if (tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) { // G 099

								fromLookup_row2 = tHash_Lookup_row2.next();

							} // G 099

							if (fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}

							///////////////////////////////////////////////
							// Starting Lookup Table "row3"
							///////////////////////////////////////////////

							boolean forceLooprow3 = false;

							row3Struct row3ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_1 = false;

								row3HashKey.primaryTitle = out2.title;

								row3HashKey.hashCodeDirty = true;

								tHash_Lookup_row3.lookup(row3HashKey);

								if (!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_1 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
								// and it contains more one result from keys : row3.primaryTitle = '" +
								// row3HashKey.primaryTitle + "'");
							} // G 071

							row3Struct fromLookup_row3 = null;
							row3 = row3Default;

							if (tHash_Lookup_row3 != null && tHash_Lookup_row3.hasNext()) { // G 099

								fromLookup_row3 = tHash_Lookup_row3.next();

							} // G 099

							if (fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_1__Struct Var = Var__tMap_1;
								Var.DI_CreatedDate = TalendDate.getCurrentDate();
								Var.DI_JobID = pid;// ###############################
								// ###############################
								// # Output tables

								out1 = null;

								if (!rejectedInnerJoin_tMap_1) {

// # Output table : 'out1'
									count_out1_tMap_1++;

									out1_tmp.revenue_fact_sk = Numeric.sequence("s121", 1, 1);
									out1_tmp.movie_sk = row3.movie_sk;
									out1_tmp.tconst = out2.tconst;
									out1_tmp.date = out2.Date;
									out1_tmp.Rank = out2.Rank;
									out1_tmp.Gross = out2.Gross;
									out1_tmp.Days = out2.Days;
									out1_tmp.DI_CreatedDate = Var.DI_CreatedDate;
									out1_tmp.DI_JobID = Var.DI_JobID;
									out1 = out1_tmp;
									log.debug("tMap_1 - Outputting the record " + count_out1_tMap_1
											+ " of the output table 'out1'.");

								} // closing inner join bracket (2)
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
								 * [tLogRow_1 main ] start
								 */

								currentComponent = "tLogRow_1";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "out1", "tMap_1", "tMap_1", "tMap", "tLogRow_1", "tLogRow_1", "tLogRow"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("out1 - " + (out1 == null ? "" : out1.toLogString()));
								}

///////////////////////		

								strBuffer_tLogRow_1 = new StringBuilder();

								strBuffer_tLogRow_1.append(String.valueOf(out1.revenue_fact_sk));

								strBuffer_tLogRow_1.append("|");

								strBuffer_tLogRow_1.append(String.valueOf(out1.movie_sk));

								strBuffer_tLogRow_1.append("|");

								if (out1.tconst != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(out1.tconst));

								} //

								strBuffer_tLogRow_1.append("|");

								if (out1.date != null) { //

									strBuffer_tLogRow_1.append(FormatterUtils.format_Date(out1.date, "dd-MM-yyyy"));

								} //

								strBuffer_tLogRow_1.append("|");

								if (out1.Rank != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(out1.Rank));

								} //

								strBuffer_tLogRow_1.append("|");

								if (out1.Gross != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(out1.Gross));

								} //

								strBuffer_tLogRow_1.append("|");

								if (out1.Days != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(out1.Days));

								} //

								strBuffer_tLogRow_1.append("|");

								if (out1.DI_CreatedDate != null) { //

									strBuffer_tLogRow_1
											.append(FormatterUtils.format_Date(out1.DI_CreatedDate, "dd-MM-yyyy"));

								} //

								strBuffer_tLogRow_1.append("|");

								if (out1.DI_JobID != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(out1.DI_JobID));

								} //

								if (globalMap.get("tLogRow_CONSOLE") != null) {
									consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
								} else {
									consoleOut_tLogRow_1 = new java.io.PrintStream(
											new java.io.BufferedOutputStream(System.out));
									globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
								}
								log.info("tLogRow_1 - Content of row " + (nb_line_tLogRow_1 + 1) + ": "
										+ strBuffer_tLogRow_1.toString());
								consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
								consoleOut_tLogRow_1.flush();
								nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

								tos_count_tLogRow_1++;

								/**
								 * [tLogRow_1 main ] stop
								 */

								/**
								 * [tLogRow_1 process_data_begin ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_begin ] stop
								 */

								/**
								 * [tLogRow_1 process_data_end ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_end ] stop
								 */

							} // End of branch "out1"

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "out2"

						/**
						 * [tMap_2 process_data_end ] start
						 */

						currentComponent = "tMap_2";

						/**
						 * [tMap_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"movie_revenuefinal\"";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"movie_revenuefinal\"";

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
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'out2': " + count_out2_tMap_2 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tDBInput_3", "\"movie_revenuefinal\"", "tMysqlInput", "tMap_2", "tMap_2", "tMap", "output")) {
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
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				if (tHash_Lookup_row3 != null) {
					tHash_Lookup_row3.endGet();
				}
				globalMap.remove("tHash_Lookup_row3");

// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out2", 2, 0, "tMap_2",
						"tMap_2", "tMap", "tMap_1", "tMap_1", "tMap", "output")) {
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
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ") + (nb_line_tLogRow_1) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out1", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tLogRow_1", "tLogRow_1", "tLogRow", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
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

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row3");

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				cLabel = "\"movie_revenuefinal\"";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
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

	public void tDBOutput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBOutput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBOutput_2");
		org.slf4j.MDC.put("_subJobPid", "swvviJ_" + subJobPidCounter.getAndIncrement());

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
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				cLabel = "imdb_db";

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
							log4jParamters_tDBOutput_2.append("HOST" + " = " + "context.imdb_db_Server");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PORT" + " = " + "context.imdb_db_Port");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DBNAME" + " = " + "context.imdb_db_Database");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USER" + " = " + "context.imdb_db_Login");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.imdb_db_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"fact_movie_revenue\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("PROPERTIES" + " = " + "context.imdb_db_AdditionalParams");
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
					talendJobLog.addCM("tDBOutput_2", "imdb_db", "tMysqlOutput");
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

				String tableName_tDBOutput_2 = "fact_movie_revenue";
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
				calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				long date_tDBOutput_2;

				java.sql.Connection conn_tDBOutput_2 = null;

				String properties_tDBOutput_2 = context.imdb_db_AdditionalParams;
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

				String url_tDBOutput_2 = "jdbc:mysql://" + context.imdb_db_Server + ":" + context.imdb_db_Port + "/"
						+ context.imdb_db_Database + "?" + properties_tDBOutput_2;

				String driverClass_tDBOutput_2 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_2) + ("."));
				String dbUser_tDBOutput_2 = context.imdb_db_Login;

				final String decryptedPassword_tDBOutput_2 = context.imdb_db_Password;

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
				java.sql.ResultSet rsTable_tDBOutput_2 = dbMetaData_tDBOutput_2.getTables(context.imdb_db_Database,
						null, null, new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_2 = false;
				while (rsTable_tDBOutput_2.next()) {
					String table_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_NAME");
					if (table_tDBOutput_2.equalsIgnoreCase("fact_movie_revenue")) {
						whetherExist_tDBOutput_2 = true;
						break;
					}
				}
				if (!whetherExist_tDBOutput_2) {
					try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_2 - " + ("Creating") + (" table '") + (tableName_tDBOutput_2) + ("'."));
						stmtCreate_tDBOutput_2.execute("CREATE TABLE `" + tableName_tDBOutput_2
								+ "`(`revenue_fact_sk` INT(0)   not null ,`movie_sk` INT(10)   not null ,`tconst` VARCHAR(10)   not null ,`date` DATE ,`Rank` VARCHAR(100)  ,`Gross` INT(10)  ,`Days` INT(10)  ,`DI_CreatedDate` DATETIME  not null ,`DI_JobID` VARCHAR(10)   not null ,primary key(`revenue_fact_sk`))");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("Create") + (" table '") + (tableName_tDBOutput_2)
									+ ("' has succeeded."));
					}
				}

				String insert_tDBOutput_2 = "INSERT INTO `" + "fact_movie_revenue"
						+ "` (`revenue_fact_sk`,`movie_sk`,`tconst`,`date`,`Rank`,`Gross`,`Days`,`DI_CreatedDate`,`DI_JobID`) VALUES (?,?,?,?,?,?,?,?,?)";

				int batchSize_tDBOutput_2 = 100;
				int batchSizeCounter_tDBOutput_2 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tDBOutput_2 main ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "imdb_db";

				tos_count_tDBOutput_2++;

				/**
				 * [tDBOutput_2 main ] stop
				 */

				/**
				 * [tDBOutput_2 process_data_begin ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "imdb_db";

				/**
				 * [tDBOutput_2 process_data_begin ] stop
				 */

				/**
				 * [tDBOutput_2 process_data_end ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "imdb_db";

				/**
				 * [tDBOutput_2 process_data_end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "imdb_db";

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
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "imdb_db";

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

		globalMap.put("tDBOutput_2_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "v224Ke_" + subJobPidCounter.getAndIncrement());

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
		final fact_movie_revenue fact_movie_revenueClass = new fact_movie_revenue();

		int exitCode = fact_movie_revenueClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'fact_movie_revenue' - Done.");
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
		log.info("TalendJob: 'fact_movie_revenue' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_Fv0tsJGgEe6-v-KvacN3eg");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-04T04:23:24.229958900Z");

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
			java.io.InputStream inContext = fact_movie_revenue.class.getClassLoader()
					.getResourceAsStream("imdb/fact_movie_revenue_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = fact_movie_revenue.class.getClassLoader()
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
					context.setContextType("imdb_db_Port", "id_String");
					if (context.getStringValue("imdb_db_Port") == null) {
						context.imdb_db_Port = null;
					} else {
						context.imdb_db_Port = (String) context.getProperty("imdb_db_Port");
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
			if (parentContextMap.containsKey("imdb_db_Port")) {
				context.imdb_db_Port = (String) parentContextMap.get("imdb_db_Port");
			}
			if (parentContextMap.containsKey("imdb_db_Login")) {
				context.imdb_db_Login = (String) parentContextMap.get("imdb_db_Login");
			}
			if (parentContextMap.containsKey("imdb_db_AdditionalParams")) {
				context.imdb_db_AdditionalParams = (String) parentContextMap.get("imdb_db_AdditionalParams");
			}
			if (parentContextMap.containsKey("imdb_db_Database")) {
				context.imdb_db_Database = (String) parentContextMap.get("imdb_db_Database");
			}
			if (parentContextMap.containsKey("imdb_db_Server")) {
				context.imdb_db_Server = (String) parentContextMap.get("imdb_db_Server");
			}
			if (parentContextMap.containsKey("imdb_db_Password")) {
				context.imdb_db_Password = (java.lang.String) parentContextMap.get("imdb_db_Password");
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
		parametersToEncrypt.add("imdb_db_Password");
		parametersToEncrypt.add("mysql_imdb_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'fact_movie_revenue' - Started.");
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
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : fact_movie_revenue");
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
		log.info("TalendJob: 'fact_movie_revenue' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 279038 characters generated by Talend Cloud Data Fabric on the 3 December
 * 2023 at 11:23:24 PM GMT-05:00
 ************************************************************************************************/