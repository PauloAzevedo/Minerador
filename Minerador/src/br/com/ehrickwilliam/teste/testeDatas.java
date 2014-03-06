/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.bibliotecas.Util;
import java.util.Calendar;

/**
 *
 * @author Erick
 */
public class testeDatas {
    
    public static void main(String[] args) {
        Calendar dataT = Util.stringToCalendar("22/09/2010");
        Calendar dataAgora = Util.stringToCalendar("05/04/2014");
        Calendar dataAntiga = Util.stringToCalendar("05/04/2013");
  
     
        System.out.println("Agora: "+(1.0 / (dataAgora.getTimeInMillis() - dataT.getTimeInMillis())));
        System.out.println("Antiga: "+(1.0 / (dataAntiga.getTimeInMillis() - dataT.getTimeInMillis())));
       
    }
    
}
