package com.ctc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by sponge on 15-7-8.
 */
public class WriteLog {
    protected static final Logger logger = LoggerFactory.getLogger(WriteLog.class);

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            logger.info(String.valueOf(new Date().getTime()));
            Thread.sleep(2000);
        }
    }

}
