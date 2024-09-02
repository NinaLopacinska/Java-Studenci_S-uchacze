/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectstudentsluchacz.domain;

import com.mycompany.mavenprojectstudentsluchacz.domain.Osoba;

/**
 *
 * @author 48514
 */
public class Sluchacz extends Osoba{
    private boolean czyZarejestrowany;
    
    public boolean isCzyZarejestrowany() {
        return czyZarejestrowany;
    }

    public void setCzyZarejestrowany(boolean czyZarejestrowany) {
        this.czyZarejestrowany = czyZarejestrowany;
    }
    
}
