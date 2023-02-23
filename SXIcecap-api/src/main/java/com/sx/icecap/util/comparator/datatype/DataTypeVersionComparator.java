package com.sx.icecap.util.comparator.datatype;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sx.icecap.model.DataType;

public class DataTypeVersionComparator extends OrderByComparator<DataType> {

	public static final String ORDER_BY_ASC = "DataType.termVersion ASC";

	public static final String ORDER_BY_DESC = "DataType.termVersion DESC";

	public static final String[] ORDER_BY_FIELDS = {"termVersion"};

	public DataTypeVersionComparator() {
		this(false);
	}

	public DataTypeVersionComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(DataType entry1, DataType entry2) {
		String version1 = entry1.getDataTypeVersion();
		String version2 = entry2.getDataTypeVersion();

		int value = version1.compareTo(version2);

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
