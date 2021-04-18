package oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KinobilletterRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreKinobillett(Kinobilletter kinobillett) {
        String sql = "INSERT INTO Kinobilletter (film, antall, fornavn, etternavn, telefonnr, epost) VALUES(?,?,?,?,?)";

        db.update(sql, kinobillett.getFilm(), kinobillett.getAntall(), kinobillett.getFornavn(), kinobillett.getEtternavn(),
                kinobillett.getTelefonnr(), kinobillett.getEpost());
    }

    public List<Kinobilletter> hentAlleKinobilletter() {
        String sql = "SELECT * FROM Kinobilletter";
        List<Kinobilletter> alleKinobilletter = db.query(sql, new BeanPropertyRowMapper(Kinobilletter.class));
        return alleKinobilletter;
    }

    public void slettAlleKinobilletter() {
            String sql = "DELETE FROM Kinobilletter";
            db.update(sql);
    }
}
