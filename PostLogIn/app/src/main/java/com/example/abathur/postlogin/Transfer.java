package com.example.abathur.postlogin;

import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abathur on 2015/3/20
 *
 * This class is for the data transfer between UI and POST/BEACON.
 */
public class Transfer
{
    //Purpose of this transfer ( log in, search, etc.)
    private int purpose;

    // Data to send/receive
    private List<NameValuePair> params;

    public Transfer(List<NameValuePair> params, int purpose)
    {
        this.params = params;

        this.purpose = purpose;
    }

    public void setParams(List<NameValuePair> params)
    {
        // Set the params
        this.params = params;
    }

    public void setPurpose(int purpose)
    {
        // Set the purpose
        this.purpose = purpose;
    }

    public int SendRequest()
    {
        // Send the request
        // All information is sent through this method

        // result of the request/transmit, 0 for success
        int result = -1;

        switch(this.purpose)
        {
            // Different cases for different purpose

            case Definition.LOGIN_POST:
            {
                // Post request for Log in
                result = 0;
            }

            case Definition.BEACON_INFO_UPLOAD:
            {
                // Post request for uploading beacon info

            }

            case Definition.SEARCH_REQUEST:
            {
                // Request for Search

            }

        }

        return result;
    }


}
