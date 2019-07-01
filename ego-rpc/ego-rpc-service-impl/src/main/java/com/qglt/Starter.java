package com.qglt;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Starter {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/applicationContext-dao.xml",
                "spring/applicationContext-dubbo.xml",
                "spring/applicationContext-service.xml",
                "spring/applicationContext-tx.xml");
        applicationContext.start();
        //阻塞程序的运行
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        applicationContext.stop();
    }
}
