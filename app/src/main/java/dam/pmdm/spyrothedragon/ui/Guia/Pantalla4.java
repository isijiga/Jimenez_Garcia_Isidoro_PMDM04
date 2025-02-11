package dam.pmdm.spyrothedragon.ui.Guia;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding;
import dam.pmdm.spyrothedragon.databinding.FragmentPantalla4Binding;
import dam.pmdm.spyrothedragon.ui.Utils.Animations;
import dam.pmdm.spyrothedragon.ui.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pantalla4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pantalla4 extends Fragment {
    ActivityMainBinding binding2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentPantalla4Binding binding;

    public Pantalla4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pantalla4.
     */
    // TODO: Rename and change types and number of parameters
    public static Pantalla4 newInstance(String param1, String param2) {
        Pantalla4 fragment = new Pantalla4();
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
        setEnterTransition(inflater.inflateTransition(R.transition.fade_out));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPantalla4Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        TransitionInflater inflaterExit = TransitionInflater.from(requireContext());

        //setExitTransition(inflaterExit.inflateTransition(R.transition.zoom_in));
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        binding.selector.setX(width / 1.5f);

        Animations.animaFondo(binding.textoPrincipal);

        binding.salir.setOnClickListener(v -> {
            Utils.salirGuia(getContext());

        });
        binding.pantalla4.setOnClickListener(v -> {


            getActivity().getSupportFragmentManager().beginTransaction()

                    .replace(R.id.guideFrameLayout, new Pantalla5())
                    .addToBackStack(null)
                    .commit();
        });
    }
}