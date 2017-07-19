package uk.tryzub.dao.interfaces;



import uk.tryzub.entities.Dating;

import java.util.Date;
import java.util.List;


public interface DatingDAO {

    List<Dating> getDatings();
    List<Dating> getDatings(int section);
    List<Dating> getDatings(Date date);
    List<Dating> getDatings(String city);

}

