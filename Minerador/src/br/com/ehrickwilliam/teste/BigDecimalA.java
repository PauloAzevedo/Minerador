/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.teste;

import java.math.BigDecimal;

/**
 *
 * @author Erick
 */
public class BigDecimalA {
 
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(1);
        BigDecimal c = new BigDecimal(9371);
        
        BigDecimal d = new BigDecimal(b.doubleValue() / c.doubleValue());
        System.out.println(d);
    }
}
