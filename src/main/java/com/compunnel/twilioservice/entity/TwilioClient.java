package com.compunnel.twilioservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("twillio_client")
public class TwilioClient {
    @Id
    @Column("row_id")
    private Integer rowId;

    @Column("client_code")
    private String clientCode;

    @Column("secretKey")
    private String secretKey;

    @Column("sendUsingNumber")
    private String sendUsingNumber;

    @Column("sendUsingName")
    private String sendUsingName;

    @Column("clientWebhook")
    private String clientWebhook;

    @Column("status")
    private Character status;
}