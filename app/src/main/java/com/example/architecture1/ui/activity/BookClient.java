package com.example.architecture1.ui.activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architecture1.R;
import com.example.architecture1.model.BooksModel;

import java.util.ArrayList;

public class BookClient extends ViewModel {


    public MutableLiveData<ArrayList<BooksModel>> liveData = new MutableLiveData<>();

    ArrayList<BooksModel> list = new ArrayList<>();

    public  void  getData() {
        list.add(new BooksModel(R.drawable.tat, "Татьяна Устинова", "Девочки я приехал!"));
        list.add(new BooksModel(R.drawable.bisnes, "Эрик Рис", "Бизнес с нуля"));
        list.add(new BooksModel(R.drawable.djon, "Джон Кехо", "Подсознание может все"));
        list.add(new BooksModel(R.drawable.reka, "Джон харт", "Вниз по реке"));
        liveData.setValue(list);
    }
}
