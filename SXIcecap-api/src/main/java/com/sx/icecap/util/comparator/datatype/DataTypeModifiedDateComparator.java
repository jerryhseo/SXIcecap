package com.sx.icecap.util.comparator.datatype;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sx.icecap.model.DataType;


public class DataTypeModifiedDateComparator extends OrderByComparator<DataType> {
	public static final String ORDER_BY_ASC =
			"DataType.modifiedDate ASC, DataType.dataTypeName ASC";

		public static final String[] ORDER_BY_CONDITION_FIELDS = {"modifiedDate"};

		public static final String ORDER_BY_DESC =
			"DataType.modifiedDate DESC, DataType.dataTypeName DESC";

		public static final String[] ORDER_BY_FIELDS = {"modifiedDate", "dataTypeName"};

		public DataTypeModifiedDateComparator() {
			this(false);
		}

		public DataTypeModifiedDateComparator(boolean ascending) {
			_ascending = ascending;
		}

		@Override
		public int compare(DataType entry1, DataType entry2) {
			int value = DateUtil.compareTo(
				entry1.getModifiedDate(), entry2.getModifiedDate());

			if (value == 0) {
				if (entry1.getPrimaryKey() < entry2.getPrimaryKey()) {
					value = -1;
				}
				else if (entry1.getPrimaryKey() > entry2.getPrimaryKey()) {
					value = 1;
				}
			}

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
		public String[] getOrderByConditionFields() {
			return ORDER_BY_CONDITION_FIELDS;
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
