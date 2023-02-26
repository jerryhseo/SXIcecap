create index IX_9AC2FB79 on SX_ICECAP_DataType (dataTypeName[$COLUMN_LENGTH:75$], dataTypeVersion[$COLUMN_LENGTH:75$]);
create index IX_ABFFB328 on SX_ICECAP_DataType (groupId, status);
create index IX_D156CF62 on SX_ICECAP_DataType (groupId, userId, status);
create index IX_39F24A4E on SX_ICECAP_DataType (status);
create index IX_ACEAE088 on SX_ICECAP_DataType (userId, status);
create index IX_71C56B5C on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_512918DE on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C255DF64 on SX_ICECAP_StructuredData (dataSetId);
create index IX_CEFA032 on SX_ICECAP_StructuredData (dataTypeId);
create index IX_41F2BDB1 on SX_ICECAP_StructuredData (groupId, status);
create index IX_C93F40EB on SX_ICECAP_StructuredData (groupId, userId, status);
create index IX_FD9491A5 on SX_ICECAP_StructuredData (status);
create index IX_C97E0DF on SX_ICECAP_StructuredData (userId, status);
create index IX_9A33B1F3 on SX_ICECAP_StructuredData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B0D61935 on SX_ICECAP_StructuredData (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4883B4C0 on SX_ICECAP_Term (groupId, status);
create index IX_F6EBB8FA on SX_ICECAP_Term (groupId, userId, status);
create index IX_95D19DB6 on SX_ICECAP_Term (status);
create index IX_305706C1 on SX_ICECAP_Term (termName[$COLUMN_LENGTH:75$], termVersion[$COLUMN_LENGTH:75$]);
create index IX_25944BF0 on SX_ICECAP_Term (userId, status);
create index IX_65C19CC4 on SX_ICECAP_Term (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C9D28446 on SX_ICECAP_Term (uuid_[$COLUMN_LENGTH:75$], groupId);