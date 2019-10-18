package customers;

import store.DataManager;


public interface Observer {
	/**
	 * Observer interface in the observer pattern
	 */
	
	public abstract void updateShortage(DataManager dm);
    
    public abstract void updateSupply(DataManager dm);

}
