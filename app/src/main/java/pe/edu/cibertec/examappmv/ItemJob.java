package pe.edu.cibertec.examappmv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class ItemJob extends RecyclerView.ViewHolder {
    TextView tvTitle,tvCompany,tvDescription;
    ImageView ivPoster;

    public ItemJob(@NonNull View itemView) {
        super(itemView);

        tvTitle =itemView.findViewById(R.id.tvTitle);
        tvCompany =itemView.findViewById(R.id.tvCompany);
        tvDescription =itemView.findViewById(R.id.tvDescription);
        ivPoster=itemView.findViewById(R.id.ivLogo);

    }
}
