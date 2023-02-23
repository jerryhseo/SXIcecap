create table SX_ICECAP_DataType (
	uuid_ VARCHAR(75) null,
	dataTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataTypeName VARCHAR(75) null,
	dataTypeVersion VARCHAR(75) null,
	displayName STRING null,
	extension VARCHAR(75) null,
	sampleFileId LONG,
	description STRING null,
	tooltip STRING null,
	hasDataStructure BOOLEAN
);

create table SX_ICECAP_DataTypeStructure (
	dataTypeId LONG not null primary key,
	structure TEXT null
);

create table SX_ICECAP_StructuredData (
	structuredDataId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dataSetId LONG,
	dataTypeId LONG,
	structuredData VARCHAR(75) null,
	patientId LONG,
	crfId LONG
);

create table SX_ICECAP_Term (
	uuid_ VARCHAR(75) null,
	termId LONG not null primary key,
	groupTermId VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	lastPublishDate DATE null,
	termName VARCHAR(75) null,
	termVersion VARCHAR(75) null,
	termType VARCHAR(75) null,
	displayName STRING null,
	definition STRING null,
	tooltip STRING null,
	synonyms VARCHAR(512) null,
	attributesJSON TEXT null,
	standard BOOLEAN
);