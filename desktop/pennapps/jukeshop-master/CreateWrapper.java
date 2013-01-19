package com.soundcloud.api;


import java.io.File;

/**
 * Creates an API wrapper instance, obtains an access token and serialises the wrapper to disk.
 * The serialised wrapper can then be used for subsequent access to resources without reauthenticating
 * @see GetResource
 */
public final class CreateWrapper {
    public static final File WRAPPER_SER = new File("wrapper.ser");

    public static void main(String[] args) throws Exception {
       
    	String[] args2 = new String[4];
    	
            final ApiWrapper wrapper = new ApiWrapper(
                    args2[0] = "d2d07b7f9b60f52746d250bf6be3f609" /* client_id */,
                    args2[1] = "8f9d54d283c2d08669410852df8ab655"/* client_secret */,
                    null    /* redirect URI */,
                    null    /* token */);
           
            Token token;
            
            if (args.length < 6) {
                token = wrapper.login(args2[2] = "mayankgupta173@gmail.com", args2[3] = "mkomko" /* password */);
            } else {
                token = wrapper.login(args2[2] /* login */, args2[3] /* password */, args2[5] /* scope */);
            }

            System.out.println("got token from server: " + token);

            // in this example the whole wrapper is serialised to disk -
            // in a real application you would just save the tokens and usually have the client_id/client_secret
            // hardcoded in the application, as they rarely change
            wrapper.toFile(WRAPPER_SER);

            System.out.println("wrapper serialised to " + WRAPPER_SER);
        }
    }

