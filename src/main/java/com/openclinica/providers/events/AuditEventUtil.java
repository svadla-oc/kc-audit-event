package com.openclinica.providers.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.openclinica.providers.events.domain.AuditEventDTO;
import com.openclinica.providers.events.domain.enumeration.AuditEventType;
import org.keycloak.events.Event;
import org.keycloak.events.EventType;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;

import static com.openclinica.providers.events.domain.enumeration.AuditEventType.getAuditEventTypeByKeycloakEvent;

public class AuditEventUtil {
    AuditEventDTO auditEvent;

    public AuditEventUtil() {
        this.auditEvent = new AuditEventDTO();
    }
    public AuditEventUtil(AuditEventDTO auditEvent) {
        this.auditEvent = auditEvent;
    }

    public void setAuditEvent(Event e) {
        auditEvent.setModifiedBy(e.getUserId());
        auditEvent.setServiceName("Keycloak Audit");
        auditEvent.setTargetObject(e.getRealmId());
        auditEvent.setTimestamp(Instant.ofEpochMilli(e.getTime()));
        auditEvent.setType(getEventType(e.getType());
    }

    private AuditEventType getEventType(EventType et) {
        AuditEventType type = getAuditEventTypeByKeycloakEvent(et);
        return type;
    }

    public void sendAuditEvent() {
        try {
            System.out.println("***************in sendAuditEvent:*******************");
            ObjectMapper mapper = new ObjectMapper();

            mapper.registerModule(new JavaTimeModule());

            String jsonData = mapper.writeValueAsString(auditEvent);
            URL object=new URL("https://build.openclinica-dev.io/audit-service/api/keycloak/audit-events");

            HttpURLConnection con = (HttpURLConnection) object.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");
            OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
            wr.write(jsonData);
            wr.flush();
            int HttpResult = con.getResponseCode();
            wr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
