package com.example.administrator.testrestful.model.bean;

/**
 * Created by pl on 2018/4/24 0024.
 * 手机产品参数表
 */

public class MobilePPBean extends BaseBean {
    private String rom;  //存储空间
    private String ram;  //运行内存
    private String system_vertion;  //系统版本
    private String platform;  //手机操作系统平台
    private String dname;  //手机全程

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSystem_vertion() {
        return system_vertion;
    }

    public void setSystem_vertion(String system_vertion) {
        this.system_vertion = system_vertion;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
