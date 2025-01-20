package com.example.navigationdrawers.ui.acerca;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navigationdrawers.R;
import com.example.navigationdrawers.databinding.FragmentAcercaBinding;
import com.example.navigationdrawers.databinding.FragmentHomeBinding;
import com.example.navigationdrawers.ui.home.HomeViewModel;

public class AcercaFragment extends Fragment {

    private FragmentAcercaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AcercaViewModel AcercaViewModel =
                new ViewModelProvider(this).get(AcercaViewModel.class);

        binding = FragmentAcercaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtcerca;
        AcercaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}