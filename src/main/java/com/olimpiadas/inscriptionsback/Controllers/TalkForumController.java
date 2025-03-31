package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Models.TalkForum;
import com.olimpiadas.inscriptionsback.Service.TalkForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/talk-forums")
@CrossOrigin(origins = "http://localhost:4200")
public class TalkForumController {

    @Autowired
    private TalkForumService talkForumService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> saveTalkForum(@RequestBody TalkForum talkForum) {
        talkForum.setAdminEmail(new Administrator("admin@example.com", "admin"));
        String result = talkForumService.saveTalkForum(
                talkForum.getType(),
                talkForum.getName(),
                talkForum.getDescription(),
                Date.valueOf(talkForum.getDate()),
                Time.valueOf(talkForum.getTime()),
                talkForum.getDuration(), // Debe ser en formato: "1 hour 30 minutes"
                talkForum.getModality(),
                talkForum.getLocation(),
                talkForum.getMaxParticipants(),
                talkForum.getMinimumAge(),
                talkForum.getMaximumAge(),
                talkForum.getAdministrator().getEmail(), // acceso al administrador
                talkForum.getState(),
                talkForum.getTheme(),
                talkForum.getTarget_audience()
        );

        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        return ResponseEntity.ok(response);
    }
}

