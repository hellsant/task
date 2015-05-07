/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas
 */
public class Profile {

    private final List<Acount> acount;
    public Profile() {
        acount = new ArrayList();
        addAcount();
    }

    public boolean validateAcount(String name, String password) {
        for (Acount acount1 : acount) {
            if(name.equals(acount1.getName())&& password.contains(acount1.getPassword())){
                return true;
            }
        }
        return false;
    }

    private void addAcount(){
        acount.add(new Acount("douglas","123"));
        acount.add(new Acount("juan","123123"));
        acount.add(new Acount("pedro","123123123"));
    }
}
