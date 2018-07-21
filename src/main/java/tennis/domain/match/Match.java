package tennis.domain.match;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tennis.domain.player.Player;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
@lombok.NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne
    @NonNull
    private Player player1;

    @OneToOne
    @NonNull
    private Player player2;

    @OneToOne
    private Player winner;

    private String score;

    private LocalDate matchDate;

    @NonNull
    private LocalDate creationDate;

    private String result;

    private byte winnerPoints;

    private byte loserPoints;


}
