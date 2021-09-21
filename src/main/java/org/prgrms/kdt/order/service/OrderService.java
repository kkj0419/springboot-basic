package org.prgrms.kdt.order.service;

import org.prgrms.kdt.order.Order;
import org.prgrms.kdt.order.OrderItem;
import org.prgrms.kdt.order.repository.OrderRepository;
import org.prgrms.kdt.voucher.service.VoucherService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Profile("file")
public class OrderService {
    private final VoucherService voucherService;
    private final OrderRepository orderRepository;

    public OrderService(final VoucherService voucherService, final OrderRepository orderRepository) {
        this.voucherService = voucherService;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(final UUID customerId, final List<OrderItem> orderItems) {
        final var order = new Order(UUID.randomUUID(), customerId, orderItems);
        return orderRepository.insert(order);
    }

    public Order createOrder(final UUID customerId, final List<OrderItem> orderItems, final UUID voucherId) {
        final var voucher = voucherService.getVoucher(voucherId);
        final var order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        voucherService.useVoucher(voucher);
        return order;
    }

}