package com.userslist.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.userslist.R;
import com.userslist.adapter.UsersAdapter;
import com.userslist.databinding.FragmentUsersBinding;
import com.userslist.db.entitiy.User;
import com.userslist.factory.UsersViewModelFactory;
import com.userslist.viewmodel.UsersViewModel;

/**
 * Created By dorso on 24/01/2021
 **/
public class UsersFragment extends Fragment {

    private FragmentUsersBinding binder;

    private UsersAdapter usersAdapter;

    private UsersViewModel usersViewModel;

    public UsersFragment() {
        super(R.layout.fragment_users);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersViewModel = new ViewModelProvider(this, new UsersViewModelFactory(requireContext())).get(UsersViewModel.class);
        usersViewModel.getUsers().observe(getViewLifecycleOwner(), users -> usersAdapter.submitList(users));
        binder = FragmentUsersBinding.bind(view);
        binder.recyclerUsers.setHasFixedSize(true);
        binder.recyclerUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
        usersAdapter = new UsersAdapter();
        binder.recyclerUsers.setAdapter(usersAdapter);
        binder.fabAddUser.setOnClickListener(
                Navigation.createNavigateOnClickListener(UsersFragmentDirections.actionUsersFragmentToAddUserFragment())
        );

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                User user = usersAdapter.getCurrentList().get(viewHolder.getAdapterPosition());
                usersViewModel.deleteUser(user);
                Toast.makeText(requireContext(), user.getName() + " Deleted!", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(binder.recyclerUsers);

        //Fragment - ViewModel - Repo - Database
        //MVVM

        getContext(); //Return context, this is nullable, meaning it can return null
        getActivity(); //Return Activity, this is nullable, meaning it can return null
        requireContext(); //Return context, This is NOT nullable, if context is null, it will throw an exception
        requireActivity(); //Return activity, This is NOT nullable, if activity is null, it will throw an exception
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binder = null;
    }
}