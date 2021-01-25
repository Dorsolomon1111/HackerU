package com.hackeruannotations;

/**
 * Created By dorso on 06/01/2021
 **/
public class Dog {

    public void preformAction(@DogAction int actionType) {
        switch (actionType) {
            case DogAction.BARKING:

                break;
            case DogAction.EATING:

                break;
            case DogAction.SLEEPING:

                break;
            case DogAction.WALKING:

                break;
        }
    }
}
