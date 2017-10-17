package com.david.sys.entity;

/**
* Public configuration table
* @author david.cn
* @version 1.0
*/
public class Config extends DataEntity<Config> {

    private static final long serialVersionUID = 1L;

    private String sysName;//system name
    private String moduleName;//moduleName
    private String configName;//key
    private String configValue;//value

    public Config() {
        super();
    }
    public Config(String id){
        super(id);
    }

    public String getSysName(){
        return sysName;
    }

    public void setSysName(String sysName){
        this.sysName = sysName;
    }

    public String getModuleName(){
        return moduleName;
    }

    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }

    public String getConfigName(){
        return configName;
    }

    public void setConfigName(String configName){
        this.configName = configName;
    }

    public String getConfigValue(){
        return configValue;
    }

    public void setConfigValue(String configValue){
        this.configValue = configValue;
    }

}
