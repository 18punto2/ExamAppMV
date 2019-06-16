package pe.edu.cibertec.examappmv;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Job> items;
    JobAdapter jobAdapter;
    RecyclerView rvJob;
    EditText etJob;
    Button btSearch;

    private void searchJob() {
        String name = etJob.getText().toString();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        JobInterface jobInterface=retrofit.create(JobInterface.class);

        Call<ArrayList<Job>> methodSearch=jobInterface.searchJob(name);

        methodSearch.enqueue(new Callback<ArrayList<Job>>() {
            @Override
            public void onResponse(Call <ArrayList<Job>> call, Response<ArrayList<Job>> response) {
                if(response.isSuccessful()){
                    ArrayList<Job> jobResponse=response.body();


                    jobAdapter = new JobAdapter(jobResponse);
                    rvJob.setAdapter(jobAdapter);
                    rvJob.setLayoutManager
                            (new LinearLayoutManager(MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Job>> call, Throwable t) {
                Log.d("MainActivity", t.toString());
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etJob =findViewById(R.id.etJob);
        btSearch =findViewById(R.id.btSearch);
        rvJob=findViewById(R.id.rvJobs);


        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchJob();

            }
        });
    }


}
