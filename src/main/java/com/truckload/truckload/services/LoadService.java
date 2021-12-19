package com.truckload.truckload.services;
import java.util.List;

import com.truckload.truckload.entities.Load;

public interface LoadService {
	public List<Load> getLoads(long shipperId);
	
	public Load getLoad(long loadId);
	
	public Load addLoad(Load load);
	
	public void updateLoad(Load load);
	
	public void deleteLoad(long parseLong);
}
