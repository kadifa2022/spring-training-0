package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name= "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
   private Status paymentStatus;

   //@OneToOne(cascade=CascadeType.ALL)//saving, deleting or any other action in parent object - child objects will be the same action
     @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})//saving, deleting or any other action in parent object
    @JoinColumn(name="payment_detail_id")//foreign key created//bidirectional and uni-direct
    private PaymentDetail paymentDetail;//is another object

    @ManyToOne
    private Costumer customer;

    @ManyToOne
    private Merchant merchant;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;

    }
}