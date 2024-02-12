--
-- ER/Studio Data Architect SQL Code Generation
-- Project :      DimensionalModel_1.DM1
--
-- Date Created : Sunday, October 22, 2023 21:08:11
-- Target DBMS : MySQL 8.x
--

-- 
-- TABLE: dim_address 
--

CREATE TABLE dim_address(
    AddressId                VARCHAR(10)        NOT NULL,
    address_sk               VARCHAR(10)        NOT NULL,
    DI_CreatedDate           DATETIME,
    DI_WorkflowFileName      VARCHAR(100),
    DI_Workflow_ProcessID    VARCHAR(100),
    Address                  VARCHAR(32),
    City                     CHAR(17),
    State                    VARCHAR(2),
    Longitude                DECIMAL(20, 20),
    Lattitude                DECIMAL(20, 20),
    ZipCode                  DECIMAL(4, 0),
    PRIMARY KEY (AddressId)
)ENGINE=MYISAM
;



-- 
-- TABLE: dim_business 
--

CREATE TABLE dim_business(
    BusinessId               VARCHAR(10)       NOT NULL,
    business_sk              VARCHAR(10)       NOT NULL,
    DI_CreatedDate           DATETIME,
    DI_WorkflowFileName      VARCHAR(100),
    DI_Workflow_ProcessID    VARCHAR(100),
    Name                     VARCHAR(70),
    PhoneNumber              DECIMAL(12, 0),
    PRIMARY KEY (BusinessId)
)ENGINE=MYISAM
;



-- 
-- TABLE: dim_date 
--

CREATE TABLE dim_date(
    Date                  DATE            NOT NULL,
    Date_sk               VARCHAR(10)     NOT NULL,
    dt                    VARCHAR(10),
    DI_CreatedDate        DATETIME,
    DIWorkflowFileName    VARCHAR(100),
    DI_ProcessID          VARCHAR(100),
    Day                   DATE,
    Month                 DATE,
    Year                  DATE,
    Quater                DATE,
    isWeekday             VARCHAR(1)      NOT NULL,
    isWeekend             VARCHAR(1),
    PRIMARY KEY (Date)
)ENGINE=MYISAM
;



-- 
-- TABLE: dim_violation 
--

CREATE TABLE dim_violation(
    InspectionId             CHAR(10)        NOT NULL,
    violation_sk             CHAR(10),
    DI_Createddate           DATETIME,
    DI_Workflow_Filename     CHAR(10),
    DI_Workflow_ProcessId    VARCHAR(10),
    CodeScore                VARCHAR(100),
    ViolationCodes           VARCHAR(250),
    ViolationDescriptions    VARCHAR(254),
    ViolationCategory        VARCHAR(10),
    PRIMARY KEY (InspectionId)
)ENGINE=MYISAM
;



-- 
-- TABLE: fact_foodinspection 
--

CREATE TABLE fact_foodinspection(
    business_sk              VARCHAR(10)     NOT NULL,
    address_sk               VARCHAR(10)     NOT NULL,
    Date_sk                  VARCHAR(10)     NOT NULL,
    ViolationScore           VARCHAR(100),
    FactInspection_sk        VARCHAR(10)     NOT NULL,
    InspectionResult         VARCHAR(50),
    InspectionType           VARCHAR(50),
    DI_CreatedDate           DATETIME,
    DI_Workflow_Filename     VARCHAR(50),
    DI_Workflow_ProcessID    VARCHAR(50),
    PRIMARY KEY (business_sk, address_sk, Date_sk)
)ENGINE=MYISAM
;



-- 
-- TABLE: fact_violation 
--

CREATE TABLE fact_violation(
    violation_sk            CHAR(10)       NOT NULL,
    FactInspection_sk       VARCHAR(10)    NOT NULL,
    FactViolation_sk        VARCHAR(10)    NOT NULL,
    DI_CreatedDate          DATETIME,
    DI_Workflow_Filename    VARCHAR(50),
    DI_WorkflowProcessID    VARCHAR(50),
    PRIMARY KEY (violation_sk, FactInspection_sk)
)ENGINE=MYISAM
;



-- 
-- INDEX: AK2 
--

CREATE UNIQUE INDEX AK2 ON dim_address(address_sk)
;
-- 
-- INDEX: AK1 
--

CREATE UNIQUE INDEX AK1 ON dim_business(business_sk)
;
-- 
-- INDEX: AK4 
--

CREATE UNIQUE INDEX AK4 ON dim_date(Date_sk)
;
-- 
-- INDEX: AK3 
--

CREATE UNIQUE INDEX AK3 ON dim_violation(violation_sk)
;
-- 
-- INDEX: AK5 
--

CREATE UNIQUE INDEX AK5 ON fact_foodinspection(FactInspection_sk)
;
-- 
-- TABLE: fact_foodinspection 
--

ALTER TABLE fact_foodinspection ADD CONSTRAINT Refdim_business1 
    FOREIGN KEY (business_sk)
    REFERENCES dim_business(business_sk)
;

ALTER TABLE fact_foodinspection ADD CONSTRAINT Refdim_address2 
    FOREIGN KEY (address_sk)
    REFERENCES dim_address(address_sk)
;

ALTER TABLE fact_foodinspection ADD CONSTRAINT Refdim_date4 
    FOREIGN KEY (Date_sk)
    REFERENCES dim_date(Date_sk)
;


-- 
-- TABLE: fact_violation 
--

ALTER TABLE fact_violation ADD CONSTRAINT Refdim_violation3 
    FOREIGN KEY (violation_sk)
    REFERENCES dim_violation(violation_sk)
;

ALTER TABLE fact_violation ADD CONSTRAINT Reffact_foodinspection5 
    FOREIGN KEY (FactInspection_sk)
    REFERENCES fact_foodinspection(FactInspection_sk)
;


