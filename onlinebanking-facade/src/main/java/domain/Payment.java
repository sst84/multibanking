package domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by alexg on 19.10.17.
 */
@Data
public class Payment extends AbstractScaType {

    private PaymentType paymentType;
    private String senderAccountNumber;
    private String senderIban;
    private String senderBic;
    private String receiver;
    private String receiverBic;
    private String receiverIban;
    private String receiverBankCode;
    private String receiverAccountNumber;
    private String purpose;
    private BigDecimal amount;
    private int executionDay;
    private LocalDate firstExecutionDate;
    private LocalDate lastExecutionDate;
    private Cycle cycle;

    public enum PaymentType {
        TRANSFER,
        SEPA_TRANSFER,
        STANDING_ORDER
    }
}
