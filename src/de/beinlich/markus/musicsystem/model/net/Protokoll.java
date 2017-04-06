/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.musicsystem.model.net;

import java.io.*;
import java.util.*;

/**
 *
 * @author Markus Beinlich
 */
public class Protokoll implements Serializable {

    private final ProtokollType protokollType;
    private Object value;

    public Protokoll(ProtokollType protokollType, Object value) throws InvalidObjectException {
        this.protokollType = protokollType;
//        if (value.getClass() != protokollType.getClasss()) {
//        if (Arrays.asList(value.getClass().getClasses()).contains(protokollType.getClasss())) {
        if (! protokollType.getClasss().isInstance(value)) {
            throw new InvalidObjectException(protokollType.getClasss() + " expected. " + value.getClass() + " not valid.");
        }
        this.value = value;
    }

    /**
     * @return the protokollType
     */
    public ProtokollType getProtokollType() {
        return protokollType;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.protokollType.name() + " - " + this.value.toString();
    }
}
