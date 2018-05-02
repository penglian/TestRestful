package com.example.administrator.testrestful.pl.model.bean;

/**
 * 图片上传
 * Created by pl on 2018/4/26 0026.
 */

public class UploadBean extends BaseBean {
    private String filename;   //文件名
    private String url;    //文件地址
    private String cdn;   //cdn

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }
}
