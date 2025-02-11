package dam.pmdm.spyrothedragon.ui.Guia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.transition.TransitionInflater;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding;

import dam.pmdm.spyrothedragon.databinding.PantallaInicioGuiaBinding;
import dam.pmdm.spyrothedragon.ui.Utils.Animations;
import dam.pmdm.spyrothedragon.ui.Utils.Utils;

public class PantallaInicioGuia extends Fragment {

    NavController navController = null;
    PantallaInicioGuiaBinding binding;
    ActivityMainBinding binding2;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = PantallaInicioGuiaBinding.inflate(inflater, container, false);
        Animations.animaIcono(binding.buttonInicio);
        return binding.getRoot();


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();


        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.fade_out));

        binding.buttonInicio.setOnClickListener(v -> {

            Utils.iniciarSonido(getContext(), R.raw.sound_effect_videogame);

            getActivity().getSupportFragmentManager().beginTransaction()

                    .replace(R.id.guideFrameLayout, new Pantalla2())
                    .addToBackStack(null)
                    .commit();
        });

    }
}
