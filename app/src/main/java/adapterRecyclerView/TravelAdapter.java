package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.sprm_project.R;

import models.Travel;

public class TravelAdapter  extends RecyclerView.Adapter<TravelAdapter.ViewHolder>{

    ArrayList<Travel> listTravel;
    final onTravelListener mOnTravelListener;

    public TravelAdapter(ArrayList<Travel> listTravel, onTravelListener onTravelListener){
        this.listTravel = listTravel;
        this.mOnTravelListener = onTravelListener;
    }


    @NonNull
    @Override
    public TravelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.travel_item,parent,false);
        return new TravelAdapter.ViewHolder(v,mOnTravelListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelAdapter.ViewHolder holder, int position) {

        String destination = listTravel.get(position).getCountry() +", "+ listTravel.get(position).getCity() +", "+ listTravel.get(position).getInstitution();
        holder.travelDestination.setText(destination);
        holder.travelProgram.setText(listTravel.get(position).getProgram());
        holder.travelDuration.setText(listTravel.get(position).getDuration());

        holder.flag.setImageResource(listTravel.get(position).getFlag());
    }

    @Override
    public int getItemCount() {
        return listTravel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView flag;
        TextView travelDestination, travelProgram, travelDuration;
        onTravelListener onTravelListener;

        public ViewHolder(@NonNull View itemView, onTravelListener onTravelListener){
            super(itemView);

            flag = itemView.findViewById(R.id.travel_flag);

            travelDestination = itemView.findViewById(R.id.travel_destination);
            travelProgram = itemView.findViewById(R.id.travel_program);
            travelDuration = itemView.findViewById(R.id.travel_duration);

            this.onTravelListener = onTravelListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {onTravelListener.onTravelClick(getAdapterPosition());}

    }

    public interface onTravelListener{void onTravelClick(int position);}

}
