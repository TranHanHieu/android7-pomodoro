package com.example.hieuit.shipdoandem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginFaceBook extends AppCompatActivity {
    private static final String TAG = LoginFaceBook.class.toString();
    private LoginButton iv_loginFb;
    private TextView tv_info;
    private CallbackManager callbackManager;
    private Profile infoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login_face_book);
        getReferences();
        settupUI();
        addListener();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }



    private void addListener() {

        iv_loginFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            private ProfileTracker mProfileTracker;


            @Override
            public void onSuccess(LoginResult loginResult) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginFaceBook.this);
                progressDialog.setMessage("Procesando datos...");
                progressDialog.show();
                if (Profile.getCurrentProfile() == null) {
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                            // profile2 is the new profile
                            tv_info.setText("Info User : " + profile2.getName());
                            Log.v("facebook - profile", profile2.getFirstName());
                            mProfileTracker.stopTracking();
                            progressDialog.hide();
                        }
                    };
                    // no need to call startTracking() on mProfileTracker
                    // because it is called by its constructor, internally.
                } else {
                    Profile profile = Profile.getCurrentProfile();
                    tv_info.setText("Info User : " + profile.getName());

                    Log.v("facebook - profile", profile.getFirstName());
                }
            }
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                // App code
//                GraphRequest request = GraphRequest.newMeRequest(
//                        loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(
//                                    JSONObject object,
//                                    GraphResponse response) {
//                                object = response.getJSONObject();
//                                try {
//                                    Log.d(TAG, "onCompleted: "+ object.getString("email"));
//                                    //tv_info.setText("Name : "+object.getString("name"));
//                                    tv_info.setText("Name : "+object.getString("name")+ "\nEmail : "+object.getString("email") + "\nGender : "+object.getString("gender") );
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,email,gender,birthday");
//                request.setParameters(parameters);
//                request.executeAsync();
//
//
//            }


            @Override
            public void onCancel() {
                iv_loginFb.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException error) {
                iv_loginFb.setText("Login attempt failed.");
            }

        });


    }


    private void getReferences() {
        iv_loginFb = (LoginButton) findViewById(R.id.bt_loginFaceBook);
        tv_info = (TextView) findViewById(R.id.tv_facebook);
    }

    private void settupUI() {

    }
}
