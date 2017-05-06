package org.casino.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 18.02.2017.
 */
@Component
@Scope("prototype")
public class Casino implements ICasino {

    @Autowired // чтобы назначил объект
    IBones number;

    public Casino() {

    }

    public void throwBones() {
        System.out.println(number);
        int first = number.getNumber();
        int second = number.getNumber();

        System.out.println( "Casino{" + "first=" + first + ", second=" + second + '}' );
        int summa = first + second;
        if ( summa > 10 ) {
            System.out.println( "Summa: " + summa + ", вы выйграли" );
        } else if(summa < 10) {
            System.out.println( "Summa: " + summa + ", вы проиграли" );
        } else {
            System.out.println( "Summa: " + summa + ", ничья" );

        }

    }

}
