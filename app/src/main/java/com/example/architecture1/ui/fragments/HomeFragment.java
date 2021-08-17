 package com.example.architecture1.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.architecture1.Click;
import com.example.architecture1.R;
import com.example.architecture1.databinding.FragmentHomeBinding;
import com.example.architecture1.model.BooksModel;
import com.example.architecture1.ui.activity.BookClient;
import com.example.architecture1.ui.adapters.BooksAdapter;

import java.util.ArrayList;

 public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    BooksAdapter adapter = new BooksAdapter();
    BookClient viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setUpView();
        setUpList();
        setItem();


    }

    private void setItem() {
        adapter.setClick(new Click() {
            @Override
            public void onItemClick(int position, BooksModel booksModel, View view) {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment2(booksModel).setDesc(booksModel));
            }
        });
    }


    private void setUpList() {
        setClickButton();
    }

    private void setClickButton() {
        binding.btnFill.setOnClickListener(v -> {
            binding.btnFill.setVisibility(View.GONE);
            viewModel.getData();
        });
            viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<BooksModel>>() {
                @Override
                public void onChanged(ArrayList<BooksModel> booksModels) {
                    adapter.getList(booksModels);
                }
            });
    }

    private void setUpView() {
        setRecycler();
    }

    private void setRecycler() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void initView() {
        viewModel = new ViewModelProvider(this).get(BookClient.class);

    }
}