package gov.nist.toolkit.actorfactory;

import gov.nist.toolkit.actorfactory.client.Simulator;
import gov.nist.toolkit.actorfactory.client.SimulatorConfig;
import gov.nist.toolkit.actortransaction.client.ATFactory.TransactionType;
import gov.nist.toolkit.sitemanagement.client.Site;

import java.util.List;

/**
 * This class exists only to expose methods in ActorFactory such as
 * the buildNewSimulator method which
 * would otherwise be buried in the abstract class ActorFactory.
 * @author bill
 *
 */
public class SimulatorFactory extends ActorFactory {
	String newID = null;
	@SuppressWarnings("unused")
	private SimulatorFactory() {
	}
	
	public SimulatorFactory(SimManager simManager) {
		super(simManager);
	}

	public Simulator buildNewSimulator(SimManager simm, String simtype, String simID) throws Exception {
		return buildNewSimulator(simm, simtype, simID, true);
	}

	
	@Override
	protected Simulator buildNew(SimManager simm, String newID, boolean configureBase) throws Exception {
		this.newID = newID;
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void verifyActorConfigurationOptions(SimulatorConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public Site getActorSite(SimulatorConfig asc, Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionType> getIncomingTransactions() {
		// TODO Auto-generated method stub
		return null;
	}
	

}