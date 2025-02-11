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
import dam.pmdm.spyrothedragon.databinding.FragmentPantalla2Binding;
import dam.pmdm.spyrothedragon.ui.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pantalla2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pantalla2 extends Fragment {
    NavController navController = null;
    FragmentPantalla2Binding binding;
    ActivityMainBinding binding2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Pantalla2() {

    }


    public static Pantalla2 newInstance(String param1, String param2) {
        Pantalla2 fragment = new Pantalla2();
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
        Fragment navHostFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        navController = NavHostFragment.findNavController(navHostFragment);
        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setEnterTransition(inflater.inflateTransition(R.transition.fade_in));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentPantalla2Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onResume() {
         /*idea de Martínez Ruiz, Javier foro
        Float  posicion =  binding2.navView.findViewById(R.id.nav_characters).getX();
        Log.d("posicion",posicion.toString());*/
        /*conocer el ancho de la pantalla*/
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        binding.selector.setX(width / 21);


        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.fade_out));


        iniciarAnimacion();

        binding.salir.setOnClickListener(v -> {
            Utils.salirGuia(getContext());

        });

        binding.pantalla2.setOnClickListener(v -> {

            navController.navigate(R.id.navigation_worlds);
            Utils.iniciarSonido(getContext(), R.raw.text_notification);


            getActivity().getSupportFragmentManager().beginTransaction()

                    .replace(R.id.guideFrameLayout, new Pantalla3())
                    .addToBackStack(null)
                    .commit();
        });
        super.onResume();
    }


    private void iniciarAnimacion() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(binding.selector, "scaleX", 1.5f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(binding.selector, "scaleY", 1.5f);

        ObjectAnimator animarFondoX = ObjectAnimator.ofFloat(binding.textoPrincipal, "ScaleX", 1.03f);
        ObjectAnimator animarFondoY = ObjectAnimator.ofFloat(binding.textoPrincipal, "ScaleY", 1.03f);
        ObjectAnimator animarFondoRotation = ObjectAnimator.ofFloat(binding.textoPrincipal, "rotation", 1.05f);


        animarFondoX.setDuration(1500);
        animarFondoY.setDuration(1500);
        animarFondoX.setRepeatCount(9);
        animarFondoY.setRepeatCount(9);
        animarFondoRotation.setDuration(1500);
        animarFondoRotation.setRepeatCount(9);
        animarFondoX.setRepeatMode(ObjectAnimator.REVERSE);
        animarFondoY.setRepeatMode(ObjectAnimator.REVERSE);
        animarFondoRotation.setRepeatMode(ObjectAnimator.REVERSE);

        animatorX.setDuration(1500);
        animatorY.setDuration(1500);
        animatorX.setRepeatCount(9);
        animatorY.setRepeatCount(9);

        animarFondoX.start();
        animarFondoY.start();
        animatorX.start();
        animatorY.start();
        animarFondoRotation.start();
    }
}