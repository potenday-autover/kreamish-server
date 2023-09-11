package com.potenday.kreamish.puchase.entity;

import com.potenday.kreamish.common.entity.BaseEntity;
import com.potenday.kreamish.common.entity.DealStatus;
import com.potenday.kreamish.itemsizes.entity.ItemSizes;
import com.potenday.kreamish.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "purchase")
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long purchaseId;

    @ManyToOne
    @JoinColumn(name = "item_sizes_id")
    private ItemSizes itemSizes;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "purchase_price", nullable = false)
    private Long purchasePrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "purchase_status", nullable = false)
    private DealStatus purchaseStatus;
}
