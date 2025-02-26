package edu.cnm.deepdive.nasaapod.controller;

import android.os.Bundle;

import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.squareup.picasso.Picasso;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.nasaapod.R;
import edu.cnm.deepdive.nasaapod.databinding.ActivityMainBinding;
import edu.cnm.deepdive.nasaapod.model.entity.Apod;
import edu.cnm.deepdive.nasaapod.viewmodel.ApodViewModel;
import javax.inject.Inject;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private ActivityMainBinding binding;
  private ApodViewModel viewModel;

  @Inject
  Picasso picasso;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupUI();
    setupViewModel();
  }

  private void setupUI() {
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // TODO: 2/26/2025 attach listeners to view widgets (fields in binding) todo
    // TODO: 2/26/2025 update state of view widgets
    setContentView(binding.getRoot());
  }

  private void setupViewModel() {
    viewModel = new ViewModelProvider(this).get(ApodViewModel.class);
    viewModel
        .getApod()
        .observe(this, (apod) -> {
          if (apod != null) {
            // TODO: 2/26/2025 Grab image HOW? and put in ImageView widget.
            picasso
                .load(apod.getLowDefUrl().toString())
                .into(binding.image);
              }
            });

    viewModel.setToday();
  }

}