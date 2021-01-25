package com.hackeruannotations;

import androidx.annotation.IntDef;

import static com.hackeruannotations.DogAction.BARKING;
import static com.hackeruannotations.DogAction.EATING;
import static com.hackeruannotations.DogAction.SLEEPING;
import static com.hackeruannotations.DogAction.WALKING;

/**
 * Created By dorso on 06/01/2021
 **/
@IntDef({EATING, WALKING, SLEEPING, BARKING})
@interface DogAction {
    int EATING = 0;
    int WALKING = 1;
    int SLEEPING = 2;
    int BARKING = 3;
}