package com.jason9075.javaannotationplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jason9075.javaannotationplayground.annotation.MyAnnotation;
import com.jason9075.javaannotationplayground.model.MyModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyModel myModel = new MyModel("value 1", "value 2", "value 3");

        for (Method method : myModel.getClass().getDeclaredMethods()) {
            MyAnnotation myAnnotation;
            String annotationValue = "(null)";

            if (method.isAnnotationPresent(MyAnnotation.class)) {
                myAnnotation = method.getAnnotation(MyAnnotation.class);
                annotationValue = myAnnotation.value();
            }

            try {
                Object response = method.invoke(myModel);
                System.out.println(">>> Method Name:" + method.getName() +
                        " return:" + response +
                        " annotation value:" + annotationValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
                System.out.println(">>> Unidentified Method:" + method.getName());
            }
        }

    }

}
