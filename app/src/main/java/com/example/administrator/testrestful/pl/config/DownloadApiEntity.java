package com.example.administrator.testrestful.pl.config;

/**
 * 文件下载配置
 * Created by pl on 2018/5/2 0002.
 */

public class DownloadApiEntity extends BaseApiEntity{
    public DownloadApiEntity(){
        //http://download.fir.im/v2/app/install/595c5959959d6901ca0004ac?download_token=1a9dfa8f248b6e45ea46bc5ed96a0a9e&source=update
        setBaseUrl("http://download.fir.im/");
    }
}
