create index IX_734C9ABC on SX_ICECAP_DataPack (dataPackName[$COLUMN_LENGTH:75$], dataPackVersion[$COLUMN_LENGTH:75$]);
create index IX_FE2A9975 on SX_ICECAP_DataPack (dataSetId, dataSetFolderId);
create index IX_B0B65DE9 on SX_ICECAP_DataPack (groupId, status);
create index IX_F95B2923 on SX_ICECAP_DataPack (groupId, userId, status);
create index IX_6F89526D on SX_ICECAP_DataPack (status);
create index IX_734359A7 on SX_ICECAP_DataPack (userId, status);
create index IX_3E418BB on SX_ICECAP_DataPack (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_178191FD on SX_ICECAP_DataPack (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FEFC6F49 on SX_ICECAP_DataPackEntry (dataPackId);
create index IX_243B1AFA on SX_ICECAP_DataPackEntry (dataSetFolderId);
create index IX_11B904AC on SX_ICECAP_DataPackEntry (dataSetId);
create index IX_6266CCF9 on SX_ICECAP_DataPackEntry (groupId, status);
create index IX_EB738833 on SX_ICECAP_DataPackEntry (groupId, userId, status);
create index IX_1F9CB15D on SX_ICECAP_DataPackEntry (status);
create index IX_8140C897 on SX_ICECAP_DataPackEntry (userId, status);
create index IX_88418BAB on SX_ICECAP_DataPackEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_257F00ED on SX_ICECAP_DataPackEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_71403F87 on SX_ICECAP_DataSet (dataSetName[$COLUMN_LENGTH:75$], dataSetVersion[$COLUMN_LENGTH:75$]);
create index IX_8D1CF5D0 on SX_ICECAP_DataSet (groupId, status);
create index IX_36FAEA0A on SX_ICECAP_DataSet (groupId, userId, status);
create index IX_2C67EAA6 on SX_ICECAP_DataSet (status);
create index IX_1746A8E0 on SX_ICECAP_DataSet (userId, status);
create index IX_B4507DB4 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB84E136 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9AC2FB79 on SX_ICECAP_DataType (dataTypeName[$COLUMN_LENGTH:75$], dataTypeVersion[$COLUMN_LENGTH:75$]);
create index IX_ABFFB328 on SX_ICECAP_DataType (groupId, status);
create index IX_D156CF62 on SX_ICECAP_DataType (groupId, userId, status);
create index IX_39F24A4E on SX_ICECAP_DataType (status);
create index IX_ACEAE088 on SX_ICECAP_DataType (userId, status);
create index IX_71C56B5C on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_512918DE on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_61FAEB91 on SX_ICECAP_StructuredData (dataPackId);
create index IX_3C70BB2 on SX_ICECAP_StructuredData (dataSetFolderId);
create index IX_C255DF64 on SX_ICECAP_StructuredData (dataSetId);
create index IX_6E43F39E on SX_ICECAP_StructuredData (dataTypeId, groupId, status);
create index IX_82E639D8 on SX_ICECAP_StructuredData (dataTypeId, groupId, userId, status);
create index IX_F0EB8D18 on SX_ICECAP_StructuredData (dataTypeId, status);
create index IX_FD81B952 on SX_ICECAP_StructuredData (dataTypeId, userId, status);
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