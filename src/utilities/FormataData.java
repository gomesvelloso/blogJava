package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
	
	
	public String dataTela(Date data) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
	
	public String dataBanco(Date data) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(data);
	}
	
	

}
