package com.example.kaitzer.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by KaiTzer on 14-May-16.
 */

public interface ItemClickListener {

    void onClick (View view, int position, boolean isLongClick);
    }

