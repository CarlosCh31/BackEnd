package com.olimpiadas.inscriptionsback.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "talk_forum")
@PrimaryKeyJoinColumn(name = "id")
public class TalkForum extends Activity {

    @Column(length = 255)
    private String theme;

    @Column(name = "target_audience", length = 255)
    private String target_audience;

    public TalkForum(String theme, String targetAudience) {
        this.theme = theme;
        this.target_audience = targetAudience;
    }

    public TalkForum(Long id, String theme, String targetAudience) {
        super.setId(id);
        this.theme = theme;
        this.target_audience = targetAudience;
    }
}
