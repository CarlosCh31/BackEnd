package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Repositories.TalkForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class TalkForumServiceImpl implements TalkForumService {

    @Autowired
    private TalkForumRepository talkForumRepository;

    @Override
    public String saveTalkForum(
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
    ) {
        return talkForumRepository.saveTalkForum(
                type, name, description, date, time, duration, modality, location,
                maxParticipants, minimumAge, maximumAge, adminEmail, state, theme, targetAudience
        );
    }
}

