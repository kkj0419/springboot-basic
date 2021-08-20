package org.prgrms.kdt.domain.voucher;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher{
    private UUID voucherId;
    private final long amount;

    public FixedAmountVoucher(UUID voucherId, long amount) {
        this.voucherId = voucherId;
        this.amount = amount;
    }

    public FixedAmountVoucher(long amount) {
        this.amount = amount;
    }

    @Override
    public UUID getVoucherId() {
        return null;
    }

    public long discount(long beforeDiscount) {
        return beforeDiscount - amount;
    }
}