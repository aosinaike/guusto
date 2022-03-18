package com.guusto.giftcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCardModel, Integer> {

    List<GiftCardModel> findAll();
    List<GiftCardModel> findAllByGiftName(String giftName);
    List<GiftCardModel> findAllById(Integer id);
}
