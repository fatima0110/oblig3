package oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KinobillettController {

    @Autowired
    KinobilletterRepository rep;

    @PostMapping("/lagre")
    public void lagreBilletter(Kinobilletter innBillett){
        rep.lagreKinobillett(innBillett);
    }
    @GetMapping("/hentAlle")
    public List<Kinobilletter> hentAlle(){ return rep.hentAlleKinobilletter();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlleKinobilletter();
    }


}
