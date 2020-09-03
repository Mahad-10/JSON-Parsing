package pk.codebase.jsonparse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pk.codebase.requests.HttpError;
import pk.codebase.requests.HttpRequest;
import pk.codebase.requests.HttpResponse;

public class MainActivity extends AppCompatActivity {
    final ArrayList<Handler> competition = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        HttpRequest request = new HttpRequest();
        request.setOnResponseListener(new HttpRequest.OnResponseListener() {
            @Override
            public void onResponse(HttpResponse response) {
                String end_date,style,start_date,name,enabled,detail,uid;
                if (response.code == HttpResponse.HTTP_OK) {
                    String jsonStr =response.text;
                    if (jsonStr != null) {
                        System.out.println("String not null");
                        try {
                            JSONArray jsonArray = new JSONArray(jsonStr);
                            int length = jsonArray.length();
                            for (int i = 0; i <= length; i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                end_date = jsonObject.getString("end_date");
                                style = jsonObject.getString("style");
                                start_date = jsonObject.getString("start_date");
                                name = jsonObject.getString("name");
                                enabled = jsonObject.getString("enabled");
                                detail = jsonObject.getString("detail");
                                uid = jsonObject.getString("uid");
                                competition.add(new Handler(end_date, style, start_date, name, enabled, detail,
                                        uid));
                                System.out.println("String added");
                                test();
                            }
                            System.out.println("String outside");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        request.setOnErrorListener(new HttpRequest.OnErrorListener() {
            @Override
            public void onError(HttpError error) {
                System.out.println("Error");
            }
        });

        request.get("http://donor-cola.bnr.la:5000/api/competition/");
    }
    public void test(){
        HandlerAdapter adapter =new HandlerAdapter( this,competition);
        listView = (ListView)findViewById(R.id.list1);
        listView.setAdapter(adapter);
    }

}