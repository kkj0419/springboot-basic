package org.prgrms.voucherprgrms.voucher.model;

import java.util.Arrays;

public enum VoucherType {
    FIXEDAMOUNT("FixedAmountVoucher"),
    PERCENTDISCOUNT("PercentDiscountVoucher");

    private final String name;

    VoucherType(String name) {
        this.name = name;
    }

    public static VoucherType getType(String name) {
        return Arrays.stream(values())
                .filter(v -> v.isEqualsVoucherType(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Voucher type error"));
    }

    private boolean isEqualsVoucherType(String name) {
        return this.name.equals(name);
    }


    public String getName() {
        return this.name;
    }

}
