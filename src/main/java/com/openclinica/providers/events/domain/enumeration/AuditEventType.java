package com.openclinica.providers.events.domain.enumeration;

import org.keycloak.events.EventType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.keycloak.events.EventType.*;

/**
 * The AuditEventType enumeration.
 */
public enum AuditEventType {

    SUCCESSFUL_LOGOUT, SUCCESSFUL_LOGIN, PASSWORD_RESET_REQUEST, PASSWORD_CHANGED,
    FAILED_LOGIN, ACCOUNT_REMOVED, ROLE_CHANGE, ROLE_DEFINITION_CHANGE, USER_PROFILE_CHANGE, INVITATION_SENT, USER_CREATED,
    BLOCKED_ACCOUNT, UNMAPPED_AUTH_EVENT;

    // Auth0 event to Audit event mapping
    private static final Map<EventType, AuditEventType> auth0EventMapping;

    static {
        Map<EventType, AuditEventType> aMap = new HashMap<>();
        aMap.put(LOGIN, SUCCESSFUL_LOGIN);
        aMap.put(LOGOUT, SUCCESSFUL_LOGOUT);
        aMap.put(LOGIN_ERROR, FAILED_LOGIN);
        aMap.put(SEND_RESET_PASSWORD, PASSWORD_RESET_REQUEST);
        aMap.put(UPDATE_PASSWORD, PASSWORD_CHANGED);
        auth0EventMapping = Collections.unmodifiableMap(aMap);
    }

    /**
     * Get Audit event type by auth0 event code
     *
     * @param keycloakEvent code
     * @return AuditEventType
     */
    public static AuditEventType getAuditEventTypeByKeycloakEvent(EventType type) {
        AuditEventType event = auth0EventMapping.get(type);
        return event != null ? event : UNMAPPED_AUTH_EVENT;
    }
}
