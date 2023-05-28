create table SX_ICECAP_DataPack (
	uuid_ VARCHAR(75) null,
	dataPackId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataSetId LONG,
	dataSetFolderId LONG,
	dataPackName VARCHAR(75) null,
	dataPackVersion VARCHAR(75) null,
	displayName STRING null,
	description STRING null
);

create table SX_ICECAP_DataPackEntry (
	uuid_ VARCHAR(75) null,
	dataPackEntryId LONG not null primary key,
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
	dataSetId LONG,
	dataSetFolderId LONG,
	dataPackId LONG,
	entryData VARCHAR(75) null
);

create table SX_ICECAP_DataPackStructure (
	dataPackId LONG not null primary key,
	structure TEXT null
);

create table SX_ICECAP_DataSet (
	uuid_ VARCHAR(75) null,
	dataSetId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataSetName VARCHAR(75) null,
	dataSetVersion VARCHAR(75) null,
	displayName STRING null,
	description STRING null
);

create table SX_ICECAP_DataType (
	uuid_ VARCHAR(75) null,
	dataTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
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
	uuid_ VARCHAR(75) null,
	structuredDataId LONG not null primary key,
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
	dataSetId LONG,
	dataSetDisplayName STRING null,
	dataTypeId LONG,
	dataTypeDisplayName STRING null,
	dataSetFolderId LONG,
	dataSetFolderName STRING null,
	dataPackId LONG,
	dataPackDisplayName STRING null,
	recordType VARCHAR(75) null,
	recordDelimiter VARCHAR(75) null,
	recordFormat VARCHAR(75) null,
	entryCount INTEGER,
	startEntryNo INTEGER,
	endEntryNo INTEGER,
	structuredData TEXT null
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