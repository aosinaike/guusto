package com.guusto.giftcard;


import javax.persistence.*;

@Entity
@Table(name = "gift_card")
public class GiftCardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name ="gift_name")
    private String giftName;
    @Column(name ="price")
    private String price;

    public GiftCardModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

}
