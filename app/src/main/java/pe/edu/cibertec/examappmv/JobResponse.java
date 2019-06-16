package pe.edu.cibertec.examappmv;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JobResponse {

    private ArrayList<Job> jobs;

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }
}
