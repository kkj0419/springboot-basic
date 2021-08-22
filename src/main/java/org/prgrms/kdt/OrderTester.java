package org.prgrms.kdt;

import org.prgrms.kdt.Model.FixedAmountVoucher;
import org.prgrms.kdt.Model.OrderItem;
import org.prgrms.kdt.Repository.VoucherRepository;
import org.prgrms.kdt.Service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class OrderTester {
    public static void main(String[] args) {


            //자바 기반의 메타데이터 설정은 어노테이션
            var apllicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
            var customerId = UUID.randomUUID();
            var voucherRepository=apllicationContext.getBean(VoucherRepository.class);
            var voucher=voucherRepository.save( new FixedAmountVoucher(UUID.randomUUID(),10L));
            var orderservice = apllicationContext.getBean(OrderService.class);
            var order = orderservice.createOrder(customerId, new ArrayList<OrderItem>() {{
                add(new OrderItem(UUID.randomUUID(), 100L, 1));
            }},voucher.getVoucherId());
            Assert.isTrue(order.totalAmount() == 90L, MessageFormat.format("totalAmount({0}) is not 90L", order.totalAmount()));
        }



}