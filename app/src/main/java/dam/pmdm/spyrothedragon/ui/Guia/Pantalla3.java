package dam.pmdm.spyrothedragon.ui.Guia;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding;
import dam.pmdm.spyrothedragon.databinding.FragmentPantalla3Binding;
import dam.pmdm.spyrothedragon.ui.Utils.Animations;
import dam.pmdm.spyrothedragon.ui.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pantalla3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pantalla3 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    NavController navController = null;
    FragmentPantalla3Binding binding;
    ActivityMainBinding binding2;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Pantalla3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pantalla3.
     */
    // TODO: Rename and change types and number of parameters
    public static Pantalla3 newInstance(String param1, String param2) {
        Pantalla3 fragment = new Pantalla3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slide_left));
        Fragment navHostFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        navController = NavHostFragment.findNavController(navHostFragment);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentPantalla3Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {


        TransitionInflater inflaterExit = TransitionInflater.from(requireContext());
        /*setEnterTransition(inflater.inflateTransition(R.transition.fade_in));*/
        /*setExitTransition(inflaterExit.inflateTransition(R.transition.slide_right));*/
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        binding.selector.setX(width / 2.6f);

        Animations.animaFondo(binding.textoPrincipal);

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(binding.selector, "rotationY", 360f);
        animatorX.setDuration(1000);
        animatorX.setRepeatCount(2);
        animatorX.start();

        binding.salir.setOnClickListener(v -> {
            Utils.salirGuia(getContext());

        });

        binding.pantalla3.setOnClickListener(v -> {

            navController.navigate(R.id.navigation_collectibles);
            Utils.iniciarSonido(getContext(), R.raw.text_notification);
            getActivity().getSupportFragmentManager().beginTransaction()

                    .replace(R.id.guideFrameLayout, new Pantalla4())
                    .addToBackStack(null)
                    .commit();
        });
        super.onResume();
    }
}