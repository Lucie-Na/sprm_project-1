package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprm_project.R;

import java.util.ArrayList;

import models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    ArrayList<Post> listPost;
    final onPostListener mOnPostListener;

    public PostAdapter(ArrayList<Post> listPost, onPostListener onPostListener) {
        this.listPost = listPost;
        this.mOnPostListener = onPostListener;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostAdapter.ViewHolder(v,mOnPostListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.pp.setImageResource(listPost.get(position).getUser().getPp());

        String name = listPost.get(position).getUser().getLastName() +" "+listPost.get(position).getUser().getFirstName();
        holder.postName.setText(name);
        holder.postUsername.setText(listPost.get(position).getUser().getUsername());

        holder.postTimer.setText("");

        holder.postContent.setText(listPost.get(position).getContent());
        holder.postDate.setText(listPost.get(position).getDate());

        holder.postNbComment.setText(listPost.get(position).nbComment());
        holder.postNbRepost.setText(listPost.get(position).nbRepost());
        holder.postNbFav.setText(listPost.get(position).nbFav());

        holder.postBtnCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.postBtnRepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.postBtnFav.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        holder.postBtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return  listPost.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView pp;
        TextView postName,postUsername,postTimer,postContent,postDate,postNbComment,postNbRepost,postNbFav;
        Button postBtnMore, postBtnCom, postBtnRepost, postBtnFav;
        onPostListener onPostListener;

        public ViewHolder(@NonNull View itemView, onPostListener onPostListener) {
            super(itemView);
            pp = itemView.findViewById(R.id.pp);

            postName = itemView.findViewById(R.id.post_name);
            postUsername = itemView.findViewById(R.id.post_username);
            postTimer = itemView.findViewById(R.id.post_timer);
            postContent = itemView.findViewById(R.id.post_content);
            postDate = itemView.findViewById(R.id.post_date);
            postNbComment = itemView.findViewById(R.id.post_nb_comment);
            postNbRepost = itemView.findViewById(R.id.post_nb_repost);
            postNbFav = itemView.findViewById(R.id.post_nb_fav);

            postBtnMore = itemView.findViewById(R.id.post_btn_more);
            postBtnCom = itemView.findViewById(R.id.post_btn_comment);
            postBtnRepost = itemView.findViewById(R.id.post_btn_repost);
            postBtnFav = itemView.findViewById(R.id.post_btn_fav);

            this.onPostListener = onPostListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPostListener.onPostClick(getAdapterPosition());
        }
    }

    public interface onPostListener{
        void onPostClick(int position);
    }



}
