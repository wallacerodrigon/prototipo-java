/**
 * 
 */
package br.jus.trf1.api.utilitarios;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


/**
 * @author wallace
 *
 */
public class UtilFormatador {

	public static String formatarDecimal(BigDecimal valor){
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.'); 		
		return new DecimalFormat("###,###,##0.00", simbolos).format(valor);
	}
	
	public static String formatarTelefone(String numero) {
		if (numero != null && numero.length() == 11) {
			return "("+numero.substring(0, 2)+")"+numero.substring(2, 7)+"-"+numero.substring(7);
		} else if (numero != null && numero.length() == 10) {
			return "("+numero.substring(0, 2)+")"+numero.substring(2, 6)+"-"+numero.substring(6);
		} else {
			return "-";
		}
	}
	
	public static BigDecimal formatarStringComoValor(String numero) {
		if (numero != null) {
			return new BigDecimal(numero.indexOf(",") > -1 ? numero.replaceAll(",", ".") : numero);
		} else {
			return null;
		}
	}
	
	

}
