package com.example.luo.loginandlogout.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.modules.User;
import com.example.luo.loginandlogout.data.util.DrawableUtil;

import java.util.List;

public class UsersAdapters extends RecyclerView.Adapter<UsersAdapters.UserViewHolder> {

    private final String TAG = "AdaptersLogs";
    private List<User> userList;

    public UsersAdapters(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_user, viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + i);
        User user = userList.get(i);

        userViewHolder.mIconUrl.setImageResource(DrawableUtil.getResourceByReflect(user.getUserIconUrl()));
        userViewHolder.mUserName.setText("Name: " + user.getUserName());
        userViewHolder.mAge.setText("Age: " + String.valueOf(user.getAge()));
        userViewHolder.mEmail.setText("Email: " + user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIconUrl;
        private TextView mUserName;
        private TextView mAge;
        private TextView mEmail;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mIconUrl = itemView.findViewById(R.id.user_image_view);
            mUserName = itemView.findViewById(R.id.user_name_text_view);
            mAge = itemView.findViewById(R.id.age_text_view);
            mEmail = itemView.findViewById(R.id.email_text_view);
        }
    }
}
