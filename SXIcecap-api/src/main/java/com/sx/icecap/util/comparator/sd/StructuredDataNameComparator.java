package com.sx.icecap.util.comparator.sd;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sx.icecap.model.DataType;

public class StructuredDataNameComparator extends OrderByComparator<DataType> {

	public static final String ORDER_BY_ASC = "DataType.dataTypeName ASC";

	public static final String ORDER_BY_DESC = "DataType.dataTypeName DESC";

	public static final String[] ORDER_BY_FIELDS = {"dataTypeName"};

	public StructuredDataNameComparator() {
		this(false);
	}

	public StructuredDataNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(DataType entry1, DataType entry2) {
		String title1 = entry1.getDataTypeName();
		String title2 = entry2.getDataTypeName();

		int value = title1.compareTo(title2);

		System.out.println("*** Compate: "+value);
		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}
