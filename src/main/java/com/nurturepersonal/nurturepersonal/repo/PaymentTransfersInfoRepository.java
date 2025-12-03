package com.nurturepersonal.nurturepersonal.repo;

import com.nurturepersonal.nurturepersonal.entity.PaymentTransfersInfo;
import com.nurturepersonal.nurturepersonal.enums.PaymentType;
import com.nurturepersonal.nurturepersonal.service.PaymentTransfersInfoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentTransfersInfoRepository extends JpaRepository<PaymentTransfersInfo, Long> {

    @Query(value = "select app_order_id from payment_transfers_info where payment_type in (:paymentType) and enterprise_id != 3 and reversal_against_id is null and status in ('processed','Created') and app_order_id in\n" +
            "(:orderIDs)",nativeQuery = true)
    List<String> payoutCreatedOrderIDsForSeller(@Param("orderIDs") List<String> orderIDs, @Param("paymentType") String paymentType);

}
