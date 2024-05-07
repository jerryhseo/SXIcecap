package com.sx.icecap.constant;

public class IcecapSSSTermTypes {
	public static final String STRING = "String";
	public static final String NUMERIC = "Numeric";
	public static final String INTEGER = "Integer";
	public static final String BOOLEAN = "Boolean";
	public static final String LIST = "List";
	public static final String ADDRESS = "Address";
	public static final String DATE = "Date";
	public static final String PHONE = "Phone";
	public static final String EMAIL = "EMail";
	public static final String MATRIX = "Matrix";
	public static final String FILE = "File";
	public static final String GRID = "Grid";
	public static final String GROUP = "Group";
	public static final String COMMENT = "Comment";
	
	public static final String[] getTypes() {
		String[] types = {
				STRING, NUMERIC, BOOLEAN, INTEGER, ADDRESS, LIST, DATE, PHONE, EMAIL, MATRIX, FILE, GROUP, COMMENT 
		};
		return types;
	}
}
