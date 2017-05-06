package org.casino.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 18.02.2017.
 */

public class Bone implements IBones {

    public int getNumber() {
        return (int)(Math.random()*6 + 1);
    }

}
