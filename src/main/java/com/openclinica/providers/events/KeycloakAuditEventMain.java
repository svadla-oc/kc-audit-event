package com.openclinica.providers.events;

import com.openclinica.providers.events.domain.AuditEventDTO;
import com.openclinica.providers.events.domain.enumeration.AuditEventType;

import java.time.Instant;

public class KeycloakAuditEventMain {
    public static void main(String[] args) {
        AuditEventDTO auditEvent = new AuditEventDTO();
        auditEvent.setType(AuditEventType.SUCCESSFUL_LOGIN);
        auditEvent.setServiceName("Keycloak Audit");
        auditEvent.setTargetObject("cust1");
        auditEvent.setTimestamp(Instant.ofEpochMilli(System.currentTimeMillis()));
        auditEvent.setCustomerUuid("test-yogi1");
        auditEvent.setModifiedBy("yogi");
        AuditEventUtil auditEventUtil = new AuditEventUtil(auditEvent);
        auditEventUtil.sendAuditEvent();
    }
}