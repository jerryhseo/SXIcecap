package com.sx.icecap.util.comparator.sss;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sx.icecap.model.Term;

public class TermVersionComparator extends OrderByComparator<Term> {

	public static final String ORDER_BY_ASC = "Term.termVersion ASC";

	public static final String ORDER_BY_DESC = "Term.termVersion DESC";

	public static final String[] ORDER_BY_FIELDS = {"termVersion"};

	public TermVersionComparator() {
		this(false);
	}

	public TermVersionComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Term entry1, Term entry2) {
		String version1 = entry1.getTermVersion();
		String version2 = entry2.getTermVersion();

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
