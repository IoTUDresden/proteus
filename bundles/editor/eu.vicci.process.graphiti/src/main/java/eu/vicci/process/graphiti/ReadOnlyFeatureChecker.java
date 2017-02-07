package eu.vicci.process.graphiti;

import org.eclipse.graphiti.features.FeatureCheckerAdapter;

public class ReadOnlyFeatureChecker extends FeatureCheckerAdapter {

	public ReadOnlyFeatureChecker() {
		super(false); //readonly
	}

}
