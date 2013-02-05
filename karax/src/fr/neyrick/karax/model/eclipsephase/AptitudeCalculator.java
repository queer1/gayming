package fr.neyrick.karax.model.eclipsephase;

import fr.neyrick.karax.model.CharacterFeature;
import fr.neyrick.karax.model.FeatureCalculator;
import fr.neyrick.karax.model.FixedNumericFeature;
import fr.neyrick.karax.model.VariableNumericFeature;

public class AptitudeCalculator implements FeatureCalculator{

	private VariableNumericFeature baseFeature;
	
	private FixedNumericFeature morphLimitFeature;
	
	@Override
	public Number calculate(CharacterFeature feature) {
		VariableNumericFeature targetFeature = (VariableNumericFeature)feature;
		int result = baseFeature.getNumericValue().intValue();
		result += targetFeature.getAmount("MORPH");
		if (morphLimitFeature != null) {
			int morphLimit = morphLimitFeature.getAmount();
			if (result > morphLimit) return morphLimit;
		}		
		return result;
	}

	public AptitudeCalculator(VariableNumericFeature baseFeature, FixedNumericFeature morphLimitFeature) {
		super();
		this.baseFeature = baseFeature;
		this.morphLimitFeature = morphLimitFeature;
	}

}
