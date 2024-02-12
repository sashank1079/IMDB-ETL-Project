
package imdb.region_dim_0_1;

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
 * Job: region_dim Purpose: <br>
 * Description: <br>
 * 
 * @author machiraju.s@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class region_dim implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "region_dim.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(region_dim.class);

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
	private final String jobName = "region_dim";
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
			"_fRcScJJ_Ee6_WIiIWRIzPA", "0.1");
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
					region_dim.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(region_dim.this, new Object[] { e, currentComponent, globalMap });
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

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
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
		final static byte[] commonByteArrayLock_IMDB_region_dim = new byte[0];
		static byte[] commonByteArray_IMDB_region_dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer region_sk;

		public Integer getRegion_sk() {
			return this.region_sk;
		}

		public Boolean region_skIsNullable() {
			return true;
		}

		public Boolean region_skIsKey() {
			return true;
		}

		public Integer region_skLength() {
			return 10;
		}

		public Integer region_skPrecision() {
			return null;
		}

		public String region_skDefault() {

			return null;

		}

		public String region_skComment() {

			return "";

		}

		public String region_skPattern() {

			return "";

		}

		public String region_skOriginalDbColumnName() {

			return "region_sk";

		}

		public String name;

		public String getName() {
			return this.name;
		}

		public Boolean nameIsNullable() {
			return true;
		}

		public Boolean nameIsKey() {
			return false;
		}

		public Integer nameLength() {
			return 100;
		}

		public Integer namePrecision() {
			return 0;
		}

		public String nameDefault() {

			return null;

		}

		public String nameComment() {

			return "";

		}

		public String namePattern() {

			return "dd-MM-yyyy";

		}

		public String nameOriginalDbColumnName() {

			return "name";

		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public Boolean regionIsNullable() {
			return true;
		}

		public Boolean regionIsKey() {
			return false;
		}

		public Integer regionLength() {
			return 255;
		}

		public Integer regionPrecision() {
			return 0;
		}

		public String regionDefault() {

			return null;

		}

		public String regionComment() {

			return "";

		}

		public String regionPattern() {

			return "";

		}

		public String regionOriginalDbColumnName() {

			return "region";

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
			return 12;
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
			return 12;
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

				result = prime * result + ((this.region_sk == null) ? 0 : this.region_sk.hashCode());

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

			if (this.region_sk == null) {
				if (other.region_sk != null)
					return false;

			} else if (!this.region_sk.equals(other.region_sk))

				return false;

			return true;
		}

		public void copyDataTo(out1Struct other) {

			other.region_sk = this.region_sk;
			other.name = this.name;
			other.region = this.region;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_JobID = this.DI_JobID;

		}

		public void copyKeysDataTo(out1Struct other) {

			other.region_sk = this.region_sk;

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
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.region_sk = readInteger(dis);

					this.name = readString(dis);

					this.region = readString(dis);

					this.DI_CreatedDate = readDate(dis);

					this.DI_JobID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.region_sk = readInteger(dis);

					this.name = readString(dis);

					this.region = readString(dis);

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

				writeInteger(this.region_sk, dos);

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

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

				writeInteger(this.region_sk, dos);

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

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
			sb.append("region_sk=" + String.valueOf(region_sk));
			sb.append(",name=" + name);
			sb.append(",region=" + region);
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_JobID=" + DI_JobID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (region_sk == null) {
				sb.append("<null>");
			} else {
				sb.append(region_sk);
			}

			sb.append("|");

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			if (region == null) {
				sb.append("<null>");
			} else {
				sb.append(region);
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

			returnValue = checkNullsAndCompare(this.region_sk, other.region_sk);
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
		final static byte[] commonByteArrayLock_IMDB_region_dim = new byte[0];
		static byte[] commonByteArray_IMDB_region_dim = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public Boolean nameIsNullable() {
			return true;
		}

		public Boolean nameIsKey() {
			return false;
		}

		public Integer nameLength() {
			return 32;
		}

		public Integer namePrecision() {
			return 0;
		}

		public String nameDefault() {

			return null;

		}

		public String nameComment() {

			return "";

		}

		public String namePattern() {

			return "dd-MM-yyyy";

		}

		public String nameOriginalDbColumnName() {

			return "name";

		}

		public String alpha_2;

		public String getAlpha_2() {
			return this.alpha_2;
		}

		public Boolean alpha_2IsNullable() {
			return true;
		}

		public Boolean alpha_2IsKey() {
			return false;
		}

		public Integer alpha_2Length() {
			return 25;
		}

		public Integer alpha_2Precision() {
			return 0;
		}

		public String alpha_2Default() {

			return null;

		}

		public String alpha_2Comment() {

			return "";

		}

		public String alpha_2Pattern() {

			return "dd-MM-yyyy";

		}

		public String alpha_2OriginalDbColumnName() {

			return "alpha_2";

		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public Boolean regionIsNullable() {
			return true;
		}

		public Boolean regionIsKey() {
			return false;
		}

		public Integer regionLength() {
			return 13;
		}

		public Integer regionPrecision() {
			return 0;
		}

		public String regionDefault() {

			return null;

		}

		public String regionComment() {

			return "";

		}

		public String regionPattern() {

			return "dd-MM-yyyy";

		}

		public String regionOriginalDbColumnName() {

			return "region";

		}

		public String sub_region;

		public String getSub_region() {
			return this.sub_region;
		}

		public Boolean sub_regionIsNullable() {
			return true;
		}

		public Boolean sub_regionIsKey() {
			return false;
		}

		public Integer sub_regionLength() {
			return 31;
		}

		public Integer sub_regionPrecision() {
			return 0;
		}

		public String sub_regionDefault() {

			return null;

		}

		public String sub_regionComment() {

			return "";

		}

		public String sub_regionPattern() {

			return "dd-MM-yyyy";

		}

		public String sub_regionOriginalDbColumnName() {

			return "sub_region";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.alpha_2 = readString(dis);

					this.region = readString(dis);

					this.sub_region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.alpha_2 = readString(dis);

					this.region = readString(dis);

					this.sub_region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.alpha_2, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.sub_region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.alpha_2, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.sub_region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",alpha_2=" + alpha_2);
			sb.append(",region=" + region);
			sb.append(",sub_region=" + sub_region);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			if (alpha_2 == null) {
				sb.append("<null>");
			} else {
				sb.append(alpha_2);
			}

			sb.append("|");

			if (region == null) {
				sb.append("<null>");
			} else {
				sb.append(region);
			}

			sb.append("|");

			if (sub_region == null) {
				sb.append("<null>");
			} else {
				sb.append(sub_region);
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

	public static class after_tFileInputDelimited_1Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_1Struct> {
		final static byte[] commonByteArrayLock_IMDB_region_dim = new byte[0];
		static byte[] commonByteArray_IMDB_region_dim = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public Boolean nameIsNullable() {
			return true;
		}

		public Boolean nameIsKey() {
			return false;
		}

		public Integer nameLength() {
			return 32;
		}

		public Integer namePrecision() {
			return 0;
		}

		public String nameDefault() {

			return null;

		}

		public String nameComment() {

			return "";

		}

		public String namePattern() {

			return "dd-MM-yyyy";

		}

		public String nameOriginalDbColumnName() {

			return "name";

		}

		public String alpha_2;

		public String getAlpha_2() {
			return this.alpha_2;
		}

		public Boolean alpha_2IsNullable() {
			return true;
		}

		public Boolean alpha_2IsKey() {
			return false;
		}

		public Integer alpha_2Length() {
			return 25;
		}

		public Integer alpha_2Precision() {
			return 0;
		}

		public String alpha_2Default() {

			return null;

		}

		public String alpha_2Comment() {

			return "";

		}

		public String alpha_2Pattern() {

			return "dd-MM-yyyy";

		}

		public String alpha_2OriginalDbColumnName() {

			return "alpha_2";

		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public Boolean regionIsNullable() {
			return true;
		}

		public Boolean regionIsKey() {
			return false;
		}

		public Integer regionLength() {
			return 13;
		}

		public Integer regionPrecision() {
			return 0;
		}

		public String regionDefault() {

			return null;

		}

		public String regionComment() {

			return "";

		}

		public String regionPattern() {

			return "dd-MM-yyyy";

		}

		public String regionOriginalDbColumnName() {

			return "region";

		}

		public String sub_region;

		public String getSub_region() {
			return this.sub_region;
		}

		public Boolean sub_regionIsNullable() {
			return true;
		}

		public Boolean sub_regionIsKey() {
			return false;
		}

		public Integer sub_regionLength() {
			return 31;
		}

		public Integer sub_regionPrecision() {
			return 0;
		}

		public String sub_regionDefault() {

			return null;

		}

		public String sub_regionComment() {

			return "";

		}

		public String sub_regionPattern() {

			return "dd-MM-yyyy";

		}

		public String sub_regionOriginalDbColumnName() {

			return "sub_region";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.alpha_2 = readString(dis);

					this.region = readString(dis);

					this.sub_region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.alpha_2 = readString(dis);

					this.region = readString(dis);

					this.sub_region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.alpha_2, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.sub_region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.alpha_2, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.sub_region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",alpha_2=" + alpha_2);
			sb.append(",region=" + region);
			sb.append(",sub_region=" + sub_region);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			if (alpha_2 == null) {
				sb.append("<null>");
			} else {
				sb.append(alpha_2);
			}

			sb.append("|");

			if (region == null) {
				sb.append("<null>");
			} else {
				sb.append(region);
			}

			sb.append("|");

			if (sub_region == null) {
				sb.append("<null>");
			} else {
				sb.append(sub_region);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_1Struct other) {

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

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileInputDelimited_1");
		org.slf4j.MDC.put("_subJobPid", "veJskW_" + subJobPidCounter.getAndIncrement());

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

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();

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
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"region_dim\"");
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

				String tableName_tDBOutput_1 = "region_dim";
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
					if (table_tDBOutput_1.equalsIgnoreCase("region_dim")) {
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
							+ "`(`region_sk` INT(10)  ,`name` VARCHAR(100)  ,`region` VARCHAR(255)  ,`DI_CreatedDate` DATETIME  not null ,`DI_JobID` VARCHAR(12)   not null ,primary key(`region_sk`))");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Create") + (" table '") + (tableName_tDBOutput_1)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_1 = "INSERT INTO `" + "region_dim"
						+ "` (`region_sk`,`name`,`region`,`DI_CreatedDate`,`DI_JobID`) VALUES (?,?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
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

				int count_row2_tMap_1 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();
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
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				cLabel = "csv_geocodes";

				int tos_count_tFileInputDelimited_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileInputDelimited_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileInputDelimited_1 = new StringBuilder();
							log4jParamters_tFileInputDelimited_1.append("Parameters:");
							log4jParamters_tFileInputDelimited_1.append("USE_EXISTING_DYNAMIC" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("FILENAME" + " = " + "\"C:/Users/Sashank Machiraju/Downloads/all.csv\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CSV_OPTION" + " = " + "true");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CSVROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("FIELDSEPARATOR" + " = " + "\",\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("ESCAPE_CHAR" + " = " + "\"\\\"\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("TEXT_ENCLOSURE" + " = " + "\"\"\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("HEADER" + " = " + "1");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("FOOTER" + " = " + "0");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("LIMIT" + " = " + "");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("REMOVE_EMPTY_ROW" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("UNCOMPRESS" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("ADVANCED_SEPARATOR" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("TRIMALL" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("TRIMSELECT" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("name") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("alpha_2") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("region")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("sub_region") + "}]");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CHECK_FIELDS_NUM" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CHECK_DATE" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("ENCODING" + " = " + "\"UTF-8\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("ENABLE_DECODE" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("USE_HEADER_AS_IS" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileInputDelimited_1 - " + (log4jParamters_tFileInputDelimited_1));
						}
					}
					new BytesLimit65535_tFileInputDelimited_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFileInputDelimited_1", "csv_geocodes", "tFileInputDelimited");
					talendJobLogProcess(globalMap);
				}

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				int footer_tFileInputDelimited_1 = 0;
				int totalLinetFileInputDelimited_1 = 0;
				int limittFileInputDelimited_1 = -1;
				int lastLinetFileInputDelimited_1 = -1;

				char fieldSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_1 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_1 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_1 = /** Start field tFileInputDelimited_1:FILENAME */
						"C:/Users/Sashank Machiraju/Downloads/all.csv"/** End field tFileInputDelimited_1:FILENAME */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_1 = null;

				try {

					String[] rowtFileInputDelimited_1 = null;
					int currentLinetFileInputDelimited_1 = 0;
					int outputLinetFileInputDelimited_1 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_1 = 0;
							if (footer_value_tFileInputDelimited_1 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_1,
									fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
						} else {
							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_1),
									fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
						}

						csvReadertFileInputDelimited_1.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
							csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

						csvReadertFileInputDelimited_1.setQuoteChar('"');

						// ?????doesn't work for other escapeChar
						// the default escape mode is double escape
						csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						if (footer_tFileInputDelimited_1 > 0) {
							for (totalLinetFileInputDelimited_1 = 0; totalLinetFileInputDelimited_1 < 1; totalLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
							csvReadertFileInputDelimited_1.setSkipEmptyRecords(false);
							while (csvReadertFileInputDelimited_1.readNext()) {

								totalLinetFileInputDelimited_1++;

							}
							int lastLineTemptFileInputDelimited_1 = totalLinetFileInputDelimited_1
									- footer_tFileInputDelimited_1 < 0 ? 0
											: totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1;
							if (lastLinetFileInputDelimited_1 > 0) {
								lastLinetFileInputDelimited_1 = lastLinetFileInputDelimited_1 < lastLineTemptFileInputDelimited_1
										? lastLinetFileInputDelimited_1
										: lastLineTemptFileInputDelimited_1;
							} else {
								lastLinetFileInputDelimited_1 = lastLineTemptFileInputDelimited_1;
							}

							csvReadertFileInputDelimited_1.close();
							if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_1,
										fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
							} else {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_1),
										fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
							}
							csvReadertFileInputDelimited_1.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
								csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

							csvReadertFileInputDelimited_1.setQuoteChar('"');

							// ?????doesn't work for other escapeChar
							// the default escape mode is double escape
							csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						}

						if (limittFileInputDelimited_1 != 0) {
							for (currentLinetFileInputDelimited_1 = 0; currentLinetFileInputDelimited_1 < 1; currentLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
						}
						csvReadertFileInputDelimited_1.setSkipEmptyRecords(false);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						log.error("tFileInputDelimited_1 - " + e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");

					while (limittFileInputDelimited_1 != 0 && csvReadertFileInputDelimited_1 != null
							&& csvReadertFileInputDelimited_1.readNext()) {
						rowstate_tFileInputDelimited_1.reset();

						rowtFileInputDelimited_1 = csvReadertFileInputDelimited_1.getValues();

						currentLinetFileInputDelimited_1++;

						if (lastLinetFileInputDelimited_1 > -1
								&& currentLinetFileInputDelimited_1 > lastLinetFileInputDelimited_1) {
							break;
						}
						outputLinetFileInputDelimited_1++;
						if (limittFileInputDelimited_1 > 0
								&& outputLinetFileInputDelimited_1 > limittFileInputDelimited_1) {
							break;
						}

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							char fieldSeparator_tFileInputDelimited_1_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_1_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row1.name = null;

								row1.alpha_2 = null;

								row1.region = null;

								row1.sub_region = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_1 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_1 = 0;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.name = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.name = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 1;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.alpha_2 = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.alpha_2 = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 2;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.region = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.region = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 3;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.sub_region = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.sub_region = null;

								}

							}

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							log.error("tFileInputDelimited_1 - " + e.getMessage());

							System.err.println(e.getMessage());
							row1 = null;

							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						}

						log.debug("tFileInputDelimited_1 - Retrieving the record " + (nb_line_tFileInputDelimited_1 + 1)
								+ ".");

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "csv_geocodes";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "csv_geocodes";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "row1", "tFileInputDelimited_1", "csv_geocodes", "tFileInputDelimited", "tMap_1",
									"tMap_1", "tMap"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2Struct row2 = null;

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

								row2HashKey.region = row1.alpha_2;

								row2HashKey.hashCodeDirty = true;

								tHash_Lookup_row2.lookup(row2HashKey);

								if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_1 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
								// and it contains more one result from keys : row2.region = '" +
								// row2HashKey.region + "'");
							} // G 071

							row2Struct fromLookup_row2 = null;
							row2 = row2Default;

							if (tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) { // G 099

								fromLookup_row2 = tHash_Lookup_row2.next();

							} // G 099

							if (fromLookup_row2 != null) {
								row2 = fromLookup_row2;
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

									out1_tmp.region_sk = Numeric.sequence("s10", 1, 1);
									out1_tmp.name = row1.name;
									out1_tmp.region = row2.region;
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
								 * [tDBOutput_1 main ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "imdb_db";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "out1", "tMap_1", "tMap_1", "tMap", "tDBOutput_1", "imdb_db", "tMysqlOutput"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("out1 - " + (out1 == null ? "" : out1.toLogString()));
								}

								whetherReject_tDBOutput_1 = false;
								if (out1.region_sk == null) {
									pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
								} else {
									pstmt_tDBOutput_1.setInt(1, out1.region_sk);
								}

								if (out1.name == null) {
									pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(2, out1.name);
								}

								if (out1.region == null) {
									pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(3, out1.region);
								}

								if (out1.DI_CreatedDate != null) {
									date_tDBOutput_1 = out1.DI_CreatedDate.getTime();
									if (date_tDBOutput_1 < year1_tDBOutput_1
											|| date_tDBOutput_1 >= year10000_tDBOutput_1) {
										pstmt_tDBOutput_1.setString(4, "0000-00-00 00:00:00");
									} else {
										pstmt_tDBOutput_1.setTimestamp(4, new java.sql.Timestamp(date_tDBOutput_1));
									}
								} else {
									pstmt_tDBOutput_1.setNull(4, java.sql.Types.DATE);
								}

								if (out1.DI_JobID == null) {
									pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(5, out1.DI_JobID);
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
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
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
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
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
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "csv_geocodes";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "csv_geocodes";

						nb_line_tFileInputDelimited_1++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_1 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_1 != null) {
							csvReadertFileInputDelimited_1.close();
						}
					}
					if (csvReadertFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", nb_line_tFileInputDelimited_1);
					}

					log.info("tFileInputDelimited_1 - Retrieved records count: " + nb_line_tFileInputDelimited_1 + ".");

				}

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_1 - " + ("Done."));

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
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

// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tFileInputDelimited_1", "csv_geocodes", "tFileInputDelimited", "tMap_1", "tMap_1", "tMap",
						"output")) {
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

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out1", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tDBOutput_1", "imdb_db", "tMysqlOutput", "output")) {
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

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				cLabel = "csv_geocodes";

				/**
				 * [tFileInputDelimited_1 finally ] stop
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

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_IMDB_region_dim = new byte[0];
		static byte[] commonByteArray_IMDB_region_dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String titleId;

		public String getTitleId() {
			return this.titleId;
		}

		public Boolean titleIdIsNullable() {
			return false;
		}

		public Boolean titleIdIsKey() {
			return true;
		}

		public Integer titleIdLength() {
			return 10;
		}

		public Integer titleIdPrecision() {
			return 0;
		}

		public String titleIdDefault() {

			return null;

		}

		public String titleIdComment() {

			return "";

		}

		public String titleIdPattern() {

			return "";

		}

		public String titleIdOriginalDbColumnName() {

			return "titleId";

		}

		public int ordering;

		public int getOrdering() {
			return this.ordering;
		}

		public Boolean orderingIsNullable() {
			return false;
		}

		public Boolean orderingIsKey() {
			return true;
		}

		public Integer orderingLength() {
			return 10;
		}

		public Integer orderingPrecision() {
			return 0;
		}

		public String orderingDefault() {

			return null;

		}

		public String orderingComment() {

			return "";

		}

		public String orderingPattern() {

			return "";

		}

		public String orderingOriginalDbColumnName() {

			return "ordering";

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
			return 1024;
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

		public String region;

		public String getRegion() {
			return this.region;
		}

		public Boolean regionIsNullable() {
			return true;
		}

		public Boolean regionIsKey() {
			return false;
		}

		public Integer regionLength() {
			return 255;
		}

		public Integer regionPrecision() {
			return 0;
		}

		public String regionDefault() {

			return null;

		}

		public String regionComment() {

			return "";

		}

		public String regionPattern() {

			return "";

		}

		public String regionOriginalDbColumnName() {

			return "region";

		}

		public String isOriginalTitle;

		public String getIsOriginalTitle() {
			return this.isOriginalTitle;
		}

		public Boolean isOriginalTitleIsNullable() {
			return true;
		}

		public Boolean isOriginalTitleIsKey() {
			return false;
		}

		public Integer isOriginalTitleLength() {
			return 255;
		}

		public Integer isOriginalTitlePrecision() {
			return 0;
		}

		public String isOriginalTitleDefault() {

			return "'0'";

		}

		public String isOriginalTitleComment() {

			return "";

		}

		public String isOriginalTitlePattern() {

			return "";

		}

		public String isOriginalTitleOriginalDbColumnName() {

			return "isOriginalTitle";

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

				result = prime * result + ((this.region == null) ? 0 : this.region.hashCode());

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

			if (this.region == null) {
				if (other.region != null)
					return false;

			} else if (!this.region.equals(other.region))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.titleId = this.titleId;
			other.ordering = this.ordering;
			other.title = this.title;
			other.region = this.region;
			other.isOriginalTitle = this.isOriginalTitle;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_JobID = this.DI_JobID;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.region = this.region;

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
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_IMDB_region_dim.length) {
					if (length < 1024 && commonByteArray_IMDB_region_dim.length == 0) {
						commonByteArray_IMDB_region_dim = new byte[1024];
					} else {
						commonByteArray_IMDB_region_dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_region_dim, 0, length);
				strReturn = new String(commonByteArray_IMDB_region_dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_region_dim) {

				try {

					int length = 0;

					this.region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.region, dos);

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

				this.titleId = readString(dis, ois);

				this.ordering = dis.readInt();

				this.title = readString(dis, ois);

				this.isOriginalTitle = readString(dis, ois);

				this.DI_CreatedDate = readDate(dis, ois);

				this.DI_JobID = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.titleId = readString(dis, objectIn);

				this.ordering = objectIn.readInt();

				this.title = readString(dis, objectIn);

				this.isOriginalTitle = readString(dis, objectIn);

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

				writeString(this.titleId, dos, oos);

				dos.writeInt(this.ordering);

				writeString(this.title, dos, oos);

				writeString(this.isOriginalTitle, dos, oos);

				writeDate(this.DI_CreatedDate, dos, oos);

				writeString(this.DI_JobID, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.titleId, dos, objectOut);

				objectOut.writeInt(this.ordering);

				writeString(this.title, dos, objectOut);

				writeString(this.isOriginalTitle, dos, objectOut);

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
			sb.append("titleId=" + titleId);
			sb.append(",ordering=" + String.valueOf(ordering));
			sb.append(",title=" + title);
			sb.append(",region=" + region);
			sb.append(",isOriginalTitle=" + isOriginalTitle);
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_JobID=" + DI_JobID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (titleId == null) {
				sb.append("<null>");
			} else {
				sb.append(titleId);
			}

			sb.append("|");

			sb.append(ordering);

			sb.append("|");

			if (title == null) {
				sb.append("<null>");
			} else {
				sb.append(title);
			}

			sb.append("|");

			if (region == null) {
				sb.append("<null>");
			} else {
				sb.append(region);
			}

			sb.append("|");

			if (isOriginalTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(isOriginalTitle);
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

			returnValue = checkNullsAndCompare(this.region, other.region);
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
		org.slf4j.MDC.put("_subJobPid", "NUIdC2_" + subJobPidCounter.getAndIncrement());

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
				// source node:tDBInput_1 - inputs:(after_tFileInputDelimited_1)
				// outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2)
				// outputs:()
				// linked node: tMap_1 - inputs:(row1,row2) outputs:(out1)

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

				cLabel = "\"stg_title_akas\"";

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
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"stg_title_akas\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"SELECT    `stg_title_akas`.`titleId`,    `stg_title_akas`.`ordering`,    `stg_title_akas`.`title`,    `stg_title_akas`.`region`,    `stg_title_akas`.`isOriginalTitle`,    `stg_title_akas`.`DI_CreatedDate`,    `stg_title_akas`.`DI_JobID` FROM `stg_title_akas`\"");
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
									+ ", SCHEMA_COLUMN=" + ("titleId") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("ordering") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("title")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("region") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("isOriginalTitle") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DI_CreatedDate") + "}, {TRIM=" + ("false")
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
					talendJobLog.addCM("tDBInput_1", "\"stg_title_akas\"", "tMysqlInput");
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

				String dbquery_tDBInput_1 = "SELECT \n  `stg_title_akas`.`titleId`, \n  `stg_title_akas`.`ordering`, \n  `stg_title_akas`.`title`, \n  `stg_title_akas`."
						+ "`region`, \n  `stg_title_akas`.`isOriginalTitle`, \n  `stg_title_akas`.`DI_CreatedDate`, \n  `stg_title_akas`.`DI_JobID`\nFR"
						+ "OM `stg_title_akas`";

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
							row2.titleId = null;
						} else {

							row2.titleId = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row2.ordering = 0;
						} else {

							row2.ordering = rs_tDBInput_1.getInt(2);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row2.title = null;
						} else {

							row2.title = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row2.region = null;
						} else {

							row2.region = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row2.isOriginalTitle = null;
						} else {

							row2.isOriginalTitle = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row2.DI_CreatedDate = null;
						} else {

							if (rs_tDBInput_1.getString(6) != null) {
								String dateString_tDBInput_1 = rs_tDBInput_1.getString(6);
								if (!("0000-00-00").equals(dateString_tDBInput_1)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
									row2.DI_CreatedDate = rs_tDBInput_1.getTimestamp(6);
								} else {
									row2.DI_CreatedDate = (java.util.Date) year0_tDBInput_1.clone();
								}
							} else {
								row2.DI_CreatedDate = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row2.DI_JobID = null;
						} else {

							row2.DI_JobID = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"stg_title_akas\"";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"stg_title_akas\"";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row2", "tDBInput_1", "\"stg_title_akas\"", "tMysqlInput", "tAdvancedHash_row2",
								"tAdvancedHash_row2", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.titleId = row2.titleId;

						row2_HashRow.ordering = row2.ordering;

						row2_HashRow.title = row2.title;

						row2_HashRow.region = row2.region;

						row2_HashRow.isOriginalTitle = row2.isOriginalTitle;

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

						cLabel = "\"stg_title_akas\"";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"stg_title_akas\"";

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
						"tDBInput_1", "\"stg_title_akas\"", "tMysqlInput", "tAdvancedHash_row2", "tAdvancedHash_row2",
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

				cLabel = "\"stg_title_akas\"";

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

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "fucbX3_" + subJobPidCounter.getAndIncrement());

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
		final region_dim region_dimClass = new region_dim();

		int exitCode = region_dimClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'region_dim' - Done.");
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
		log.info("TalendJob: 'region_dim' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_fRcScJJ_Ee6_WIiIWRIzPA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-04T08:33:19.848561500Z");

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
			java.io.InputStream inContext = region_dim.class.getClassLoader()
					.getResourceAsStream("imdb/region_dim_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = region_dim.class.getClassLoader()
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
		parametersToEncrypt.add("imdb_db_Password");
		parametersToEncrypt.add("imdb2_dbconn_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'region_dim' - Started.");
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
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : region_dim");
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
		log.info("TalendJob: 'region_dim' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 171073 characters generated by Talend Cloud Data Fabric on the 4 December
 * 2023 at 3:33:19 AM GMT-05:00
 ************************************************************************************************/