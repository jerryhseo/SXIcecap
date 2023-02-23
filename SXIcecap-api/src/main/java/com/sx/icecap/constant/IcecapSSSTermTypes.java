package com.sx.icecap.constant;

public class IcecapSSSTermTypes {
	public static final String STRING = "String";
	public static final String NUMERIC = "Numeric";
	public static final String INTEGER = "Integer";
	public static final String BOOLEAN = "Boolean";
	public static final String LIST = "List";
	public static final String ADDRESS = "Address";
	public static final String ARRAY = "Array";
	public static final String DATE = "Date";
	public static final String PHONE = "Phone";
	public static final String EMAIL = "EMail";
	public static final String LIST_ARRAY = "ListArray";
	public static final String MATRIX = "Matrix";
	public static final String FILE = "File";
	public static final String FILE_ARRAY = "FileArray";
	public static final String OBJECT = "Object";
	public static final String OBJECT_ARRAY = "ObjectArray";
	public static final String DATA_LINK = "DataLink";
	public static final String DATA_LINK_ARRAY = "DataLinkArray";
	public static final String GROUP = "Group";
	public static final String COMMENT = "Comment";
	
	public static final String[] getTypes() {
		String[] types = {
				STRING, NUMERIC, BOOLEAN, INTEGER, ADDRESS, LIST, ARRAY, DATE, PHONE, EMAIL, LIST_ARRAY, MATRIX, FILE, FILE_ARRAY, OBJECT, OBJECT_ARRAY, DATA_LINK, DATA_LINK_ARRAY, GROUP, COMMENT 
		};
		return types;
	}
	
	public static final boolean hasDedicatedAttributes( String termType ) {
		if( termType.equals(EMAIL) || termType.equals(DATE) ) {
			return false;
		}
		
		return true;
	}
}
