package org.prgms.w3d1.repository;

import org.prgms.w3d1.model.voucher.Voucher;
import org.prgms.w3d1.model.voucher.VoucherType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
    Optional<Voucher> findById(UUID voucherId);

    List<Voucher> findByVoucherType(VoucherType voucherType);

    void save(Voucher voucher);

    List<Voucher> findAll();

    List<Voucher> findByVoucherWalletId(UUID voucherWalletId);

    void deleteAll();

    void deleteById(UUID voucherId);
}