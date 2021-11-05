/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author JR
 */
public class utilidad {
static DateFormat dateFormatQSL = new SimpleDateFormat("yyyy-MM-dd");
static DateFormat dateFormatQSLhora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
    public static String fecha(){
       Calendar hoy = Calendar.getInstance();
                Date hoydia = hoy.getTime(); 
         return dateFormatQSL.format(hoydia);
    }
    public static String fecha_hora(){
               Calendar hoy = Calendar.getInstance();
                Date hoydia = hoy.getTime(); 
         return dateFormatQSLhora.format(hoydia);
    }
}
