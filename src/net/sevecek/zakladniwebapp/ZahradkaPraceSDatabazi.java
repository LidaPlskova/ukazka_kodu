package net.sevecek.zakladniwebapp;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Repository
public class ZahradkaPraceSDatabazi {

    @Autowired
    private JdbcTemplate pokladacDotazu;

    public List<Rostlina> nactiMojeRostliny() {

        return pokladacDotazu.query(
                "select rostliny.id, rostliny.nazev from zahradka join rostliny on zahradka.id_rostliny = rostliny.id",
                BeanPropertyRowMapper.newInstance(Rostlina.class)
        );
    }

    public List<Integer> nactiIdMychRostlin() {

        return pokladacDotazu.queryForList(
                "select id_rostliny from zahradka",
                Integer.class);
    }

    public List<Rostlina> nactiVsechnyRostliny() {

        return pokladacDotazu.query(
                "select * from rostliny",
                BeanPropertyRowMapper.newInstance(Rostlina.class)
        );
    }

    public Rostlina nactiDetailRostliny(int id) {

        return pokladacDotazu.queryForObject(
                "select * from rostliny WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Rostlina.class),
                id
        );
    }

    public void aktualizujZahradku(int[] rostliny) {

        pokladacDotazu.execute("delete from zahradka");

        if (rostliny == null) {
            return;
        }

        for (int id : rostliny) {
            pokladacDotazu.update("INSERT INTO zahradka VALUES  (?);", id);
        }

    }

    public List<String> nactiNazvyCinnosti() {
        return pokladacDotazu.queryForList(
                "select nazev from cinnosti;",
                String.class
        );
    }

    public List<CinnostVMesici> nactiCinnostiVMesicichProRostlinu(@PathVariable Integer id) {
        return pokladacDotazu.query(
                "select mesic, nazev as cinnost from cinnost_pro_rostlinu_v_mesici " +
                        "  join cinnosti on cinnost_pro_rostlinu_v_mesici.id_cinnosti = cinnosti.id " +
                        "  where id_rostliny= ? ",
                BeanPropertyRowMapper.newInstance(CinnostVMesici.class),
                id
        );
    }


}
