package com.example.architecture1;

import android.view.View;

import com.example.architecture1.model.BooksModel;

public interface Click {

    void onItemClick (int position, BooksModel booksModel, View view);
}
