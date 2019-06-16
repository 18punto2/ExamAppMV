package pe.edu.cibertec.examappmv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.layoutJob> {

    ArrayList<Job> jobs;

    public JobAdapter(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }
    @NonNull
    @Override
    public layoutJob onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.job_item, viewGroup, false);

        layoutJob itemJob = new layoutJob(view);
        return itemJob;


    }

    @Override
    public void onBindViewHolder(@NonNull layoutJob layoutJob, int i) {
        layoutJob.tvTitle.setText(jobs.get(i).getTitle());
        layoutJob.tvCompany .setText(jobs.get(i).getCompany());
        layoutJob.tvDescription.setText(jobs.get(i).getDescription());
        Glide.with(layoutJob.itemView).
                load("https://jobs.github.com/rails/active_storage/blobs/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBakJoIiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--61410c2a7e6b8a997423a068f576d26c4b8e3985/"+ jobs.get(i).getCompany() +".png"
                )
                .into(layoutJob.ivPoster);
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
    public class layoutJob extends RecyclerView.ViewHolder {
        TextView tvTitle,tvCompany,tvDescription;
        ImageView ivPoster;

        public layoutJob(@NonNull View itemView) {
            super(itemView);

            tvTitle =itemView.findViewById(R.id.tvTitle);
            tvCompany =itemView.findViewById(R.id.tvCompany);
            tvDescription =itemView.findViewById(R.id.tvDescription);
            ivPoster=itemView.findViewById(R.id.ivLogo);

        }
    }

}
