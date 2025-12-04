package com.example.coach.model;

import junit.framework.TestCase;

import java.util.Date;

public class ProfilTest extends TestCase {

    private Profil profilMaigre = new Profil (45, 170, 20, 0, new Date());
    private Profil profilNormal = new Profil (70, 180, 40, 1, new Date());
    private Profil profilGras = new Profil (67, 165, 35, 0, new Date());

    public void testGetImg() {
        assertEquals(17.9, profilMaigre.getImg(), 0.1);
        assertEquals(18.9, profilNormal.getImg(), 0.1);
        assertEquals(32.2, profilGras.getImg(), 0.1);
    }

    public void testGetMessage() {
        assertEquals("trop faible", profilMaigre.getMessage());
        assertEquals("normal", profilNormal.getMessage());
        assertEquals("trop élevé", profilGras.getMessage());
    }

    public void testGetImage() {
        assertEquals("maigre", profilMaigre.getImage());
        assertEquals("normal", profilNormal.getImage());
        assertEquals("graisse", profilGras.getImage());
    }

    public void testNormal() {
        assertFalse(profilMaigre.normal());
        assertTrue(profilNormal.normal());
        assertFalse(profilGras.normal());
    }
}