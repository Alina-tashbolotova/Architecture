package com.example.architecture1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.architecture1.databinding.FragmentDetailBinding;
import com.example.architecture1.model.BooksModel;
import com.example.architecture1.ui.activity.BookClient;

import org.jetbrains.annotations.NotNull;


public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    BookClient viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
}

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        getInform();
    }

    private void getInform() {
        BooksModel booksModel = DetailFragmentArgs.fromBundle(getArguments()).getDesc();
        binding.imageView.setImageResource(booksModel.getImage());
        binding.txtTitle.setText(booksModel.getTitle());
        binding.txtDesc.setText(booksModel.getDescription());
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(BookClient.class);
    }
}