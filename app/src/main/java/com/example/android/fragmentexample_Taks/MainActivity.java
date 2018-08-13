/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.fragmentexample_Taks;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String STATE_FRAGMENT= "state_of_fragment";

    private Button button;
    private Boolean Fragment_state = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button =  findViewById(R.id.button_open);
        displayFragment();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Fragment_state){
                    displayFragment();
                }
                else  {
                        closeFragment();
                }
            }
        });

        if (savedInstanceState != null){
            Fragment_state =savedInstanceState.getBoolean(STATE_FRAGMENT);
            if(Fragment_state){
                button.setText(R.string.close);
            }
        }
    }
    public void displayFragment(){
        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container,simpleFragment).addToBackStack(null).commit();

        button.setText(R.string.close);

        Fragment_state = true;


    }
    public  void closeFragment(){
        android.app.FragmentManager fragmentManager = getFragmentManager();

        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);



        if (simpleFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.remove(simpleFragment).commit();

            button.setText(R.string.open);

            Fragment_state =false;

        }



    }
    public void onSaveInstanceState(Bundle savedinstancestate){
        savedinstancestate.putBoolean(STATE_FRAGMENT,Fragment_state);
        super.onSaveInstanceState(savedinstancestate);
    }
}
