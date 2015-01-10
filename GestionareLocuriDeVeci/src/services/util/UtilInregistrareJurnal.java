package services.util;

import java.sql.Timestamp;
import java.util.Date;

import domain.InregistrareJurnal;

public class UtilInregistrareJurnal {
	public static InregistrareJurnal creeazaInregistrareJurnal(String user, String operatie, String entitate, String... entitateModificata ){
	     InregistrareJurnal inregistrareJurnal = new InregistrareJurnal();
	     Timestamp timestamp = new Timestamp(new Date().getTime());
	     inregistrareJurnal.setDataOra(timestamp);
	     inregistrareJurnal.setUser(user);
	     StringBuilder detaliiModificare = new StringBuilder();
	     detaliiModificare.append("S-a efectuat operatia de ");
	     detaliiModificare.append(operatie);
	     detaliiModificare.append(" pe entitatea ");
	     detaliiModificare.append(entitate);
	     if (operatie.equals("actualizare")){
	    	 detaliiModificare.append(" rezultand entitatea ");
	    	 detaliiModificare.append(entitateModificata[0]);
	     }
	     inregistrareJurnal.setDetaliiModificare(detaliiModificare.toString());
	     return inregistrareJurnal;
	}
}
