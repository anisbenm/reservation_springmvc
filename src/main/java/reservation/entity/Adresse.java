/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class Adresse {
    Short num;
    String rue;
    String localite;
    Long codePostal;
    String pays;
}
