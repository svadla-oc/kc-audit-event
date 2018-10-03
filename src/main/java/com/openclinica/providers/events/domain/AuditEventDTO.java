package com.openclinica.providers.events.domain;


import com.openclinica.providers.events.domain.enumeration.AuditEventType;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the AuditEvent entity.
 */
public class AuditEventDTO implements Serializable {

    private String uuid;

    private AuditEventType type;


    private Instant timestamp;


    private String targetObject;

    private String modifiedBy;

    private String valueType;


    private String oldValue;


    private String newValue;

    private String eventSetId;

    private String serviceName;

    private String customerUuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AuditEventType getType() {
        return type;
    }

    public void setType(AuditEventType type) {
        this.type = type;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getEventSetId() {
        return eventSetId;
    }

    public void setEventSetId(String eventSetId) {
        this.eventSetId = eventSetId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuditEventDTO auditEventDTO = (AuditEventDTO) o;
        if(auditEventDTO.getUuid() == null || getUuid() == null) {
            return false;
        }
        return Objects.equals(getUuid(), auditEventDTO.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUuid());
    }

    @Override
    public String toString() {
        return "AuditEventDTO{" +
            ", uuid='" + getUuid() + "'" +
            ", type='" + getType() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", targetObject='" + getTargetObject() + "'" +
            ", modifiedBy='" + getModifiedBy() + "'" +
            ", valueType='" + getValueType() + "'" +
            ", oldValue='" + getOldValue() + "'" +
            ", newValue='" + getNewValue() + "'" +
            ", eventSetId='" + getEventSetId() + "'" +
            ", serviceName='" + getServiceName() + "'" +
            ", customerUuid='" + getCustomerUuid() + "'" +
            "}";
    }
}
