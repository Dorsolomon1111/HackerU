package com.hackeruannotations;

import android.Manifest;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private String theData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnalyticsManager.sendAnalytic(AnalyticsManager.Analytics.ON_BOARDING);

        /*Female female = new Female();
        female.doSomething();


        Dog dog = new Dog();
        dog.preformAction(DogAction.BARKING);

        theData = null;

        String data = null;
        splitString(data);

        String xx = x();
        if (xx != null) {
            String[] xxx = xx.split(" ");
        }*/

        AnalyticsManager.sendAnalytic(AnalyticsManager.Analytics.SIGN_UP);


        //String getString = string(R.string.app_name);

        //int color = color(R.color.black);

        //Drawable drawable = drawable(R.drawable.ic_launcher_background);


        //inflateLayout(R.layout.activity_main);

        //orderDrink(73);

        //@FloatRange(from = 1.2, to = 2.5) float height, @FloatRange(from = 40, to = 150)

        //int bmiResult = calculateBmi(1.2f, 150f);

        //int thisIsALargeNumber = 1_0_0_0_0_0_0;

        //String x = doSomethingToName("sdfsd");
        //String[] xxx = x.split(" ");

        //if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

        //    return;
        //}
        //accessCameraAndDoSomething();

        AnalyticsManager.sendAnalytic(AnalyticsManager.Analytics.HOME);


        AnalyticsManager.sendAnalytic(AnalyticsManager.Analytics.SETTINGS);
    }

    //Runtime exception
    //Compile time exception

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @NonNull
    private String x() {
        return "null";
    }


    public void splitString(@Nullable String data) {
        if (data != null) {
            String[] newData = data.split(" ");
        }
    }

    public String string(@StringRes int data) {
        return getString(data);
    }

    public int color(@ColorRes int colorId) {
        return ActivityCompat.getColor(this, colorId);
    }

    public Drawable drawable(@DrawableRes int drawableId) {
        return ContextCompat.getDrawable(this, drawableId);
    }

    public void inflateLayout(@LayoutRes int layoutRes) {
        LayoutInflater.from(this).inflate(layoutRes, null, false);
    }

    public void orderDrink(@IntRange(from = 18, to = 75) int age) {
        // TODO: 06/01/2021 Order drink
    }

    public int calculateBmi(@FloatRange(from = 1.2, to = 2.5) float height, @FloatRange(from = 40, to = 150) float weight) {
        return -1;
    }

    @Nullable
    public String doSomethingToName(@Size(min = 2, max = 10) String name) {
        return null;
    }

    @RequiresPermission(Manifest.permission.READ_CONTACTS)
    public void accessCameraAndDoSomething() {

    }
}


/*
 * Annotations - Annotations are a way to add meta-data to our source code.
 * They enable us add functionality to our code with minimum effort.
 * We can add annotations to: classes, variables, functions
 */

/*
 * @Override - Indicate that the function were overriding is a function that comes from one of our parent classes/interfaces.
 * @NonNull - Indicate that the parameter can't be null/that the function return value won't be null/that the variable can't be assigned with a null value.
 * @Nullable - Indicate that the parameter can be null/that the function return value can be null/that the variable can be assigned with a null value.
 */

/*
 * Resources annotations:
 * @StringRes - The parameter must be of type R.string.something and not simple an integer
 * @ColorRes -  The parameter must be of type R.color.something and not simple an integer
 * @DrawableRes -  The parameter must be of type R.drawable.something and not simple an integer
 * @LayoutRes -  The parameter must be of type R.layout.something and not simple an integer
 */

/*
 * Value Constraint Annotations:
 * @Size - Size measure couple of things:
 *      1. String.
 *      2. Array/Collection
 * It can have, an exact value, a min value, a max value or a multiple value.
 * @IntRange - The parameter must be an integer between the value from - to, we can define just from/to because each one of them
 * as a default value.
 * @FloatRange - The parameter must be a float between the value from - to, we can define just from/to because each one of them
 * as a default value.
 */

/*
 * Permission Annotations:
 * @RequiresPermission - Forces the caller of the function to add the permission to the Manifest.xml file
 * AND add a check before the calling of the function, whether the permission is granted or not.
 */

/*
 * @CallSuper - Forces sub classes that override the function to call the super implementation.
 */

/*
 * What are the advantages of using @IntDef @StringDef?
 * 1. The code is more readable.
 * 2. The code is more organized.
 * 3. The code is cleaner and easier to maintain.
 * 4. Provide us failure notifying.
 * 5. Help us avoid mistakes.
 */

/*
 * Device ----> Server ------> Database
 * Device <---- Server <------ Database
 *
 * Room
 */