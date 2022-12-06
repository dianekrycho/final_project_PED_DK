package com.example.final_project_ped_dk;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import java.util.Map;

public interface LoginModule {
    void initialize(Subject subject, CallbackHandler callbackHandler,
                    Map<String, ?> sharedState, Map<String, ?> options);
    boolean login() throws LoginException;
    boolean commit() throws LoginException;
    boolean abort() throws LoginException;
    boolean logout() throws LoginException;
}