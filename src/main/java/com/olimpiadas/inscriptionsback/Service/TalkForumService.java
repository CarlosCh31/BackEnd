package com.olimpiadas.inscriptionsback.Service;

import java.sql.Date;
import java.sql.Time;

public interface TalkForumService {
    String saveTalkForum(
            String type,
            String name,
            String description,
            Date date,
            Time time,
            String duration,
            String modality,
            String location,
            Integer maxParticipants,
            Integer minimumAge,
            Integer maximumAge,
            String adminEmail,
            String state,
            String theme,
            String targetAudience
    );
}

