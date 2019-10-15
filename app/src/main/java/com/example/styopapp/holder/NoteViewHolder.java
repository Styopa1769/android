package com.example.styopapp.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.styopapp.R;
import com.example.styopapp.activity.NoteDetailActivity;
import com.example.styopapp.model.Note;

import java.text.DateFormat;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView noteTextView;
    private TextView noteDateView;
    private TextView noteTitleView;
    private ImageView noteImageView;
    private long id;

    public NoteViewHolder(final View itemView) {
        super(itemView);
        noteTextView = itemView.findViewById(R.id.noteTextView);
        noteDateView = itemView.findViewById(R.id.noteDateView);
        noteTitleView = itemView.findViewById(R.id.noteTitleView);
        noteImageView = itemView.findViewById(R.id.noteImageView);
        noteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Context context = v.getContext();
                context.startActivity(NoteDetailActivity.getIntent(context, id));
            }
        });
    }

    public void bind(final Note note) {
        noteTextView.setText(note.getText());

        DateFormat formatter = DateFormat.getDateInstance();
        noteDateView.setText(formatter.format(note.getDate()));

        noteTitleView.setText(note.getTitle());
        noteImageView.setImageDrawable(itemView.getContext().getDrawable(note.getDrawableIdRes()));

        id = note.getId();
    }
}