package com.rest.services.batch;

import org.apache.log4j.Logger;

/**
 *
 * @author User
 */
public class MonitorStatusImpl implements MonitorStatus{
    private final Logger log = Logger.getLogger(MonitorStatusImpl.class);
    
    public void status() {
        this.log.info(" -- Status del servidor: OK");
    }
    
    public MonitorStatusImpl getInstance(){
        return MonitorStatusImpl.InstanceHolder.SINGLETON;
    }
   
    private static final class InstanceHolder{
        private static final MonitorStatusImpl SINGLETON = new MonitorStatusImpl();
    }
    
    private MonitorStatusImpl(){}
    
   
}
