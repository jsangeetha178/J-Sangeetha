package com.abc.insurance.sorting;

import java.util.Comparator;

import com.abc.insurance.entity.TravelInsurance;

public class SortingBasedOnPremiumHighToLow implements Comparator<TravelInsurance> {

	@Override
	public int compare(TravelInsurance o1, TravelInsurance o2) {
		
		return o2.getPremium()-o1.getPremium();
	}

}
