package dam.pmdm.spyrothedragon.ui.Guia;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.databinding.FragmentPantalla5Binding;
import dam.pmdm.spyrothedragon.ui.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pantalla5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pantalla5 extends Fragment {
    FragmentPantalla5Binding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Pantalla5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pantalla5.
     */
    // TODO: Rename and change types and number of parameters
    public static Pantalla5 newInstance(String param1, String param2) {
        Pantalla5 fragment = new Pantalla5();
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
        setEnterTransition(inflater.inflateTransition(R.transition.explode));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPantalla5Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;


        animacionflecha();


        binding.salir.setOnClickListener(v -> {
            Utils.salirGuia(getContext());

        });
        binding.pantalla5.setOnClickListener(v ->
                Utils.salirGuia(requireContext())

        );


    }

    private void animacionflecha() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(binding.selector, "scaleX", 1.5f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(binding.selector, "scaleY", 1.5f);
        animatorX.setDuration(1000);
        animatorY.setDuration(1000);
        animatorX.setRepeatCount(3);
        animatorY.setRepeatCount(3);
        animatorX.start();
        animatorY.start();

    }
}