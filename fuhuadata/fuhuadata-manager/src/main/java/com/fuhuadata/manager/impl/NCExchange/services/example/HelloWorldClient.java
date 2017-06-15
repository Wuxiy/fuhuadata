package com.fuhuadata.manager.impl.NCExchange.services.example;

import com.fuhuadata.manager.impl.NCExchange.services.M5715FileManagerWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

/**
 * Created by zhangxiang on 2017/5/9.
 */
public class HelloWorldClient {


  public static void main(String[] args) {
    com.fuhuadata.manager.impl.NCExchange.services.M5715FileManagerWsPortType service=new com.fuhuadata.manager.impl.NCExchange.services.M5715FileManagerWs().getM5715FileManagerWsSOAP11PortHttp();
    //service.crmExchangeFileToNC();
    System.out.println("连接成功");
  }
}
