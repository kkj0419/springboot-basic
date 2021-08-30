package org.prgrms.kdt.kdtspringorder;

import org.prgrms.kdt.kdtspringorder.common.config.AppConfiguration;
import org.prgrms.kdt.kdtspringorder.voucher.application.VoucherCommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Voucher Command Line 어플리케이션을 실행한다.
 */
@SpringBootApplication
public class VoucherCommandLineApplication {

    private static final Logger logger = LoggerFactory.getLogger(VoucherCommandLineApplication.class);

    public static void main(String[] args) {

        logger.info("Application Start!");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        applicationContext.getBean(VoucherCommandLine.class).start();
        applicationContext.close();
        logger.info("Application End!");

    }

}