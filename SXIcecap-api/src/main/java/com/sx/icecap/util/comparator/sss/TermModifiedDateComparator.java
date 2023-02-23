package com.sx.icecap.util.comparator.sss;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sx.icecap.model.Term;


public class TermModifiedDateComparator extends OrderByComparator<Term> {
	public static final String ORDER_BY_ASC =
			"Term.modifiedDate ASC, Term.termName ASC";

		public static final String[] ORDER_BY_CONDITION_FIELDS = {"modifiedDate"};

		public static final String ORDER_BY_DESC =
			"Term.modifiedDate DESC, Term.termName DESC";

		public static final String[] ORDER_BY_FIELDS = {"modifiedDate", "termName"};

		public TermModifiedDateComparator() {
			this(false);
		}

		public TermModifiedDateComparator(boolean ascending) {
			_ascending = ascending;
		}

		@Override
		public int compare(Term entry1, Term entry2) {
			int value = DateUtil.compareTo(
				entry1.getModifiedDate(), entry2.getModifiedDate());

			if (value == 0) {
				if (entry1.getTermId() < entry2.getTermId()) {
					value = -1;
				}
				else if (entry1.getTermId() > entry2.getTermId()) {
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
